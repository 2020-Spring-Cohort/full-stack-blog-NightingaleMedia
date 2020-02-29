package org.wcci.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class HashTag {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(mappedBy = "postTags")
    private List<Post> posts;

    public String getTag() {
        return tag;
    }

    private String tag;

    public HashTag() {
    }

    public HashTag(String t){
        this.tag = t;
    }

}
