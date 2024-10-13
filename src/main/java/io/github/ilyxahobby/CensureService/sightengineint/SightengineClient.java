package io.github.ilyxahobby.CensureService.sightengineint;

import io.github.ilyxahobby.CensureService.sightengineint.dto.SightengineResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "sightengine-censurer-integration",
        url = "${censure.url}",
        configuration = SightengineConfig.class
)
public interface SightengineClient {

    @GetMapping("/1.0/check.json")
    SightengineResponseDto getCensureLevelOfImage(@RequestParam String models, @RequestParam String url,
                                                  @RequestParam("api_user") String apiUser,
                                                  @RequestParam("api_secret") String apiSecret);
}
