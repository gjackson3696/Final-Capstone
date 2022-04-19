<template>
  <div>
    <h3>Log Workout</h3>
    <form class="logWorkoutForm" v-on:submit.prevent="logWorkout">
      <div class="field">
        <label for="name">Name:</label>
        <input type="text" name="name" placeholder="Name of workout" v-model="workout.name" />
      </div>
      <div class="field">
        <label for="domain">Domain:</label>
        <input type="text" name="domain" placeholder="i.e. ARMAP, Time, EMOM, etc." v-model="workout.domain" />
      </div>
      <div class="field">
        <label for="structure">Structure:</label>
        <input type="text" name="structure" placeholder="Movements/reps, i.e. 30 burpees, 20 pull ups" v-model="workout.structure" />
      </div>
      <div class="field">
        <label for="weights">Weights:</label>
        <input type="text" name="weights" placeholder="Weights used for workout" v-model="workout.weights" />
      </div>
      <div class="field">
        <label for="workoutTime">Time:</label>
        <input type="text" name="workoutTime" placeholder="Length of workout" v-model="workout.workoutTime" />
      </div>
      <div class="field">
        <label for="rounds">Rounds/Reps:</label>
        <input type="text" name="rounds" placeholder="Number of rounds/reps completed" v-model="workout.rounds" />
      </div>
      <div class="field">
        <label for="completed">Completed</label>
        <input type="checkbox" name="completed" v-model="workout.completed" />
      </div>
      <h4>Enter one rep max for each movement</h4>
      <div class="field">
        <h5>Squats</h5>
        <label for="backSquat">Back Squat Max:</label>
        <input type="text" name="backSquat" placeholder="Back Squat" v-model="workout.backSquat" />
      </div>
      <div class="field">
        <label for="frontSquat">Front Squat Max:</label>
        <input type="text" name="frontSquat" placeholder="Front Squat" v-model="workout.frontSquat" />
      </div>
      <div class="field">
        <label for="zercherSquat">Zercher Squat Max:</label>
        <input type="text" name="zercherSquat" placeholder="Zercher Squat" v-model="workout.zercherSquat" />
      </div>
      <div class="field">
        <label for="overheadSquat">Overhead Squat Max:</label>
        <input type="text" name="overheadSquat" placeholder="Overhead Squat" v-model="workout.overheadSquat" />
      </div>
      <div class="field">
        <label for="bulgarianSplitSquat">Bulgarian Split Squat Max:</label>
        <input type="text" name="bulgarianSplitSquat" placeholder="Bulgarian Split Squat" v-model="workout.bulgarianSplitSquat" />
      </div>
      <div class="field">
        <h5>Deadlifts</h5>
        <label for="conventionalDeadlift">Conventional Deadlift Max:</label>
        <input type="text" name="conventionalDeadlift" placeholder="Conventional Deadlift" v-model="workout.conventionalDeadlift" />
      </div>
      <div class="field">
        <label for="sumoDeadlift">Sumo Deadlift Max:</label>
        <input type="text" name="sumoDeadlift" placeholder="Sumo Deadlift" v-model="workout.sumoDeadlift" />
      </div>
      <div class="field">
        <h5>Presses</h5>
        <label for="overheadPress">Overhead Press Max:</label>
        <input type="text" name="overheadPress" placeholder="Overhead Press" v-model="workout.overheadPress" />
      </div>
      <div class="field">
        <label for="militaryPress">Military Press Max:</label>
        <input type="text" name="militaryPress" placeholder="Military Press" v-model="workout.militaryPress" />
      </div>
      <div class="field">
        <label for="pushPress">Push Press Max:</label>
        <input type="text" name="pushPress" placeholder="Push Press" v-model="workout.pushPress" />
      </div>
      <div class="field">
        <h5>Olympic Lifts</h5>
        <label for="squatClean">Squat Clean Max:</label>
        <input type="text" name="squatClean" placeholder="Squat Clean" v-model="workout.squatClean" />
      </div>
      <div class="field">
        <label for="powerClean">Power Clean Max:</label>
        <input type="text" name="powerClean" placeholder="Power Clean" v-model="workout.powerClean" />
      </div>
      <div class="field">
        <label for="cleanJerk">Clean & Jerk Max:</label>
        <input type="text" name="cleanJerk" placeholder="Clean Jerk" v-model="workout.cleanJerk" />
      </div>
      <div class="field">
        <label for="splitJerk">Split Jerk Max:</label>
        <input type="text" name="splitJerk" placeholder="Split Jerk" v-model="workout.splitJerk" />
      </div>
      <div class="field">
        <label for="pushJerk">Push Jerk Max:</label>
        <input type="text" name="pushJerk" placeholder="Push Jerk" v-model="workout.pushJerk" />
      </div>
      <div class="field">
        <label for="squatJerk">Squat Jerk Max:</label>
        <input type="text" name="squatJerk" placeholder="Squat Jerk" v-model="workout.squatJerk" />
      </div>
      <div class="field">
        <label for="squatSnatch">Squat Snatch Max:</label>
        <input type="text" name="squatSnatch" placeholder="Squat Snatch" v-model="workout.squatSnatch" />
      </div>
      <div class="field">
        <label for="powerSnatch">Power Snatch Max:</label>
        <input type="text" name="powerSnatch" placeholder="Power Snatch" v-model="workout.powerSnatch" />
      </div>
      <div class="field">
        <label for="snatchBalance">Snatch Balance Max:</label>
        <input type="text" name="snatchBalance" placeholder="Snatch Balance" v-model="workout.snatchBalance" />
      </div>
      <div class="btn">
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
        name: "",
        domain: "",
        structure: "",
        weights: "",
        workoutTime: "",
        rounds: "",
        backSquat: "",
        frontSquat: "",
        zercherSquat: "",
        overheadSquat: "",
        bulgarianSplitSquat: "",
        conventionalDeadlift: "",
        sumoDeadlift: "",
        overheadPress: "",
        militaryPress: "",
        pushPress: "",
        squatClean: "",
        powerClean: "",
        cleanJerk: "",
        splitJerk: "",
        pushJerk: "",
        squatJerk: "",
        squatSnatch: "",
        powerSnatch: "",
        snatchBalance: "",
        completed: true
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
        name: "",
        domain: "",
        structure: "",
        weights: "",
        workoutTime: "",
        rounds: "",
        completed: true,
        backSquat: "",
        frontSquat: "",
        zercherSquat: "",
        overheadSquat: "",
        bulgarianSplitSquat: "",
        conventionalDeadlift: "",
        sumoDeadlift: "",
        overheadPress: "",
        militaryPress: "",
        pushPress: "",
        squatClean: "",
        powerClean: "",
        cleanJerk: "",
        splitJerk: "",
        pushJerk: "",
        squatJerk: "",
        squatSnatch: "",
        powerSnatch: "",
        snatchBalance: ""
      }
    }
  }
}
</script>

<style scoped>
.logWorkoutForm {
  position: relative;
}
</style>