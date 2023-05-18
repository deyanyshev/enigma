package _com7.enigma.data;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class Enigma {
    private List<Rotor> rotors;
    private List<Plug> plugs;
    private String alphabet;
    private Reflector reflector;

    public Character encryptSymbol(Character symbol) {
        rotateRotors();

        for (Plug plug: plugs) {
            symbol = plug.nextState(symbol);
        }

        for (Rotor rotor: rotors) {
            symbol = rotor.nextState(symbol, false);
        }

        symbol = reflector.nextState(symbol);

        for (int i = rotors.size() - 1; i >= 0; --i) {
            symbol = rotors.get(i).nextState(symbol, true);
        }

        for (Plug plug: plugs) {
            symbol = plug.nextState(symbol);
        }

        return symbol;
    }

    public void rotateRotors() {
        int i = 1;
        rotors.get(0).rotate();

        while (i < rotors.size() && rotors.get(i - 1).getPosition() == 1) {
            rotors.get(i).rotate();
            i += 1;
        }
    }
}
