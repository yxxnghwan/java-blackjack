package blackjack.utils;

import blackjack.domain.Card;

import java.util.List;

public interface CardDeck {
    Card pop();

    boolean isEmpty();

    List<Card> initCards();
}
