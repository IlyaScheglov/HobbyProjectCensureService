package io.github.ilyxahobby.CensureService.service;

import io.github.ilyxahobby.CensureService.config.CredentialProperties;
import io.github.ilyxahobby.CensureService.kafka.dto.ImageDto;
import io.github.ilyxahobby.CensureService.sightengineint.SightengineClient;
import io.github.ilyxahobby.CensureService.sightengineint.dto.SightengineResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CheckCensureService {

    private static final String CENSURE_PARAMS = "nudity-2.1,weapon,recreational_drug,medical,"
            + "scam,gore-2.0,qr-content,self-harm,gambling";

    private final SightengineClient sightengineClient;

    private final CredentialProperties credentialProperties;

    // todo Это будет void и общение только по кафке
    public String checkCensure(ImageDto imageDto) {
        var sightengineResponse = sightengineClient.getCensureLevelOfImage(CENSURE_PARAMS, imageDto.getUrl(),
                credentialProperties.getLoginKey(), credentialProperties.getSecretKey());

        CompletableFuture<Boolean> sexualActivityCheck = CompletableFuture
                .supplyAsync(() -> checkSexualActivity(sightengineResponse));
        List<Boolean> results = List.of(sexualActivityCheck.join());

        if (results.contains(false)) {
            return "Удалить";
        }
        return "Фото норм";
    }

    private boolean checkSexualActivity(SightengineResponseDto sightengineResponseDto) {
        var activity = sightengineResponseDto.getNudity().getSexualActivity();
        return activity.compareTo(BigDecimal.valueOf(0.5)) < 0;
    }
}
