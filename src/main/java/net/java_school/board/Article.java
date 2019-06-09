package net.java_school.board;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Article {
    @Id public String id;
}
