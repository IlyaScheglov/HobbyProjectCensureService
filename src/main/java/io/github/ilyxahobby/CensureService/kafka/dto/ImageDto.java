package io.github.ilyxahobby.CensureService.kafka.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ImageDto {

    UUID id;

    String url;
}
