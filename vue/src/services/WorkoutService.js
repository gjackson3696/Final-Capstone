import axios from 'axios';

export default {

  getWorkouts() {
    return axios.get('/workouts')
  },
  
  getLoggedWorkouts() {
    return axios.get('/workouts/logged');
  },

  saveWorkout(workout) {
    return axios.post('/workouts', {
      "name": workout.workoutName,
      "domain": workout.workoutDomain,
      "structure": workout.workoutStructure,
      "workoutWeights": workout.workoutWeights,
      "time": workout.workoutTime,
      "rounds": workout.workoutRounds,
      "completed": workout.completedAsPrescribed
    })
  },

  logWorkout(workout) {
    return axios.post('/workouts/log', {
      "name": workout.name,
      "domain": workout.domain,
      "structure": workout.structure,
      "workoutWeights": workout.weights,
      "time": workout.time,
      "rounds": workout.rounds,
      "completed": workout.completed,
      "backSquat": workout.backSquat,
      "frontSquat": workout.frontSquat,
      "zercherSquat": workout.zercherSquat,
      "overheadSquat": workout.overheadSquat,
      "bulgarianSplitSquat": workout.bulgarianSplitSquat,
      "conventionalDeadlift": workout.conventionalDeadlift,
      "sumoDeadlift": workout.sumoDeadlift,
      "overheadPress": workout.overheadPress,
      "militaryPress": workout.militaryPress,
      "pushPress": workout.pushPress,
      "squatClean": workout.squatClean,
      "powerClean": workout.powerClean,
      "cleanJerk": workout.cleanJerk,
      "splitJerk": workout.splitJerk,
      "pushJerk": workout.pushJerk,
      "squatJerk": workout.squatJerk,
      "squatSnatch": workout.squatSnatch,
      "powerSnatch": workout.powerSnatch,
      "snatchBalance": workout.snatchBalance
    })
  }

}