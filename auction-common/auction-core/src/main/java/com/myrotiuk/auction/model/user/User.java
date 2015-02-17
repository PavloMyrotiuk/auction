package com.myrotiuk.auction.model.user;

import com.myrotiuk.auction.model.BaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Created by pav on 2/11/15.
 */
@Document(collection = "users")
public class User implements BaseEntity<ObjectId> {

    @Id
    private ObjectId id;

    private String name;

    private String email;

    private String password;

    private Set<String> roles;

    @Override
    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
