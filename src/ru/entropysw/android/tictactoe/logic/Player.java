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
    TIC_PLAYER(R.drawable.cross_symbol, 1),
    TAC_PLAYER(R.drawable.null_symbol, -1);

    private int pictureId;
    private int statusNum;

    private Player(int pictureId, int statusNum) {
        this.pictureId = pictureId;
        this.statusNum = statusNum;
    }

    public int getPictureId() {
        return this.pictureId;
    }

    public int getStatusNum() {
        return this.statusNum;
    }

}
