package ru.entropysw.android.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.*;
import ru.entropysw.android.R;
import ru.entropysw.android.tictactoe.logic.GameField;
import ru.entropysw.android.tictactoe.logic.Out;
import ru.entropysw.android.tictactoe.view.GameFieldView;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 18.12.12
 * Time: 12:02
 * Основное activity. Пока работаем через него.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_l);

        // инициируем месенджер
        Out.get().setContext(getApplicationContext());

        makeGameField(3);
    }

    private void makeGameField(int num) {
        GameField.getIssue().init(num);
        GameFieldView.getForActivity(this).make();
    }
    /*
    Просто, чтоб не забыть, как работать с тостами
    В остальном этот функционал раскидан по классам

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
    }    */

}
