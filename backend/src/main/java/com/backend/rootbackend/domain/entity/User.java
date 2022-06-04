package com.backend.rootbackend.domain.entity;

import com.backend.rootbackend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "Users")
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

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;


    public void modifyUser(String nickname, String password, String phoneNum, String profileImageUrl) {
        this.nickname = nickname;
        this.userPassword = password;
        this.phoneNum = phoneNum;
        this.profileImageUrl = profileImageUrl;
    }

}
