from fmp4j import Fmp4jClient

def test_calendar_dividends():
    # given
    client = Fmp4jClient()

    # when
    dividends = client.dividends("JNJ")

    # then
    assert dividends is not None
    assert len(dividends) > 0
    for d in dividends:
        assert d.symbol().value() == "JNJ"
        assert d.dividend() >= 0
