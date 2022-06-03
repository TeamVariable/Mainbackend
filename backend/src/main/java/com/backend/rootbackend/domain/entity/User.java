package com.backend.rootbackend.domain.entity;

import com.backend.rootbackend.global.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    private UUID userIdx;

    private String name;
    private String nickname;
    private String profileImageUrl;
    private String phoneNum;
    private String userEmail;
    private String userPassword;


}
