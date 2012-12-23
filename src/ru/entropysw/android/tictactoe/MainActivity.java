package ru.entropysw.android.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import ru.entropysw.android.R;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 18.12.12
 * Time: 12:02
 * Основное activity. Пока работаем через него.
 */
public class MainActivity extends Activity {
    TableLayout game_table;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_l);
        game_table = (TableLayout)findViewById(R.id.main_table);
        makeGameField(3);
    }

    private void makeGameField(int num) {
        for(int trCount=0; trCount < num; trCount++) {
            TableRow tr = new TableRow(this);
            for(int tdCount=0;tdCount < num; tdCount++) {
                Button btn = new Button(this);
                btn.setText(trCount%2 == 0 ? "X" : "O");
                // bad code
                tr.addView(btn, 100, 100);
            }
            game_table.addView(tr);
        }
    }

}
