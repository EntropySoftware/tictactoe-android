package ru.entropysw.android.tictactoe.view;

import android.view.View;
import android.widget.ImageButton;
import ru.entropysw.android.tictactoe.logic.Arbiter;
import ru.entropysw.android.tictactoe.logic.GameField;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 04.01.13
 * Time: 19:26
 * Слушатель нажатий на кнопку игрового поля
 */
public class ButtonClicker implements View.OnClickListener {

    private ImageButton button;
    private Arbiter arbiter = Arbiter.get();
    private GameField gfModel = GameField.getIssue();

    /**
     * Координаты в матрице игрового поля
     */
    private int x = 0;
    private int y = 0;

    ButtonClicker(ImageButton button, int x, int y) {
        this.button = button;
        this.x = x;
        this.y = y;
    }

    /**
     * Обрабатывает клик по ячейке поля
     *
     * @param v
     */
    public void onClick(View v) {
        button.setImageResource(arbiter.getActivePlayer().getPictureId());
        button.setEnabled(false);

        arbiter.endTurn();
        gfModel.setValue(x, y, arbiter.getActivePlayer().getStatusNum());
        gfModel.setLastX(x);
        gfModel.setLastY(y);
    }

}
