package com.example.FeatureFlag.controller;

import com.example.FeatureFlag.model.feature.Feature;
import com.example.FeatureFlag.model.feature.FeatureCreateRequest;
import com.example.FeatureFlag.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("feature")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping("list")
    public ResponseEntity<Set<Feature>> featureList() {
        return featureService.list();
    }

    @PostMapping("create")
    public ResponseEntity<HttpStatus> createFeature(@RequestBody @Valid FeatureCreateRequest request) {
        return featureService.create(request.getName());
    }
}
