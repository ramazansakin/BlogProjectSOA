package com.rsakin.blogapp.controller;

import com.rsakin.blogapp.entity.Comment;
import com.rsakin.blogapp.entity.Post;
import com.rsakin.blogapp.exception.NotFoundException;
import com.rsakin.blogapp.service.impl.CommentService;
import com.rsakin.blogapp.service.impl.PostService;
import com.rsakin.blogapp.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {
                "http://localhost:8090"
        },
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS,
                RequestMethod.HEAD,
        },
        allowCredentials = "true",
        allowedHeaders = "*"
)
@RestController
@RequestMapping("/blog-api")
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/posts")
    public List<Post> posts() {
        return postService.findAll();
    }

    @GetMapping(value = "/post/{id}")
    public Post getPostById(@PathVariable Long id) throws NotFoundException {
        return postService.findById(id);
    }

    @PostMapping(value = "/post")
    public String publishPost(@RequestBody Post post) {
        postService.save(post);
        return "Post was published";
    }

    @GetMapping(value = "/posts/{username}")
    public List<Post> postsByUser(@PathVariable String username) {
        return postService.findByUser(userService.getUser(username));
    }

    @DeleteMapping(value = "/post/{id}")
    public boolean deletePost(@PathVariable Long id) throws Throwable {
        return postService.deleteById(id);
    }

    @DeleteMapping(value = "/comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        try {
            commentService.deleteById(id);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Comment was deleted successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/post-comments/{postId}")
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getComments(postId);
    }

//    @PostMapping(value = "/post/postComment")
//    public boolean postComment(@RequestBody PojoComment comment) throws Throwable {
//        Optional<Post> post = Optional.ofNullable(postService.findById(comment.getPostId()));
//        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User creator = userService.getUser(userDetails.getUsername());
//        if (!post.isPresent() || creator == null)
//            return false;
//        commentService.save(
//                Comment.builder()
//                        .creator(creator)
//                        .post(post.get())
//                        .text(comment.getText())
//                        .build());
//        return true;
//    }

}
