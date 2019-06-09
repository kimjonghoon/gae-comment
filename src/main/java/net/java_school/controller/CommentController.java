package net.java_school.controller;

import com.googlecode.objectify.Key;
import java.util.Date;
import java.util.List;
import net.java_school.board.Article;

import net.java_school.board.Comment;
import net.java_school.board.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    public void addComment(String articleNo, String content) {
        Comment comment = new Comment(articleNo);
        comment.setContent(content);
        Date today = new Date();
        comment.setCreation(today);
        comment.setUsername("John Doe");
        service.addComment(comment);
    }

    @GetMapping
    public List<Comment> getComments(String articleNo) {
        return service.getComments(articleNo);
    }

    @DeleteMapping("/{keyString}")
    public void removeComment(@PathVariable String keyString) {
        service.removeComment(keyString);
    }

    @PutMapping("/{keyString}")
    public void modifyComment(String content, @PathVariable String keyString) {
        Comment comment = service.getComment(keyString);
        comment.setContent(content);
        service.modifyComment(comment);
    }

    @GetMapping("/{keyString}")
    public Comment getComment(@PathVariable String keyString) {
        return service.getComment(keyString);
    }

}
