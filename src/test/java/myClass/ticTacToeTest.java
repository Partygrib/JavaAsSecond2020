package myClass;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        for (int i = 0;i < 3;i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(result1[i][j], main.getCell(i, j));
            }
        }

        main = new ticTacToe(2);
        char[][] result2 = {
                {' ', ' '},
                {' ', ' '}
        };
        main.inField();
        for (int i = 0;i < 2;i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(result2[i][j], main.getCell(i, j));
            }
        }

        main = new ticTacToe(4);
        char[][] result3 = {
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '}
        };
        main.inField();
        for (int i = 0;i < 4;i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(result3[i][j], main.getCell(i, j));
            }
        }

        main = new ticTacToe(3);
        assertEquals("Ошибка!Такой клетки не существует!", main.getCell(5, 2));

        try {
            ticTacToe main1 = new ticTacToe(0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Размер поля не может быть меньше единицы!");
        }

        try {
            ticTacToe main2 = new ticTacToe(-2);
        } catch (IllegalArgumentException ex) {
            System.out.println("Размер поля не может быть меньше единицы!");
        }
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        ticTacToe main = new ticTacToe(3);
        main.inField();
        main.putK(0, 0);
        main.putO(0, 1);
        main.putK(1, 0);
        String result1 = "| x | o |   |" + System.lineSeparator() +
                "| x |   |   |" + System.lineSeparator() + "|   |   |   |";
        assertEquals(result1, main.toString());

        main = new ticTacToe(2);
        main.inField();
        String result2 = "|   |   |" + System.lineSeparator() + "|   |   |";
        assertEquals(result2, main.toString());

        main = new ticTacToe(4);
        main.inField();
        main.putK(0, 0);
        main.putO(0, 1);
        main.putK(0, 2);
        main.putO(0, 3);
        main.putK(1, 0);
        main.putO(2, 2);
        main.putK(3, 0);
        main.putK(3, 1);
        main.putK(3, 2);
        main.putK(3, 3);
        String result3 = "| x | o | x | o |" + System.lineSeparator() + "| x |   |   |   |" + System.lineSeparator()
                + "|   |   | o |   |" + System.lineSeparator() + "| x | x | x | x |";
        assertEquals(result3, main.toString());
    }

    @org.junit.jupiter.api.Test
    void putK() {
        ticTacToe main = new ticTacToe(3);
        main.inField();
        assertEquals("Успешно!", main.putK(1, 2));
        assertEquals('x', main.getCell(1,2));

        main = new ticTacToe(5);
        main.inField();
        assertEquals("Успешно!", main.putK(4, 4));
        assertEquals('x', main.getCell(4,4));

        main = new ticTacToe(2);
        main.inField();
        main.putO(0, 0);
        assertEquals("Ошибка!Клетка уже занята!", main.putK(0, 0));
        assertEquals('o', main.getCell(0,0));

        main = new ticTacToe(3);
        main.inField();
        assertEquals("Ошибка!Такой клетки не существует!", main.putK(4, 4));
    }

    @org.junit.jupiter.api.Test
    void putO() {
        ticTacToe main = new ticTacToe(4);
        main.inField();
        assertEquals("Успешно!", main.putO(3, 3));
        assertEquals('o', main.getCell(3,3));

        main = new ticTacToe(2);
        main.inField();
        assertEquals("Успешно!", main.putO(0, 1));
        assertEquals('o', main.getCell(0,1));

        main = new ticTacToe(2);
        main.inField();
        main.putK(1, 1);
        assertEquals("Ошибка!Клетка уже занята!", main.putO(1, 1));
        assertEquals('x', main.getCell(1,1));

        main = new ticTacToe(3);
        main.inField();
        assertEquals("Ошибка!Такой клетки не существует!", main.putO(3, 2));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        ticTacToe main = new ticTacToe(5);
        main.inField();
        main.putO(0, 0);
        main.clear(0, 0);
        assertEquals(' ', main.getCell(0,0));
        assertEquals("Ошибка!Такой клетки не существует!", main.clear(-2, 2));
    }

    @org.junit.jupiter.api.Test
    void findK() {
        ticTacToe main = new ticTacToe(3);
        main.inField();
        main.putK(0, 0);
        main.putK(0, 1);
        main.putK(0, 2);
        List<String> result1 = new LinkedList<>();
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
        List<String> result2 = new LinkedList<>();
        result2.add("4;1");
        result2.add("3;2");
        result2.add("2;3");
        result2.add("1;4");
        assertEquals(result2, main.findK());

        main = new ticTacToe(5);
        main.inField();
        main.putK(3, 0);
        main.putK(2, 1);
        main.putK(1, 2);
        main.putK(0, 3);
        main.putK(0, 0);
        main.putK(0, 1);
        List<String> result4 = new LinkedList<>();
        result4.add("3;0");
        result4.add("2;1");
        result4.add("1;2");
        result4.add("0;3");
        assertEquals(result4, main.findK());

        main = new ticTacToe(3);
        List<String> result3 = new LinkedList<>();
        main.inField();
        assertEquals(result3, main.findK());
    }

    @org.junit.jupiter.api.Test
    void findO() {
        ticTacToe main = new ticTacToe(5);
        main.inField();
        main.putO(1, 0);
        main.putO(2, 1);
        main.putO(3, 2);
        main.putO(4, 3);
        LinkedList<String> result1 = new LinkedList<>();
        result1.add("1;0");
        result1.add("2;1");
        result1.add("3;2");
        result1.add("4;3");
        assertEquals(result1, main.findO());

        main = new ticTacToe(5);
        main.inField();
        main.putO(0, 1);
        main.putO(1, 2);
        main.putO(2, 3);
        main.putO(3, 4);
        LinkedList<String> result4 = new LinkedList<>();
        result4.add("0;1");
        result4.add("1;2");
        result4.add("2;3");
        result4.add("3;4");
        assertEquals(result4, main.findO());

        main = new ticTacToe(2);
        main.inField();
        main.putO(0, 1);
        main.putO(1, 1);
        main.putK(1, 0);
        main.putK(0, 0);
        LinkedList<String> result2 = new LinkedList<>();
        result2.add("0;1");
        result2.add("1;1");
        assertEquals(result2, main.findO());

        main = new ticTacToe(4);
        List<String> result3 = new LinkedList<>();
        main.inField();
        assertEquals(result3, main.findO());
    }
}