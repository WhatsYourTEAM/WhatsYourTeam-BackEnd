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

    @Column(name = "assist_first")
    private Integer assistFirst;

    @Column(name = "rebound_second")
    private Integer reboundSecond;

    @Column(name = "steal_second")
    private Integer stealSecond;

    @Column(name = "three_second")
    private Integer threeSecond;

    @Column(name = "block_second")
    private Integer blockSecond;

    @Column(name = "assist_second")
    private Integer assistSecond;

    @Column(name = "rebound_third")
    private Integer reboundThird;

    @Column(name = "steal_third")
    private Integer stealThird;

    @Column(name = "three_third")
    private Integer threeThird;

    @Column(name = "block_third")
    private Integer blockThird;

    @Column(name = "assist_third")
    private Integer assistThird;


}
