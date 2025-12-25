package skyshineb.aoc.y2025.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skyshineb.aoc.y2025.core.Input;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    private final String input = """
            987654321111111
            811111111111119
            234234234234278
            818181911112111""";

    @Test
    public void testP1() {
        var solver = new Day3();
        var result = solver.solveP1(new Input(input));
        Assertions.assertEquals("357", result);
    }

    @Test
    public void testP2() {
        var solver = new Day3();
        var result = solver.solveP2(new Input(input));
        Assertions.assertEquals("3121910778619", result);
    }

}