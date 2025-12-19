package skyshineb.aoc.y2025.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skyshineb.aoc.y2025.core.Input;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void solveP1() {

    }

    @Test
    void solveP2() {
        var input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
        var solver = new Day2();
        Assertions.assertEquals("4174379265", solver.solveP2(new Input(input)));
    }
}