# Benchmark

## Dividends Endpoint

```python
from fmp4j import Fmp4jClient
import time
import requests

def fmp4j_jpype_call():
    client = Fmp4jClient()
    start = time.time()
    client.dividends("AAPL")
    return time.time() - start

def python_http_call():
    start = time.time()
    requests.get("https://financialmodelingprep.com/stable/dividends?symbol=AAPL&apikey=yourapikeyhere")
    return time.time() - start


def test_performance():
    print("fmp4j call time:", fmp4j_jpype_call())
    print("Vanilla Python HTTP call time:", python_http_call())
```

### Results

* fmp4j call time: 0.2177729606628418
* Python HTTP call time: 1.6133832931518555

The FMP4J Python wrapper is 8x faster than vanilla Python
