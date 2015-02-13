package com.myrotiuk.auction.model.user;

import com.myrotiuk.auction.model.BaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pav on 2/11/15.
 */
@Document(collection = "users")
public class User implements BaseEntity<ObjectId> {

    @Id
    private ObjectId id;

    private String login;

    private String name;

    private String email;

    @Override
    public ObjectId getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
