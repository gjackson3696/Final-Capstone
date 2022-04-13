<template>
  <div class="container">
    <h3>Enter data for a personal workout:</h3>
    <button class="btn btn-light" v-on:click="showPersonalWorkouts = !showPersonalWorkouts">Add Personal Workout</button>

    <form
      id="frmAddNewWorkout"
      v-on:submit.prevent="saveWorkout"
      v-if="showPersonalWorkouts === true"
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
      <div class="field" id="workoutDomain">
        <label for="workoutDomain">Workout Domain:</label>
        <input
          type="text"
          name="workoutDomain"
          placeholder="ARMAP, For Time, EMOM, etc."
          v-model="personalWorkout.workoutDomain"
        />
      </div>
      <div class="field">
        <label for="workoutStructure">Workout Structure:</label>
        <input
          type="text"
          name="workoutStructure"
          placeholder="Workout details (reps, movements)"
          v-model="personalWorkout.workoutStructure"
        />
      </div>
      <div class="field">
        <label for="workoutWeights">Workout Weights:</label>
        <input
          type="text"
          name="workoutWeights"
          placeholder="Weights used for movements"
          v-model="personalWorkout.workoutWeights"
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
      <button type="submit" class="btn btn-primary">Save Workout</button>
    </form>

    <h3>Enter goals for a standardized CrossFit Workout</h3>
    <button class="btn btn-light" v-on:click="showBenchmarkWorkouts = !showBenchmarkWorkouts">Enter Score</button>

    <form
      id="frmSaveBenchmarkWorkout"
      v-on:submit.prevent="saveBenchmarkWorkout"
      v-if="showBenchmarkWorkouts === true"
    >
      <div v-for="workout in crossfitWorkouts" v-bind:key="workout.workoutName">
        <h4>{{ workout.workoutName }}</h4>
        <p>{{ workout.workoutDomain }}</p>
        <p>{{ workout.workoutStructure }}</p>
        <p>{{ workout.workoutWeights }}</p>
        <p>{{ workout.workoutRounds }}</p>
        <input
          type="text"
          v-bind="workout.workoutTime"
          placeholder="Time workout completed in"
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
    <button class="btn btn-light" v-on:click="showBenchmarkMovements = !showBenchmarkMovements">
      Enter Goals for Individual Movements
    </button>
    <h4 v-if="showBenchmarkMovements === true">Enter one rep max for each movement</h4>
    <form
      id="frmSaveBenchmarkMovements"
      v-on:submit.prevent="saveBenchmarkMovements"
      v-if="showBenchmarkMovements === true"
    >
      <div name="squats">
          <div>
        <h4>Squat Goals</h4>
        <label for="backSquat">Back Squat</label>
        <input
          type="text"
          name="backSquat"
          v-model="benchmarkMovements.backSquat"
        />
      </div>
        <label for="frontSquat">Front Squat</label>
        <input
          type="text"
          name="frontSquat"
          v-model="benchmarkMovements.frontSquat"
        />
        <div>
        <label for="zercherSquat">Zercher Squat</label>
        <input
          type="text"
          name="zercherSquat"
          v-model="benchmarkMovements.zercherSquat"
        />
        </div>
        <div>
        <label for="overheadSquat">Overhead Squat</label>
        <input
          type="text"
          name="overheadSquat"
          v-model="benchmarkMovements.overheadSquat"
        />
        </div>
        <div>
        <label for="bulgarianSplitSquat">Bulgarian Split Squat</label>
        <input
          type="text"
          name="bulgarianSplitSquat"
          v-model="benchmarkMovements.bulgarianSplitSquat"
        />
        </div>
      </div>
      <h4>Deadlift Goals</h4>
      <div name="deadlifts">
          <div>
        <label for="conventionalDeadlift">Conventional Deadlift</label
        >
        <input
          type="text"
          name="conventionalDeadlift"
          v-model="benchmarkMovements.conventionalDeadlift"
        />
        </div>
        <div>
        <label for="sumoDeadlift">Sumo Deadlift</label>
        <input
          type="text"
          name="sumoDeadlift"
          v-model="benchmarkMovements.sumoDeadlift"
        />
        </div>
      </div>
      <h4>Pressing Goals</h4>
      <div name="presses">
          <div>
        <label for="overheadPress">Overhead Press</label>
        <input
          type="text"
          name="overheadPress"
          v-model="benchmarkMovements.overheadPress"
        />
        </div>
        <div>
        <label for="militaryPress">Military Press</label>
        <input
          type="text"
          name="pushPress"
          v-model="benchmarkMovements.militaryPress"
        />
        </div>
        <div>
        <label for="pushPress">Push Press</label>
        <input
          type="text"
          name="pushPress"
          v-model="benchmarkMovements.pushPress"
        />
        </div>
      </div>
      <h4>Olympic Lifting Goals</h4>
      <div name="olympic">
          <div>
        <label for="squatClean">Squat Clean</label>
        <input
          type="text"
          name="squatClean"
          v-model="benchmarkMovements.squatClean"
        />
        </div>
        <div>
        <label for="powerClean">Power Clean</label>
        <input
          type="text"
          name="powerClean"
          v-model="benchmarkMovements.powerClean"
        />
        </div>
        <div>
        <label for="cleanJerk">Clean and Jerk</label>
        <input
          type="text"
          name="cleanJerk"
          v-model="benchmarkMovements.cleanJerk"
        />
        </div>
        <div>
        <label for="splitJerk">Split Jerk</label>
        <input
          type="text"
          name="splitJerk"
          v-model="benchmarkMovements.splitJerk"
        />
        </div>
        <div>
        <label for="pushJerk">Push Jerk</label>
        <input
          type="text"
          name="pushJerk"
          v-model="benchmarkMovements.pushJerk"
        />
        </div>
        <div>
        <label for="squatJerk">Squat Jerk</label>
        <input
          type="text"
          name="squatJerk"
          v-model="benchmarkMovements.squatJerk"
        />
        </div>
        <div>
        <label for="squatClean">Squat Clean</label>
        <input
          type="text"
          name="squatClean"
          v-model="benchmarkMovements.squatClean"
        />
        </div>
        <div>
        <label for="squatSnatch">Squat Snatch</label>
        <input
          type="text"
          name="squatSnatch"
          v-model="benchmarkMovements.squatSnatch"
        />
        </div>
        <div>
        <label for="powerSnatch">Power Snatch</label>
        <input
          type="text"
          name="powerSnatch"
          v-model="benchmarkMovements.powerSnatch"
        />
        </div>
        <div>
        <label for="snatchBalance">Snatch Balance</label>
        <input
          type="text"
          name="snatchBalance"
          v-model="benchmarkMovements.snatchBalance"
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
  background-image: linear-gradient(180deg, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(../assets/goals_page.jpg);
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

.btn {
  display: .75rem
}

</style>