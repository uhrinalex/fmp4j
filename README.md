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

| Name                    | Endpoint                          | Supported | Version |
|-------------------------|-----------------------------------|:---------:|:-------:|
| Quote (Short)           | `/stable/quote-short`             |    ✅️     |  alpha  |
| Income Statement        | `/stable/income-statement`        |    ✅️     |  alpha  |
| Balance Sheet Statement | `/stable/balance-sheet-statement` |    ✅️     |  alpha  |
| Cash Flow Statement     | `/stable/cash-flow-statement`     |    ✅️     |  alpha  |
| Ratios                  | `/stable/ratios`                  |    ✅️     |  alpha  |
| Ratios (TTM)            | `/stable/ratios-ttm`              |    ✅️     |  alpha  |
| Key Metrics             | `/stable/key-metrics`             |    ✅️     |  alpha  |
| Key Metrics (TTM)       | `/stable/key-metrics-ttm`         |    ✅️     |  alpha  |

## Dependencies

- `com.fasterxml.jackson.datatype:jackson-datatype-jsr310`
- `com.fasterxml.jackson.core:jackson-databind`
- `org.apache.httpcomponents.client5:httpclient5`
- `org.apache.commons:commons-lang3`