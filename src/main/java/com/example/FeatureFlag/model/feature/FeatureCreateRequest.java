package com.example.FeatureFlag.model.feature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@AllArgsConstructor
public class FeatureCreateRequest {

    @NotEmpty
    String name;
}
