package com.example.demo.model;

public class SciencePlan {
    //ลองดู ใน class นะ อันนี้เค้า draft ให้เฉยๆ
    String planID;
    String planName;
    String creator;
    String submitter;
    double funding;
    String objective;
    String target;
    String startDate;
    String endDate;
    String telescopeLocation;
    String dataProcessing;
    String status;

    // Constructor
    public SciencePlan(String planID, String planName, String creator, String submitter, double funding,
                       String objective, String target, String startDate, String endDate,
                       String telescopeLocation, String dataProcessing, String status) {
        this.planID = planID;
        this.planName = planName;
        this.creator = creator;
        this.submitter = submitter;
        this.funding = funding;
        this.objective = objective;
        this.target = target;
        this.startDate = startDate;
        this.endDate = endDate;
        this.telescopeLocation = telescopeLocation;
        this.dataProcessing = dataProcessing;
        this.status = status;
    }


    // Getters and Setters
    public String getId() {
        return this.planID;
    }

    public void setId(String id) {
        this.planID = id;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSubmitter() {
        return this.submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public double getFundingInUSD() {
        return this.funding;
    }

    public void setFundingInUSD(double fundingInUSD) {
        this.funding = fundingInUSD;
    }

    public String getObjective() {
        return this.objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getStarSystem() {
        return this.target;
    }

    public void setStarSystem(String starSystem) {
        this.target = starSystem;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTelescopeLocation() {
        return this.telescopeLocation;
    }

    public void setTelescopeLocation(String telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataProcessing() {
        return dataProcessing;
    }

    public void setDataProcessing(String dataProcessing) {
        this.dataProcessing = dataProcessing;
    }

    public String getSciencePlanDetail() {
        return "Science Plan: " +this.planID+" "+this.planName + ", Creator: " + this.creator +", Submitter: " + this.submitter + ", Funding: " + this.funding;
    }
}
