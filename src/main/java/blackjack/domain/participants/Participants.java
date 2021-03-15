package blackjack.domain.participants;

import blackjack.domain.card.CardDeck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

    private final List<Participant> participantGroup;

    public Participants(final Names names, final List<Double> moneys) {
        participantGroup = participantsSetUp(names, moneys);
    }

    public Participants(final Participant dealer, final List<Participant> players) {
        participantGroup = new ArrayList<>();
        participantGroup.add(dealer);
        participantGroup.addAll(players);
    }

    private List<Participant> participantsSetUp(final Names names, final List<Double> moneys) {
        final List<Participant> participants = new ArrayList<>();
        final List<Name> nameGroup = names.toList();
        for (int i = 0; i < nameGroup.size(); i++) {
            participants.add(new Player(nameGroup.get(i), moneys.get(i)));
        }
        participants.add(0, new Dealer());
        return participants;
    }

    public void distributeCard() {
        participantGroup.forEach(participant -> {
            participant.receiveCard(CardDeck.distribute());
            participant.receiveCard(CardDeck.distribute());
        });
    }

    public Participant getDealer() {
        return participantGroup.get(0);
    }

    public List<Participant> getPlayers() {
        return Collections.unmodifiableList(participantGroup.subList(1, participantGroup.size()));
    }

    public List<Participant> getParticipantGroup() {
        return Collections.unmodifiableList(participantGroup);
    }
}