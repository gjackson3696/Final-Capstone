<template>
  <div class="container">
    <img
      id="logo"
      src="../assets/Small-logo.png"
      alt="CrossFit Syntactical Logo"
    />
    <h2 id="goals-header" v-if="!showBenchmarkMovements && !showBenchmarkWorkouts && !showPersonalWorkouts">Set Goals, Crush Them!</h2>
    <h3 v-if="!showBenchmarkMovements && !showBenchmarkWorkouts">
      Enter data for a personal workout:
    </h3>
    <button
      class="btn btn-light"  id="personal-workout-btn"
      v-on:click="showPersonalWorkouts = !showPersonalWorkouts"
      v-if="!showBenchmarkMovements && !showBenchmarkWorkouts"
      v-text="showPersonalWorkouts === true ? 'Close' : 'Add Personal Workout'"
    ></button>
    <div class="personal-workout"  v-if="showPersonalWorkouts">
    <form
      id="frmAddNewWorkout"
      v-on:submit.prevent="saveWorkout"
      v-if="showPersonalWorkouts === true"
    >
      <div class="field">
        <label for="workoutName">Name of Workout:</label>
        <input
          size="50"
          type="text"
          name="workoutName"
          placeholder="Name your workout"
          v-model="personalWorkout.workoutName"
        />
      </div>
      <div class="field" id="workoutDomain">
        <label for="workoutDomain">Domain of Workout:</label>
        <input
          size="50"
          type="text"
          name="workoutDomain"
          placeholder="Domain, i.e. ARMAP, Time, EMOM, etc."
          v-model="personalWorkout.workoutDomain"
        />
      </div>
      <div class="field">
        <label for="workoutStructure">Structure of Workout:</label>
        <input
          size="50"
          type="text"
          name="workoutStructure"
          placeholder="Movements/reps, i.e. 30 burpees, 20 pull ups"
          v-model="personalWorkout.workoutStructure"
        />
      </div>
      <div class="field">
        <label for="workoutWeights">Weights for Workout:</label>
        <input
          size="50"
          type="text"
          name="workoutWeights"
          placeholder="Goal for weights used for this workout"
          v-model="personalWorkout.workoutWeights"
        />
      </div>
      <div class="field">
        <label for="workoutTime">Time for Workout:</label>
        <input
          size="50"
          type="text"
          name="workoutTime"
          placeholder="Time goal for this workout"
          v-model="personalWorkout.workoutTime"
        />
      </div>
      <div class="field">
        <label for="workoutReps">Reps for Workout:</label>
        <input
          size="50"
          type="text"
          name="workoutReps"
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
  </div>
    <h3 v-if="!showBenchmarkMovements && !showPersonalWorkouts">
      Enter goals for a standardized CrossFit Workout
    </h3>
    <button
      class="btn btn-light"
      v-on:click="showBenchmarkWorkouts = !showBenchmarkWorkouts"
      v-if="!showBenchmarkMovements && !showPersonalWorkouts"
      v-text="showBenchmarkWorkouts === true ? 'Close' : 'Enter Desired Score'"
    ></button>

    <form
      id="frmSaveBenchmarkWorkout"
      v-on:submit.prevent="saveBenchmarkWorkout"
      v-if="showBenchmarkWorkouts === true"
    >
    <div class="main-benchmark">
      <div
        class="benchmark-workouts"
        v-for="workout in crossfitWorkouts"
        v-bind:key="workout.workoutName"
      >
      <div class="benchmark-card">
        <div class="girl-card">
        <h4>{{ workout.workoutName }}</h4>
        <p>{{ workout.workoutDomain }}</p>
        <p>{{ workout.workoutStructure }}</p>
        <p>{{ workout.workoutWeights }}</p>
        <div class="label">
        <label for="time">Time:</label>
        </div>
        <input
          type="text"
          v-model="workout.workoutTime"
          name="time"
          placeholder="Desired completion time"
        />
        <br />
        <div class="label">
        <label for="reps">Reps:</label>
        </div>
        <div class="input">
        <input
          type="text"
          v-model="workout.workoutRounds"
          name="reps"
          placeholder="# rounds/# reps"
        />
        </div>
        </div>
        </div>
      </div>
      </div>
    
      <div class="standardized-goals">
      <button type="submit" class="btn btn-primary">Save Workout</button>
    </div>
    </form>
    <div class="movements-title">
    <h3 class="benchmark-movements-title" v-if="!showBenchmarkWorkouts && !showPersonalWorkouts">
      Enter goals for individual movements (squats, olympic lifts, etc.)
    </h3>
    </div>
    <button
      class="btn btn-light"
      v-on:click="showBenchmarkMovements = !showBenchmarkMovements"
      v-if="!showBenchmarkWorkouts && !showPersonalWorkouts"
      v-text="
        showBenchmarkMovements === true
          ? 'Close'
          : 'Enter Goals for Individual Movements'
      "
    ></button>
    <h4 v-if="showBenchmarkMovements === true">
      Enter one rep max for each movement
    </h4>
    <form
      id="frmSaveBenchmarkMovements"
      v-on:submit.prevent="saveBenchmarkMovements"
      v-if="showBenchmarkMovements === true"
    >
      <div>
        <div  id="squats">
        <div>
          <h5>Squat Goals</h5>
          <label for="backSquat">Back Squat:</label>

          <div>
            <input
              type="text"
              name="backSquat"
              v-model="benchmarkMovements.backSquat"
              placeholder="Back Squat"
            />
          </div>
        </div>
        <label for="frontSquat">Front Squat:</label>

        <div>
          <input
            type="text"
            name="frontSquat"
            v-model="benchmarkMovements.frontSquat"
            placeholder="Front Squat"
          />
        </div>
        <label for="zercherSqat">Zercher Squat:</label>

        <div>
          <input
            type="text"
            name="zercherSquat"
            v-model="benchmarkMovements.zercherSquat"
            placeholder="Zercher Squat"
          />
        </div>
        <label for="overheadSquat">Overhead Squat:</label>

        <div>
          <input
            type="text"
            name="overheadSquat"
            v-model="benchmarkMovements.overheadSquat"
            placeholder="Overhead Squat"
          />
        </div>
        <label for="bulgarianSplitSquat">Bulgarian Split Squat:</label>

        <div>
          <input
            type="text"
            name="bulgarianSplitSquat"
            v-model="benchmarkMovements.bulgarianSplitSquat"
            placeholder="Bulgarian Split Squat"
          />
        </div>
      </div>
      </div>
      <div id="deadlifts">
      <div >
        <h5>Deadlift Goals</h5>
        <label for="conventionalDeadlift">Conventional Deadlift:</label>

        <div>
          <input
            type="text"
            name="conventionalDeadlift"
            v-model="benchmarkMovements.conventionalDeadlift"
            placeholder="Conventional Deadlift"
          />
        </div>
        <label for="sumoDeadlift">Sumo Deadlift:</label>

        <div>
          <input
            type="text"
            name="sumoDeadlift"
            v-model="benchmarkMovements.sumoDeadlift"
            placeholder="Sumo Deadlift"
          />
        </div>
      </div>
      </div>
      <div id="presses">
      <div >
        <h5>Pressing Goals</h5>
        <label for="overheadPress">Overhead Press:</label>

        <div>
          <input
            type="text"
            name="overheadPress"
            v-model="benchmarkMovements.overheadPress"
            placeholder="Overhead Press"
          />
        </div>
        <label for="militaryPress">Military Press:</label>

        <div>
          <input
            type="text"
            name="militaryPress"
            v-model="benchmarkMovements.militaryPress"
            placeholder="Military Press"
          />
        </div>
        <label for="pushPress">Push Press:</label>

        <div>
          <input
            type="text"
            name="pushPress"
            v-model="benchmarkMovements.pushPress"
            placeholder="Push Press"
          />
        </div>
      </div>
      </div>
      <div id="olympic">
      <div>
        <h5>Olympic Lifting Goals</h5>
        <label for="squatClean">Squat Clean:</label>

        <div>
          <input
            type="text"
            name="squatClean"
            v-model="benchmarkMovements.squatClean"
            placeholder="Squat Clean"
          />
        </div>
        <label for="powerClean">Power Clean:</label>

        <div>
          <input
            type="text"
            name="powerClean"
            v-model="benchmarkMovements.powerClean"
            placeholder="Power Clean"
          />
        </div>
        <label for="cleanJerk">Clean & Jerk:</label>

        <div>
          <input
            type="text"
            name="cleanJerk"
            v-model="benchmarkMovements.cleanJerk"
            placeholder="Clean & Jerk"
          />
        </div>
        <label for="splitJerk">Split Jerk:</label>

        <div>
          <input
            type="text"
            name="splitJerk"
            v-model="benchmarkMovements.splitJerk"
            placeholder="Split Jerk"
          />
        </div>
        <label for="pushJerk">Push Jerk:</label>

        <div>
          <input
            type="text"
            name="pushJerk"
            v-model="benchmarkMovements.pushJerk"
            placeholder="Push Jerk"
          />
        </div>
        <label for="squatJerk">Squat Jerk:</label>

        <div>
          <input
            type="text"
            name="squatJerk"
            v-model="benchmarkMovements.squatJerk"
            placeholder="Squat Jerk"
          />
        </div>
        <label for="squatSnatch">Squat Snatch:</label>

        <div>
          <input
            type="text"
            name="squatSnatch"
            v-model="benchmarkMovements.squatSnatch"
            placeholder="Squat Snatch"
          />
        </div>
        <label for="powerSnatch">Power Snatch:</label>

        <div>
          <input
            type="text"
            name="powerSnatch"
            v-model="benchmarkMovements.powerSnatch"
            placeholder="Power Snatch"
          />
        </div>
        <label for="snatchBalance">Snatch Balance:</label>

        <div>
          <input
            type="text"
            name="snatchBalance"
            v-model="benchmarkMovements.snatchBalance"
            placeholder="Snatch Balance"
          />
        </div>
      </div>
      </div>
      <div id="last-save-button">
	<button type="submit" class="btn btn-primary" >Save Movements</button>
  </div>
    </form>
    </div>
</template>

<script>
import workoutService from "../services/WorkoutService.js";
import goalsService from '../services/GoalsService.js';
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
    saveWorkout() {
      workoutService.saveWorkout(this.personalWorkout).then((response) => {
        this.personalWorkout = response.data;
      });
      this.resetForm();
    },

    saveBenchmarkWorkout() {
      workoutService.saveWorkout(this.crossfitWorkouts[0]).then((response) => {
        this.crossfitWorkouts[0] = response.data;
      });
      workoutService.saveWorkout(this.crossfitWorkouts[1]).then((response) => {
        this.crossfitWorkouts[1] = response.data;
      });
    },

    saveBenchmarkMovements() {
      goalsService.update(this.benchmarkMovements).then((response) => {
        if(response.data.length !== 0) {
          goalsService.create(this.benchmarkMovements);
        } else {
          this.benchmarkMovements = response.data;
        }
      });
    },
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
  created() {
    goalsService.getGoals().then(response => {
      if(response.data.length !== 0) {
        this.benchmarkMovements = response.data;
      }
    })
  }
};
</script>

<style scoped>
.container {
	position: relative;
	min-height: 100%;
	min-width: 100%;
	width: 100%;
	height: 210vh;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
.container::before {
	content: '';
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-image: linear-gradient(
			180deg,
			rgba(0, 0, 0, 0.5),
			rgba(0, 0, 0, 0.5)
		),
		url('../assets/goals-page.png');
	background-position: top center;
	opacity: 0.9;
	box-shadow: rgba(0, 229, 255, 0.279) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
}
.personal-workout {
  position: relative;
	border-radius: 10px;
	width: 500px;
	height: 560px;
	text-align: center;
	display: grid;
  position: relative;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgb(0, 229, 255) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#personal-workout-btn {
margin-top: 4px;
margin-bottom: 40px;
}

#checkboxRx {
	position: relative;
	margin: 0 0 0 8px;
}

label {
	color: rgb(255, 255, 255);
	font-family: Stencil;
  font-size: 20px;
  margin: 5px;
  text-shadow: 1px 1px black;

}

p {
	color: white;
	font-family: Stencil;
}


.btn-light {
	position: relative;
	display: flex;
	width: 700px;
	justify-content: center;
	font-family: Stencil;
  margin-bottom: 30px;
}
.btn-primary {
	position: relative;
	display: flex;
	width: 700px;
	justify-content: center;
	font-family: Stencil;
}

#frmSaveBenchmarkMovements {
  position: relative;
	display: grid;
	justify-content: center;
	grid-auto-flow: column;
	color: white;
}

#frmAddNewWorkout, #frmSaveBenchmarkWorkout {
	position: relative;
}

#frmSaveBenchmarkWorkout {
	display: flex;
	flex-direction: column;
	align-items: center;

}

#frmSaveBenchmarkWorkout > .btn, #frmAddNewWorkout > .btn {
	position: relative;
	margin-top: 5px;
	height: 50px;
	
}
#squats {
  position: relative;
	border-radius: 10px;
	height: 800px;
  width: 17.5rem;
	text-align: center;
	display: grid;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#deadlifts {
position: relative;
	border-radius: 10px;
	height: 800px;
  width: 17.5rem;
	text-align: center;
	display: grid;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#presses {
position: relative;
	border-radius: 10px;
	height: 800px;
  width: 17.5rem;
	text-align: center;
	display: grid;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#olympic {
  position: relative;
	border-radius: 10px;
	height: 800px;
  width: 17.5rem;
	text-align: center;
	display: grid;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#last-save-button {
position: absolute;
display: grid;
align-content: center;
margin-top: 840px;
margin-left: 350px;
}


.btn{
	position: relative;
	color: rgb(20, 255, 247);
	display: inline-block;
	outline: 0;
	border: 0;
	cursor: pointer;
	will-change: box-shadow, transform;
	background: radial-gradient(100% 100% at 100% 0%, #03ffc0f3 0%, #00e0fe 100%);
	box-shadow: 0px 2px 4px rgb(45 35 66 / 40%),
		0px 7px 13px -3px rgb(45 35 66 / 30%),
		inset 0px -3px 0px rgb(58 65 111 / 50%);
	padding: 0 32px;
	border-radius: 6px;
	color: rgb(0, 0, 0);
	width: 400px;
	height: 60px;
	font-size: 18px;
	text-shadow: 0 1px 0 rgb(0 0 0 / 40%);
	transition: box-shadow 0.15s ease, transform 0.15s ease;
}
.btn:hover {
	box-shadow: 0px 4px 8px rgb(45 35 66 / 40%),
		0px 7px 13px -3px rgb(45 35 66 / 30%), inset 0px -3px 30px #f700ff;
	transform: translateY(-2px);
}
.btn :active {
	box-shadow: inset 0px 3px 7px #000000;
	transform: translateY(2px);
}

#logo {
	position: absolute;
	max-width: 100px;
	top: 0;
	right: 0;
}

#goals-header {
	position: absolute;
	top: 0;
	font-family: Stencil;
	font-size: 5em;
	font-weight: 800;
	color: white;
	display: flex;
	justify-content: center;
  text-shadow: 2px 2px 2px black;
  margin-top: 80px;
  margin-bottom: 40px;
}

#annoying-button {
	margin-top: 5px;
	width: 100%;
}

h5 {
  margin: 0px 8px 8px;
	position: relative;
	font-family: Stencil;
	color: white;
	display: flex;
	justify-content: center;
  font-size: 30px;
  text-shadow: 1px 1px black;
}
h3 {
	position: relative;
	font-family: Stencil;
	color: white;
	display: flex;
	justify-content: center;
  font-size: 50px;
  text-shadow: 1px 1px black;
}
h4{
	position: relative;
	font-family: Stencil;
	color: white;
	display: flex;
	justify-content: center;
  font-size: 40px;
}
.benchmark-workouts {
  position: relative;
	border-radius: 10px;
	height: 400px;
  width: 17.5rem;
	text-align: center;
	display: flex;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.904) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
.benchmark-workouts  > input {
  margin-bottom: 20px;
  width: 250px;
  margin-left: 40px;

}
.standardized-goals {
    position: relative;
    display: flex;
    margin-top: 30px;
    text-align: center;
}

.benchmark > input {
  display:grid;


}
div.main-benchmark {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;

}
div.benchmark-card {

  position: relative;
  display: flex;
  flex-wrap: wrap;

}
div.girl-card {
    position: relative;
    display: inline-block;
    flex-direction: column;
  
}
.movements-title {
  display: flex;
  flex-wrap: wrap;
  margin: 100px;
}
</style>