package com.example.FeatureFlag.repository;


import com.example.FeatureFlag.model.user_feature.UserFeatureRelation;
import com.example.FeatureFlag.model.user_feature.UserFeatureRelationId;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface UserFeatureRepository extends Repository<UserFeatureRelation, UserFeatureRelationId> {

    void save(UserFeatureRelation userFeatureRelation);

    void delete(UserFeatureRelation userFeatureRelation);

    Set<UserFeatureRelation> findAllByUserId(Integer userId);
}
