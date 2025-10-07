# :christmas_tree: Advent of Code

A Kotlin-based repository for [Advent of Code](https://adventofcode.com/) solutions.

## :triangular_ruler: Structure

Solutions are organized by year and day:

```text
src/main/kotlin/
├── common/          # Shared utilities and interfaces
├── y2015/d01/       # Year 2015, Day 1
├── y2022/d01/       # Year 2022, Day 1
└── y2023/d01/       # Year 2023, Day 1
```

## :minidisc: Running solutions

```bash
# Build the project
./gradlew build

# Run tests
./gradlew test
```

Each day implements the `Day<T, Y>` interface with `p1()` and `p2()` methods for parts 1 and 2.

## :battery: Progress

- **2015:** Days 1-6
- **2017:** Days 2, 4
- **2021:** Days 1-3
- **2022:** Days 1-7
- **2023:** Days 1-4, 6-7, 9, 15
