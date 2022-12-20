package WhatsYourTeam.WhatsYourTeamBackEnd;

import WhatsYourTeam.WhatsYourTeamBackEnd.dto.Favorite;
import WhatsYourTeam.WhatsYourTeamBackEnd.dto.FirstSurvey;
import WhatsYourTeam.WhatsYourTeamBackEnd.user.User;
import WhatsYourTeam.WhatsYourTeamBackEnd.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String landingPage(){return "landing.html";}

    @GetMapping("/firstSurvey")
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

    @GetMapping("/favorite")
    public String favorite(){return "favorite.html";}

    @GetMapping("/review")
    public String review(){return "review.html";}

    @GetMapping("/thank")
    public String thank(){return "thank.html";}

    @GetMapping("/result")
    public String result(Model model) throws IOException {

        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);

        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/kitae/Desktop/WhatsYourTeam-BackEnd/src/main/java/WhatsYourTeam/WhatsYourTeamBackEnd/testDB.csv", true));
        PrintWriter pw = new PrintWriter(bw,true);
        String NEWLINE = System.lineSeparator();

        pw.write(user.getUserId().toString());
        pw.write(",");
        pw.write(user.getReboundFirst().toString());
        pw.write(",");
        pw.write(user.getStealFirst().toString());
        pw.write(",");
        pw.write(user.getThreeFirst().toString());
        pw.write(",");
        pw.write(user.getBlockFirst().toString());
        pw.write(",");
        pw.write(user.getAssistFirst().toString());
        pw.write(",");
        pw.write(user.getAssistSecond().toString());
        pw.write(",");
        pw.write(user.getAssistThird().toString());
        pw.write(",");
        pw.write(user.getBlockSecond().toString());
        pw.write(",");
        pw.write(user.getBlockThird().toString());
        pw.write(",");
        pw.write(user.getReboundSecond().toString());
        pw.write(",");
        pw.write(user.getReboundThird().toString());
        pw.write(",");
        pw.write(user.getStealSecond().toString());
        pw.write(",");
        pw.write(user.getStealThird().toString());
        pw.write(",");
        pw.write(user.getThreeSecond().toString());
        pw.write(",");
        pw.write(user.getThreeThird().toString());
        pw.write(",");
        pw.write("0");
        pw.write(NEWLINE);
        pw.flush();
        pw.close();

        String[] command = new String[2];
        command[0] = "python";
        command[1] = "/Users/kitae/Desktop/WhatsYourTeam-BackEnd/src/main/java/WhatsYourTeam/WhatsYourTeamBackEnd/whatsyourteam.py";

        try {
            CommandLine commandLine = CommandLine.parse(command[0]);
            for (int i = 1, n = command.length; i < n; i++) {
                commandLine.addArgument(command[i]);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
            DefaultExecutor executor = new DefaultExecutor();
            executor.setStreamHandler(pumpStreamHandler);
            int result = executor.execute(commandLine);
            System.out.println(outputStream.toString());
            model.addAttribute("contentsRecommend", outputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public void writeCSV() throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/kitae/Desktop/WhatsYourTeam-BackEnd/src/main/java/WhatsYourTeam/WhatsYourTeamBackEnd/testDB.csv", true));
        PrintWriter pw = new PrintWriter(bw,true);
        String NEWLINE = System.lineSeparator();

        pw.write("이기태");
        pw.write(NEWLINE);
        pw.flush();
        pw.close();

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

    @ResponseBody
    @RequestMapping(value = "/favorite", method = RequestMethod.POST)
    public void favorite(FirstSurvey firstSurvey) throws IOException{
        List<User> userList = userRepository.findAll();
        User user = userList.get(userList.size() - 1);
        if(firstSurvey.getFirstSurvey() != null) {
            user.setFavorite(firstSurvey.getFirstSurvey());
            userRepository.save(user);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/kitae/Desktop/WhatsYourTeam-BackEnd/src/main/java/WhatsYourTeam/WhatsYourTeamBackEnd/testDB.csv", false));
        PrintWriter pw = new PrintWriter(bw, false);
        String NEWLINE = System.lineSeparator();

        pw.write("user_id,rebound_first,steal_first,three_first,block_first,assist_first,assist_second,assist_third,block_second,block_third,rebound_second,rebound_third,steal_second,steal_third,three_second,three_third,favorite");
        pw.write(NEWLINE);

        for (User user1 : userList) {
            pw.write(user1.getUserId().toString());
            pw.write(",");
            pw.write(user1.getReboundFirst().toString());
            pw.write(",");
            pw.write(user1.getStealFirst().toString());
            pw.write(",");
            pw.write(user1.getThreeFirst().toString());
            pw.write(",");
            pw.write(user1.getBlockFirst().toString());
            pw.write(",");
            pw.write(user1.getAssistFirst().toString());
            pw.write(",");
            pw.write(user1.getAssistSecond().toString());
            pw.write(",");
            pw.write(user1.getAssistThird().toString());
            pw.write(",");
            pw.write(user1.getBlockSecond().toString());
            pw.write(",");
            pw.write(user1.getBlockThird().toString());
            pw.write(",");
            pw.write(user1.getReboundSecond().toString());
            pw.write(",");
            pw.write(user1.getReboundThird().toString());
            pw.write(",");
            pw.write(user1.getStealSecond().toString());
            pw.write(",");
            pw.write(user1.getStealThird().toString());
            pw.write(",");
            pw.write(user1.getThreeSecond().toString());
            pw.write(",");
            pw.write(user1.getThreeThird().toString());
            pw.write(",");
            pw.write(user1.getFavorite().toString());
            pw.write(NEWLINE);
        }
        pw.flush();
        pw.close();
    }
}
