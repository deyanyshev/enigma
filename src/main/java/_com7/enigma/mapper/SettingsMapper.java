package _com7.enigma.mapper;

import _com7.enigma.data.*;
import _com7.enigma.dto.SettingsDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettingsMapper {

    public Enigma SettingsToEnigma(SettingsDto settings) {
        List<Rotor> rotors = new java.util.ArrayList<>(List.of());
        List<Plug> plugs = new java.util.ArrayList<>(List.of());

        for (int i = 0; i < settings.getRotors().size(); ++i) {
            rotors.add(
                    Rotor.builder()
                            .values(settings.getRotors().get(i))
                            .position(settings.getPositions().get(i))
                            .alphabet(Alphabet.builder().alphabet(settings.getAlphabet()).build())
                            .build()
            );
        }

        for (int i = 0; i < settings.getPlugs().size(); ++i) {
            plugs.add(
                    Plug.builder()
                            .plug(settings.getPlugs().get(0))
                            .alphabet(Alphabet.builder().alphabet(settings.getAlphabet()).build())
                            .build()
            );
        }

        return Enigma.builder()
                .rotors(rotors)
                .plugs(plugs)
                .alphabet(Alphabet.builder().alphabet(settings.getAlphabet()).build())
                .reflector(Reflector.builder()
                        .reflector(settings.getReflector())
                        .alphabet(Alphabet.builder().alphabet(settings.getAlphabet()).build())
                        .build()
                )
                .build();
    }
}
