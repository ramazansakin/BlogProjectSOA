package com.rsakin.blogapp.service.impl;

import com.rsakin.blogapp.entity.Comment;
import com.rsakin.blogapp.service.AbstractGenericService;
import com.rsakin.blogapp.repository.CommentRepository;
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

