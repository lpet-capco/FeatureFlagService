package com.example.FeatureFlag.service;

import com.example.FeatureFlag.model.feature.Feature;
import com.example.FeatureFlag.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeatureService {

    private final FeatureRepository featureRepository;

    public ResponseEntity<HttpStatus> create(String name) {
        featureRepository.save(new Feature(null, name, false));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<Set<Feature>> list() {
        return ResponseEntity.ok(featureRepository.findAll());
    }
}
