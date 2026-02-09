package tech.goes.twitterspring.controller.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
