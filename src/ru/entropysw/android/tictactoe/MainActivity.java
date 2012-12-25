package ru.entropysw.android.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.*;
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
        makeGameField(4);
    }

    private void makeGameField(int num) {
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int sqrSize = Math.round(width/num);

        for(int trCount=0; trCount < num; trCount++) {
            TableRow tr = new TableRow(this);
            for(int tdCount=0;tdCount < num; tdCount++) {
                Button btn = new Button(this);
                btn.setText(tdCount%2 == 0 ? "X" : "O");
                btn.setOnClickListener(getOnClickChange(btn));
                tr.addView(btn, sqrSize, sqrSize);
            }
            game_table.addView(tr);
        }
    }

    private View.OnClickListener getOnClickChange(final Button button)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence currentSymbol = button.getText();
                CharSequence newSymbol = currentSymbol == "X" ? "O" : "X";
                button.setText(newSymbol);

                Context context = getApplicationContext();
                CharSequence text = "You click me! And now I`m "+newSymbol;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        };
    }

}
