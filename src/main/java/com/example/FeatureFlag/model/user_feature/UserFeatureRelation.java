package com.example.FeatureFlag.model.user_feature;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "USER_FEATURE")
@IdClass(UserFeatureRelationId.class)
@Getter
public class UserFeatureRelation implements Serializable {

    @Id
    @NotNull
    private Integer userId;
    @Id
    @NotNull
    private Integer featureId;
}
