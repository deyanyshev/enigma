package _com7.enigma.service;

import _com7.enigma.data.Enigma;
import _com7.enigma.dto.SettingsDto;
import _com7.enigma.mapper.SettingsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnigmaService {
    private final SettingsService settingsService;
    private final SettingsMapper settingsMapper;

    public String encrypt(String text) {
        String result = "";

        SettingsDto settings = settingsService.getSettings();
        Enigma enigma = settingsMapper.SettingsToEnigma(settings);

        enigma.start();

        for (int i = 0; i < text.length(); ++i) {
            Character symbol = text.charAt(i);
            result += enigma.encryptSymbol(symbol);
        }

        return result;
    }
}
