package net.java_school.board;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;
import java.util.Date;

@Entity
@Cache
public class Comment {
    @Parent Key<Article> theArticle;
    @Id public Long id;
    
    public String username;
    public String content;
    @Index public Date creation;
    @Ignore public boolean editable;

    public Comment() {
    }
    
    public Comment(String articleNo) {
        theArticle = Key.create(Article.class, articleNo);
    }
    
    public String getKeyString() {
        return Key.create(theArticle, Comment.class, id).toWebSafeString();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
