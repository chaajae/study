package study.practice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@ToString
@Table(name = "USER_INFO")
public class UserInfoEntity {
    @Id
    @Column(name = "UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_DESCRIPTION")
    private String userDescription;

    @Builder
    public UserInfoEntity(
            Integer uid,
            String userId,
            String userName,
            String userDescription
    ) {
        this.uid = uid;
        this.userId = userId;
        this.userName = userName;
        this.userDescription = userDescription;
    }
}
