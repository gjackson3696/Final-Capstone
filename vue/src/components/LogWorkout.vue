<template>
  <div>
    <h3>Log Workout</h3>
    <form id="logWorkoutForm" v-on:submit.prevent="logWorkout">
      <div class="field">
        <label for="workoutName">Name:</label>
        <input type="text" name="workoutName" placeholder="Name of workout" v-model="workout.workoutName" />
      </div>
      <div class="field">
        <label for="workoutDomain">Domain:</label>
        <input type="text" name="workoutDomain" placeholder="i.e. ARMAP, Time, EMOM, etc." v-model="workout.workoutDomain" />
      </div>
      <div class="field">
        <label for="workoutStructure">Structure:</label>
        <input type="text" name="workoutStructure" placeholder="Movements/reps, i.e. 30 burpees, 20 pull ups" v-model="workout.workoutStructure" />
      </div>
      <div class="field">
        <label for="workoutWeights">Weights:</label>
        <input type="text" name="workoutWeights" placeholder="Weights used for workout" v-model="workout.workoutWeights" />
      </div>
      <div class="field">
        <label for="workoutTime">Time:</label>
        <input type="text" name="workoutTime" placeholder="Length of workout" v-model="workout.workoutTime" />
      </div>
      <div class="field">
        <label for="workoutRounds">Rounds/Reps:</label>
        <input type="text" name="workoutRounds" placeholder="Number of rounds/reps completed" v-model="workout.workoutRounds" />
      </div>
      <div class="field">
        <label for="completed">Completed</label>
        <input type="checkbox" name="completed" v-model="workout.completedAsPrescribed" />
      </div>
      <div class="button">
        <button id="logWorkoutButton" type="submit">Log Workout</button>
      </div>
    </form>
  </div>
</template>

<script>
import workoutService from '../services/WorkoutService';

export default {
  name: 'log-workout',
  data() {
    return {
      workout: {
        workoutName: "",
        workoutDomain: "",
        workoutStructure: "",
        workoutWeights: "",
        workoutTime: "",
        workoutRounds: "",
        completedAsPrescribed: true
      }
    }
  },
  methods: {
    logWorkout() {
      workoutService.logWorkout(this.workout).then(response => {
        if(response.status == 201) {
          this.clearForm();
        }
      })
    },
    clearForm() {
      this.workout = {
        workoutName: "",
        workoutDomain: "",
        workoutStructure: "",
        workoutWeights: "",
        workoutTime: "",
        workoutRounds: "",
        completedAsPrescribed: true
      }
    }
  }
}
</script>

<style scoped>
.field, h3 {
  display: flex;
  justify-content: center;
  margin: 10px 0 0 0;
}
</style>