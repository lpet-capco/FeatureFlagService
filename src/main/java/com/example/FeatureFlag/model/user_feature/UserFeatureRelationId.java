package com.example.FeatureFlag.model.user_feature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFeatureRelationId implements Serializable {
    private Integer userId;
    private Integer featureId;
}
