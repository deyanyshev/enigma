package _com7.enigma.data;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Alphabet {
    private String alphabet;

    Integer getPosition(Character symbol) {
        return alphabet.indexOf(symbol);
    }

    void rotate() {
        alphabet = alphabet.substring(1) + alphabet.charAt(0);
    }
}
