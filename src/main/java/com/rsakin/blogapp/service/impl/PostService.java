package com.rsakin.blogapp.service.impl;


import com.rsakin.blogapp.entity.Post;
import com.rsakin.blogapp.entity.User;
import com.rsakin.blogapp.repository.PostRepository;
import com.rsakin.blogapp.service.AbstractGenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService extends AbstractGenericService<Post> {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        super(postRepository);
        this.postRepository = postRepository;
    }

    public List<Post> findByUser(User user) {
        return postRepository.findByCreatorId(user.getId());
    }
}