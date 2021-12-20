package com.example.FeatureFlag.model.user_feature;

import com.example.FeatureFlag.model.feature.Feature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class UserFeatureResponse {
    private Set<Feature> globallyEnabled;
    private Set<Feature> userEnabled;
}
