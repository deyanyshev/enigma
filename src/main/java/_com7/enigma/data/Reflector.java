package _com7.enigma.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Reflector {
    private String reflector;
    private Alphabet alphabet;

    public State nextState(State state) {
        Character symbol = alphabet.getAlphabet().charAt(state.getPosition());
        return new State(symbol, reflector.indexOf(symbol));
    }
}
