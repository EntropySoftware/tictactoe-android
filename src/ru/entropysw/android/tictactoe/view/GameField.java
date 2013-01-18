package ru.entropysw.android.tictactoe.view;

import android.app.Activity;
import android.view.Display;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 04.01.13
 * Time: 19:19
 * Класс, отвечающий за формирование игрового поля
 */
public class GameField {

    private Activity activity;
    private TableLayout gameTable;

    private GameField() {
        // синглтон
    }

    private GameField(Activity activity) {
        this.activity = activity;
    }

    public static GameField getForActivity(Activity activity) {
        return new GameField(activity);
    }

    public void make(int dimension) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int sqrSize = Math.round(width / dimension);

        for (int trCount = 0; trCount < dimension; trCount++) {
            TableRow tr = new TableRow(activity);
            for (int tdCount = 0; tdCount < dimension; tdCount++) {
                ImageButton btn = new ImageButton(activity);
                btn.setOnClickListener(new ButtonClicker(btn));
                tr.addView(btn, sqrSize, sqrSize);
            }
            gameTable.addView(tr);
        }
    }

}
