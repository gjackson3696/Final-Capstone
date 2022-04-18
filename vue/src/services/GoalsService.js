import axios from "axios";

export default {

    getGoals() {
        return axios.get('/goals');
    },

    create(goals) {
        axios.post('/goals',{
            "backSquat": goals.backSquat,
            "frontSquat": goals.frontSquat,
            "zercherSquat": goals.zercherSquat,
            "overheadSquat": goals.overheadSquat,
            "bulgarianSplitSquat": goals.bulgarianSplitSquat,
            "conventionalDeadlift": goals.conventionalDeadlift,
            "sumoDeadlift": goals.sumoDeadlift,
            "overheadPress": goals.overheadPress,
            "militaryPress": goals.militaryPress,
            "pushPress": goals.pushPress,
            "squatClean": goals.squatClean,
            "powerClean": goals.powerClean,
            "splitJerk": goals.splitJerk,
            "pushJerk": goals.pushJerk,
            "squatJerk": goals.squatJerk,
            "squatSnatch": goals.squatSnatch,
            "powerSnatch": goals.powerSnatch,
            "snatchBalance": goals.snatchBalance
        });
    },

    update(goals) {
        axios.put('/goals',{
            "backSquat": goals.backSquat,
            "frontSquat": goals.frontSquat,
            "zercherSquat": goals.zercherSquat,
            "overheadSquat": goals.overheadSquat,
            "bulgarianSplitSquat": goals.bulgarianSplitSquat,
            "conventionalDeadlift": goals.conventionalDeadlift,
            "sumoDeadlift": goals.sumoDeadlift,
            "overheadPress": goals.overheadPress,
            "militaryPress": goals.militaryPress,
            "pushPress": goals.pushPress,
            "squatClean": goals.squatClean,
            "powerClean": goals.powerClean,
            "splitJerk": goals.splitJerk,
            "pushJerk": goals.pushJerk,
            "squatJerk": goals.squatJerk,
            "squatSnatch": goals.squatSnatch,
            "powerSnatch": goals.powerSnatch,
            "snatchBalance": goals.snatchBalance
        });
    }

}