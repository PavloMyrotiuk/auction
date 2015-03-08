package com.myrotiuk.auction.middleware.persistence.repository;

import com.myrotiuk.auction.common.core.model.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pav on 2/12/15.
 */
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String userName);
}
