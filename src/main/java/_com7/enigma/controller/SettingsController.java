package _com7.enigma.controller;

import _com7.enigma.dto.SettingsDto;
import _com7.enigma.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    private final SettingsService settingsService;

    @GetMapping("/get")
    public SettingsDto getSettings() {
        return settingsService.getSettings();
    }

    @PostMapping("/put")
    public void setSettings(@RequestBody SettingsDto settings) {
        settingsService.saveSettings(settings);
    }
}
