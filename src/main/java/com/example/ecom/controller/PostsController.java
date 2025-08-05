package com.example.ecom.controller;

import com.example.ecom.dto.requests.PostResquestDTO;
import com.example.ecom.dto.responses.PostResponseDTO;
import com.example.ecom.model.Post;
import com.example.ecom.model.User;
import com.example.ecom.service.PostsService;
import com.example.ecom.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;
    private final UserService userService;

    public PostsController(PostsService postsService, UserService userService) {
        this.postsService = postsService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        List<Post> posts = postsService.listAllPosts();

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostResquestDTO postData) {

        User user = userService.getAuthenticatedUser();
        String userName = user.getName();

        Post newPost = postsService.createPost(userName, postData.getTitle(), postData.getDescription(), postData.getContent());

        PostResponseDTO postResponseDTO = new PostResponseDTO(newPost);

        return ResponseEntity.status(HttpStatus.CREATED).body(postResponseDTO);
    }

}
