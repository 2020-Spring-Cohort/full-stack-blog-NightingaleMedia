package org.wcci.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
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
        posts = new ArrayList<>();
        this.tag = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTag hashTag = (HashTag) o;

        if (id != hashTag.id) return false;
        return tag != null ? tag.equals(hashTag.tag) : hashTag.tag == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
