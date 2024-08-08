package com.posts.record;

public record Post(
        Integer userId,
        Integer id,
        String title,
        String body
) {
    public Post{
        if(title.isEmpty()){
            throw new RuntimeException("The Title cannot be null.");
        }
    }
}
