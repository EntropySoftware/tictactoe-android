package ru.entropysw.android.tictactoe.logic;

/**
 * Created with IntelliJ IDEA.
 * User: Mikhail_Levanov
 * Date: 4/10/13
 * Time: 2:52 PM
 * Класс, хранящий в себе состояние игрового поля
 */
public class GameField {

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

    public static GameField getIssue() {
        return new GameField();
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
            this.setDimension(num);
        } else {
            throw new IllegalArgumentException("Невозможно задать поле с неположительным размером");
        }

        for(int trCount = 0; trCount < this.dimension; trCount++) {
            for(int tdCount = 0; tdCount < this.dimension; tdCount++) {
                this.data[trCount][tdCount] = 0;
            }
        }
    }

    /**
     * Возвращает послежний X
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
