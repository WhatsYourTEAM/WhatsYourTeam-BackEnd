package WhatsYourTeam.WhatsYourTeamBackEnd;

import WhatsYourTeam.WhatsYourTeamBackEnd.dto.FirstSurvey;
import WhatsYourTeam.WhatsYourTeamBackEnd.user.User;
import WhatsYourTeam.WhatsYourTeamBackEnd.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String firstSurvey() {
        return "landingPage.html";
    }

    @GetMapping("/secondSurvey")
    public String secondSurvey() {
        return "secondSurvey.html";
    }

    @GetMapping("/thirdSurvey")
    public String thirdSurvey() {
        return "thirdSurvey.html";
    }

    @GetMapping("/fourthSurvey")
    public String fourthSurvey() {
        return "fourthSurvey.html";
    }

    @GetMapping("/fifthSurvey")
    public String fifthSurvey() {
        return "fifthSurvey.html";
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void firstSurvey(FirstSurvey firstSurvey) {
        User user = new User();
        if(firstSurvey.getFirstSurvey() != null) {
            user.setReboundFirst(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/secondSurvey", method = RequestMethod.POST)
    public void secondSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setStealFirst(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/thirdSurvey", method = RequestMethod.POST)
    public void thirdSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setThreeFirst(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/fourthSurvey", method = RequestMethod.POST)
    public void fourthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setBlockFirst(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }
}
