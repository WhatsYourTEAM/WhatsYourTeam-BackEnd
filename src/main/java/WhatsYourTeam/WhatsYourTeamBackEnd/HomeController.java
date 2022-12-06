package WhatsYourTeam.WhatsYourTeamBackEnd;

import WhatsYourTeam.WhatsYourTeamBackEnd.dto.FirstSurvey;
import WhatsYourTeam.WhatsYourTeamBackEnd.user.User;
import WhatsYourTeam.WhatsYourTeamBackEnd.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/sixthSurvey")
    public String sixthSurvey() {
        return "sixthSurvey.html";
    }

    @GetMapping("/seventhSurvey")
    public String seventhSurvey() {
        return "seventhSurvey.html";
    }

    @GetMapping("/eighthSurvey")
    public String eighthSurvey() {
        return "eighthSurvey.html";
    }

    @GetMapping("/ninthSurvey")
    public String ninthSurvey() {
        return "ninthSurvey.html";
    }

    @GetMapping("/tenthSurvey")
    public String tenthSurvey() {
        return "tenthSurvey.html";
    }
    @GetMapping("/eleventhSurvey")
    public String eleventhSurvey() {
        return "eleventhSurvey.html";
    }

    @GetMapping("/twelvethSurvey")
    public String twelvethSurvey() {
        return "twelvethSurvey.html";
    }

    @GetMapping("/thirteenthSurvey")
    public String thirteenthSurvey() {
        return "thirteenthSurvey.html";
    }

    @GetMapping("/fourteenthSurvey")
    public String fourteenthSurvey() {
        return "fourteenthSurvey.html";
    }

    @GetMapping("/fifteenthSurvey")
    public String fifteenthSurvey() {
        return "fifteenthSurvey.html";
    }

    @GetMapping("/waiting")
    public String waiting() {
        return "waiting.html";
    }

    @GetMapping("/result")
    public String result(Model model) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        int max = 0;
        int reboundScore = user.getReboundFirst() + user.getReboundSecond() + user.getReboundThird();
        int stealScore = user.getStealFirst() + user.getStealSecond() + user.getStealThird();
        int assistScore = user.getAssistFirst() + user.getAssistSecond() + user.getAssistThird();
        int blockScore = user.getBlockFirst() + user.getBlockSecond() + user.getBlockThird();
        int threeScore = user.getThreeFirst() + user.getThreeSecond() + user.getThreeThird();

        ArrayList<Integer> scoreList = new ArrayList<>();
        scoreList.add(reboundScore);
        scoreList.add(stealScore);
        scoreList.add(assistScore);
        scoreList.add(blockScore);
        scoreList.add(threeScore);

        for (Integer integer : scoreList) {
            if (integer > max) {
                max = integer;
            }
        }

        if(reboundScore == max){
            model.addAttribute("type", "rebound");
        }

        else if(stealScore == max){
            model.addAttribute("type", "steal");
        }

        else if(threeScore == max){
            model.addAttribute("type", "three");
        }

        else if(blockScore == max){
            model.addAttribute("type", "block");
        }

        else if(assistScore == max){
            model.addAttribute("type", "assist");
        }

        return "result.html";
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

    @ResponseBody
    @RequestMapping(value = "/fifthSurvey", method = RequestMethod.POST)
    public void fifthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setAssistFirst(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/sixthSurvey", method = RequestMethod.POST)
    public void sixthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setReboundSecond(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/seventhSurvey", method = RequestMethod.POST)
    public void seventhSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setStealSecond(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/eighthSurvey", method = RequestMethod.POST)
    public void eighthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setThreeSecond(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/ninthSurvey", method = RequestMethod.POST)
    public void ninthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setBlockSecond(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/tenthSurvey", method = RequestMethod.POST)
    public void tenthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setAssistSecond(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/eleventhSurvey", method = RequestMethod.POST)
    public void eleventhSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setReboundThird(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/twelvethSurvey", method = RequestMethod.POST)
    public void twelvethSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setStealThird(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/thirteenthSurvey", method = RequestMethod.POST)
    public void thirteenthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setThreeThird(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/fourteenthSurvey", method = RequestMethod.POST)
    public void fourteenthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setBlockThird(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/fifteenthSurvey", method = RequestMethod.POST)
    public void fifteenthSurvey(FirstSurvey firstSurvey) {
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setAssistThird(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }
    }
}
