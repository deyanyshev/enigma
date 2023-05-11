package _com7.enigma.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Rotor {
    private String values;
    private Alphabet alphabet;
    private Integer position;

    public State nextState(State state, boolean reverse) {
        System.out.println(values);
        System.out.println(alphabet.getAlphabet());
        if (reverse) {
            char symbol = alphabet.getAlphabet().charAt(state.getPosition());
            return new State(symbol, values.indexOf(symbol));
        } else {
            char symbol = values.charAt(state.getPosition());
            return new State(symbol, alphabet.getAlphabet().indexOf(symbol));
        }
    }

    public void rotate(Boolean update) {
        if (update) {
            position = (position + 1) % values.length();
        }

        values = values.substring(1) + values.charAt(0);
        alphabet.rotate();
    }
}
