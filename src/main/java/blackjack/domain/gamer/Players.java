package blackjack.domain.gamer;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final String PLAYER_NAME_DUPLICATE_ERROR_MESSAGE = "참가자 이름은 중복될 수 없습니다.";

    private final List<CasinoCustomer> players;
    private int nowIndex;

    private Players(List<CasinoCustomer> players) {
        this.players = players;
        this.nowIndex = 0;
    }

    public static Players fromNames(List<String> names) {
        validate(names);
        return new Players(toPlayers(names));
    }

    private static List<CasinoCustomer> toPlayers(List<String> names) {
        return names.stream()
                .map(CasinoCustomer::new)
                .collect(Collectors.toList());
    }

    private static void validate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void next() {
        nowIndex++;
    }

    public boolean hasNext() {
        return nowIndex < players.size();
    }

    public CasinoCustomer getNowPlayer() {
        return players.get(nowIndex);
    }

    public List<CasinoCustomer> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
