package WhatsYourTeam.WhatsYourTeamBackEnd.survey.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "survey")
public class Survey {

    /**
     * 리바운드
     * 스틸
     * 3점
     * 블록
     * 어시스트
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long surveyId;

    @Column(name = "block_first")
    private Integer blockFirst;

    @Column(name = "block_second")
    private Integer blockSecond;

    @Column(name = "block_third")
    private Integer blockThird;

    @Column(name = "steal_first")
    private Integer stealFirst;

    @Column(name = "steal_second")
    private Integer stealSecond;

    @Column(name = "steal_third")
    private Integer stealThird;

    @Column(name = "rebound_first")
    private Integer reboundFirst;

    @Column(name = "rebound_second")
    private Integer reboundSecond;

    @Column(name = "rebound_third")
    private Integer reboundThird;

    @Column(name = "three_first")
    private Integer threeFirst;

    @Column(name = "three_second")
    private Integer threeSecond;

    @Column(name = "three_third")
    private Integer threeThird;

    @Column(name = "assist_first")
    private Integer assistFirst;

    @Column(name = "assist_second")
    private Integer assistSecond;

    @Column(name = "assist_third")
    private Integer assistThird;
}
