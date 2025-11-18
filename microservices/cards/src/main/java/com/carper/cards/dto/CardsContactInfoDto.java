package com.carper.cards.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * Get the contact info
 * (Spring team recommends to use this approach compared to @Value)
 */
@ConfigurationProperties(prefix = "cards")
@Getter @Setter
public class CardsContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
