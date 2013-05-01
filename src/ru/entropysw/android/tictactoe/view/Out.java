package ru.entropysw.android.tictactoe.view;

import android.content.Context;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Mikhail_Levanov
 * Date: 4/16/13
 * Time: 2:56 PM
 * Выводит указанное сообщение
 */
public class Out {
    private Context context;

    private static Out instance;

    private Out() {
        // синглтон
    }

    /**
     * Возвращает экземпляр
     *
     * @return
     */
    public static Out get() {
        if (instance == null) {
            instance = new Out();
        }
        return instance;
    }

    /**
     * Устанавливает контекст вывода
     *
     * @param context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Выводит сообщение через Toast
     *
     * @param text
     */
    public void show(CharSequence text) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
