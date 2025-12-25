package skyshineb.aoc.y2025.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skyshineb.aoc.y2025.core.Input;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    private final String input = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.""";

    @Test
    void solveP1() {
        var solver = new Day4();
        Assertions.assertEquals("13", solver.solveP1(new Input(input)));
    }

    @Test
    void solveP2() {
        var solver = new Day4();
        Assertions.assertEquals("43", solver.solveP2(new Input(input)));
    }

    @Test
    public void testCountAdjacentScrolls() {
        var solver = new Day4();
        Assertions.assertEquals(3,solver.countAdjacentScrolls(solver.convertInput(new Input(input)), 2, 0));
        Assertions.assertEquals(4,solver.countAdjacentScrolls(solver.convertInput(new Input(input)), 4, 1));
        Assertions.assertEquals(1,solver.countAdjacentScrolls(solver.convertInput(new Input(input)), 0, 9));
        Assertions.assertEquals(4,solver.countAdjacentScrolls(solver.convertInput(new Input(input)), 9, 5));
        Assertions.assertEquals(7,solver.countAdjacentScrolls(solver.convertInput(new Input(input)), 5, 8));
    }
}