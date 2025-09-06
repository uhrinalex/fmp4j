from fmp4j import Fmp4jClient
import pytest
import time

@pytest.fixture(autouse=True)
def delay_between_tests():
    time.sleep(1)

def test_search_by_cik():
    # given
    cik = "0000320193"
    client = Fmp4jClient()

    # when
    res = client.search_by_cik(cik)

    # then
    assert res is not None
    assert res[0] is not None
    assert res[0].cik().value() == cik

def test_search_by_cusip():
    # given
    cusip = "037833100"
    client = Fmp4jClient()

    # when
    res = client.search_by_cusip(cusip)

    # then
    assert res is not None
    assert res[0] is not None
    assert res[0].cusip().value() == cusip

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

def test_search_by_name():
    # given
    name = "Apple"
    client = Fmp4jClient()

    # when
    res = client.search_by_name(name)

    # then
    assert res is not None
    assert res[0] is not None
    assert res[0].name() == name + " Inc."

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

def test_full_quote():
    # given
    symbol = "AAPL"
    client = Fmp4jClient()

    # when
    res = client.full_quote(symbol)

    # then
    assert res is not None
    assert res[0] is not None
    assert res[0].symbol().value() == symbol
    assert res[0].price() is not None

def test_partial_quote():
    # given
    symbol = "AAPL"
    client = Fmp4jClient()

    # when
    res = client.partial_quote(symbol)

    # then
    assert res is not None
    assert res[0] is not None
    assert res[0].symbol().value() == symbol
    assert res[0].price() is not None

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
