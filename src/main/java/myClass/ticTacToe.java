package myClass;

import java.util.*;
class ticTacToe {
    private final char empty = ' ';
    private final char k = 'x';
    private final char o = 'o';
    private final int raz;
    private final char[][] field;

    public ticTacToe(Integer r) throws Exception {
        raz = r;
        if (raz < 1) throw new Exception("Размер поля не может быть меньше единицы!");
        field = new char[raz][raz];
    }

    public boolean help1(Integer x, Integer y) {
        return !(x >= raz | x < 0 | y >= raz | y < 0);
    }

    public Object getCell(Integer x, Integer y) {
        if (help1(x, y)) return field[x][y];
        else return "Ошибка!Такой клетки не существует!";
    }

    void inField() {
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                field[i][j] = empty;
            }
        }
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;
        ticTacToe ticTacToe = (ticTacToe) o1;
        return raz == ticTacToe.raz && Arrays.equals(field, ticTacToe.field);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(empty, k, o, raz);
        result = 31 * result + Arrays.hashCode(field);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        for (int i = 0; i < raz; i++) {
            for (int j = 0; j < raz; j++) {
                builder.append(String.format(" %c |", field[i][j]));
            }
            if (i + 1 < raz) builder.append(System.lineSeparator()).append("|");
        }
        return builder.toString();
    }

    public String putK(Integer x, Integer y) {
        if (!help1(x, y)) return "Ошибка!Такой клетки не существует!";
        if (field[x][y] != empty) return "Ошибка!Клетка уже занята!";
        else {
            field[x][y] = k;
            return "Успешно!";
        }
    }

    public String putO(Integer x, Integer y) {
        if (!help1(x, y)) return "Ошибка!Такой клетки не существует!";
        if (field[x][y] != empty) return "Ошибка!Клетка уже занята!";
        else {
            field[x][y] = o;
            return "Успешно!";
        }
    }

    public String clear(Integer x, Integer y) {
        if (help1(x, y)) {
            field[x][y] = empty;
            return "Успех";
        }
        else return "Ошибка!Такой клетки не существует!";
    }

    public List<String> findK() { return helper2(k); }

    public List<String> findO() { return helper2(o); }

    public void helper4(List<String> list1, List<String> list2) {
        if (list1.size() > list2.size()) {
            list2.clear();
            list2.addAll(list1);
        }
        list1.clear();
    }

    public void helper3(char z, List<String> list1, List<String> list2, int a, int b) {
        if (field[a][b] == z)
            list1.add(String.format("%d;%d", a, b));
        else {
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
                list1.clear();
            }
        }
    }

    public List<String> helper2(char z) {
        int s;
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                helper3(z, list1, list2, i, j);
            }
            helper4(list1, list2);
        }
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                helper3(z, list1, list2, j, i);
            }
            helper4(list1, list2);
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                helper3(z, list1, list2, s, j);
                s = s + 1;
            }
            helper4(list1, list2);
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                helper3(z, list1, list2, j, s);
                s = s + 1;
            }
            helper4(list1, list2);
        }
        for (int i = 0;i < raz - 1;i++) {
            s = i + 1;
            for (int j = 0; j < i + 2; j++) {
                helper3(z, list1, list2, s, j);
                s = s - 1;
            }
            helper4(list1, list2);
        }
        for (int i = 1;i < raz;i++) {
            s = raz - 1;
            for (int j = raz - i - 1; j < raz; j++) {
                helper3(z, list1, list2, s, j);
                s = s - 1;
            }
            helper4(list1, list2);
        }
        return list2;
    }
}
