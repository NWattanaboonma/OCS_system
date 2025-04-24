package com.example.demo.model;

import edu.gemini.app.ocs.model.AstronomicalData;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.StarSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SciencePlanBuilder {

//    private String planID;
//    private String planName;
//    private String creator;
//    private String submitter;
//    private double funding;
//    private String objective;
//    private List<Star> target;
//    private DateTimeFormatter startDate;
//    private DateTimeFormatter endDate;
//    private enumeration.TelescopeLocation telescopeLocation;
//    private DataProcessing dataProcessing;
//    private enumeration.Status status;
    int planNo;
    String creator;
    String submitter;
    double fundingInUSD;
    String objectives;
    StarSystem.CONSTELLATIONS starSystem;
    Date startDate;
    Date endDate;
    SciencePlan.TELESCOPELOC telescopeLocation;
    ArrayList<DataProcRequirement> dataProcRequirements = new ArrayList<>();
//    private AstronomicalData astroData = new AstronomicalData();
    SciencePlan.STATUS status;

    // --- Builder Methods ---
//    public SciencePlanBuilder setPlanName(String planName) {
//        this.planName = planName;
//        return this;
//    }

    public SciencePlanBuilder setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public SciencePlanBuilder setSubmitter(String submitter) {
        this.submitter = submitter;
        return this;
    }

    public SciencePlanBuilder setFundingInUSD(double funding) {
        this.fundingInUSD = funding;
        return this;
    }

    public SciencePlanBuilder setObjective(String objective) {
        this.objectives = objective;
        return this;
    }

    public SciencePlanBuilder setStarSystem(StarSystem.CONSTELLATIONS target) {
        this.starSystem = target;
        return this;
    }

    public SciencePlanBuilder setStartDate(String startDate) {
        try {
            this.startDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(startDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid start date format", e);
        }
        return this;
    }


    public SciencePlanBuilder setEndDate(String endDate) {
        try {
            this.endDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid end date format", e);
        }
        return this;
    }


    public SciencePlanBuilder setTelescopeLocation(SciencePlan.TELESCOPELOC telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
        return this;
    }

    public SciencePlanBuilder setDataProcessing(ArrayList<DataProcRequirement> dataProcessing) {
        this.dataProcRequirements = dataProcessing;
        return this;
    }

    public SciencePlanBuilder setStatus(SciencePlan.STATUS status) {
        this.status = status;
        return this;
    }

    // --- Build Method ---
    public SciencePlan build() {
        this.planNo = generatePlanID();
        return new SciencePlan(this);
    }

    // --- ID Generator ---
    private int generatePlanID() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    //add data processing
}
