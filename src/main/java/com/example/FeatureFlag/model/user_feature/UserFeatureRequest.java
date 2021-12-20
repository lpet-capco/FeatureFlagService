package com.example.FeatureFlag.model.user_feature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFeatureRequest {

    @NotNull
    private Integer userId;
}
