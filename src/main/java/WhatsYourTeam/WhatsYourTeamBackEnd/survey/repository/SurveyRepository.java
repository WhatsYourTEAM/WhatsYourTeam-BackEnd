package WhatsYourTeam.WhatsYourTeamBackEnd.survey.repository;

import WhatsYourTeam.WhatsYourTeamBackEnd.survey.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
