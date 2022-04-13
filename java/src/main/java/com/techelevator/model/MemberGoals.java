package com.techelevator.model;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class MemberGoals {
    private Long goalsId;
    @NotNull
    private Long memberId;
    private String backSquat="", frontSquat="", zercherSquat="", overheadSquat="", bulgarianSplitSquat="";
    private String conventionalDeadlift="", sumoDeadlift="";
    private String overheadPress="", militaryPress="", pushPress="";
    private String squatClean="", powerClean="", splitJerk="", pushJerk="", squatJerk="", squatSnatch="", powerSnatch="", snatchBalance="";
    private Map<String,String> goals;

    public MemberGoals() {
        this.goals = new HashMap<>();
    }

    public MemberGoals(Long memberId, String backSquat, String frontSquat, String zercherSquat, String overheadSquat, String bulgarianSplitSquat, String conventionalDeadlift, String sumoDeadlift, String overheadPress, String militaryPress, String pushPress, String squatClean, String powerClean, String splitJerk, String pushJerk, String squatJerk, String squatSnatch, String powerSnatch, String snatchBalance) {
        this.memberId = memberId;
        this.backSquat = backSquat;
        this.frontSquat = frontSquat;
        this.zercherSquat = zercherSquat;
        this.overheadSquat = overheadSquat;
        this.bulgarianSplitSquat = bulgarianSplitSquat;
        this.conventionalDeadlift = conventionalDeadlift;
        this.sumoDeadlift = sumoDeadlift;
        this.overheadPress = overheadPress;
        this.militaryPress = militaryPress;
        this.pushPress = pushPress;
        this.squatClean = squatClean;
        this.powerClean = powerClean;
        this.splitJerk = splitJerk;
        this.pushJerk = pushJerk;
        this.squatJerk = squatJerk;
        this.squatSnatch = squatSnatch;
        this.powerSnatch = powerSnatch;
        this.snatchBalance = snatchBalance;
        this.goals = new HashMap<>();
    }

    public MemberGoals(Long goalsId, Long memberId, String backSquat, String frontSquat, String zercherSquat, String overheadSquat, String bulgarianSplitSquat, String conventionalDeadlift, String sumoDeadlift, String overheadPress, String militaryPress, String pushPress, String squatClean, String powerClean, String splitJerk, String pushJerk, String squatJerk, String squatSnatch, String powerSnatch, String snatchBalance) {
        this.goalsId = goalsId;
        this.memberId = memberId;
        this.backSquat = backSquat;
        this.frontSquat = frontSquat;
        this.zercherSquat = zercherSquat;
        this.overheadSquat = overheadSquat;
        this.bulgarianSplitSquat = bulgarianSplitSquat;
        this.conventionalDeadlift = conventionalDeadlift;
        this.sumoDeadlift = sumoDeadlift;
        this.overheadPress = overheadPress;
        this.militaryPress = militaryPress;
        this.pushPress = pushPress;
        this.squatClean = squatClean;
        this.powerClean = powerClean;
        this.splitJerk = splitJerk;
        this.pushJerk = pushJerk;
        this.squatJerk = squatJerk;
        this.squatSnatch = squatSnatch;
        this.powerSnatch = powerSnatch;
        this.snatchBalance = snatchBalance;
        this.goals = new HashMap<>();
    }

    public MemberGoals(Long memberId) {
        this.memberId = memberId;
        this.goals = new HashMap<>();
        this.goals.put("backSquat",backSquat);
        this.goals.put("frontSquat",frontSquat);
        this.goals.put("zercherSquat",zercherSquat);
        this.goals.put("overheadSquat",overheadSquat);
        this.goals.put("bulgarianSplitSquat",bulgarianSplitSquat);
        this.goals.put("conventionalDeadlift",conventionalDeadlift);
        this.goals.put("sumoDeadlift",sumoDeadlift);
        this.goals.put("overheadPress",overheadPress);
        this.goals.put("militaryPress",militaryPress);
        this.goals.put("pushPress",pushPress);
        this.goals.put("squatClean",squatClean);
        this.goals.put("powerClean",powerClean);
        this.goals.put("splitJerk",splitJerk);
        this.goals.put("pushJerk",pushJerk);
        this.goals.put("squatJerk",squatJerk);
        this.goals.put("squatSnatch",squatSnatch);
        this.goals.put("powerSnatch",powerSnatch);
        this.goals.put("snatchBalance",snatchBalance);
    }

    public Long getGoalsId() {
        return goalsId;
    }

    public void setGoalsId(Long gaolsId) {
        this.goalsId = gaolsId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getBackSquat() {
        return backSquat;
    }

    public void setBackSquat(String backSquat) {
        this.backSquat = backSquat;
        this.goals.put("backSquat",backSquat);
    }

    public String getFrontSquat() {
        return frontSquat;
    }

    public void setFrontSquat(String frontSquat) {
        this.frontSquat = frontSquat;
        this.goals.put("frontSquat",frontSquat);
    }

    public String getZercherSquat() {
        return zercherSquat;
    }

    public void setZercherSquat(String zercherSquat) {
        this.zercherSquat = zercherSquat;
        this.goals.put("zercherSquat",zercherSquat);
    }

    public String getOverheadSquat() {
        return overheadSquat;
    }

    public void setOverheadSquat(String overheadSquat) {
        this.overheadSquat = overheadSquat;
        this.goals.put("overheadSquat",overheadSquat);
    }

    public String getBulgarianSplitSquat() {
        return bulgarianSplitSquat;
    }

    public void setBulgarianSplitSquat(String bulgarianSplitSquat) {
        this.bulgarianSplitSquat = bulgarianSplitSquat;
        this.goals.put("bulgarianSplitSquat",bulgarianSplitSquat);
    }

    public String getConventionalDeadlift() {
        return conventionalDeadlift;
    }

    public void setConventionalDeadlift(String conventionalDeadlift) {
        this.conventionalDeadlift = conventionalDeadlift;
        this.goals.put("conventionalDeadlift",conventionalDeadlift);
    }

    public String getSumoDeadlift() {
        return sumoDeadlift;
    }

    public void setSumoDeadlift(String sumoDeadlift) {
        this.sumoDeadlift = sumoDeadlift;
        this.goals.put("sumoDeadlift",sumoDeadlift);
    }

    public String getOverheadPress() {
        return overheadPress;
    }

    public void setOverheadPress(String overheadPress) {
        this.overheadPress = overheadPress;
        this.goals.put("overheadPress",overheadPress);
    }

    public String getMilitaryPress() {
        return militaryPress;
    }

    public void setMilitaryPress(String militaryPress) {
        this.militaryPress = militaryPress;
        this.goals.put("militaryPress",militaryPress);
    }

    public String getPushPress() {
        return pushPress;
    }

    public void setPushPress(String pushPress) {
        this.pushPress = pushPress;
        this.goals.put("pushPress",pushPress);
    }

    public String getSquatClean() {
        return squatClean;
    }

    public void setSquatClean(String squatClean) {
        this.squatClean = squatClean;
        this.goals.put("squatClean",squatClean);
    }

    public String getPowerClean() {
        return powerClean;
    }

    public void setPowerClean(String powerClean) {
        this.powerClean = powerClean;
        this.goals.put("powerClean",powerClean);
    }

    public String getSplitJerk() {
        return splitJerk;
    }

    public void setSplitJerk(String splitJerk) {
        this.splitJerk = splitJerk;
        this.goals.put("splitJerk",splitJerk);
    }

    public String getPushJerk() {
        return pushJerk;
    }

    public void setPushJerk(String pushJerk) {
        this.pushJerk = pushJerk;
        this.goals.put("pushJerk",pushJerk);
    }

    public String getSquatJerk() {
        return squatJerk;
    }

    public void setSquatJerk(String squatJerk) {
        this.squatJerk = squatJerk;
        this.goals.put("squatJerk",squatJerk);
    }

    public String getSquatSnatch() {
        return squatSnatch;
    }

    public void setSquatSnatch(String squatSnatch) {
        this.squatSnatch = squatSnatch;
        this.goals.put("squatSnatch",squatSnatch);
    }

    public String getPowerSnatch() {
        return powerSnatch;
    }

    public void setPowerSnatch(String powerSnatch) {
        this.powerSnatch = powerSnatch;
        this.goals.put("powerSnatch",powerSnatch);
    }

    public String getSnatchBalance() {
        return snatchBalance;
    }

    public void setSnatchBalance(String snatchBalance) {
        this.snatchBalance = snatchBalance;
        this.goals.put("snatchBalance",snatchBalance);
    }

    public Map<String,String> getMap() {
        return this.goals;
    }

}
