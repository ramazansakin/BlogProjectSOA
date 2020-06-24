package com.sakinramzan.blogapp.service.impl;

import com.sakinramzan.blogapp.entity.Comment;
import com.sakinramzan.blogapp.repository.CommentRepository;
import com.sakinramzan.blogapp.service.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends AbstractGenericService<Comment> {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}

