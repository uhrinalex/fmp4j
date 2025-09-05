from fmp4j import Fmp4jClient

def test_search_by_symbol():
    # given
    symbol = "AAPL"
    client = Fmp4jClient()

    # when
    res = client.search_by_symbol(symbol)

    # then
    assert res is not None
    assert res[0] is not None
    assert res[0].symbol().value() == symbol

def test_search_by_isin():
    # given
    isin = "US0378331005"
    client = Fmp4jClient()

    # when
    res = client.search_by_isin(isin)

    # then
    assert res is not None
    assert res[0] is not None
    assert res[0].isin().value() == isin

def test_etfs():
    # given
    client = Fmp4jClient()

    # when
    etfs = client.etfs()

    # then
    assert etfs is not None
    assert len(etfs) > 0
    for etf in etfs:
        assert etf.symbol() is not None
        assert etf.name() is not None

def test_calendar_dividends():
    # given
    symbol = "JNJ"
    client = Fmp4jClient()

    # when
    dividends = client.dividends(symbol)

    # then
    assert dividends is not None
    assert len(dividends) > 0
    for d in dividends:
        assert d.symbol().value() == symbol
        assert d.dividend() >= 0
