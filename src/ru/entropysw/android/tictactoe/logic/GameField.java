package ru.entropysw.android.tictactoe.logic;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mikhail_Levanov
 * Date: 4/10/13
 * Time: 2:52 PM
 * Класс, хранящий в себе состояние игрового поля
 */
public class GameField {

    private static GameField instance;

    /**
     * Флаг инициализации
     */
    private boolean initialized = false;

    /**
     * Размер поля
     */
    private int dimension;

    /**
     * Координаты последнего хода
     */
    private int lastX = 0;
    private int lastY = 0;

    /**
     * Матрица игрового поля
     */
    private int[][] data;

    /**
     * Скрытый конструктор
     */
    private GameField() {
        // синглтон
    }

    public static GameField get() {
        if (instance == null) {
            instance = new GameField();
        }
        return instance;
    }

    /**
     * Устанавливает размер поля
     *
     * @param newDimension
     */
    public void setDimension(int newDimension) {
        this.dimension = newDimension;
    }

    /**
     * Возвращает размер поля
     *
     * @return
     */
    public int getDimension() {
        if (!initialized) {
            throw new IllegalStateException("Прежде, чем получать размеры, " +
                    "игровое поле должно быть проинициализировано");
        }
        return dimension;
    }

    /**
     * Устанавливает значение ячейки поля
     *
     * @param x
     * @param y
     * @param value значение -1/0/1
     */
    public void setValue(int x, int y, int value) {
        data[x][y] = value;
    }

    /**
     * Возвращает даные игрового поля
     *
     * @return
     */
    public int[][] getData() {
        return data;
    }

    /**
     * Заполняет матрицу даных нулями
     *
     */
    public void init(int num) {
        if (initialized) {
            throw new IllegalStateException("Невозможно повторно инициализировать игровое поле");
        }

        if(num > 0) {
            setDimension(num);
        } else {
            throw new IllegalArgumentException("Невозможно задать поле с неположительным размером");
        }

        data = new int[dimension][dimension];
        for(int trCount = 0; trCount < this.dimension; trCount++) {
            for (int tdCount = 0; tdCount < this.dimension; tdCount++) {
                data[trCount][tdCount] = 0;
            }
        }

        this.initialized = true;
    }

    /**
     * Возвращает последний X
     *
     * @return
     */
    public int getLastX() {
        return lastX;
    }

    /**
     * Возвращает последний Y
     *
     * @return
     */
    public int getLastY() {
        return lastY;
    }

    /**
     * Устанавливает последний X
     *
     * @param x
     */
    public void setLastX(int x) {
        lastX = x;
    }

    /**
     * Устанавливает последний Y
     *
     * @param y
     */
    public void setLastY(int y) {
        lastY = y;
    }

}
