package com.techelevator.model;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class MemberProfile {
    private Long profileId;
    private Long userId;
    @NotNull
    private String backSquat, frontSquat, zercherSquat, overheadSquat, bulgarianSplitSquat;
    @NotNull
    private String conventionalDeadlift, sumoDeadlift;
    @NotNull
    private String overheadPress, militaryPress, pushPress;
    @NotNull
    private String squatClean, powerClean, splitJerk, pushJerk, squatJerk, squatSnatch, powerSnatch, snatchBalance;
    private Map<String,String> profile;

    public MemberProfile() {
        this.profile = new HashMap<>();
    }

    public MemberProfile(Long userId, String backSquat, String frontSquat, String zercherSquat, String overheadSquat, String bulgarianSplitSquat, String conventionalDeadlift, String sumoDeadlift, String overheadPress, String militaryPress, String pushPress, String squatClean, String powerClean, String splitJerk, String pushJerk, String squatJerk, String squatSnatch, String powerSnatch, String snatchBalance) {
        this.userId = userId;
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
        this.profile = new HashMap<>();
    }

    public MemberProfile(Long profileId, Long userId, String backSquat, String frontSquat, String zercherSquat, String overheadSquat, String bulgarianSplitSquat, String conventionalDeadlift, String sumoDeadlift, String overheadPress, String militaryPress, String pushPress, String squatClean, String powerClean, String splitJerk, String pushJerk, String squatJerk, String squatSnatch, String powerSnatch, String snatchBalance) {
        this.profileId = profileId;
        this.userId = userId;
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
        this.profile = new HashMap<>();
    }

    public MemberProfile(Long userId) {
        this.userId = userId;
        this.profile = new HashMap<>();
        this.profile.put("backSquat",backSquat);
        this.profile.put("frontSquat",frontSquat);
        this.profile.put("zercherSquat",zercherSquat);
        this.profile.put("overheadSquat",overheadSquat);
        this.profile.put("bulgarianSplitSquat",bulgarianSplitSquat);
        this.profile.put("conventionalDeadlift",conventionalDeadlift);
        this.profile.put("sumoDeadlift",sumoDeadlift);
        this.profile.put("overheadPress",overheadPress);
        this.profile.put("militaryPress",militaryPress);
        this.profile.put("pushPress",pushPress);
        this.profile.put("squatClean",squatClean);
        this.profile.put("powerClean",powerClean);
        this.profile.put("splitJerk",splitJerk);
        this.profile.put("pushJerk",pushJerk);
        this.profile.put("squatJerk",squatJerk);
        this.profile.put("squatSnatch",squatSnatch);
        this.profile.put("powerSnatch",powerSnatch);
        this.profile.put("snatchBalance",snatchBalance);
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBackSquat() {
        return backSquat;
    }

    public void setBackSquat(String backSquat) {
        this.backSquat = backSquat;
        this.profile.put("backSquat",backSquat);
    }

    public String getFrontSquat() {
        return frontSquat;
    }

    public void setFrontSquat(String frontSquat) {
        this.frontSquat = frontSquat;
        this.profile.put("frontSquat",frontSquat);
    }

    public String getZercherSquat() {
        return zercherSquat;
    }

    public void setZercherSquat(String zercherSquat) {
        this.zercherSquat = zercherSquat;
        this.profile.put("zercherSquat",zercherSquat);
    }

    public String getOverheadSquat() {
        return overheadSquat;
    }

    public void setOverheadSquat(String overheadSquat) {
        this.overheadSquat = overheadSquat;
        this.profile.put("overheadSquat",overheadSquat);
    }

    public String getBulgarianSplitSquat() {
        return bulgarianSplitSquat;
    }

    public void setBulgarianSplitSquat(String bulgarianSplitSquat) {
        this.bulgarianSplitSquat = bulgarianSplitSquat;
        this.profile.put("bulgarianSplitSquat",bulgarianSplitSquat);
    }

    public String getConventionalDeadlift() {
        return conventionalDeadlift;
    }

    public void setConventionalDeadlift(String conventionalDeadlift) {
        this.conventionalDeadlift = conventionalDeadlift;
        this.profile.put("conventionalDeadlift",conventionalDeadlift);
    }

    public String getSumoDeadlift() {
        return sumoDeadlift;
    }

    public void setSumoDeadlift(String sumoDeadlift) {
        this.sumoDeadlift = sumoDeadlift;
        this.profile.put("sumoDeadlift",sumoDeadlift);
    }

    public String getOverheadPress() {
        return overheadPress;
    }

    public void setOverheadPress(String overheadPress) {
        this.overheadPress = overheadPress;
        this.profile.put("overheadPress",overheadPress);
    }

    public String getMilitaryPress() {
        return militaryPress;
    }

    public void setMilitaryPress(String militaryPress) {
        this.militaryPress = militaryPress;
        this.profile.put("militaryPress",militaryPress);
    }

    public String getPushPress() {
        return pushPress;
    }

    public void setPushPress(String pushPress) {
        this.pushPress = pushPress;
        this.profile.put("pushPress",pushPress);
    }

    public String getSquatClean() {
        return squatClean;
    }

    public void setSquatClean(String squatClean) {
        this.squatClean = squatClean;
        this.profile.put("squatClean",squatClean);
    }

    public String getPowerClean() {
        return powerClean;
    }

    public void setPowerClean(String powerClean) {
        this.powerClean = powerClean;
        this.profile.put("powerClean",powerClean);
    }

    public String getSplitJerk() {
        return splitJerk;
    }

    public void setSplitJerk(String splitJerk) {
        this.splitJerk = splitJerk;
        this.profile.put("splitJerk",splitJerk);
    }

    public String getPushJerk() {
        return pushJerk;
    }

    public void setPushJerk(String pushJerk) {
        this.pushJerk = pushJerk;
        this.profile.put("pushJerk",pushJerk);
    }

    public String getSquatJerk() {
        return squatJerk;
    }

    public void setSquatJerk(String squatJerk) {
        this.squatJerk = squatJerk;
        this.profile.put("squatJerk",squatJerk);
    }

    public String getSquatSnatch() {
        return squatSnatch;
    }

    public void setSquatSnatch(String squatSnatch) {
        this.squatSnatch = squatSnatch;
        this.profile.put("squatSnatch",squatSnatch);
    }

    public String getPowerSnatch() {
        return powerSnatch;
    }

    public void setPowerSnatch(String powerSnatch) {
        this.powerSnatch = powerSnatch;
        this.profile.put("powerSnatch",powerSnatch);
    }

    public String getSnatchBalance() {
        return snatchBalance;
    }

    public void setSnatchBalance(String snatchBalance) {
        this.snatchBalance = snatchBalance;
        this.profile.put("snatchBalance",snatchBalance);
    }

    public Map<String,String> getMap() {
        return this.profile;
    }

}
