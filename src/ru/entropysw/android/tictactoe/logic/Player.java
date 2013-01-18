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
    TIC_PLAYER(R.drawable.cross_symbol),
    TAC_PLAYER(R.drawable.null_symbol);

    private int pictureId;

    private Player(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getPictureId() {
        return this.pictureId;
    }

}
