package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.model.SciencePlanBuilder;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class SciencePlanController {

//    @Autowired
//    private DemoApplication demoApplication;
    private static OCS ocs = new OCS(true);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @GetMapping("/science-plans")
    public String getSciencePlans(Model model) {
        System.out.println(">>> /science-plans was called");
        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
        model.addAttribute("sciencePlans", sciencePlans);
        return "HomePage";
    }

    @GetMapping("/SciencePlan-page1")
    public String createSciencePlan_Page1(Model model) {
        System.out.println(">>> /Form Page1 was called");
//        model.addAttribute("constellations", StarSystem.CONSTELLATIONS.values());
        model.addAttribute("constellationNames", Arrays.stream(StarSystem.CONSTELLATIONS.values())
                .map(Enum::name)
                .collect(Collectors.toList()));
        model.addAttribute("telescopeLocations", SciencePlan.TELESCOPELOC.values());
        return "page1";
    }

    @GetMapping("/SciencePlan-page2")
    public String createSciencePlan_Page2(Model model) {
        System.out.println(">>> /Form Page2 was called");
        return "page2";
    }

    @PostMapping("/submit-science-plan")
    public String CreateSciencePlan(@RequestParam Map<String, String> formData) {
        System.out.println(">>> /create-plan was called");

        // String fields (can be null or empty)
        String creator = emptyToNull(formData.get("creator"));
        String submitter = emptyToNull(formData.get("submitter"));
        submitter = "Ching Bole";   // FOR DEBUG ONLY

        String objectives = emptyToNull(formData.get("objective"));

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = emptyToNull(formData.get("startDate"));
        LocalDateTime startDateParsed = parseDate(startDate);
        String formattedStartDate = startDateParsed.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String endDate = emptyToNull(formData.get("endDate"));
        LocalDateTime endDateParsed = parseDate(endDate);
        String formattedEndDate = endDateParsed.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Numeric fields
        double fundingInUSD = parseOrDefault((formData.get("funding")));

        // Enums (use safe parsing)
        StarSystem.CONSTELLATIONS starSystem = parseEnum(formData.get("constellation"), StarSystem.CONSTELLATIONS.class);
        com.example.demo.model.SciencePlan.TELESCOPELOC telescopeLocation = parseEnum(
                formData.get("telescope"), com.example.demo.model.SciencePlan.TELESCOPELOC.class
        );

        if (telescopeLocation == null) {
            throw new IllegalArgumentException("Telescope location must not be null");
        }

        // DataProcRequirement: all Double fields nullable
        DataProcRequirement dr = new DataProcRequirement(
                emptyToNull(formData.get("fileType")),
                emptyToNull(formData.get("fileQuality")),
                emptyToNull(formData.get("colorType")),
                parseOrDefault(formData.get("contrast")),
                parseOrDefault(formData.get("brightness")),
                parseOrDefault(formData.get("saturation")),
                parseOrDefault(formData.get("highlights")),
                parseOrDefault(formData.get("exposure")),
                parseOrDefault(formData.get("shadows")),
                parseOrDefault(formData.get("whites")),
                parseOrDefault(formData.get("blacks")),
                parseOrDefault(formData.get("luminance")),
                parseOrDefault(formData.get("hue"))
        );

        com.example.demo.model.SciencePlan.STATUS status = com.example.demo.model.SciencePlan.STATUS.SAVED;

        // Log all values for debugging
        System.out.println("Creator: " + creator);
        System.out.println("Submitter: " + submitter);
        System.out.println("Objectives: " + objectives);
        System.out.println("Start Date: " + formattedStartDate);
        System.out.println("End Date: " + formattedEndDate);
        System.out.println("Funding in USD: " + fundingInUSD);
        System.out.println("Star System: " + starSystem);
        System.out.println("Telescope Location: " + telescopeLocation);
        System.out.println("DataProcRequirement: " + dr);


        // Build the plan
        com.example.demo.model.SciencePlan sciencePlan = new SciencePlanBuilder()
                .setCreator(creator)
                .setSubmitter(submitter)
                .setFundingInUSD(fundingInUSD)
                .setObjective(objectives)
                .setStarSystem(starSystem)
//                .setStartDate(formattedStartDate)
//                .setEndDate(formattedEndDate)
                .setStartDate(formattedStartDate != null ? formattedStartDate : "1900-01-01 00:00:00")
                .setEndDate(formattedEndDate != null ? formattedEndDate : "1900-01-01 00:00:00")
                .setTelescopeLocation(telescopeLocation)
                .setDataProcessing(new ArrayList<>(List.of(dr)))
                .setStatus(status)
                .build();

        System.out.println("Science Plan created: " + sciencePlan.getDetail());
        ocs.createSciencePlan(sciencePlan);
        System.out.println(ocs.getAllSciencePlans());
        return "redirect:/science-plans";
    }

    private String emptyToNull(String value) {
        return (value == null || value.trim().isEmpty()) ? null : value.trim();
    }

    private double parseOrDefault(String value) {
        try {
            return (value == null || value.trim().isEmpty()) ? 0.0 : Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private <T extends Enum<T>> T parseEnum(String value, Class<T> enumType) {
        try {
            return (value == null || value.trim().isEmpty()) ? null : Enum.valueOf(enumType, value.trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private LocalDateTime parseDate(String dateStr) {
        try {
//            return (dateStr == null || dateStr.trim().isEmpty()) ? null : LocalDateTime.parse(dateStr.trim(), DATE_TIME_FORMATTER);
            if (dateStr == null || dateStr.trim().isEmpty()) {
                return null;
            }
            if (dateStr.contains("T")) {
                return LocalDateTime.parse(dateStr);
            } else {
                return LocalDateTime.parse(dateStr.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        } catch (DateTimeParseException e) {
            System.out.println("Date parsing failed: " + dateStr);
            return null;
        }
    }

}

