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
        for(String language : languages) {
            returnString += "<li>" + language + "</li>";
        }

        return returnString + "</ol>";
    }

    @GetMapping("/form")
    public String skillsTrackerForm() {
        String formString = "<form method='post' action='/form'>" +
                "<h2>Name:</h2>" +
                "<input type='text' name='coder' /><br>" +
                "<h2>My favorite language</h2>";
        for(int i = 0; i < 3; i++) {
            if(i > 0) {
                formString += "<h2>My " + (i == 1 ? "second" : "third") + " favorite language</h2>";
            }
            formString += "<select>";
            for(String language : languages) {
                formString += "<option value='" + language + " name='language" + i + "'>" + language + "</option>";
            }
            formString += "</select>" +
                    "<input type='submit' name='Submit!' />";
        }

        return formString;
    }


    @PostMapping("/form")
    public String skillsTrackerOutput(@RequestParam String coder, String language0, String language1, String language2) {
        String returnString = "<h1>" + coder +"</h1>" +
                "<ul><li> " + language0 +
                "</ul></li>";




        return returnString;
    }

}
