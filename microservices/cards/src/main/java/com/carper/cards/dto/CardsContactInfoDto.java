package com.carper.cards.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * Get the contact info
 * (Spring team recommends to use this approach compared to @Value)
 * @param message
 * @param contactDetails
 * @param onCallSupport
 */
@ConfigurationProperties(prefix = "cards")
public record CardsContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
