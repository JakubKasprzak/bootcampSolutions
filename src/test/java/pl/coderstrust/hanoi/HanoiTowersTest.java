package pl.coderstrust.hanoi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HanoiTowersTest {

    @ParameterizedTest
    @MethodSource("hanoiTowersArguments")
    void shouldReturnCorrectStackOFDiscsOnPile3(HanoiTower givenA, HanoiTower givenB, HanoiTower givenC, HanoiTower expected) throws IOException {
        assertEquals(expected.getDiscs().size(), HanoiTowers.hanoi(givenA, givenB, givenC).getDiscs().size());
    }

    private static Stream<Arguments> hanoiTowersArguments() {
        HanoiTower expected3C = new HanoiTower("e3C");
        expected3C.getDiscs().push(3);
        expected3C.getDiscs().push(2);
        expected3C.getDiscs().push(1);

        HanoiTower given3A = new HanoiTower("g3A");
        given3A.getDiscs().push(3);
        given3A.getDiscs().push(2);
        given3A.getDiscs().push(1);

        HanoiTower given3B = new HanoiTower("g3B");

        HanoiTower given3C = new HanoiTower("g3C");

        return Stream.of(
                Arguments.of(given3A, given3B, given3C, expected3C));
    }

    @Test
    void shouldThrowEmptyStackExceptionForEmptyPileA() {
        HanoiTower givenEmptyPileA = new HanoiTower("gA0");
        HanoiTower givenPileB = new HanoiTower("gB0");
        HanoiTower givenPileC = new HanoiTower("gC0");
        assertThrows(EmptyStackException.class, () -> HanoiTowers.hanoi(givenEmptyPileA, givenPileB, givenPileC));
    }

    @ParameterizedTest
    @MethodSource("hanoiLoadedBorCTowerArguments")
    void shouldThrowRuntimeException(HanoiTower givenPileA, HanoiTower givenPileB, HanoiTower givenPileC) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> HanoiTowers.hanoi(givenPileA, givenPileB, givenPileC));
        assertEquals("Piles B and C must be empty", thrown.getMessage());
    }

    private static Stream<Arguments> hanoiLoadedBorCTowerArguments() {
        HanoiTower givenPileA = new HanoiTower("g3A");
        givenPileA.getDiscs().push(3);
        givenPileA.getDiscs().push(2);
        givenPileA.getDiscs().push(1);

        HanoiTower givenPileB = new HanoiTower("g3B");
        givenPileB.getDiscs().push(1);

        HanoiTower givenPileC = new HanoiTower("g3C");
        givenPileC.getDiscs().push(1);

        HanoiTower givenEmptyPileB = new HanoiTower("gEB");

        HanoiTower givenEmptyPileC = new HanoiTower("gEC");

        return Stream.of(
                Arguments.of(givenPileA, givenPileB, givenEmptyPileC),
                Arguments.of(givenPileA, givenEmptyPileB, givenPileC));
    }
}
