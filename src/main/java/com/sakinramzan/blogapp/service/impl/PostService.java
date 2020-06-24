package com.sakinramzan.blogapp.service.impl;


import com.sakinramzan.blogapp.entity.Post;
import com.sakinramzan.blogapp.entity.User;
import com.sakinramzan.blogapp.repository.PostRepository;
import com.sakinramzan.blogapp.service.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService extends AbstractGenericService<Post> {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        super(postRepository);
        this.postRepository = postRepository;
    }

    public List<Post> findByUser(User user) {
        return postRepository.findByCreatorId(user.getId());
    }
}