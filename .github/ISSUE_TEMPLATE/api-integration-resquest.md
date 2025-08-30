---
name: API Integration
about: Request a new API integration
title: "Add new API integration: /replace-this-with-endpoint"
labels: enhancement
assignees: ''

---

**Instructions**
Replace *all* example values below with your actual implementation details. Do **not** keep the examples as-is. Make
sure to read the full [documentation](https://github.com/sorndotdev/fmp4j/tree/master/docs) before contributing.

---

**FMP Docs Link:**
*Replace with the direct link to the relevant endpoint in the Financial Modeling Prep docs*

> https://site.financialmodelingprep.com/developer/docs/stable#search-by-symbol

**Parameters:**
*Replace with the required and optional endpoint parameters (or `N/A`)*

> - Required: symbol, from, to
> - Optional: page, limit


**Proposed model class name:**
*Replace with the name of the model class you plan to add*

> FmpEtfHolding

**Proposed client class name:**
*Replace with the name of the client class*

> FmpEtfClient

**Proposed client method names:**
*Replace with the method names in the client*

> - info()
> - holdings()
> - sectorWeightings()

---

## Requirements

**All models**

- [x] start with `Fmp`
- [x] are implemented as Java 16+ records
- [x] implement the `FmpModel` interface
- [x] have `serialVersionUID`
- [x] have test: `is_serializable`
- [x] have test: `serializes`
- [x] use date time classes for dates, instead of strings, where appropriate
- [x] use value objects, instead of strings, where appropriate
- [x] have `*TestData` in `testFixtures`

**All services**

- [x] use the model name + `Service` suffix
- [x] are added to the appropriate FmpClient
- [x] have tests with real responses from FMP
- [x] with responses stored as JSON in `testFixtures` (*for large responses, include only an excerpt*)

**General**

- [x] aim for 100% test coverage; TDD is preferred
- [x] double-check your work before creating a PR
- [x] refactor unrelated code in a separate PR from feature or bugfix changes (don’t refactor "as you go")
- [x] adhere to the existing code style