import regex

numbersStringToInt = {
    "zero": 0,
    "one": 1,
    "two": 2,
    "three": 3,
    "four": 4,
    "five": 5,
    "six": 6,
    "seven": 7,
    "eight": 8,
    "nine": 9
}

def main():
    f = open('input.txt', 'r')
    sum = 0
    for line in f:
        found = regex.findall(
            "(?:(zero|one|two|three|four|five|six|seven|eight|nine|[1-9]))",
            line,
            overlapped=True)
        first = int(found[0]) if found[0].isdigit() else numbersStringToInt[found[0]]
        second = int(found[-1]) if found[-1].isdigit() else numbersStringToInt[found[-1]]
        sum += first * 10 + second
    print(sum)

main()
