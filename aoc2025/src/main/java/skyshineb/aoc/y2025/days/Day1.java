package skyshineb.aoc.y2025.days;

import skyshineb.aoc.y2025.core.AoCDay;
import skyshineb.aoc.y2025.core.Input;
import skyshineb.aoc.y2025.core.ProblemSolver;

import java.util.List;


@AoCDay(day = 1, inputFile = "aoc/2025/day1.txt")
public class Day1 implements ProblemSolver {

    @Override
    public String solveP1(Input input) {
        List<String> rotations = input.lines();
        long intersections = 0;
        int cur = 50;
        for (var rotation : rotations) {
            int num = Integer.parseInt(rotation.substring(1));
            if (num > 99) {
                num = Integer.parseInt(rotation.substring(2));
            }
            if (rotation.charAt(0) == 'L') {
                cur -= num;
            } else {
                cur += num;
            }
            if (cur < 0) {
                cur += 100;
            } else if (cur > 99) {
                cur -=100;
            }
            if (cur == 0) {
                intersections++;
            }
        }
        return String.valueOf(intersections);
    }

    @Override
    public String solveP2(Input input) {
        List<String> rotations = input.lines();
        long intersections = 0;
        int cur = 50, prev = cur;
        for (var rotation : rotations) {
            int num = Integer.parseInt(rotation.substring(1));
            if (num > 99) {
                // number of times it crosses the 0 in any direction
                intersections += Integer.parseInt(rotation.substring(1, 2));
                num = Integer.parseInt(rotation.substring(2));
            }
            if (rotation.charAt(0) == 'L') {
                prev = cur;
                cur -= num;
            } else {
                prev = cur;
                cur += num;
            }
            if (cur < 0) {
                cur += 100;
                if (prev != 0) intersections++;
                continue;
            } else if (cur > 99) {
                cur -=100;
                if (prev != 0) intersections++;
                continue;
            }
            if (cur == 0) {
                intersections++;
            }
        }
        return String.valueOf(intersections);
    }
}
