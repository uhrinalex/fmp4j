![](./.github/badges/jacoco.svg)

```txt
╔───────────────────────────────────────────╗
│                                           │
│                                           │
│       _|                    |  |   _)     │
│      |    __ `__ \   __ \   |  |    |     │
│      __|  |   |   |  |   | ___ __|  |     │
│     _|   _|  _|  _|  .__/     _|    |     │
│                     _|          ___/      │
│                                           │
│                                           │
╚───────────────────────────────────────────╝
```

# fmp4j

**fmp4j** is a lightweight Java SDK for accessing
the [Financial Modeling Prep (FMP)](https://site.financialmodelingprep.com/) API.

> **DO NOT CONTACT ME FOR API SUPPORT OF ANY KIND — I AM NOT AFFILIATED WITH FMP.**<br>
> This is simply an open-source Java SDK that wraps their API

## Supported Endpoints (Stable API)

The section names, ordering, and endpoints are copy-pasted from FMP docs.

### Search

Copy of https://site.financialmodelingprep.com/developer/docs/stable#search

|    | Since | Endpoint                    |
|:--:|:-----:|-----------------------------|
| ✅️ | alpha | `/search-symbol`            |
| ✅️ | alpha | `/search-name`              |
| ❌️ |   -   | `/search-cik`               |
| ❌️ |   -   | `/search-cusip`             |
| ✅️ | alpha | `/search-isin`              |
| ❌️ |   -   | `/search-exchange-variants` |
| ❌️ |   -   | `/company-screener`         |

### Directory

Copy of https://site.financialmodelingprep.com/developer/docs/stable#directory

|    | Since | Endpoint                           |
|:--:|:-----:|------------------------------------|
| ✅️ | alpha | `/stock-list`                      |
| ❌️ |   -   | `/financial-statement-symbol-list` |
| ❌️ |   -   | `/cik-list`                        |
| ❌️ |   -   | `/symbol-change`                   |
| ✅️ | alpha | `/etf-list`                        |
| ❌️ |   -   | `/actively-trading-list`           |
| ❌️ |   -   | `/earnings-transcript-list`        |
| ❌️ |   -   | `/available-exchanges`             |
| ❌️ |   -   | `/available-sectors`               |
| ❌️ |   -   | `/available-industries`            |
| ❌️ |   -   | `/available-countries`             |

### Analyst

Copy of https://site.financialmodelingprep.com/developer/docs/stable#analyst

|    | Since | Endpoint                    |
|:--:|:-----:|-----------------------------|
| ❌️ |   -   | `/analyst-estimates`        |
| ❌️ |   -   | `/ratings-snapshot`         |
| ❌️ |   -   | `/ratings-historical`       |
| ❌️ |   -   | `/price-target-summary`     |
| ❌️ |   -   | `/price-target-consensus`   |
| ❌️ |   -   | `/price-target-news`        |
| ❌️ |   -   | `/price-target-latest-news` |
| ❌️ |   -   | `/grades`                   |
| ❌️ |   -   | `/grades-historical`        |
| ❌️ |   -   | `/grades-consensus`         |
| ❌️ |   -   | `/grades-news`              |
| ❌️ |   -   | `/grades-latest-news`       |

### Calendar

Copy of https://site.financialmodelingprep.com/developer/docs/stable#calendar

|    | Since | Endpoint              |
|:--:|:-----:|-----------------------|
| ✅️ | alpha | `/dividends`          |
| ✅️ | alpha | `/dividends-calendar` |
| ✅️ | alpha | `/earnings`           |
| ✅️ | alpha | `/earnings-calendar`  |
| ❌️ |   -   | `/ipos-calendar`      |
| ❌️ |   -   | `/ipos-disclosure`    |
| ❌️ |   -   | `/ipos-prospectus`    |
| ❌️ |   -   | `/splits`             |
| ❌️ |   -   | `/splits-calendar`    |

### Chart

Copy of https://site.financialmodelingprep.com/developer/docs/stable#chart

|    | Since | Endpoint                                   |
|:--:|:-----:|--------------------------------------------|
| ✅️ | alpha | `/historical-price-eod/light`              |
| ✅️ | alpha | `/historical-price-eod/full`               |
| ❌️ |   -   | `/historical-price-eod/non-split-adjusted` |
| ❌️ |   -   | `/historical-price-eod/dividend-adjusted`  |
| ❌️ |   -   | `/historical-chart/1min`                   |
| ❌️ |   -   | `/historical-chart/5min`                   |
| ❌️ |   -   | `/historical-chart/15min`                  |
| ❌️ |   -   | `/historical-chart/30min`                  |
| ❌️ |   -   | `/historical-chart/1hour`                  |
| ❌️ |   -   | `/historical-chart/4hour`                  |

### Company

Copy of https://site.financialmodelingprep.com/developer/docs/stable#chart

|    | Since | Endpoint                             |
|:--:|:-----:|--------------------------------------|
| ✅️ | alpha | `/profile`                           |
| ❌️ |   -   | `/profile-cik`                       |
| ❌️ |   -   | `/company-notes`                     |
| ❌️ |   -   | `/stock-peers`                       |
| ❌️ |   -   | `/delisted-companies`                |
| ❌️ |   -   | `/employee-count`                    |
| ❌️ |   -   | `/historical-employee-count`         |
| ❌️ |   -   | `/market-capitalization`             |
| ❌️ |   -   | `/market-capitalization`             |
| ❌️ |   -   | `/market-capitalization-batch`       |
| ❌️ |   -   | `/historical-market-capitalization`  |
| ❌️ |   -   | `/shares-float`                      |
| ❌️ |   -   | `/shares-float-all`                  |
| ❌️ |   -   | `/mergers-acquisitions-latest`       |
| ❌️ |   -   | `/mergers-acquisitions-search`       |
| ❌️ |   -   | `/key-executives`                    |
| ❌️ |   -   | `/governance-executive-compensation` |
| ❌️ |   -   | `/executive-compensation-benchmark`  |

### Commitment Of Traders

Copy of https://site.financialmodelingprep.com/developer/docs/stable#commitment-of-traders

|    | Since | Endpoint                          |
|:--:|:-----:|-----------------------------------|
| ❌️ |   -   | `/commitment-of-traders-report`   |
| ❌️ |   -   | `/commitment-of-traders-analysis` |
| ❌️ |   -   | `/commitment-of-traders-list`     |

### Economics

Copy of https://site.financialmodelingprep.com/developer/docs/stable#commitment-of-traders

|    | Since | Endpoint               |
|:--:|:-----:|------------------------|
| ❌️ |   -   | `/treasury-rates`      |
| ❌️ |   -   | `/economic-indicators` |
| ❌️ |   -   | `/economic-calendar`   |
| ❌️ |   -   | `/market-risk-premium` |

### ESG

Copy of https://site.financialmodelingprep.com/developer/docs/stable#esg

|    | Since | Endpoint           |
|:--:|:-----:|--------------------|
| ❌️ |   -   | `/esg-disclosures` |
| ❌️ |   -   | `/esg-ratins`      |
| ❌️ |   -   | `/esg-benchmark`   |

Copy of ### Discounted Cash Flow

https://site.financialmodelingprep.com/developer/docs/stable#discounted-cash-flow

|    | Since | Endpoint                               |
|:--:|:-----:|----------------------------------------|
| ❌️ |   -   | `/discounted-cash-flow`                |
| ❌️ |   -   | `/levered-discounted-cash-flow`        |
| ❌️ |   -   | `/custom-discounted-cash-flow`         |
| ❌️ |   -   | `/custom-levered-discounted-cash-flow` |

### Statements

Copy of https://site.financialmodelingprep.com/developer/docs/stable#statements

|    | Since | Endpoint                                  |
|:--:|:-----:|-------------------------------------------|
| ❌️ |   -   | `/latest-financial-statements`            |
| ❌️ |   -   | `/financial-statement-full-as-reported`   |
| ✅️ | alpha | `/income-statement`                       |
| ❌️ |   -   | `/income-statement-ttm`                   |
| ❌️ |   -   | `/income-statement-growth`                |
| ❌️ |   -   | `/income-statement-growth-as-reported`    |
| ✅️ | alpha | `/balance-sheet-statement`                |
| ❌️ |   -   | `/balance-sheet-statement-ttm`            |
| ❌️ |   -   | `/balance-sheet-statement-growth`         |
| ❌️ |   -   | `/balance-sheet-statement-as-reported`    |
| ✅️ | alpha | `/cash-flow-statement`                    |
| ❌️ |   -   | `/cash-flow-statement-ttm`                |
| ❌️ |   -   | `/cash-flow-statement-growth`             |
| ❌️ |   -   | `/cash-flow-statement-growth-as-reported` |
| ❌️ |   -   | `/financial-growth`                       |
| ✅️ | alpha | `/ratios`                                 |
| ✅️ | alpha | `/ratios-ttm`                             |
| ✅️ | alpha | `/key-metrics`                            |
| ✅️ | alpha | `/key-metrics-ttm`                        |
| ❌️ |   -   | `/financial-scores`                       |
| ❌️ |   -   | `/owner-earnings`                         |
| ✅️ | alpha | `/enterprise-values`                      |
| ✅️ | alpha | `/revenue-product-segmentation`           |
| ✅️ | alpha | `/revenue-geographic-segmentation`        |

### Form 13F

Copy of https://site.financialmodelingprep.com/developer/docs/stable#form-13f

|    | Since | Endpoint                                              |
|:--:|:-----:|-------------------------------------------------------|
| ❌️ |   -   | `/institutional-ownership/latest`                     |
| ❌️ |   -   | `/institutional-ownership/extract`                    |
| ❌️ |   -   | `/institutional-ownership/extract-analytics/holder`   |
| ❌️ |   -   | `/institutional-ownership/holder-performance-summary` |
| ❌️ |   -   | `/institutional-ownership/holder-industry-breakdown`  |
| ❌️ |   -   | `/institutional-ownership/symbols-positions-summary`  |
| ❌️ |   -   | `/institutional-ownership/industry-summary`           |

### Indexes

Copy of https://site.financialmodelingprep.com/developer/docs/stable#indexes

|    | Since | Endpoint                           |
|:--:|:-----:|------------------------------------|
| ❌️ |   -   | `/index-list`                      |
| ❌️ |   -   | `/quote`                           |
| ✅️ | alpha | `/quote-short`                     |
| ❌️ |   -   | `/batch-index-quotes`              |
| ❌️ |   -   | `/historical-price-eod/light`      |
| ❌️ |   -   | `/historical-price-eod/full`       |
| ❌️ |   -   | `/historical-chart/1min`           |
| ❌️ |   -   | `/historical-chart/5min`           |
| ❌️ |   -   | `/historical-chart/1hour`          |
| ❌️ |   -   | `/sp500-constituent`               |
| ❌️ |   -   | `/nasdaq-constituent`              |
| ❌️ |   -   | `/dowjones-constituent`            |
| ❌️ |   -   | `/historical-sp500-constituent`    |
| ❌️ |   -   | `/histoircal-nasdaq-constituent`   |
| ❌️ |   -   | `/historical-dowjones-constituent` |

### Insider Trades

Copy of https://site.financialmodelingprep.com/developer/docs/stable#insider-trades

|    | Since | Endpoint                                |
|:--:|:-----:|-----------------------------------------|
| ❌️ |   -   | `/insider-trading`                      |
| ❌️ |   -   | `/insider-trading/reporting-name`       |
| ❌️ |   -   | `/insider-trading/search`               |
| ❌️ |   -   | `/insider-trading/statistics`           |
| ❌️ |   -   | `/insider-trading-transaction-type`     |
| ❌️ |   -   | `/acquisitions-of-beneficial-ownership` |

### Market Performance

Copy of https://site.financialmodelingprep.com/developer/docs/stable#market-performance

|    | Since | Endpoint                           |
|:--:|:-----:|------------------------------------|
| ❌️ |   -   | `/sector-performance-snapshot`     |
| ❌️ |   -   | `/industry-performance-snapshot`   |
| ❌️ |   -   | `/historical-sector-performance`   |
| ❌️ |   -   | `/historical-industry-performance` |
| ❌️ |   -   | `/sector-pe-snapshot`              |
| ❌️ |   -   | `/industry-pe-snapshot`            |
| ❌️ |   -   | `/historical-sector-pe`            |
| ❌️ |   -   | `/historical-industry-pe`          |
| ❌️ |   -   | `/biggest-gainers`                 |
| ❌️ |   -   | `/biggest-losers`                  |
| ❌️ |   -   | `/most-actives`                    |

### Market Hours

Copy of https://site.financialmodelingprep.com/developer/docs/stable#market-hours

|    | Since | Endpoint                     |
|:--:|:-----:|------------------------------|
| ❌️ |   -   | `/exchange-market-hours`     |
| ❌️ |   -   | `/holidays-by-exchange`      |
| ❌️ |   -   | `/all-exchange-market-hours` |

### ETF & Mutual Funds

Copy of https://site.financialmodelingprep.com/developer/docs/stable#holdings

|    | Since | Endpoint                           |
|:--:|:-----:|------------------------------------|
| ❌️ |   -   | `/etf/holdings`                    |
| ❌️ |   -   | `/etf/info`                        |
| ❌️ |   -   | `/etf/country-weightings`          |
| ❌️ |   -   | `/etf/asset-exposure`              |
| ❌️ |   -   | `/etf/sector-weightings`           |
| ❌️ |   -   | `/funds/disclosure`                |
| ❌️ |   -   | `/funds/disclosure-holders-latest` |
| ❌️ |   -   | `/funds/disclosure-holders-search` |
| ❌️ |   -   | `/funds/disclosure-dates`          |

### Commodities

Copy of https://site.financialmodelingprep.com/developer/docs/stable#commodities

|    | Since | Endpoint                      |
|:--:|:-----:|-------------------------------|
| ❌️ |   -   | `/commodities-list`           |
| ❌️ |   -   | `/quote`                      |
| ✅️ | alpha | `/quote-short`                |
| ❌️ |   -   | `/batch-commodities-quotes`   |
| ❌️ |   -   | `/historical-price-eod/light` |
| ❌️ |   -   | `/historical-price-eod/full`  |
| ❌️ |   -   | `/historical-chart/1min`      |
| ❌️ |   -   | `/historical-chart/5min`      |
| ❌️ |   -   | `/historical-chart/1hour`     |

### Fundraisers

Copy of https://site.financialmodelingprep.com/developer/docs/stable#fundraisers

|    | Since | Endpoint                         |
|:--:|:-----:|----------------------------------|
| ❌️ |   -   | `/crowdfunding-offerings-latest` |
| ❌️ |   -   | `/crowdfunding-offerings-search` |
| ❌️ |   -   | `/crowdfunding-offerings`        |
| ❌️ |   -   | `/fundraising-latest`            |
| ❌️ |   -   | `/fundraising-search`            |
| ❌️ |   -   | `/fundraising`                   |

### Crypto

Copy of https://site.financialmodelingprep.com/developer/docs/stable#crypto

|    | Since | Endpoint                      |
|:--:|:-----:|-------------------------------|
| ❌️ |   -   | `/cryptocurrency-list`        |
| ❌️ |   -   | `/batch-crypto-quotes`        |
| ❌️ |   -   | `/quote`                      |
| ✅️ | alpha | `/quote-short`                |
| ❌️ |   -   | `/historical-price-eod/light` |
| ❌️ |   -   | `/historical-price-eod/full`  |
| ❌️ |   -   | `/historical-chart/1min`      |
| ❌️ |   -   | `/historical-chart/5min`      |
| ❌️ |   -   | `/historical-chart/1hour`     |

### Crypto

Copy of https://site.financialmodelingprep.com/developer/docs/stable#crypto

|    | Since | Endpoint                      |
|:--:|:-----:|-------------------------------|
| ❌️ |   -   | `/forex-list`                 |
| ❌️ |   -   | `/batch-forex-quotes`         |
| ❌️ |   -   | `/quote`                      |
| ✅️ | alpha | `/quote-short`                |
| ❌️ |   -   | `/historical-price-eod/light` |
| ❌️ |   -   | `/historical-price-eod/full`  |
| ❌️ |   -   | `/historical-chart/1min`      |
| ❌️ |   -   | `/historical-chart/5min`      |
| ❌️ |   -   | `/historical-chart/1hour`     |

### News

Copy of https://site.financialmodelingprep.com/developer/docs/stable#news

|    | Since | Endpoint                      |
|:--:|:-----:|-------------------------------|
| ❌️ |   -   | `/fmp-articles`               |
| ❌️ |   -   | `/news/general-latest`        |
| ❌️ |   -   | `/news/press-releases`        |
| ❌️ |   -   | `/news/press-releases-latest` |
| ❌️ |   -   | `/news/stock`                 |
| ❌️ |   -   | `/news/stock-latest`          |
| ❌️ |   -   | `/news/crypto`                |
| ❌️ |   -   | `/news/crypto-latest`         |
| ❌️ |   -   | `/news/forex`                 |
| ❌️ |   -   | `/news/forex-latest`          |

### Technical Indicators

Copy of https://site.financialmodelingprep.com/developer/docs/stable#technical-indicators

|    | Since | Endpoint                                  |
|:--:|:-----:|-------------------------------------------|
| ❌️ |   -   | `/technical-indicators-sma`               |
| ❌️ |   -   | `/technical-indicators-ema`               |
| ❌️ |   -   | `/technical-indicators-wma`               |
| ❌️ |   -   | `/technical-indicators-dema`              |
| ❌️ |   -   | `/technical-indicators-tema`              |
| ❌️ |   -   | `/technical-indicators-rsi`               |
| ❌️ |   -   | `/technical-indicators-standarddeviation` |
| ❌️ |   -   | `/technical-indicators-williams`          |
| ❌️ |   -   | `/technical-indicators-adx`               |

### Quote

Copy of https://site.financialmodelingprep.com/developer/docs/stable#quote

|    | Since | Endpoint                   |
|:--:|:-----:|----------------------------|
| ❌️ |   -   | `/quote`                   |
| ✅️ | alpha | `/quote-short`             |
| ❌️ |   -   | `/aftermarket-trade`       |
| ❌️ |   -   | `/aftermarket-quote`       |
| ❌️ |   -   | `/stock-price-change`      |
| ❌️ |   -   | `/batch-quote`             |
| ❌️ |   -   | `/batch-quote-short`       |
| ❌️ |   -   | `/batch-aftermarket-trade` |
| ❌️ |   -   | `/batch-aftermarket-quote` |
| ❌️ |   -   | `/batch-exchange-quote`    |
| ❌️ |   -   | `/batch-mutaulfund-quotes` |
| ❌️ |   -   | `/batch-etf-quotes`        |
| ❌️ |   -   | `/batch-commodity-quotes`  |
| ❌️ |   -   | `/batch-crypto-quotes`     |
| ❌️ |   -   | `/batch-forex-quotes`      |
| ❌️ |   -   | `/batch-index-quotes`      |

### SEC Filings

Copy of https://site.financialmodelingprep.com/developer/docs/stable#sec-filings

|    | Since | Endpoint                                   |
|:--:|:-----:|--------------------------------------------|
| ❌️ |   -   | `/sec-filings-8k`                          |
| ❌️ |   -   | `/sec-filings-financials`                  |
| ❌️ |   -   | `/sec-filings-search/form-type`            |
| ❌️ |   -   | `/sec-filings-search/cik`                  |
| ❌️ |   -   | `/sec-filings-company-search/name`         |
| ❌️ |   -   | `/sec-filings-company-search/symbol`       |
| ❌️ |   -   | `/sec-filings-company-search/cik`          |
| ❌️ |   -   | `/sec-profile`                             |
| ❌️ |   -   | `/standard-industrial-classification-list` |
| ❌️ |   -   | `/industry-classification-search`          |
| ❌️ |   -   | `/all-industry-classification`             |

### Earnings Transcript

Copy of https://site.financialmodelingprep.com/developer/docs/stable#earnings-transcript

|    | Since | Endpoint                          |
|:--:|:-----:|-----------------------------------|
| ❌️ |   -   | `/earning-call-transcript-latest` |
| ❌️ |   -   | `/earning-call-transcript`        |
| ❌️ |   -   | `/earning-call-transcript-dates`  |
| ❌️ |   -   | `/earnings-transcript-list`       |

### Senate

Copy of https://site.financialmodelingprep.com/developer/docs/stable#senate

|    | Since | Endpoint                 |
|:--:|:-----:|--------------------------|
| ❌️ |   -   | `/senate-latest`         |
| ❌️ |   -   | `/senate-trades`         |
| ❌️ |   -   | `/senate-trades-by-name` |
| ❌️ |   -   | `/house-latest`          |
| ❌️ |   -   | `/house-trades`          |
| ❌️ |   -   | `/house-trades-by-name`  |

### Bulk

Copy of https://site.financialmodelingprep.com/developer/docs/stable#bulk

|    | Since | Endpoint                               |
|:--:|:-----:|----------------------------------------|
| ❌️ |   -   | `/profile-bulk`                        |
| ❌️ |   -   | `/rating-bulk`                         |
| ❌️ |   -   | `/dcf-bulk`                            |
| ❌️ |   -   | `/scores-bulk`                         |
| ❌️ |   -   | `/price-target-summary-bulk`           |
| ❌️ |   -   | `/etf-holder-bulk`                     |
| ❌️ |   -   | `/upgrades-downgrades-consensus-bulk`  |
| ❌️ |   -   | `/key-metrics-ttm-bulk`                |
| ❌️ |   -   | `/ratios-ttm-bulk`                     |
| ❌️ |   -   | `/ratios-ttm-bulk`                     |
| ❌️ |   -   | `/peers-bulk`                          |
| ❌️ |   -   | `/earnings-surprises-bulk`             |
| ❌️ |   -   | `/income-statement-bulk`               |
| ❌️ |   -   | `/income-statement-growth-bulk`        |
| ❌️ |   -   | `/balance-sheet-statement-bulk`        |
| ❌️ |   -   | `/balance-sheet-statement-growth-bulk` |
| ❌️ |   -   | `/cash-flow-statement-bulk`            |
| ❌️ |   -   | `/cash-flow-statement-growth-bulk`     |
| ❌️ |   -   | `/eod-bulk`                            |

## Dependencies

- `com.fasterxml.jackson.datatype:jackson-datatype-jsr310`
- `com.fasterxml.jackson.core:jackson-databind`
- `org.apache.httpcomponents.client5:httpclient5`
- `org.apache.commons:commons-lang3`