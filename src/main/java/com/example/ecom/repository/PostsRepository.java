package com.example.ecom.repository;

import com.example.ecom.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, String> {

    public Post getPostById(String id);
}
