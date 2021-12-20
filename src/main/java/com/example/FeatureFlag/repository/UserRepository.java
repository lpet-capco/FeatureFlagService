package com.example.FeatureFlag.repository;

import com.example.FeatureFlag.model.user.User;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface UserRepository extends Repository<User, Integer> {

    Set<User> findAll();
}
