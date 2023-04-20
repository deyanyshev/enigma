package _com7.enigma.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enigma")
public class EnigmaController {

    @GetMapping("/encrypt")
    public String encrypt(@RequestBody String text) {
        return "";
    }

    public String decrypt(@RequestBody String text) {
        return "";
    }
}
