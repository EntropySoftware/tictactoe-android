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
     * Размер поля
     */
    private int dimension;
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
        if(num > 0) this.setDimension(num);

        for(int trCount = 0; trCount < this.dimension; trCount++) {
            for(int tdCount = 0; tdCount < this.dimension; tdCount++) {
                this.data[trCount][tdCount] = 0;
            }
        }
    }

}
