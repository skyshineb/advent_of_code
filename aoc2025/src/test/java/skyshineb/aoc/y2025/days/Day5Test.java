package skyshineb.aoc.y2025.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skyshineb.aoc.y2025.core.Input;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {
    private final String input = """
            3-5
            10-14
            16-20
            12-18
            
            1
            5
            8
            11
            17
            32""";

    @Test
    void solveP1() {
        var solver = new Day5();
        Assertions.assertEquals("3", solver.solveP1(new Input(input)));
    }

    @Test
    void solveP2() {
        var solver = new Day5();
        Assertions.assertEquals("14", solver.solveP2(new Input(input)));
    }
}