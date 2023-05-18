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

    public Character nextState(Character symbol) {
        if (plug.charAt(0) == symbol) {
            return plug.charAt(1);
        }

        if (plug.charAt(1) == symbol) {
            return plug.charAt(0);
        }

        return symbol;
    }
}
