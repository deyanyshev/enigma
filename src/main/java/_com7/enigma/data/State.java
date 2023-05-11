package _com7.enigma.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class State {
    private Character symbol;
    private Integer position;
}
