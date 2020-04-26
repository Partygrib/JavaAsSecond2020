package myClass;

import java.util.*;

class ticTacToe {
    private final char empty = ' ';
    private final char k = 'x';
    private final char o = 'o';
    private final int raz;
    private final char[][] field;

    public ticTacToe(Integer r) {
        raz = r;
        if (raz < 1) throw new IllegalArgumentException();
        field = new char[raz][raz];
    }

    private boolean check(Integer x, Integer y) {
        return !(x >= raz | x < 0 | y >= raz | y < 0);
    }

    public Object getCell(Integer x, Integer y) {
        if (check(x, y)) return field[x][y];
        else return "Ошибка!Такой клетки не существует!";
    }

    public void inField() {
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
        if (!check(x, y)) return "Ошибка!Такой клетки не существует!";
        if (field[x][y] != empty) return "Ошибка!Клетка уже занята!";
        else {
            field[x][y] = k;
            return "Успешно!";
        }
    }

    public String putO(Integer x, Integer y) {
        if (!check(x, y)) return "Ошибка!Такой клетки не существует!";
        if (field[x][y] != empty) return "Ошибка!Клетка уже занята!";
        else {
            field[x][y] = o;
            return "Успешно!";
        }
    }

    public String clear(Integer x, Integer y) {
        if (check(x, y)) {
            field[x][y] = empty;
            return "Успех";
        }
        else return "Ошибка!Такой клетки не существует!";
    }

    public List<String> findK() { return helper(k); }

    public List<String> findO() { return helper(o); }

    private void compare(List<String> list1, List<String> list2) {
        //сравнение получившейся комбинации с наибольшей
        if (list1.size() > list2.size()) {
            list2.clear();
            list2.addAll(list1);
        }
        list1.clear();
    }

    private void record(char z, List<String> list1, List<String> list2, int a, int b) {
        //запись текущей комбинации
        if (field[a][b] == z)
            list1.add(String.format("%d;%d", a, b));
        else compare(list1, list2);
    }

    private List<String> helper(char z) {
        int s;
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        //поиск комбинаций по горизонтали
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                record(z, list1, list2, i, j);
            }
            compare(list1, list2);
        }
        //поиск комбинаций по вертикали
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                record(z, list1, list2, j, i);
            }
            compare(list1, list2);
        }
        //поиск комбинаций по диагонали четверти левого нижнего угла поля
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                record(z, list1, list2, s, j);
                s = s + 1;
            }
            compare(list1, list2);
        }
        //поиск комбинаций по диагонали четверти правого верхнего угла поля
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                record(z, list1, list2, j, s);
                s = s + 1;
            }
            compare(list1, list2);
        }
        //поиск комбинаций по диагонали четверти левого верхнего угла поля
        for (int i = 0;i < raz - 1;i++) {
            s = i + 1;
            for (int j = 0; j < i + 2; j++) {
                record(z, list1, list2, s, j);
                s = s - 1;
            }
            compare(list1, list2);
        }
        //поиск комбинаций по диагонали четверти правого нижнего угла поля
        for (int i = 1;i < raz;i++) {
            s = raz - 1;
            for (int j = raz - i - 1; j < raz; j++) {
                record(z, list1, list2, s, j);
                s = s - 1;
            }
            compare(list1, list2);
        }
        return list2;
    }
}
