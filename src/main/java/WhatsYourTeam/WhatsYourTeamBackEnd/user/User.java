package WhatsYourTeam.WhatsYourTeamBackEnd.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "rebound_first")
    private Integer reboundFirst;

    @Column(name = "steal_first")
    private Integer stealFirst;

    @Column(name = "three_first")
    private Integer threeFirst;

    @Column(name = "block_first")
    private Integer blockFirst;
}
