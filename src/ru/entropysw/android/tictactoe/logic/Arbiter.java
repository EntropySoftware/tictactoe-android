package ru.entropysw.android.tictactoe.logic;

/**
 * Created with IntelliJ IDEA.
 * User: stille
 * Date: 04.01.13
 * Time: 19:43
 * Класс, отвечающий за реализацию игровой логики, арбитр
 */
public class Arbiter {

    private Player activePlayer = Player.TIC_PLAYER;

    private Arbiter() {
        // синглтон
    }

    public static Arbiter get() {
        return new Arbiter();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void endTurn() {
        // todo: записывать состояние игрового поля в отдельный класс
        if (!hasWinner()) {
            moveTurn();
        }
        // todo: кричать MainActivity о том, что у нас победитель
        /*
        Вообще, можно сделать класс-мессенджер, который будет заниматься выводом всяких сообщений на экран.
        Определить в нём разные типы сообщений, выводить их по-разному. Сделать ему простой интерфейс, наподобие
        какого-нибудь стандартного логгера, типа Out.info(), Out.error(), Out.win() и так далее. В этом случае
        тут будет достаточно сообщить MainActivity о том, что у нас победитель, а она залочит поле и выведет
        с помощью этого класса информационное сообщение и имя победителя.
         */
    }

    private boolean hasWinner() {
        // todo: обращаться к логическому классу игрового поля (НЕ GameField), чтобы оно сообщало о победителе
        return false;
    }

    private void moveTurn() {
        activePlayer = (getActivePlayer() == Player.TIC_PLAYER) ? Player.TAC_PLAYER : Player.TIC_PLAYER;
    }

}
