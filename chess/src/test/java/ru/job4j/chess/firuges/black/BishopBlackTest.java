package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expect = Cell.C8;
        Cell rsl = bishopBlack.position();
        assertThat(rsl).isEqualTo(expect);
    }

    @Test
    void whenCopyToG4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expect = Cell.G4;
        Cell rsl = bishopBlack.copy(Cell.G4).position();
        assertThat(rsl).isEqualTo(expect);
    }

    @Test
    void whenC1WayToG5ThanD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rsl = bishopBlack.way(Cell.G5);
        assertThat(rsl).isEqualTo(expect);
    }

    @Test
    void whenE6WayToA2ThanD5C4B3A2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E6);
        Cell[] expect = {Cell.D5, Cell.C4, Cell.B3, Cell.A2};
        Cell[] rsl = bishopBlack.way(Cell.A2);
        assertThat(rsl).isEqualTo(expect);
    }

    @Test
    void whenC3WayToD2ThanD2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Cell[] expect = {Cell.D2};
        Cell[] rsl = bishopBlack.way(Cell.D2);
        assertThat(rsl).isEqualTo(expect);
    }

    @Test
    void whenG1WayToA7ThanF2E3D4C5B6A7() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        Cell[] expect = {Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7};
        Cell[] rsl = bishopBlack.way(Cell.A7);
        assertThat(rsl).isEqualTo(expect);
    }

    @Test
    void whenIsDiagonalThenImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bishopBlack.way(Cell.A5);
        });
        assertThat(exception.getMessage())
                .isEqualTo("Could not way by diagonal from %s to %s",
                        bishopBlack.position(), Cell.A5);
    }
}