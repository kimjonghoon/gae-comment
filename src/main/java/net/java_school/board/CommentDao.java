package net.java_school.board;

import com.googlecode.objectify.Key;
import java.util.List;

import org.springframework.stereotype.Component;

import static com.googlecode.objectify.ObjectifyService.ofy;
import java.util.logging.Logger;

@Component
public class CommentDao {
    private static final Logger log = Logger.getLogger(CommentDao.class.getName());
    
    public void addComment(Comment comment) {
        ofy().save().entity(comment).now();
    }

    public List<Comment> getComments(String articleNo) {
        Key<Article> theArticle = Key.create(Article.class, articleNo);

        List<Comment> comments = ofy()
                .load()
                .type(Comment.class)
                .ancestor(theArticle)
                .order("creation")
                .list();
        
        comments.forEach((comment) -> {
           comment.setEditable(true);
        });

        return comments;
    }

    public void removeComment(String keyString) {
        Key<Comment> key = Key.create(keyString);
        ofy().delete().key(key).now();
    }

    public void modifyComment(Comment comment) {
        ofy().save().entity(comment).now();
    }

    public Comment getComment(String keyString) {
        Key<Comment> key = Key.create(keyString);
        Comment comment = ofy().load().key(key).now();
        return comment;
    }

}
