package ru.entropysw.android.tictactoe.view;

import android.app.Activity;
import android.view.Display;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import ru.entropysw.android.R;
import ru.entropysw.android.tictactoe.logic.GameField;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 04.01.13
 * Time: 19:19
 * Класс, отвечающий за формирование игрового поля
 */
public class GameFieldView {

    private Activity activity;
    private TableLayout gameTable;
    private GameField gameField = GameField.get();

    private static GameFieldView instance;

    private GameFieldView() {
        // синглтон
    }

    private GameFieldView(Activity activity) {
        this.activity = activity;
        gameTable = (TableLayout) this.activity.findViewById(R.id.main_table);
    }

    public static GameFieldView getForActivity(Activity activity) {
        if (instance == null) {
            instance = new GameFieldView(activity);
        }
        return instance;
    }

    public void make() {
        int dimension = gameField.getDimension();

        Display display = activity.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int sqrSize = Math.round(width / dimension);

        for (int trCount = 0; trCount < dimension; trCount++) {
            TableRow tr = new TableRow(activity);
            for (int tdCount = 0; tdCount < dimension; tdCount++) {
                ImageButton btn = new ImageButton(activity);
                btn.setOnClickListener(new ButtonClicker(btn, trCount, tdCount));
                tr.addView(btn, sqrSize, sqrSize);
            }
            gameTable.addView(tr);
        }
    }

}
