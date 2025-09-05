import jpype
import jpype.imports
from jpype.types import *
from jpype import JProxy, JClass

import os
from pathlib import Path

jar_path = os.environ.get("FMP_JAR_PATH")

if not jar_path:
    raise EnvironmentError("FMP_JAR_PATH environment variable is not set.")

jar_file = Path(jar_path).resolve()
if not jar_file.exists():
    raise FileNotFoundError(f"Could not find JAR file at {jar_file}")

if not jpype.isJVMStarted():
    jpype.startJVM("-Djava.awt.headless=true", classpath=[str(jar_file)])
    print(f"✅ JVM started with classpath: {jar_file}")

from dev.sorn.fmp4j import FmpClient
from dev.sorn.fmp4j.cfg import FmpConfig
from dev.sorn.fmp4j.http import FmpHttpClientImpl
from dev.sorn.fmp4j.types import FmpSymbol

class Fmp4jConfig:
    def fmpBaseUrl(self):
        return "https://financialmodelingprep.com/stable"

    def fmpApiKey(self):
        return "demo"

fmp4j_config_proxy = JProxy(FmpConfig, inst=Fmp4jConfig())

class Fmp4jClient:
    def __init__(self):
        self.client = FmpClient()
        # self.client = FmpClient(fmp4j_config_proxy, FmpHttpClientImpl.FMP_HTTP_CLIENT)

    def search_by_symbol(self, symbol):
        symbol = FmpSymbol.symbol(symbol)
        return self.client.search().bySymbol(symbol)
