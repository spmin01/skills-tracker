package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class SkillsController {

    private static String[] languages = {"Java", "JavaScript", "C++"};

    @GetMapping("/")
    public String skillsTracker() {
        String returnString = "<h1>Skills Tracker</h1>" +
                "<ol>";
        for (String language : languages) {
            returnString += "<li>" + language + "</li>";
        }

        return returnString + "</ol>";
    }

    @GetMapping("/form")
    public String skillsTrackerForm() {
        String formString = "<form method='post' action='/form'>" +
                "<h2>Name:</h2>" +
                "<input type='text' name='coder' /><br>" +
                "<h2>My favorite language</h2>" +
                "<select name='language1'><option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='C++'>C++</option></select>" +
                "<h2>My second favorite language</h2>" +
                "<select name='language2'><option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='C++'>C++</option></select>" +
                "<h2>My third favorite language</h2>" +
                "<select name='language3'><option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='C++'>C++</option></select>" +
                "<br><input type='submit' name='Submit!'/></form>";

        return formString;
    }


    @PostMapping("/form")
    public String skillsTrackerOutput(@RequestParam String coder, @RequestParam String language1,
                                      @RequestParam String language2, @RequestParam String language3) {
        String returnString = "<h1>" + coder + "</h1>" +
                "<ul><li> " + language1 + "</li>" +
                "<li>" + language2 + "</li>" +
                "<li>" + language3 +"</li></ul>";


        return returnString;
    }

}
