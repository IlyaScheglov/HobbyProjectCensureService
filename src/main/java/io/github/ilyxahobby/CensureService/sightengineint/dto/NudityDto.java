package io.github.ilyxahobby.CensureService.sightengineint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class NudityDto {

    @JsonProperty("sexual_activity")
    BigDecimal sexualActivity;

    @JsonProperty("sexual_display")
    BigDecimal sexualDisplay;

    BigDecimal erotica;

    @JsonProperty("very_suggestive")
    BigDecimal verySuggestive;

    BigDecimal suggestive;

    @JsonProperty("mildly_suggestive")
    BigDecimal mildlySuggestive;

    @JsonProperty("suggestive_classes")
    Object suggestiveClasses;

    BigDecimal none;

    Object context;
}