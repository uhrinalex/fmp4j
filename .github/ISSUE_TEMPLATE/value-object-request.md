---
name: Value Object
about: Create a new value object (VO)
title: "New Value Object: FmpNameOfObject"
labels: enhancement
assignees: ''

---

**Instructions**
Replace *all* example values below with your actual implementation details. Do **not** keep the examples as-is. Make
sure to read the full [documentation](https://github.com/sorndotdev/fmp4j/tree/master/docs) before contributing.

---

**Is the value object an FMP parameter?**
> Yes/No

**(If "yes") FMP Docs Link:**
>

**(If "no") Why is it needed? (be clear and concise)**
>

---

## Requirements

**Value Object**

- [x] implements `FmpValueObject`
- [x] consider edge cases (max, min, patterns, ...)
- [x] implements `equals()`
- [x] implements `hashCode()`
- [x] has `serialVersionUID`
- [x] has static factory method matching the value object name
- [x] has private constructor
- [x] where appropriate, use enums
- [x] where appropriate, implements `Comparable` interface

**General**

- [x] replace *all* existing primitives with the new Value Object in the same PR