package com.example.FeatureFlag.repository;

import com.example.FeatureFlag.model.feature.Feature;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Set;

public interface FeatureRepository extends Repository<Feature, Integer> {

    void save(Feature feature);
    Set<Feature> findAll();
    Set<Feature> findByEnabledTrue();
    Set<Feature> findByIdIn(List<Integer> featureIds);
}
