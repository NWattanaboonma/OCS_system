package com.example.demo.model;

public class SciencePlanBuilder {

    private String planID;
    private String planName;
    private String creator;
    private String submitter;
    private double funding;
    private String objective;
    private String target;
    private String startDate;
    private String endDate;
    private String telescopeLocation;
    private String dataProcessing;
    private String status;

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

    public SciencePlanBuilder setTarget(String target) {
        this.target = target;
        return this;
    }

    public SciencePlanBuilder setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public SciencePlanBuilder setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public SciencePlanBuilder setTelescopeLocation(String telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
        return this;
    }

    public SciencePlanBuilder setDataProcessing(String dataProcessing) {
        this.dataProcessing = dataProcessing;
        return this;
    }

    public SciencePlanBuilder setStatus(String status) {
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
}
