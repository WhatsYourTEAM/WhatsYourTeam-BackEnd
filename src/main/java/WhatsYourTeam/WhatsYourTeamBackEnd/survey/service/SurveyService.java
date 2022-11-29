package WhatsYourTeam.WhatsYourTeamBackEnd.survey.service;

import WhatsYourTeam.WhatsYourTeamBackEnd.survey.domain.Survey;
import WhatsYourTeam.WhatsYourTeamBackEnd.survey.repository.SurveyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public void saveSurvey(Survey survey){
        surveyRepository.save(survey);
    }
}
