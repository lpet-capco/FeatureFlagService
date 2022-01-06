package com.example.FeatureFlag.model.feature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeatureCreateRequest {

    @NotEmpty
    String name;
}
