package com.example.ecom.service;

import com.example.ecom.model.Post;
import com.example.ecom.repository.PostsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostsService {

    private PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Post> listAllPosts() {
        return postsRepository.findAll();
    }

    public Post createPost(String userName, String tile, String description, String content) {
        Post newPost = Post.builder()
                .userName(userName)
                .title(tile)
                .description(description)
                .content(content)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return postsRepository.save(newPost);
    }
}
