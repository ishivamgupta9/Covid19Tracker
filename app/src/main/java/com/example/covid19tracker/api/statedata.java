package com.example.covid19tracker.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class statedata {

    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("confirmedCasesIndian")
    @Expose
    private String confirmedCasesIndian;
    @SerializedName("confirmedCasesForeign")
    @Expose
    private String confirmedCasesForeign;
    @SerializedName("discharged")
    @Expose
    private String discharged;
    @SerializedName("deaths")
    @Expose
    private String deaths;
    @SerializedName("totalConfirmed")
    @Expose
    private String totalConfirmed;







    public statedata(){

    }


    public statedata(String loc, String deaths, String totalConfirmed) {
        super();
        this.loc = loc;
        this.deaths = deaths;
        this.totalConfirmed = totalConfirmed;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(String confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public String getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(String confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public String getDischarged() {
        return discharged;
    }

    public void setDischarged(String discharged) {
        this.discharged = discharged;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }
}