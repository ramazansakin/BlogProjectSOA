package com.sakinramzan.blogapp.service;


import com.sakinramzan.blogapp.entity.Post;
import com.sakinramzan.blogapp.entity.User;
import com.sakinramzan.blogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }

    public List<Post> findByUser(User user){
        return postRepository.findByCreatorId(user.getId());
    }

    public boolean deletePost(Long postId){
        Optional<Post> thePost = postRepository.findById(postId);
        if(!thePost.isPresent())
            return false;
        postRepository.deleteById(postId);
        return true;
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public Optional<Post> find(Long postId) {
        return postRepository.findById(postId);
    }
}