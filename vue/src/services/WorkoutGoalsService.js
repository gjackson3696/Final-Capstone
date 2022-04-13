import axios from 'axios';

export default {

  saveWorkout(workout) {
    return axios.post('/workoutGoals', workout)
  }

}