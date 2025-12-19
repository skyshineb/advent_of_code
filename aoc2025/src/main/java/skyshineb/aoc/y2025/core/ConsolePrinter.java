package skyshineb.aoc.y2025.core;

import java.io.PrintStream;
import java.util.List;

public class ConsolePrinter {
    private final PrintStream out;

    public ConsolePrinter(PrintStream out) {
        this.out = out;
    }

    public void print(List<RunResult> results) {
        if (results.isEmpty()) {
            out.println("No solvers found.");
            return;
        }

        int dayW = "Day".length();
        int p1W  = "Part1".length();
        int p2W  = "Part2".length();

        for (RunResult r : results) {
            dayW = Math.max(dayW, String.valueOf(r.day()).length());
            p1W  = Math.max(p1W, r.part1().length());
            p2W  = Math.max(p2W, r.part2().length());
        }

        String header = String.format("%-" + dayW + "s | %-" + p1W + "s | %-" + p2W + "s",
                "Day", "Part1", "Part2");
        out.println(header);
        out.println("-".repeat(header.length()));

        for (RunResult r : results) {
            out.printf("%" + dayW + "d | %-" + p1W + "s | %-" + p2W + "s%n",
                    r.day(), r.part1(), r.part2());
        }
    }
}
