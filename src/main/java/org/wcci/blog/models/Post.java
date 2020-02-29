package org.wcci.blog.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post {

    public Post() {
    }

    public Post(String postTitle,
                Category postCategory,
                Client...clients) {
        this.postTitle = postTitle;
        this.postCategory = postCategory;
        this.clients = new ArrayList<>(Arrays.asList(clients));
        this.postTags = new HashSet<>();
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Collection<Client> clients;

    @ManyToMany
    private Set<HashTag> postTags;

    @ManyToOne
    private Category postCategory;

    private String postTitle;

    private String author;

    private String content;

    private int date;

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    public Category getPostCategory() {
        return postCategory;
    }
    public String getCategoryTitle(){
        return postCategory.getCategoryTitle();

    }

    public String getPostTitle() {
        return postTitle;
    }

    public int getDate() {
        return date;
    }

    public Set<HashTag> getHashTagsForPost(){
        return postTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (date != post.date) return false;
        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (postCategory != null ? !postCategory.equals(post.postCategory) : post.postCategory != null) return false;
        return postTitle != null ? postTitle.equals(post.postTitle) : post.postTitle == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (postCategory != null ? postCategory.hashCode() : 0);
        result = 31 * result + (postTitle != null ? postTitle.hashCode() : 0);
        result = 31 * result + date;
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postCategory=" + postCategory +
                ", postTitle='" + postTitle + '\'' +
                ", date=" + date +
                '}';
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void addClient(Client c) {
        this.clients.add(c);
    }

    public void addHashTag(HashTag h) {
        postTags.add(h);
    }
}
