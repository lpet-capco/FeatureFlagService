package com.example.FeatureFlag.service;

import com.example.FeatureFlag.model.feature.Feature;
import com.example.FeatureFlag.model.user.User;
import com.example.FeatureFlag.model.user_feature.UserFeatureRelation;
import com.example.FeatureFlag.model.user_feature.UserFeatureResponse;
import com.example.FeatureFlag.repository.FeatureRepository;
import com.example.FeatureFlag.repository.UserFeatureRepository;
import com.example.FeatureFlag.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;
    private final FeatureRepository featureRepository;
    private final UserFeatureRepository userFeatureRepository;

    public ResponseEntity<Set<User>> list() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<UserFeatureResponse> features(Integer userId) {
        Set<Feature> globallyEnabled = featureRepository.findByEnabledTrue();
        Set<UserFeatureRelation> userFeatureEnabled = userFeatureRepository.findAllByUserId(userId);
        Set<Feature> userEnabled = featureRepository.findByIdIn(
                userFeatureEnabled.stream()
                        .map(UserFeatureRelation::getFeatureId)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.ok(UserFeatureResponse.builder()
                .globallyEnabled(globallyEnabled)
                .userEnabled(userEnabled)
                .build());
    }

    public ResponseEntity<HttpStatus> addUserFeature(UserFeatureRelation userFeatureRelation) {
        userFeatureRepository.save(userFeatureRelation);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> removeUserFeature(UserFeatureRelation userFeatureRelation) {
        userFeatureRepository.delete(userFeatureRelation);
        return ResponseEntity.ok(HttpStatus.GONE);
    }
}
