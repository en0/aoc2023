import requests
from pathlib import Path
from argparse import ArgumentParser, ArgumentTypeError
from datetime import datetime


def get_opts():

    def int_between(a, b):
        def fn(v):
            i = int(v)
            if (a <= i <= b):
                return i
            raise ArgumentTypeError(
                f"Invalid input {i}. Expected value between {a} and {b}"
            )
        return fn;

    ap = ArgumentParser(description="Generate solutions skeletons for the given day")
    ap.add_argument("--day", type=int_between(1, 25) , required=True)
    ap.add_argument("--part", type=int_between(1, 2), required=True)
    ap.add_argument("--download-input", action="store_true", default=False)
    ap.add_argument("--collect-testcase", action="store_true", default=False)
    ap.add_argument("--no-solution", action="store_true", default=False)
    ap.add_argument("--no-test", action="store_true", default=False)
    return ap.parse_args()


def collect_testcase(testcase):
    print("[i] Collecting testcase.")
    print("What is the puzzle's sample input?")
    print('Type "EOF" on a black line to finish input.')
    testcase["sample"] = []
    while (val := input("> ")) != "EOF":
        testcase["sample"].append(val)
    print("What is the puzzle's sample answer?")
    testcase["answer"] = int(input("> "))

def write_solution(day, part, testcase):
    print(f"[i] Creating solution file for {day}.{part}")
    lday = str(day).zfill(2)
    write_file(
        path=f"src/main/java/com/ilaird/aoc2023/day{lday}/D{day}P{part}Solver.java",
        lines=[
            f"package com.ilaird.aoc2023.day{lday};",
            "",
            "import org.springframework.beans.factory.annotation.Autowired;",
            "import org.springframework.stereotype.Component;",
            "",
            "import com.ilaird.aoc2023.aoc.AocSolution;",
            "import com.ilaird.aoc2023.aoc.Solver;",
            "import com.ilaird.aoc2023.aoc.SolverError;",
            "",
            "@Component",
            f"@AocSolution(day = {day}, part = {part})",
            f"class D{day}P{part}Solver implements Solver {{",
            "",
            "    @Autowired",
            "    private Iterable<String> input;",
            "",
            "    @Override",
            "    public int solve() throws SolverError {",
            "        var ret = 0;",
            "        for (String line : input) {",
            "            ret += line.length();",
            "        }",
            "        return ret;",
            "    }",
            "}",
        ]
    )


def write_tests(day, part, testcase):
    print(f"[i] Creating test file for {day}.{part}")
    lday = str(day).zfill(2)
    munge = lambda l: l.replace('"', r'\"')
    sample = [
        f'            "{munge(line)}"' for line in testcase["sample"]
    ]
    write_file(
        path=f"src/test/java/com/ilaird/aoc2023/day{lday}/D{day}P{part}SolverTest.java",
        lines=[
            f'package com.ilaird.aoc2023.day{lday};',
            '',
            'import org.junit.jupiter.api.BeforeEach;',
            '',
            'import com.ilaird.aoc2023.aoc.PartSolverTestBase;',
            'import com.ilaird.aoc2023.aoc.StringPuzzleInput;',
            '',
            f'class D{day}P{part}SolverTest extends PartSolverTestBase<String> {{',
            '',
            '    @BeforeEach',
            '    void setUp() {',
            f'        unit = new D{day}P{part}Solver();',
            '        parser = new StringPuzzleInput();',
            f'        answer = {testcase["answer"]};',
            '        sample = new String[] {',
            ",\n".join(sample),
            '        };',
            '',
            '        initMocks();',
            '    }',
            '}',
        ]
    )


def download_input(day, part):
    print(f"[i] Preparing to download input file for {day}.{part}.")
    print("[i] Reading session file.")
    lday = str(day).zfill(2)
    session = get_aoc_session()
    url = f"https://adventofcode.com/2023/day/{day}/input"
    result = requests.get(url, cookies={"session": session})
    if result.status_code == 200:
        write_file(f"src/main/resources/day{lday}.txt", [result.text])
    else:
        print(f"[w] Failed to download input file: {result.text}")

def get_aoc_session():
    path = Path(".AOC_SESSION")
    if path.exists():
        with open(path, "r") as fd:
            return fd.read().strip()
    print("[w] Session file not found. You will need to deal with that.")


def write_file(path, lines):
    path = Path(path)
    if path.exists():
        print("[w]: File already exists. Refusing to overwite!")
        print(path)
    else:
        print(f"[i] Writing {path}")
        path.parent.mkdir(parents=True, exist_ok=True)
        with open(path, mode="w", encoding="UTF8") as fd:
            fd.write("\n".join(lines))

def main():
    opts = get_opts()
    testcase = dict(
        sample = ["Hello, world!"],
        answer = len("Hello, world!"),
    )

    actions = []

    if opts.collect_testcase and opts.no_test:
        print("ERROR: --collect-testcase and --no-test are sorta mutually exclusive.")
        return

    if opts.collect_testcase and not opts.no_test:
        actions.append(lambda:collect_testcase(testcase))

    if not opts.no_solution:
        actions.append(lambda:write_solution(opts.day, opts.part, testcase))

    if not opts.no_test:
        actions.append(lambda:write_tests(opts.day, opts.part, testcase))

    if opts.download_input:
        actions.append(lambda:download_input(opts.day, opts.part))

    if len(actions) == 0:
        print("[i] Hmm, nothing to do.")

    for action in actions:
        action()


if __name__ == "__main__":
    main()
