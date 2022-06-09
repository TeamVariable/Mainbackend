package com.backend.rootbackend.domain.entity;

import com.backend.rootbackend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "users")
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

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "nick_name", length = 20, nullable = false)
    private String nickname;

    @Column(name = "profile_image_url", length = 50)
    private String profileImageUrl;

    @Column(name = "phone_num", length = 20, nullable = false)
    private String phoneNum;

    @Column(name = "user_email", length = 20, nullable = false)
    private String userEmail;

    @Column(name = "user_password", length = 100, nullable = false)
    private String userPassword;


    public void modifyUser(String nickname, String password, String phoneNum, String profileImageUrl) {
        this.nickname = nickname;
        this.userPassword = password;
        this.phoneNum = phoneNum;
        this.profileImageUrl = profileImageUrl;
    }

}
