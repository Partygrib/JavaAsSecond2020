package myClass;
import java.lang.reflect.Array;
import java.util.*;
class ticTacToe {
    private final char empty = ' ';
    private final char k = 'x';
    private final char o = 'o';
    private int raz;
    public char[][] field;
    public ticTacToe(Integer r) {
        raz = r;
        if (raz < 1) throw new IllegalArgumentException();
        field = new char[raz][raz];
    }
    public void inField() {
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                field[i][j] = empty;
            }
        }
    }

    public void putK(Integer x, Integer y) {
        field[x][y] = k;
    }

    @Override
    public String toString() {
        return "ticTacToe{" +
                "field=" + Arrays.toString(field) +
                '}';
    }

    public void putO(Integer x, Integer y) {
        field[x][y] = o;
    }
    public void clear(Integer x, Integer y) {
        field[x][y] = empty;
    }
    public List<String> findK() {
        int s;
        List<String> list1 = new LinkedList<String>();
        List<String> list2 = new LinkedList<String>();
        s = 0;
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (field[i][j] == k)
                    list1.add(String.format("%d;%d", i, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (field[j][i] == k)
                    list1.add(String.format("%d;%d", j, i));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (field[s][j] == k)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (field[j][s] == k)
                    list1.add(String.format("%d;%d", j, s));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz - 1;i++) {
            s = i + 1;
            for (int j = 0; j < i + 2; j++) {
                if (field[s][j] == k)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - 1;
            for (int j = raz - i - 1; j < raz; j++) {
                if (field[s][j] == k)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                        list1.clear();
                    }
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        return list2;
    }
    public List<String> findO() {
        int s;
        List<String> list1 = new LinkedList<String>();
        List<String> list2 = new LinkedList<String>();
        s = 0;
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (field[i][j] == o)
                    list1.add(String.format("%d;%d", i, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz;i++) {
            for (int j = 0; j < raz; j++) {
                if (field[j][i] == o)
                    list1.add(String.format("%d;%d", j, i));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (field[s][j] == o)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - i - 1;
            for (int j = 0; j < i + 1; j++) {
                if (field[j][s] == o)
                    list1.add(String.format("%d;%d", j, s));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s + 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 0;i < raz - 1;i++) {
            s = i + 1;
            for (int j = 0; j < i + 2; j++) {
                if (field[s][j] == o)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        for (int i = 1;i < raz;i++) {
            s = raz - 1;
            for (int j = raz - i - 1; j < raz; j++) {
                if (field[s][j] == o)
                    list1.add(String.format("%d;%d", s, j));
                else {
                    if (list1.size() > list2.size()) {
                        list2.clear();
                        list2.addAll(list1);
                    }
                    list1.clear();
                }
                s = s - 1;
            }
            if (list1.size() > list2.size()) {
                list2.clear();
                list2.addAll(list1);
            }
            list1.clear();
        }
        return list2;
    }
}
