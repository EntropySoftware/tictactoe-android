package ru.entropysw.android.tictactoe.logic;

import ru.entropysw.android.R;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 04.01.13
 * Time: 19:39
 * Список игроков
 */
public enum Player {
    TIC_PLAYER(R.drawable.cross_symbol, 1, "X"),
    TAC_PLAYER(R.drawable.null_symbol, -1, "O");

    private int pictureId;
    private int statusNum;
    private CharSequence name;

    private Player(int pictureId, int statusNum, CharSequence name) {
        this.pictureId = pictureId;
        this.statusNum = statusNum;
        this.name = name;
    }

    public int getPictureId() {
        return this.pictureId;
    }

    public int getStatusNum() {
        return this.statusNum;
    }

    public CharSequence getName() {
        return this.name;
    }

}
