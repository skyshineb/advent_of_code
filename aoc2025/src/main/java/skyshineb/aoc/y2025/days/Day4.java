package skyshineb.aoc.y2025.days;

import skyshineb.aoc.y2025.core.AoCDay;
import skyshineb.aoc.y2025.core.Input;
import skyshineb.aoc.y2025.core.ProblemSolver;

@AoCDay(day = 4, inputFile = "aoc/2025/day4.txt")
public class Day4 implements ProblemSolver {

    public boolean[][] convertInput(Input input) {
        var lines = input.lines();
        boolean[][] res = new boolean[lines.size()][lines.getFirst().length()];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                res[i][j] = line.charAt(j) == '@';
            }
        }
        return res;
    }

    private int count3InARow(boolean[][] shelf, int x, int y) {
        boolean[] row = shelf[y];
        int rb = row.length;
        int sum = 0;
        for (int i = - 1; i < 2 ; i++) {
            if (x + i >= 0 && x + i < rb && row[x + i]) {
                sum += 1;
            }
        }
        return sum;
    }

    public int countAdjacentScrolls(boolean[][] shelf, int x, int y) {
        int count = -1; // set to -1 because countAdjScrolls will count the target (x,y) also
        int bb = shelf.length;
        for (int i = - 1; i < 2 ; i++) {
            if (y + i >= 0 && y + i < bb) {
                count += count3InARow(shelf, x, y + i);
            }
        }
        return count;
    }

    @Override
    public String solveP1(Input input) {
        var shelf = convertInput(input);
        var sum = 0;
        for (int y = 0; y < shelf.length ; y++) {
            for (int x = 0; x < shelf[0].length; x++) {
                if (shelf[y][x] && countAdjacentScrolls(shelf, x, y) < 4) {
                    sum++;
                }
            }
        }
        return "%s".formatted(sum);
    }

    @Override
    public String solveP2(Input input) {
        var shelf = convertInput(input);
        var sumRemoved = 0;
        var curRemoved = 0;
        do {
            curRemoved = 0;
            for (int y = 0; y < shelf.length ; y++) {
                for (int x = 0; x < shelf[0].length; x++) {
                    if (shelf[y][x] && countAdjacentScrolls(shelf, x, y) < 4) {
                        curRemoved++;
                        shelf[y][x] = false;
                    }
                }
            }
            sumRemoved += curRemoved;

        } while (curRemoved > 0);
        return "%s".formatted(sumRemoved);
    }
}
