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
    TableLayout gameTable;
    int currentSymbol;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_l);
        currentSymbol = R.string.tic_symbol;

        gameTable = (TableLayout) findViewById(R.id.main_table);
        makeGameField(3);
    }

    private void makeGameField(int num) {
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int sqrSize = Math.round(width / num);

        for (int trCount = 0; trCount < num; trCount++) {
            TableRow tr = new TableRow(this);
            for (int tdCount = 0; tdCount < num; tdCount++) {
                ImageButton btn = new ImageButton(this);
                btn.setOnClickListener(getOnClickChange(btn));
                tr.addView(btn, sqrSize, sqrSize);
            }
            gameTable.addView(tr);
        }
    }

    private View.OnClickListener getOnClickChange(final ImageButton button) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                button.setImageResource(currentSymbol == R.string.tic_symbol ? R.drawable.cross_symbol : R.drawable.null_symbol);
                button.setEnabled(false);
                currentSymbol = currentSymbol == R.string.tic_symbol ? R.string.tac_symbol : R.string.tic_symbol;

                Boolean hasEnabled = false;
                for (int i = 0; i < gameTable.getChildCount(); i++) {
                    View childView = gameTable.getChildAt(i);
                    if (childView.isEnabled()) {
                        hasEnabled = true;
                        break;
                    }
                }

                CharSequence text = "GameOver";
                if (hasEnabled) {
                    text = "You`ve got some more turns!";
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        };
    }

}
