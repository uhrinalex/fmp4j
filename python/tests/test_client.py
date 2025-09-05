from fmp4j.client import Fmp4jClient

def test_get_stock_price():
    client = Fmp4jClient()
    result = client.search_by_symbol("AAPL")
    assert result is not None
