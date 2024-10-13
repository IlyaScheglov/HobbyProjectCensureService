package io.github.ilyxahobby.CensureService.sightengineint.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SightengineResponseDto {

    String status;

    NudityDto nudity;
}
