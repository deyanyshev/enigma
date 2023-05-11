package _com7.enigma.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettingsDto {
   List<String> rotors;
   String reflector;
   List<String> plugs;
   List<Integer> positions;
   String alphabet;
}
