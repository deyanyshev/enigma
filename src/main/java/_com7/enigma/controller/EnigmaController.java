package _com7.enigma.controller;

import _com7.enigma.dto.ResultDto;
import _com7.enigma.service.EnigmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/enigma")
public class EnigmaController {
    private final EnigmaService enigmaService;

    @GetMapping("/encrypt/{text}")
    public ResultDto encrypt(@PathVariable String text) {
        return ResultDto.builder().result(enigmaService.encrypt(text)).build();
    }

    @GetMapping("/decrypt/{text}")
    public String decrypt(@PathVariable String text) {
        return "";
    }
}
