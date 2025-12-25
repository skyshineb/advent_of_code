package skyshineb.aoc.y2025.days;

import skyshineb.aoc.y2025.core.AoCDay;
import skyshineb.aoc.y2025.core.Input;
import skyshineb.aoc.y2025.core.ProblemSolver;

@AoCDay(day = 3, inputFile = "aoc/2025/day3.txt")
public class Day3 implements ProblemSolver {
    @Override
    public String solveP1(Input input) {
        var banks = input.lines();
        int sum = 0;
        for (var bank : banks) {
            char[] chrs = bank.toCharArray();
            int head = -1, tail = -1;
            int headI = chrs.length - 2, tailI;
            for (int i = chrs.length - 2; i >= 0 ; i--) {
                int curH = chrs[i] - '0';
                if (curH >= head) {
                    head = curH;
                    headI = i;
                }
            }
            for (int i = chrs.length - 1; i > headI ; i--) {
                int curT = chrs[i] - '0';
                if (curT >= tail) {
                    tail = curT;
                    tailI = i;
                }
            }
            int num = Integer.parseInt("%s%s".formatted(head, tail));
            sum += num;
        }
        return String.valueOf(sum);
    }

    @Override
    public String solveP2(Input input) {
        var banks = input.lines();
        long sum = 0;
        for (var bank : banks) {
            char[] chrs = bank.toCharArray();
            char[] num = new char[12];

            int lb = -1, rb = chrs.length - 12;
            int candidate = 0, newLb = lb;
            for (int i = 0; i < 12; i++) {
                for (int j = rb; j > lb ; j--) {
                    int cur = chrs[j] - '0';
                    if (cur >= candidate) {
                        candidate = cur;
                        newLb = j;
                    }
                }
                num[i] = Integer.toString(candidate).toCharArray()[0];
                lb = newLb;
                rb ++;
                candidate = 0;
            }

            long numLong = Long.parseLong(String.valueOf(num));
            sum += numLong;
        }
        return String.valueOf(sum);
    }
}
