package _com7.enigma.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Reflector {
    private String reflector;
    private String alphabet;

    public Character nextState(Character symbol) {
        return reflector.charAt(alphabet.indexOf(symbol));
    }
}
