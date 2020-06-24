package com.sakinramzan.blogapp.service.impl;


import com.sakinramzan.blogapp.entity.Post;
import com.sakinramzan.blogapp.entity.User;
import com.sakinramzan.blogapp.repository.PostRepository;
import com.sakinramzan.blogapp.service.AbstractGenericService;
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