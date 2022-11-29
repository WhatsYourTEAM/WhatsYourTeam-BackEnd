package WhatsYourTeam.WhatsYourTeamBackEnd.survey;

import WhatsYourTeam.WhatsYourTeamBackEnd.survey.domain.Survey;
import WhatsYourTeam.WhatsYourTeamBackEnd.survey.dto.SurveyDto;
import WhatsYourTeam.WhatsYourTeamBackEnd.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    /**
     * 설문조사 등록 API
     * */
    @PostMapping("")
    public ResponseEntity<String> registerSurvey(SurveyDto surveyDto){
        Survey survey = new Survey();
        survey.setAssistFirst(surveyDto.getAssistFirst());
        survey.setAssistSecond(surveyDto.getAssistSecond());
        survey.setAssistThird(surveyDto.getAssistThird());
        survey.setBlockFirst(surveyDto.getBlockFirst());
        survey.setBlockSecond(surveyDto.getBlockSecond());
        survey.setBlockThird(surveyDto.getBlockThird());
        survey.setReboundFirst(surveyDto.getReboundFirst());
        survey.setReboundSecond(surveyDto.getReboundSecond());
        survey.setReboundThird(surveyDto.getReboundThird());
        survey.setStealFirst(surveyDto.getStealFirst());
        survey.setStealSecond(surveyDto.getStealSecond());
        survey.setStealThird(surveyDto.getStealThird());
        survey.setThreeFirst(surveyDto.getThreeFirst());
        survey.setThreeSecond(surveyDto.getThreeSecond());
        survey.setThreeThird(surveyDto.getThreeThird());
        surveyService.saveSurvey(survey);
        return new ResponseEntity<>("설문조사 등록 완료", HttpStatus.OK);
    }
}
