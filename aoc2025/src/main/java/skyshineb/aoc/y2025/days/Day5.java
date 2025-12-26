package skyshineb.aoc.y2025.days;

import skyshineb.aoc.y2025.core.AoCDay;
import skyshineb.aoc.y2025.core.Input;
import skyshineb.aoc.y2025.core.ProblemSolver;

import java.util.ArrayList;
import java.util.Comparator;

@AoCDay(day = 5, inputFile = "aoc/2025/day5.txt")
public class Day5 implements ProblemSolver {

    record Range(long min, long max) {
        public boolean inRange(long n) {
            return (n <= max) && (n >= min);
        }

        public long count() {
            return max - min + 1;
        }

        public Range withMax(long newMax) {
            return new Range(this.min, newMax);
        }
    }

    @Override
    public String solveP1(Input input) {
        ArrayList<Range> ranges = new ArrayList<>();
        long[] ids = null;
        boolean wasEmpty = false;
        int j = 0;
        for (int i = 0; i < input.lines().size(); i++) {
            String line = input.lines().get(i);
            if (line.isBlank()){
                wasEmpty = true;
                ids = new long[input.lines().size() - i - 1];

            } else if (!wasEmpty) {
                String[] rangeIds = line.split("-");
                ranges.add(new Range(Long.parseLong(rangeIds[0]), Long.parseLong(rangeIds[1])));
            } else {
                ids[j] = Long.parseLong(line);
                j++;
            }
        }
        // check spoilage
        int freshCount = 0;
        for (int i = 0; i < ids.length; i++) {
            long id = ids[i];
            boolean fresh = false;
            for (var range : ranges) {
                if (range.inRange(id)) {
                    fresh = true;
                }
            }
            if (fresh) {
                freshCount++;
            }
        }
        return "%s".formatted(freshCount);
    }

    @Override
    public String solveP2(Input input) {
        ArrayList<Range> ranges = new ArrayList<>();
        ArrayList<Range> mergedRanges = new ArrayList<>();
        for (int i = 0; i < input.lines().size(); i++) {
            String line = input.lines().get(i);
            if (line.isBlank()){
                break;
            } else {
                String[] rangeIds = line.split("-");
                ranges.add(new Range(Long.parseLong(rangeIds[0]), Long.parseLong(rangeIds[1])));
            }
        }
        ranges.sort(Comparator.comparingLong(x -> x.min));
        for (var range : ranges) {
            if (mergedRanges.isEmpty()) {
                mergedRanges.add(range);
                continue;
            }
            if (range.min <= mergedRanges.getLast().max) {
                long newMax = Math.max(range.max, mergedRanges.getLast().max);
                Range newRange = mergedRanges.removeLast().withMax(newMax);
                mergedRanges.add(newRange);
            } else {
                mergedRanges.add(range);
            }
        }
        long sum = 0;
        for (var range : mergedRanges) {
            sum += range.count();
        }
        return "%s".formatted(sum);
    }
}
