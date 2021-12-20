package com.example.FeatureFlag.controller;

import com.example.FeatureFlag.model.user.User;
import com.example.FeatureFlag.model.user_feature.UserFeatureRelation;
import com.example.FeatureFlag.model.user_feature.UserFeatureRequest;
import com.example.FeatureFlag.model.user_feature.UserFeatureResponse;
import com.example.FeatureFlag.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping("list")
    public ResponseEntity<Set<User>> userList() {
        return userService.list();
    }

    @GetMapping("feature")
    public ResponseEntity<UserFeatureResponse> userFeatures(@RequestBody @Valid UserFeatureRequest request) {
        return userService.features(request.getUserId());
    }

    @PostMapping("feature")
    public ResponseEntity<HttpStatus> addUserFeature(@RequestBody @Valid UserFeatureRelation userFeatureRelation) {
        return userService.addUserFeature(userFeatureRelation);
    }

    @DeleteMapping("feature")
    public ResponseEntity<HttpStatus> removeUserFeature(@RequestBody @Valid UserFeatureRelation userFeatureRelation) {
        return userService.removeUserFeature(userFeatureRelation);
    }

}
