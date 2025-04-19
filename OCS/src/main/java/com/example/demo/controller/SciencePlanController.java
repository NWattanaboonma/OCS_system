package com.example.demo.controller;

import com.example.demo.DemoApplication;
import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class SciencePlanController {

    @Autowired
    private DemoApplication demoApplication;

    @GetMapping("science-plans")
    public String getSciencePlans(Model model) {
        System.out.println(">>> /science-plans was called");
        ArrayList<SciencePlan> sciencePlans = demoApplication.getAllSciencePlans();
        model.addAttribute("sciencePlans", sciencePlans);
        return "HomePage";
    }


}

