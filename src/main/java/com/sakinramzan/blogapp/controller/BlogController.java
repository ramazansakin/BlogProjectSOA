package com.sakinramzan.blogapp.controller;

import com.sakinramzan.blogapp.config.CustomUserDetails;
import com.sakinramzan.blogapp.entity.Comment;
import com.sakinramzan.blogapp.entity.Post;
import com.sakinramzan.blogapp.entity.User;
import com.sakinramzan.blogapp.pojo.PojoComment;
import com.sakinramzan.blogapp.service.CommentService;
import com.sakinramzan.blogapp.service.PostService;
import com.sakinramzan.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value="/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @GetMapping(value="/the_post/{id}")
    public Optional<Post> getPostById(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PostMapping(value="/post")
    public String publishPost(@RequestBody Post post){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(post == null)
            post.setDateCreated(new Date());
        post.setCreator(userService.getUser(userDetails.getUsername()));
        postService.insert(post);
        return "Post was published";
    }

    @GetMapping(value="/posts/{username}")
    public List<Post> postsByUser(@PathVariable String username){
        return postService.findByUser(userService.getUser(username));
    }

    @DeleteMapping(value = "/post/{id}")
    public boolean deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }

    @DeleteMapping(value = "/comment/{id}")
    public boolean deleteComment(@PathVariable Long id){
        return commentService.deletePost(id);
    }


    @GetMapping(value = "/comments/{postId}")
    public List<Comment> getComments(@PathVariable Long postId){
        return commentService.getComments(postId);
    }

    @PostMapping(value = "/post/postComment")
    public boolean postComment(@RequestBody PojoComment comment){
        Optional<Post> post = postService.find(comment.getPostId());
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User creator = userService.getUser(userDetails.getUsername());
        if(!post.isPresent() || creator == null)
            return false;

        commentService.comment(new Comment(comment.getText(), post.get() ,creator));
        return true;
    }

}
