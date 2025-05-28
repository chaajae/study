package study.practice.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "action_card")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ActionCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTION_ID")
    private Integer id;
    @Column(name = "ACTION_NO")
    private String action_no;

    @Builder
    public ActionCard(Integer id, String action_no) {
        this.id = id;
        this.action_no = action_no;
    }
}
