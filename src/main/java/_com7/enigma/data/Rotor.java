package _com7.enigma.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Rotor {
    private String values;
    private String alphabet;
    private Integer position;

    public Character nextState(Character symbol, boolean reverse) {
        int index = (alphabet.indexOf(symbol) + position) % alphabet.length();
        symbol = alphabet.charAt(index);

        String source = reverse ? values : alphabet;
        String dest = reverse ? alphabet : values;

        index = source.indexOf(symbol);
        symbol = dest.charAt(index);

        index = (alphabet.indexOf(symbol) - position + alphabet.length()) % alphabet.length();
        symbol = alphabet.charAt(index);
        return symbol;
    }

    public void rotate() {
        position = (position + 1) % values.length();
    }
}
