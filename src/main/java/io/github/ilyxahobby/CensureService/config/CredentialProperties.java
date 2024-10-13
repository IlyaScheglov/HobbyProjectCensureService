package io.github.ilyxahobby.CensureService.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "censure.credentials")
@Getter
@Setter
public class CredentialProperties {

    private String loginKey;

    private String secretKey;
}
