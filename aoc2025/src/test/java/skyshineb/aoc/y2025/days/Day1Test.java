package skyshineb.aoc.y2025.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skyshineb.aoc.y2025.core.Input;

class Day1Test {

    @Test
    public void testP1() {
        var input = """
                L68
                L30
                R48
                L5
                R60
                L55
                L1
                L99
                R14
                L82""";
        var solver = new Day1();
        Assertions.assertEquals("3", solver.solveP1(new Input(input)));
    }

    @Test
    public void testP2() {
        var input = """
                L68
                L30
                R48
                L5
                R60
                L55
                L1
                L99
                R14
                L82""";
        var solver = new Day1();
        Assertions.assertEquals("6", solver.solveP2(new Input(input)));
    }
}