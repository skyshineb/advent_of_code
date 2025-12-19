package skyshineb.aoc.y2025.app;

import skyshineb.aoc.y2025.core.ConsolePrinter;
import skyshineb.aoc.y2025.core.InputLoader;
import skyshineb.aoc.y2025.core.Runner;

public class Main {
    public static void main(String[] args) {
        var inputLoader = new InputLoader();
        var runner = new Runner(inputLoader);
        var results = runner.runAll();

        var printer = new ConsolePrinter(System.out);
        printer.print(results);
    }
}
