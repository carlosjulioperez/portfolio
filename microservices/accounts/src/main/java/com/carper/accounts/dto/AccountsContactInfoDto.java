package com.carper.accounts.dto;

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
@ConfigurationProperties(prefix = "accounts")
public record AccountsContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
