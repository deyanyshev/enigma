package _com7.enigma.service;

import _com7.enigma.dto.SettingsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SettingsService {
    @Value("${settingsPath}")
    private String PATH;
    private final ObjectMapper objectMapper;

    SettingsService() {
        objectMapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
    }

    @SneakyThrows
    public SettingsDto getSettings() {
        return objectMapper.readValue(new File(PATH), SettingsDto.class);
    }

    @SneakyThrows
    public void saveSettings(SettingsDto settings) {
        objectMapper.writeValue(new File(PATH), settings);
    }
}
