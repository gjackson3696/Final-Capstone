<template>
  <div class="container">
    <h3>Enter data for a personal workout:</h3>
    <button v-on:click="showForm = true">Add Personal Workout</button>
    
    <form
      id="frmAddNewWorkout"
      v-on:submit.prevent="saveWorkout"
      v-if="showForm === true"
    >
      <div class="field">
        <label for="workoutName">Workout Name:</label>
        <input
          type="text"
          name="workoutName"
          placeholder="Give the workout a name"
          v-model="personalWorkout.workoutName"
        />
      </div>
      <div class="field" id="workoutDescription">
        <label for="workoutDescription">Workout Description:</label>
        <input
          type="text"
          name="workoutDescription"
          placeholder="ARMAP, For Time, movements, weights, etc."
          v-model="personalWorkout.workoutDescription"
        />
      </div>
      <div class="field">
        <label for="workoutTime">Time:</label>
        <input
          type="text"
          name="workoutTime"
          placeholder="00:00:00"
          v-model="personalWorkout.workoutTime"
        />
      </div>
      <div class="field">
        <label for="workoutRounds">Rounds and reps completed:</label>
        <input
          type="text"
          name="emailAddress"
          placeholder="Number of rounds + number of reps for non-completed rounds"
          v-model="personalWorkout.workoutRounds"
        />
      </div>
      <br />
      <label for="checkboxRx">Workout completed as prescribed</label>
      <input
        type="checkbox"
        name="checkboxRx"
        v-model="personalWorkout.completedAsPrescribed"
      />
      <button type="submit" class="btn save">Save Workout</button>
    </form>

    <h3>Enter scores for a standardized CrossFit Workout</h3>
    <button v-on:click="showStandardWorkouts = true">Enter Score</button>

    <workout class="workout" v-if="showStandardWorkouts === true">
    <div v-for="workout in crossfitWorkouts" v-bind:key="workout.workoutName">
        <h4> {{workout.workoutName}} </h4>
        <p> {{workout.workoutDescription}} </p>
        <p> {{workout.workoutRounds}} </p>
        <input type="text" v-bind="workout.workoutTime" placeholder="Time workout completed in">
        <br>
        <input type="text" v-bind="workout.workoutRounds" placeholder="# rounds/# reps">
    </div>
    </workout>
  </div>
</template>

<script>
export default {
  name: "workout-goals",
  data() {
    return {
      showForm: false,
      showStandardWorkouts: false,
      personalWorkout: {
        workoutName: "",
        workoutDescription: "",
        workoutTime: "",
        workoutRounds: "",
        completedAsPrescribed: false,
      },
      crossfitWorkouts: [
        {
          workoutName: "Amanda",
          workoutDescription:
            "5 rounds for time of:\nRing Muscle-ups\nSquat snatches\n\n♀ 24-kg KB ♂32-kg KB",
          workoutTime: "",
          workoutRounds: "",
          completedAsPrescribed: false,
        },
        {
          workoutName: "Eva",
          workoutDescription:
            "9-7-5 reps for time of:\nRun 800 meters\n30 kettlebell swings\n30 pull ups\n\n♀ 95 lb ♂ 135 lb",
          workoutTime: "",
          workoutRounds: "",
          completedAsPrescribed: false,
        },
      ],
      benchmarkMovements: [
        {
          squats: {
            backSquat: "",
            frontSquat: "",
            zercherSquat: "",
            overheadSquat: "",
            bulgarianSplitSquat: "",
          },
          deadlifts: {
            conventionalDeadlift: "",
            sumoDeadlift: "",
          },
          presses: {
            overheadPress: "",
            militaryPress: "",
            pushPress: "",
          },
          olympicBarbell: {
            squatClean: "",
            powerClean: "",
            splitJerk: "",
            pushJerk: "",
            squatJerk: "",
            squatSnatch: "",
            powerSnatch: "",
            snatchBalance: "",
          },
        },
      ],
    };
  },
  methods: {
    saveWorkout() {
      this.crossfitWorkouts.push(this.personalWorkout);
      this.resetForm();
    },

    resetForm() {
      this.personalWorkout = {
        workoutName: "",
        workoutDescription: "",
        workoutTime: "",
        workoutRounds: "",
        completedAsPrescribed: false,
      };
    },
  },
};
</script>

<style scoped>
</style>