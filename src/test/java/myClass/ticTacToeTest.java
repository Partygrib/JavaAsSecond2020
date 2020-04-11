package myClass;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ticTacToeTest {

    @org.junit.jupiter.api.Test
    void inField() {
        ticTacToe main = new ticTacToe(3);
        char[][] result1 = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
        main.inField();
        assertArrayEquals(result1, main.field);

        main = new ticTacToe(2);
        char[][] result2 = {
                {' ',' '},
                {' ',' '}
        };
        main.inField();
        assertArrayEquals(result2, main.field);

        main = new ticTacToe(4);
        char[][] result3 = {
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '}
        };
        main.inField();
        assertArrayEquals(result3, main.field);

        main = new ticTacToe(0);
        assertNull(main.field);
    }

    @org.junit.jupiter.api.Test
    void PrintField() {
        ticTacToe main = new ticTacToe(3);
        main.inField();
        main.putK(0, 0);
        main.putO(0, 1);
        main.putK(1, 0);
        assertEquals("| x | o |   |\n" +
                "| x |   |   |\n" +
                "|   |   |   |", main.toString());
    }

    @org.junit.jupiter.api.Test
    void putK() {
        ticTacToe main = new ticTacToe(3);
        main.inField();
        main.putK(1, 2);
        assertEquals('x', main.field[1][2]);

        main = new ticTacToe(5);
        main.inField();
        main.putK(4, 4);
        assertEquals('x', main.field[4][4]);

        main = new ticTacToe(2);
        main.inField();
        main.putO(0, 0);
        main.putK(0, 0);
        assertEquals('o', main.field[0][0]);
    }

    @org.junit.jupiter.api.Test
    void putO() {
        ticTacToe main = new ticTacToe(4);
        main.inField();
        main.putO(3, 3);
        assertEquals('o', main.field[3][3]);

        main = new ticTacToe(2);
        main.inField();
        main.putO(0, 1);
        assertEquals('o', main.field[0][1]);

        main = new ticTacToe(2);
        main.inField();
        main.putK(1, 1);
        main.putO(1, 1);
        assertEquals('x', main.field[1][1]);
    }

    @org.junit.jupiter.api.Test
    void clear() {
        ticTacToe main = new ticTacToe(5);
        main.inField();
        main.putO(0, 0);
        main.clear(0, 0);
        assertEquals(' ', main.field[0][0]);
    }

    @org.junit.jupiter.api.Test
    void findK() {
        ticTacToe main = new ticTacToe(3);
        main.inField();
        main.putK(0, 0);
        main.putK(0, 1);
        main.putK(0, 2);
        List<String> result1 = new LinkedList<String>();
        result1.add("0;0");
        result1.add("0;1");
        result1.add("0;2");
        assertEquals(result1, main.findK());

        main = new ticTacToe(5);
        main.inField();
        main.putK(4, 1);
        main.putK(3, 2);
        main.putK(2, 3);
        main.putK(1, 4);
        main.putK(4, 3);
        List<String> result2 = new LinkedList<String>();
        result2.add("4;1");
        result2.add("3;2");
        result2.add("2;3");
        result2.add("1;4");
        assertEquals(result2, main.findK());
    }

    @org.junit.jupiter.api.Test
    void findO() {
        ticTacToe main = new ticTacToe(4);
        main.inField();
        main.putO(0, 0);
        main.putO(1, 1);
        main.putO(2, 2);
        main.putO(0, 2);
        main.putO(1, 2);
        main.putO(3, 2);
        LinkedList<String> result1 = new LinkedList<String>();
        result1.add("0;2");
        result1.add("1;2");
        result1.add("2;2");
        result1.add("3;2");
        assertEquals(result1, main.findO());

        main = new ticTacToe(2);
        main.inField();
        main.putO(0, 1);
        main.putO(1, 1);
        main.putK(1, 0);
        main.putK(0, 0);
        LinkedList<String> result2 = new LinkedList<String>();
        result2.add("0;1");
        result2.add("1;1");
        assertEquals(result2, main.findO());
    }
}