package ru.entropysw.android.tictactoe.logic;

import ru.entropysw.android.tictactoe.view.Out;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 04.01.13
 * Time: 19:43
 * Класс, отвечающий за реализацию игровой логики, арбитр
 */
public class Arbiter {

    private Player activePlayer = Player.TIC_PLAYER;
    private Player winner;

    private Arbiter() {
        // синглтон
    }

    public static Arbiter get() {
        return new Arbiter();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void endTurn() {
        // todo: записывать состояние игрового поля в отдельный класс
        if (!hasWinner()) {
            moveTurn();
            Out.get().show(activePlayer.getName()+" player`s turn");
        } else {
            // todo: кричать MainActivity о том, что у нас победитель
        }
        /*
        Вообще, можно сделать класс-мессенджер, который будет заниматься выводом всяких сообщений на экран.
        Определить в нём разные типы сообщений, выводить их по-разному. Сделать ему простой интерфейс, наподобие
        какого-нибудь стандартного логгера, типа Out.info(), Out.error(), Out.win() и так далее. В этом случае
        тут будет достаточно сообщить MainActivity о том, что у нас победитель, а она залочит поле и выведет
        с помощью этого класса информационное сообщение и имя победителя.
         */
    }

    private boolean hasWinner() {
        // todo: обращаться к логическому классу игрового поля (НЕ GameFieldView), чтобы оно сообщало о победителе
        // проверяем строку, затем столбец, затем обе диагонали
        GameField gameField = GameField.get();
        int[][] data = gameField.getData();

        // строка
        int res = 0;
        res = checkLine(data[gameField.getLastX()]);
        if(res != 0) return setWinner(res);

        // столбец
        res = checkCol();
        if(res != 0) return setWinner(res);

        // диагонали
        res = checkDiagonals();
        if(res != 0) return setWinner(res);

        return false;
    }

    private boolean setWinner(int num) {
        winner = Player.TAC_PLAYER.getStatusNum() == num ? Player.TAC_PLAYER : Player.TIC_PLAYER;

        return true;
    }

    private void moveTurn() {
        activePlayer = (getActivePlayer() == Player.TIC_PLAYER) ? Player.TAC_PLAYER : Player.TIC_PLAYER;
    }

    /**
     * Проверяет массив
     *
     * Принцип такой.
     * - если произведение элементов массива равно 0, значит массив не заполнен и победителя нет
     * - если сумма элементов равна длине массива, то победитель определяется в зависимости от знака
     * Возвращает 0 - нет победителя, 1/-1 код победителя
     *
     *
     *
     * @param Line
     * @return
     */
    private int checkLine(int[] Line) {
        if(multiLine(Line) != 0) {
            int sum = sumLine(Line);
            if(sum == Line.length) {
                return sum/Line.length;
            } else {
                return 0;
            }
        }

        return 0;
    }

    /**
     * Проверяет колонку.
     *
     * Формирует массив данных и проверяет его через checkLine
     *
     * @return
     */
    private int checkCol() {
        int dim = GameField.get().getDimension();
        int[] col = new int[dim];
        for(int i = 0; i < dim; i++) {
            col[i] = GameField.get().getData()[GameField.get().getLastX()][i];
        }

        return checkLine(col);
    }

    /**
     * Проверяет диагонали
     *
     * Формирует данные из диагоналей и проверяет их через checkLine
     *
     * @return
     */
    private int checkDiagonals() {
        int dim = GameField.get().getDimension();
        int[][] diagonals = new int[dim][dim];
        // 1 диагональ
        for (int i = 0; i < dim; i++) {
            diagonals[0][i] = GameField.get().getData()[i][i];
        }
        // 2 диагональ
        for (int j = 0; j < dim; j++) {
            diagonals[1][j] = GameField.get().getData()[dim - j - 1][j];
        }

        int res = 0;
        res = checkLine(diagonals[0]);
        if(res == 0) res = checkLine(diagonals[1]);

        return res;
    }

    /**
     * Вычисляет сумму элементов массива
     *
     * @param line
     * @return
     */
    private int sumLine(int[] line) {
        int result = 0;
        for(int i : line) {
            result += line[i];
        }

        return result;
    }

    /**
     * Вычисляет произведение элементов массива
     *
     * @param line
     * @return
     */
    private int multiLine(int[] line) {
        int result = 1;
        for(int i : line) {
            result *= line[i];
        }

        return result;
    }

}
