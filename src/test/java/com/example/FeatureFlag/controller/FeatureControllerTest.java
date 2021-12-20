package com.example.FeatureFlag.controller;

import com.example.FeatureFlag.model.feature.Feature;
import com.example.FeatureFlag.model.feature.FeatureCreateRequest;
import com.example.FeatureFlag.service.FeatureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static java.util.Collections.EMPTY_SET;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
class FeatureControllerTest {

    FeatureCreateRequest featureCreateRequest;

    @Mock
    FeatureService featureService;

    @InjectMocks
    FeatureController featureController;

    @BeforeEach
    public void setup() {
        openMocks(this);
        featureCreateRequest = new FeatureCreateRequest("testFeature");
    }

    @Test
    void createFeature() {
        when(featureService.create(anyString())).thenReturn(ResponseEntity.ok(HttpStatus.CREATED));
        ResponseEntity<HttpStatus> responseEntity = featureController.createFeature(featureCreateRequest);
        assertNotNull(responseEntity, "Response entity was null");
        assertEquals(OK.value(), responseEntity.getStatusCodeValue(), "Different response status code");
        assertNotNull(responseEntity.getBody(), "Response body was null");
        assertEquals(CREATED.value(), responseEntity.getBody().value(), "Different body status code");
    }

    @Test
    void featureList_Empty() {
        when(featureService.list()).thenReturn(new ResponseEntity<Set<Feature>>(EMPTY_SET, OK));
        ResponseEntity<Set<Feature>> setResponseEntity = featureController.featureList();
        assertNotNull(setResponseEntity);
        assertEquals(OK.value(), setResponseEntity.getStatusCodeValue());
        assertNotNull(setResponseEntity.getBody());
        assertTrue(setResponseEntity.getBody().isEmpty());
    }

    @Test
    void featureList_WithMultipleItems() {
        when(featureService.list()).thenReturn(new ResponseEntity<>(
                Set.of(
                        new Feature(1, "feature 1", true),
                        new Feature(2, "feature 2", false),
                        new Feature(3, "feature 3", true)),
                OK));
        ResponseEntity<Set<Feature>> setResponseEntity = featureController.featureList();
        assertNotNull(setResponseEntity);
        assertEquals(OK.value(), setResponseEntity.getStatusCodeValue());
        assertNotNull(setResponseEntity.getBody());
        Set<Feature> featureSet = setResponseEntity.getBody();
        assertFalse(featureSet.isEmpty(), "Feature set should not be empty");
        assertEquals(3, featureSet.size(), "Unexpected feature set size");
    }
}