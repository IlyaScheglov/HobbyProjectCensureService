package io.github.ilyxahobby.CensureService.controllertest;

import io.github.ilyxahobby.CensureService.kafka.dto.ImageDto;
import io.github.ilyxahobby.CensureService.service.CheckCensureService;
import io.github.ilyxahobby.CensureService.sightengineint.dto.SightengineResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final CheckCensureService checkCensureService;

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam String url) {
        return ResponseEntity.ok(
                checkCensureService.checkCensure(ImageDto.builder().id(UUID.randomUUID()).url(url).build())
        );
    }
}
