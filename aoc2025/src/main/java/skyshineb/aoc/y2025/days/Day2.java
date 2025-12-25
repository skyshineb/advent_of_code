package skyshineb.aoc.y2025.days;

import skyshineb.aoc.y2025.core.AoCDay;
import skyshineb.aoc.y2025.core.Input;
import skyshineb.aoc.y2025.core.ProblemSolver;


@AoCDay(day = 2, inputFile = "aoc/2025/day2.txt")
public class Day2 implements ProblemSolver {
    @Override
    public String solveP1(Input input) {
        String[] ids = input.raw().trim().split(",");
        long sum = 0;

        for (String id : ids) {
            String[] range = id.split("-");
            for (long i = Long.parseLong(range[0]); i <= Long.parseLong(range[1]); i++) {
                String strId = String.valueOf(i);
                if (strId.length() % 2 != 0) continue;
                int middle = strId.length() / 2;
                if (strId.substring(0, middle).equals(strId.substring(middle))) {
                    sum += i;
                }
            }
        }
        return String.valueOf(sum);
    }

    @Override
    public String solveP2(Input input) {
        String[] ids = input.raw().trim().split(",");
        long sum = 0;

        for (String id : ids) {
            String[] range = id.split("-");
            for (long i = Long.parseLong(range[0]); i <= Long.parseLong(range[1]); i++) {
                String strId = String.valueOf(i);
                // bruteforce
                for (int j = 2; j <= strId.length(); j++) {
                    if (strId.length() % j != 0) continue;
                    // inner loop of splits
                    int step = strId.length() / j;
                    int firstN = Integer.parseInt(strId.substring(0, step));
                    boolean patternFound = true;
                    for (int s = 0, e = step; s < strId.length(); s = e, e += step) {
                        if ((firstN ^ Integer.parseInt(strId.substring(s, e))) != 0) {
                            patternFound = false;
                        }
                    }
                    if (patternFound) {
                        sum += i;
                        break;
                    }
                }
            }
        }
        return String.valueOf(sum);
    }
}
