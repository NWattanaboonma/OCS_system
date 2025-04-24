package com.example.demo.model;

import com.example.demo.enums.enumeration;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class SciencePlanBuilder {

    private String planID;
    private String planName;
    private String creator;
    private String submitter;
    private double funding;
    private String objective;
    private List<Star> target;
    private DateTimeFormatter startDate;
    private DateTimeFormatter endDate;
    private enumeration.TelescopeLocation telescopeLocation;
    private DataProcessing dataProcessing;
    private enumeration.Status status;

    // --- Builder Methods ---

    public SciencePlanBuilder setPlanName(String planName) {
        this.planName = planName;
        return this;
    }

    public SciencePlanBuilder setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public SciencePlanBuilder setSubmitter(String submitter) {
        this.submitter = submitter;
        return this;
    }

    public SciencePlanBuilder setFunding(double funding) {
        this.funding = funding;
        return this;
    }

    public SciencePlanBuilder setObjective(String objective) {
        this.objective = objective;
        return this;
    }

    public SciencePlanBuilder setTarget(List<Star> target) {
        this.target = target;
        return this;
    }

    public SciencePlanBuilder setStartDate(DateTimeFormatter startDate) {
        this.startDate = startDate;
        return this;
    }

    public SciencePlanBuilder setEndDate(DateTimeFormatter endDate) {
        this.endDate = endDate;
        return this;
    }

    public SciencePlanBuilder setTelescopeLocation(enumeration.TelescopeLocation telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
        return this;
    }

    public SciencePlanBuilder setDataProcessing(DataProcessing dataProcessing) {
        this.dataProcessing = dataProcessing;
        return this;
    }

    public SciencePlanBuilder setStatus(enumeration.Status status) {
        this.status = status;
        return this;
    }

    // --- Build Method ---
    public SciencePlan build() {
        this.planID = generatePlanID();
        return new SciencePlan(
                planID,
                planName,
                creator,
                submitter,
                funding,
                objective,
                target,
                startDate,
                endDate,
                telescopeLocation,
                dataProcessing,
                status
        );
    }

    // --- ID Generator ---
    private String generatePlanID() {
        return "SP-" + System.currentTimeMillis();
    }

    //add data processing
}
