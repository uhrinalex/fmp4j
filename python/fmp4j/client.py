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

class Fmp4jClient:
    def __init__(self):
        self.client = FmpClient()

    def search_by_symbol(self, symbol):
        symbol = FmpSymbol.symbol(symbol)
        return self.client.search().bySymbol(symbol)

    def dividends(self, symbol):
        symbol = FmpSymbol.symbol(symbol)
        return self.client.calendar().dividends(symbol)
