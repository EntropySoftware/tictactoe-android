package ru.entropysw.android.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import ru.entropysw.android.R;

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
    }

}
