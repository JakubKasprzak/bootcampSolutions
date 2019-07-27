package pl.coderstrust.hanoi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class HanoiTowersTest {

    @Test
    void shouldReturnCorrectStackOFDiscsOnPile3() throws IOException {
        //given
        HanoiTower givenA = new HanoiTower("A");
        givenA.getDiscs().push(3);
        givenA.getDiscs().push(2);
        givenA.getDiscs().push(1);
        HanoiTower givenB = new HanoiTower("B");
        HanoiTower givenC = new HanoiTower("C");
        Object discs = givenA.getDiscs().clone();
        //when
        HanoiTowers.hanoi(givenA, givenB, givenC);
        //then
        assertTrue(givenA.getDiscs().empty());
        assertTrue(givenB.getDiscs().empty());
        assertEquals(discs, givenC.getDiscs());
    }

    @Test
    void shouldThrowEmptyStackExceptionForEmptyPileA() {
        HanoiTower givenEmptyPileA = new HanoiTower("A");
        HanoiTower givenPileB = new HanoiTower("B");
        HanoiTower givenPileC = new HanoiTower("C");
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
        HanoiTower givenPileA = new HanoiTower("A");
        givenPileA.getDiscs().push(3);
        givenPileA.getDiscs().push(2);
        givenPileA.getDiscs().push(1);

        HanoiTower givenPileB = new HanoiTower("B");
        givenPileB.getDiscs().push(1);

        HanoiTower givenPileC = new HanoiTower("C");
        givenPileC.getDiscs().push(1);

        HanoiTower givenEmptyPileB = new HanoiTower("EB");

        HanoiTower givenEmptyPileC = new HanoiTower("EC");

        return Stream.of(
                Arguments.of(givenPileA, givenPileB, givenEmptyPileC),
                Arguments.of(givenPileA, givenEmptyPileB, givenPileC));
    }
}
