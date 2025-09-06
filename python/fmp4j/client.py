import os
from pathlib import Path

import jpype
import jpype.imports
from jpype.types import *

jar_path = os.environ.get("FMP_JAR_PATH")

if not jar_path:
    raise EnvironmentError("FMP_JAR_PATH environment variable is not set.")

jar_file = Path(jar_path).resolve()
if not jar_file.exists():
    raise FileNotFoundError(f"Could not find JAR file at {jar_file}")

if not jpype.isJVMStarted():
    jpype.startJVM("-Djava.awt.headless=true", classpath=[str(jar_file)], convertStrings=True)
    print(f"✅ JVM started with classpath: {jar_file}")

from dev.sorn.fmp4j import FmpClient
from dev.sorn.fmp4j.cfg import FmpConfig
from dev.sorn.fmp4j.types import FmpSymbol
from dev.sorn.fmp4j.types.FmpCik import cik as to_cik
from dev.sorn.fmp4j.types.FmpCusip import cusip as to_cusip
from dev.sorn.fmp4j.types.FmpIsin import isin as to_isin
from dev.sorn.fmp4j.types.FmpSymbol import symbol as to_symbol

class Fmp4jClient:
    def __init__(self):
        self.client = FmpClient()

    # +----------------+
    # | SEARCH SECTION |
    # +----------------+

    def search_by_cik(self, cik):
        cik = to_cik(cik)
        return self.client.search().byCik(cik)

    def search_by_cusip(self, cusip):
        cusip = to_cusip(cusip)
        return self.client.search().byCusip(cusip)

    def search_by_isin(self, isin):
        isin = to_isin(isin)
        return self.client.search().byIsin(isin)

    def search_by_name(self, name):
        return self.client.search().byName(name)

    def search_by_symbol(self, symbol):
        symbol = to_symbol(symbol)
        return self.client.search().bySymbol(symbol)

    # +----------------+
    # | QUOTES SECTION |
    # +----------------+

    def full_quote(self, symbol):
        symbol = to_symbol(symbol)
        return self.client.quote().full(symbol)

    def partial_quote(self, symbol):
        symbol = to_symbol(symbol)
        return self.client.quote().partial(symbol)

    def price_change(self, symbol):
        symbol = to_symbol(symbol)
        return self.client.quote().priceChange(symbol)

    def etfs(self):
        return self.client.list().etfs()

    def dividends(self, symbol):
        symbol = to_symbol(symbol)
        return self.client.calendar().dividends(symbol)
