package tech.goes.twitterspring.controller.dto;

public record FeedItemDto(long tweetId, String content, String username) {
}
