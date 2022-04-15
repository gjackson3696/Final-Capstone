<template>
  <div class="container">
    <h3>Enter data for a personal workout:</h3>
    <button
      class="btn btn-light"
      v-on:click="showPersonalWorkouts = !showPersonalWorkouts"
    >
      Add Personal Workout
    </button>
    <form
      id="frmAddNewWorkout"
      v-on:submit.prevent="saveWorkout"
      v-if="showPersonalWorkouts === true"
    >
      <div class="field">
        <input
          size="50"
          type="text"
          name="workoutName"
          placeholder="Name your workout"
          v-model="personalWorkout.workoutName"
        />
      </div>
      <div class="field" id="workoutDomain">
        <input
          size="50"
          type="text"
          name="workoutDomain"
          placeholder="Domain, i.e. ARMAP, Time, EMOM, etc."
          v-model="personalWorkout.workoutDomain"
        />
      </div>
      <div class="field">
        <input
          size="50"
          type="text"
          name="workoutStructure"
          placeholder="Movements/reps, i.e. 30 burpees, 20 pull ups"
          v-model="personalWorkout.workoutStructure"
        />
      </div>
      <div class="field">
        <input
          size="50"
          type="text"
          name="workoutWeights"
          placeholder="Goal for weights used for this workout"
          v-model="personalWorkout.workoutWeights"
        />
      </div>
      <div class="field">
        <input
          size="50"
          type="text"
          name="workoutTime"
          placeholder="Time goal for this workout"
          v-model="personalWorkout.workoutTime"
        />
      </div>
      <div class="field">
        <input
          size="50"
          type="text"
          name="emailAddress"
          placeholder="Number of rounds/reps desired"
          v-model="personalWorkout.workoutRounds"
        />
      </div>
      <label for="checkboxRx">As prescribed?</label>
      <input
        id="checkboxRx"
        type="checkbox"
        name="checkboxRx"
        v-model="personalWorkout.completedAsPrescribed"
      />
      <br />
      <button id="saveNewWorkoutButton" type="submit" class="btn btn-primary">
        Save Workout
      </button>
    </form>

    <h3>Enter goals for a standardized CrossFit Workout</h3>
    <button
      class="btn btn-light"
      v-on:click="showBenchmarkWorkouts = !showBenchmarkWorkouts"
    >
      Enter Score
    </button>

    <form
      id="frmSaveBenchmarkWorkout"
      v-on:submit.prevent="saveBenchmarkWorkout"
      v-if="showBenchmarkWorkouts === true"
    >
      <div
        class="benchmark-workouts"
        v-for="workout in crossfitWorkouts"
        v-bind:key="workout.workoutName"
      >
        <h4>{{ workout.workoutName }}</h4>
        <p>{{ workout.workoutDomain }}</p>
        <p>{{ workout.workoutStructure }}</p>
        <p>{{ workout.workoutWeights }}</p>
        <p>{{ workout.workoutRounds }}</p>
        <input
          type="text"
          v-bind="workout.workoutTime"
          placeholder="Desired completion time"
        />
        <br />
        <input
          type="text"
          v-bind="workout.workoutRounds"
          placeholder="# rounds/# reps"
        />
      </div>
      <button type="submit" class="btn btn-primary">Save Workout</button>
    </form>

    <h3>Enter goals for individual movements (squats, olympic lifts, etc.)</h3>
    <button
      class="btn btn-light"
      v-on:click="showBenchmarkMovements = !showBenchmarkMovements"
    >
      Enter Goals for Individual Movements
    </button>
    <h4 v-if="showBenchmarkMovements === true">
      Enter one rep max for each movement
    </h4>
    <form
      id="frmSaveBenchmarkMovements"
      v-on:submit.prevent="saveBenchmarkMovements"
      v-if="showBenchmarkMovements === true"
    >
      <div>
        <div id="squats">
          <h5>Squat Goals</h5>
          <input
            type="text"
            name="backSquat"
            v-model="benchmarkMovements.backSquat"
            placeholder="Back Squat"
          />
        </div>
        <input
          type="text"
          name="frontSquat"
          v-model="benchmarkMovements.frontSquat"
          placeholder="Front Squat"
        />
        <div>
          <input
            type="text"
            name="zercherSquat"
            v-model="benchmarkMovements.zercherSquat"
            placeholder="Zercher Squat"
          />
        </div>
        <div>
          <input
            type="text"
            name="overheadSquat"
            v-model="benchmarkMovements.overheadSquat"
            placeholder="Overhead Squat"
          />
        </div>
        <div>
          <input
            type="text"
            name="bulgarianSplitSquat"
            v-model="benchmarkMovements.bulgarianSplitSquat"
            placeholder="Bulgarian Split Squat"
          />
        </div>
      </div>
      <div id="deadlifts">
        <h4>Deadlift Goals</h4>
        <div>
          <input
            type="text"
            name="conventionalDeadlift"
            v-model="benchmarkMovements.conventionalDeadlift"
            placeholder="Conventional Deadlift"
          />
        </div>
        <div>
          <input
            type="text"
            name="sumoDeadlift"
            v-model="benchmarkMovements.sumoDeadlift"
            placeholder="Sumo Deadlift"
          />
        </div>
      </div>
      
      <div id="presses">
        <h5>Pressing Goals</h5>
        <div>
          <input
            type="text"
            name="overheadPress"
            v-model="benchmarkMovements.overheadPress"
            placeholder="Overhead Press"
          />
        </div>
        <div>
          <input
            type="text"
            name="pushPress"
            v-model="benchmarkMovements.militaryPress"
            placeholder="Military Press"
          />
        </div>
        <div>
          <input
            type="text"
            name="pushPress"
            v-model="benchmarkMovements.pushPress"
            placeholder="Push Press"
          />
        </div>
      </div>
      <div id="olympic">
              <h5>Olympic Lifting Goals</h5>
        <div>
          <input
            type="text"
            name="squatClean"
            v-model="benchmarkMovements.squatClean"
            placeholder="Squat Clean"
          />
        </div>
        <div>
          <input
            type="text"
            name="powerClean"
            v-model="benchmarkMovements.powerClean"
            placeholder="Power Clean"
          />
        </div>
        <div>
          <input
            type="text"
            name="cleanJerk"
            v-model="benchmarkMovements.cleanJerk"
            placeholder="Clean & Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="splitJerk"
            v-model="benchmarkMovements.splitJerk"
            placeholder="Split Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="pushJerk"
            v-model="benchmarkMovements.pushJerk"
            placeholder="Push Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="squatJerk"
            v-model="benchmarkMovements.squatJerk"
            placeholder="Squat Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="squatSnatch"
            v-model="benchmarkMovements.squatSnatch"
            placeholder="Squat Snatch"
          />
        </div>
        <div>
          <input
            type="text"
            name="powerSnatch"
            v-model="benchmarkMovements.powerSnatch"
            placeholder="Power Snatch"
          />
        </div>
        <div>
          <input
            type="text"
            name="snatchBalance"
            v-model="benchmarkMovements.snatchBalance"
            placeholder="Snatch Balance"
          />
        </div>
      </div>
            <button type="submit" class="btn btn-primary">Save Movements</button>
    </form>
  </div>
</template>

<script>
import apiService from "@/services/WorkoutGoalsService.js";
export default {
  name: "workout-goals",
  data() {
    return {
      showPersonalWorkouts: false,
      showBenchmarkWorkouts: false,
      showBenchmarkMovements: false,
      personalWorkout: {
        workoutName: "",
        workoutDomain: "",
        workoutStructure: "",
        workoutWeights: "",
        workoutTime: "",
        workoutRounds: "",
        completedAsPrescribed: false,
      },
      crossfitWorkouts: [
        {
          workoutName: "Amanda",
          workoutDomain: "9-7-5 reps for time of:",
          workoutStructure: "Ring Muscle-ups, Squat snatches",
          workoutWeights: "♀24-kg (53 lb) KB ♂32-kg (70 lb) KB",
          workoutTime: "",
          workoutRounds: "",
          completedAsPrescribed: false,
        },
        {
          workoutName: "Eva",
          workoutDomain: "5 rounds for time of:",
          workoutStructure: "Run 800 meters, 30 kettlebell swings, 30 pull ups",
          workoutWeights: "♀95 lb ♂135 lb",
          workoutTime: "",
          workoutRounds: "",
          completedAsPrescribed: false,
        },
      ],
      benchmarkMovements: {
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
      },
    };
  },
  methods: {
    //update these methods with the appropriate service methods and api service name
    //these are just placeholders

    saveWorkout() {
      apiService.saveWorkout.then((response) => {
        this.personalWorkout = response.data;
      });
      this.resetForm();
    },

    saveBenchmarkWorkout() {
      apiService.saveWorkout.then((response) => {
        this.crossfitWorkouts = response.data;
      });
    },

    saveBenchmarkMovements() {
      apiService.saveWorkout.then((response) => {
        this.benchmarkMovements = response.data;
      });
    },

    //method to save movements
    //submit data with axios.post using path required
    //second argument passed into method is object without subcategories of object

    resetForm() {
      this.personalWorkout = {
        workoutName: "",
        workoutDomain: "",
        workoutStructure: "",
        workoutWeights: "",
        workoutTime: "",
        workoutRounds: "",
        completedAsPrescribed: false,
      };
    },
  },
};
</script>

<style scoped>
.container {
  background-image: linear-gradient(
      180deg,
      rgba(0, 0, 0, 0.5),
      rgba(0, 0, 0, 0.5)
    ),
    url(../assets/goals_page.jpg);
  background-position: 0px 0px, 50% 50%;
  background-size: auto, cover;
  background-attachment: scroll, fixed;
  color: #fff;
  justify-content: center;
  -webkit-box-align: center;
  flex-direction: column;
  -webkit-box-pack: center;
  display: flex;
  height: 100vh;
  text-align: center;
  margin-bottom: 100px;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
}

#frmAddNewWorkout > .field {
  display: flex;
  justify-content: center;
  margin: 10px 0 0 0;
}

#checkboxRx {
  margin: 0 0 0 8px;
}

#frmSaveBenchmarkMovements {
  display: flex;
  flex-direction: row;
  align-content: space-between;
  gap: 10px;
}

#frmSaveBenchmarkMovements > .btn {
  position: absolute;
  bottom: 0;
  justify-content: center;
  }

</style>