package net.java_school.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentDao dao;

    public void addComment(Comment comment) {
        dao.addComment(comment);
    }

    public List<Comment> getComments(String articleId) {
        return dao.getComments(articleId);
    }

    public void removeComment(String keyString) {
        dao.removeComment(keyString);
    }

    public Comment getComment(String keyString) {
        return dao.getComment(keyString);
    }

    public void modifyComment(Comment comment) {
        dao.modifyComment(comment);
    }
}
