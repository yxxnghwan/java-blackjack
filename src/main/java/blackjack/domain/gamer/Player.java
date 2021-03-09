package blackjack.domain.gamer;

import blackjack.domain.Score;

public class Player extends Participants {

    public Player(String name) {
        super(name);
    }

    @Override
    public boolean canDraw() {
        return Score.calculatorScore(this.getTakenCards()) < Score.MAX_SCORE;
    }
}