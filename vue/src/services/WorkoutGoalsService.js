import axios from 'axios';

export default {

  getWorkouts(memberId) {
    return axios.get('/workouts/'+memberId)
  },

  getLoggedWorkouts(memberId) {
    return axios.get('/workouts/logged/'+memberId);
  },

  saveWorkout(memberId, workout) {
    return axios.post('/workouts', {
      "memberId": memberId,
      "name": workout.workoutName,
      "domain": workout.workoutDomain,
      "structure": workout.workoutStructure,
      "workoutWeights": workout.workoutWeights,
      "time": workout.workoutTime,
      "rounds": workout.workoutRounds,
      "completed": workout.completedAsPrescribed
    })
  },

  logWorkout(memberId, workout) {
    return axios.post('/workouts/log', {
      "memberId": memberId,
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