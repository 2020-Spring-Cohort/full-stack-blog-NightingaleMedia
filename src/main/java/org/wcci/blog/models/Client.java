package org.wcci.blog.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    public Client() {
    }

    public Client(String clientName){
        this.clientName = clientName;
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "clients")
    private List<Post> posts;

    public String getClientName() {
        return clientName;
    }

    private String clientName;

    public boolean isEmpty() {
        if (posts.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }



}
