package com.example.demo.model;

import edu.gemini.app.ocs.model.AstronomicalData;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.StarSystem;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class SciencePlan extends edu.gemini.app.ocs.model.SciencePlan {
    private int planNo;
    private String creator;
    private String submitter;
    private double fundingInUSD;
    private String objectives;
    private StarSystem.CONSTELLATIONS starSystem;
    private Date startDate;
    private Date endDate;
    private TELESCOPELOC telescopeLocation;
    private final ArrayList<ArrayList<DataProcRequirement>> dataProcRequirements = new ArrayList<>();
    private final AstronomicalData astroData = new AstronomicalData();
    private STATUS status;

    SciencePlan(SciencePlanBuilder builder) {
        this.planNo = builder.planNo;
        this.creator = builder.creator;
        this.submitter = builder.submitter;
        this.fundingInUSD = builder.fundingInUSD;
        this.objectives = builder.objectives;
        this.starSystem = builder.starSystem;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.telescopeLocation = builder.telescopeLocation;
        this.dataProcRequirements.add(builder.dataProcRequirements);
        this.status = builder.status;
    }

//    public String getCreator() {
//        return this.creator;
//    }
//
//    public void setCreator(String creator) {
//        this.creator = creator;
//    }
//
//    public String getSubmitter() {
//        return this.submitter;
//    }
//
//    public void setSubmitter(String submitter) {
//        this.submitter = submitter;
//    }
//
//    public double getFundingInUSD() {
//        return this.fundingInUSD;
//    }
//
//    public void setFundingInUSD(double fundingInUSD) {
//        this.fundingInUSD = fundingInUSD;
//    }
//
//    public String getObjectives() {
//        return this.objectives;
//    }
//
//    public void setObjectives(String objectives) {
//        this.objectives = objectives;
//    }
//
//    public StarSystem.CONSTELLATIONS getStarSystem() {
//        return this.starSystem;
//    }
//
//    public void setStarSystem(StarSystem.CONSTELLATIONS starSystem) {
//        this.starSystem = starSystem;
//    }
//
//    public String getStartDate() {
//        String sDate = null;
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        try {
//            sDate = formatter.format(this.startDate);
//        } catch (Exception var4) {
//            sDate = "-1";
//        }
//
//        return sDate;
//    }

//    public void setStartDate(String startDate) {
//        try {
//            this.startDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).parse(startDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public String getEndDate() {
//        String eDate = null;
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        try {
//            eDate = formatter.format(this.endDate);
//        } catch (Exception var4) {
//            eDate = "-1";
//        }
//
//        return eDate;
//    }
//
//    public void setEndDate(String endDate) {
//        try {
//            this.endDate = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).parse(endDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }

//    public edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC getTelescopeLocation() {
//        return this.telescopeLocation;
//    }
//
//    public void setTelescopeLocation(TELESCOPELOC telescopeLocation) {
//        this.telescopeLocation = telescopeLocation;
//    }
//
//    public ArrayList<ArrayList<DataProcRequirement>> getDataProcRequirements() {
//        return this.dataProcRequirements;
//    }
//
//    public void setDataProcRequirements(ArrayList<DataProcRequirement> dataProcRequirements) {
//        this.dataProcRequirements.add(dataProcRequirements);
//    }
//
//    public int getPlanNo() {
//        return this.planNo;
//    }
//
//    public void setPlanNo(int planNo) {
//        this.planNo = planNo;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public edu.gemini.app.ocs.model.SciencePlan.STATUS getStatus() {
//        return this.status;
//    }
//
//    public void setStatus(STATUS status) {
//        this.status = status;
//    }
//
//    public AstronomicalData retrieveAstroData(ArrayList<String> imgURL) throws IOException {
//        return this.astroData.getAstronomicalData(imgURL);
//    }

//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        } else if (o != null && this.getClass() == o.getClass()) {
//            SciencePlan that = (SciencePlan)o;
//            return this.planNo == that.planNo && Double.compare(that.fundingInUSD, this.fundingInUSD) == 0 && this.creator.equals(that.creator) && this.submitter.equals(that.submitter) && this.objectives.equals(that.objectives) && this.starSystem == that.starSystem && this.startDate.equals(that.startDate) && this.endDate.equals(that.endDate) && this.telescopeLocation == that.telescopeLocation && Objects.equals(this.dataProcRequirements, that.dataProcRequirements) && Objects.equals(this.astroData, that.astroData) && this.status == that.status;
//        } else {
//            return false;
//        }
//    }

//    public int hashCode() {
//        return Objects.hash(new Object[]{this.planNo, this.creator, this.submitter, this.fundingInUSD, this.objectives, this.starSystem, this.startDate, this.endDate, this.telescopeLocation, this.dataProcRequirements, this.astroData, this.status});
//    }

    public String getDetail() {
//        if (this.creator != null && this.submitter != null && this.objectives != null && this.starSystem != null && this.startDate != null && this.endDate != null && this.telescopeLocation != null && this.dataProcRequirements != null && this.status != null) {
//            int var10000 = this.planNo;
//            return "{planNo=" + var10000 + ", creator='" + this.creator + "', submitter='" + this.submitter + "', fundingInUSD=" + this.fundingInUSD + ", objectives='" + this.objectives + "', starSystem=" + String.valueOf(this.starSystem) + ", startDate=" + (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(this.startDate) + ", endDate=" + (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(this.endDate) + ", telescopeLocation='" + String.valueOf(this.telescopeLocation) + "', status='" + String.valueOf(this.status) + "', " + String.valueOf(this.dataProcRequirements) + "}\n";
//        } else {
//            return "ERROR: Cannot print the science plan. Some of the attributes are null.";
//        }
        return "{planNo=" + this.planNo + ", creator='" + this.creator + "', submitter='" + this.submitter + "', fundingInUSD=" + this.fundingInUSD + ", objectives='" + this.objectives + "', starSystem=" + String.valueOf(this.starSystem) + ", startDate=" + (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(this.startDate) + ", endDate=" + (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(this.endDate) + ", telescopeLocation='" + String.valueOf(this.telescopeLocation) + "', status='" + String.valueOf(this.status) + "', " + String.valueOf(this.dataProcRequirements) + "}";
    }

//    public static enum TELESCOPELOC {
//        HAWAII,
//        CHILE;
//
//        private TELESCOPELOC() {
//        }
//    }
//
//    public static enum STATUS {
//        SAVED,
//        COMPLETE,
//        TESTED,
//        CANCELLED,
//        RUNNING,
//        SUBMITTED,
//        VALIDATED,
//        INVALIDATED;
//
//        private STATUS() {
//        }
//    }
}
