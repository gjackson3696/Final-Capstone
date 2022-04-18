import axios from "axios";

export default {

    getProfile() {
        return axios.get('/profile');
    },

    create(profile) {
        axios.post('/profile',{
            "backSquat": profile.backSquat,
            "frontSquat": profile.frontSquat,
            "zercherSquat": profile.zercherSquat,
            "overheadSquat": profile.overheadSquat,
            "bulgarianSplitSquat": profile.bulgarianSplitSquat,
            "conventionalDeadlift": profile.conventionalDeadlift,
            "sumoDeadlift": profile.sumoDeadlift,
            "overheadPress": profile.overheadPress,
            "militaryPress": profile.militaryPress,
            "pushPress": profile.pushPress,
            "squatClean": profile.squatClean,
            "powerClean": profile.powerClean,
            "splitJerk": profile.splitJerk,
            "pushJerk": profile.pushJerk,
            "squatJerk": profile.squatJerk,
            "squatSnatch": profile.squatSnatch,
            "powerSnatch": profile.powerSnatch,
            "snatchBalance": profile.snatchBalance
        });
    },

    update(profile) {
        axios.put('/profile',{
            "backSquat": profile.backSquat,
            "frontSquat": profile.frontSquat,
            "zercherSquat": profile.zercherSquat,
            "overheadSquat": profile.overheadSquat,
            "bulgarianSplitSquat": profile.bulgarianSplitSquat,
            "conventionalDeadlift": profile.conventionalDeadlift,
            "sumoDeadlift": profile.sumoDeadlift,
            "overheadPress": profile.overheadPress,
            "militaryPress": profile.militaryPress,
            "pushPress": profile.pushPress,
            "squatClean": profile.squatClean,
            "powerClean": profile.powerClean,
            "splitJerk": profile.splitJerk,
            "pushJerk": profile.pushJerk,
            "squatJerk": profile.squatJerk,
            "squatSnatch": profile.squatSnatch,
            "powerSnatch": profile.powerSnatch,
            "snatchBalance": profile.snatchBalance
        });
    }

}