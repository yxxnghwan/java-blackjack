package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.CardType;
import blackjack.domain.participants.Dealer;
import blackjack.domain.participants.Participant;
import blackjack.domain.participants.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

public class BlackjackGameTest {

    private BlackjackGame blackjackGame;
    private final Participant dealer = new Dealer();
    private List<Participant> players = new ArrayList<>();

    @BeforeEach
    void setUp() {
        blackjackGame = new BlackjackGame(dealer, players);
        dealer.receiveCard(new Card(CardNumber.TEN, CardType.CLOVER));
        for (int i = 0; i < 3; i++) {
            Participant player = new Player(i + "");
            player.receiveCard(new Card(CardNumber.EIGHT, CardType.CLOVER));
            players.add(player);
        }
    }

}