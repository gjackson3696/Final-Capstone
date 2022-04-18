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
      "name": workout.workoutName,
      "domain": workout.workoutDomain,
      "structure": workout.workoutStructure,
      "workoutWeights": workout.workoutWeights,
      "time": workout.workoutTime,
      "rounds": workout.workoutRounds,
      "completed": workout.completedAsPrescribed
    })
  }

}