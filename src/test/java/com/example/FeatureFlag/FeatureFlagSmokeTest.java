package com.example.FeatureFlag;


import com.example.FeatureFlag.controller.FeatureController;
import com.example.FeatureFlag.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FeatureFlagSmokeTest {

    @Autowired
    private FeatureController featureController;

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() {
        assertThat(featureController).isNotNull();
        assertThat(userController).isNotNull();
    }
}

