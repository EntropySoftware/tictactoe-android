package ru.entropysw.android.tictactoe.view;

import android.view.View;
import android.widget.ImageButton;
import ru.entropysw.android.tictactoe.logic.Arbiter;

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

    ButtonClicker(ImageButton button) {
        this.button = button;
    }

    public void onClick(View v) {
        button.setImageResource(arbiter.getActivePlayer().getPictureId());
        button.setEnabled(false);

        arbiter.endTurn();
    }

}
