package _com7.enigma.controller;

import _com7.enigma.dto.SettingsDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    @PostMapping("/put")
    public void setSettings(@RequestBody SettingsDto settings) {

    }

    @PostMapping("/put")
    public void setSettings(@RequestParam(value="file") MultipartFile settings) {

    }
}
