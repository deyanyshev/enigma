package _com7.enigma.data;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Plug {
    String plug;
    Alphabet alphabet;

    public State nextState(Character symbol) {
        if (plug.charAt(0) == symbol) {
            return new State(plug.charAt(1), alphabet.getPosition(plug.charAt(1)));
        } else {
            return new State(plug.charAt(0), alphabet.getPosition(plug.charAt(0)));
        }
    }
}
