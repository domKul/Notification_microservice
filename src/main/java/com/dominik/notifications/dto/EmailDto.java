package com.dominik.notifications.dto;

public record EmailDto(
        String to,
        String title,
        String content
) {
}
