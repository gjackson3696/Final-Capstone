package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class LoggedWorkout extends Workout {
    @NotNull
    private String backSquat, frontSquat, zercherSquat, overheadSquat, bulgarianSplitSquat;
    @NotNull
    private String conventionalDeadlift, sumoDeadlift;
    @NotNull
    private String overheadPress, militaryPress, pushPress;
    @NotNull
    private String squatClean, powerClean, splitJerk, pushJerk, squatJerk, squatSnatch, powerSnatch, snatchBalance;

    public LoggedWorkout() {
        super();
    }

    public String getBackSquat() {
        return backSquat;
    }

    public void setBackSquat(String backSquat) {
        this.backSquat = backSquat;
    }

    public String getFrontSquat() {
        return frontSquat;
    }

    public void setFrontSquat(String frontSquat) {
        this.frontSquat = frontSquat;
    }

    public String getZercherSquat() {
        return zercherSquat;
    }

    public void setZercherSquat(String zercherSquat) {
        this.zercherSquat = zercherSquat;
    }

    public String getOverheadSquat() {
        return overheadSquat;
    }

    public void setOverheadSquat(String overheadSquat) {
        this.overheadSquat = overheadSquat;
    }

    public String getBulgarianSplitSquat() {
        return bulgarianSplitSquat;
    }

    public void setBulgarianSplitSquat(String bulgarianSplitSquat) {
        this.bulgarianSplitSquat = bulgarianSplitSquat;
    }

    public String getConventionalDeadlift() {
        return conventionalDeadlift;
    }

    public void setConventionalDeadlift(String conventionalDeadlift) {
        this.conventionalDeadlift = conventionalDeadlift;
    }

    public String getSumoDeadlift() {
        return sumoDeadlift;
    }

    public void setSumoDeadlift(String sumoDeadlift) {
        this.sumoDeadlift = sumoDeadlift;
    }

    public String getOverheadPress() {
        return overheadPress;
    }

    public void setOverheadPress(String overheadPress) {
        this.overheadPress = overheadPress;
    }

    public String getMilitaryPress() {
        return militaryPress;
    }

    public void setMilitaryPress(String militaryPress) {
        this.militaryPress = militaryPress;
    }

    public String getPushPress() {
        return pushPress;
    }

    public void setPushPress(String pushPress) {
        this.pushPress = pushPress;
    }

    public String getSquatClean() {
        return squatClean;
    }

    public void setSquatClean(String squatClean) {
        this.squatClean = squatClean;
    }

    public String getPowerClean() {
        return powerClean;
    }

    public void setPowerClean(String powerClean) {
        this.powerClean = powerClean;
    }

    public String getSplitJerk() {
        return splitJerk;
    }

    public void setSplitJerk(String splitJerk) {
        this.splitJerk = splitJerk;
    }

    public String getPushJerk() {
        return pushJerk;
    }

    public void setPushJerk(String pushJerk) {
        this.pushJerk = pushJerk;
    }

    public String getSquatJerk() {
        return squatJerk;
    }

    public void setSquatJerk(String squatJerk) {
        this.squatJerk = squatJerk;
    }

    public String getSquatSnatch() {
        return squatSnatch;
    }

    public void setSquatSnatch(String squatSnatch) {
        this.squatSnatch = squatSnatch;
    }

    public String getPowerSnatch() {
        return powerSnatch;
    }

    public void setPowerSnatch(String powerSnatch) {
        this.powerSnatch = powerSnatch;
    }

    public String getSnatchBalance() {
        return snatchBalance;
    }

    public void setSnatchBalance(String snatchBalance) {
        this.snatchBalance = snatchBalance;
    }
}
