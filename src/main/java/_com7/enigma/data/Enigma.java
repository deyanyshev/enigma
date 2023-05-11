package _com7.enigma.data;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class Enigma {
    private List<Rotor> rotors;
    private List<Plug> plugs;
    private Alphabet alphabet;
    private Reflector reflector;

    public void start() {
        for (Rotor rotor: rotors) {
            for (int i = 0; i < rotor.getPosition(); ++i) {
                rotor.rotate(false);
                System.out.println(rotor.getPosition());
            }
        }
    }

    public Character encryptSymbol(Character symbol) {
        rotateRotors();
        State state = new State(symbol, alphabet.getPosition(symbol));
        System.out.println("-----------");
        System.out.println(state.getSymbol() + " " + state.getPosition().toString());

        for (Plug plug: plugs) {
            if (plug.plug.indexOf(symbol) != -1) {
                state = plug.nextState(symbol);
            }
        }
        System.out.println(state.getSymbol() + " " + state.getPosition().toString());

        for (Rotor rotor: rotors) {
            state = rotor.nextState(state, false);
            System.out.println(state.getSymbol() + " " + state.getPosition().toString());
        }

        state = reflector.nextState(state);
        System.out.println(state.getSymbol() + " " + state.getPosition().toString());

        for (int i = rotors.size() - 1; i >= 0; --i) {
            state = rotors.get(i).nextState(state, true);
            System.out.println(state.getSymbol() + " " + state.getPosition().toString());
        }

        symbol = alphabet.getAlphabet().charAt(state.getPosition());
        state.setSymbol(symbol);

        for (Plug plug: plugs) {
            if (plug.plug.indexOf(symbol) != -1) {
                state = plug.nextState(symbol);
            }
        }
        System.out.println(state.getSymbol() + " " + state.getPosition().toString());

        return state.getSymbol();
    }

    public void rotateRotors() {
        int i = 1;
        rotors.get(0).rotate(true);

        while (i < rotors.size() && rotors.get(i - 1).getPosition() == 1) {
            rotors.get(i).rotate(true);
            i += 1;
        }
    }
}
