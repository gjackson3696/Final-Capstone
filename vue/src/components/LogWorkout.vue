<template>
	<div class="body">
		<div class="enter-text">
			<h1>Enter one rep max for each movement</h1>
		</div>
		<div class="showForm">
			<button
				class="showFormBtn"
				@click="showForm = !showForm"
				v-text="showForm ? 'Close' : 'Log Workout'"
				v-show="!sh"
			></button>
		</div>
		<form
			class="logWorkoutForm"
			v-on:submit.prevent="logWorkout"
			v-if="showForm"
		>
			<div class="main-field name">
				<div class="field ">
					<h3>Personal Info</h3>
					<label for="name">Name:</label>
					<input
						class="input-field"
						type="text"
						name="name"
						placeholder="Name of workout"
						v-model="workout.name"
					/>
				</div>
				<div class="field">
					<label for="domain">Domain:</label>
					<input
						class="input-field"
						type="text"
						name="domain"
						placeholder="i.e. ARMAP, Time, EMOM, etc."
						v-model="workout.domain"
					/>
				</div>
				<div class="field">
					<label for="structure">Structure:</label>
					<input
						class="input-field"
						type="text"
						name="structure"
						placeholder="Movements/reps, i.e. 30 burpees, 20 pull ups"
						v-model="workout.structure"
					/>
				</div>
				<div class="field">
					<label for="weights">Weights:</label>
					<input
						class="input-field"
						type="text"
						name="weights"
						placeholder="Weights used for workout"
						v-model="workout.weights"
					/>
				</div>
				<div class="field">
					<label for="workoutTime">Time:</label>
					<input
						class="input-field"
						type="text"
						name="workoutTime"
						placeholder="Length of workout"
						v-model="workout.workoutTime"
					/>
				</div>
				<div class="field">
					<label for="rounds">Rounds/Reps:</label>
					<input
						class="input-field"
						type="text"
						name="rounds"
						placeholder="Number of rounds/reps completed"
						v-model="workout.rounds"
					/>
				</div>
				<div class="field">
					<label for="completed">Completed</label>
					<input
						class="input-field-checkbox"
						type="checkbox"
						name="completed"
						v-model="workout.completed"
					/>
				</div>
			</div>

			<div class="main-field squats">
				<div class="field">
					<h3>Squats</h3>
					<label for="backSquat">Back Squat Max:</label>
					<input
						class="input-field"
						type="text"
						name="backSquat"
						placeholder="Back Squat"
						v-model="workout.backSquat"
					/>
				</div>
				<div class="field">
					<label for="frontSquat">Front Squat Max:</label>
					<input
						class="input-field"
						type="text"
						name="frontSquat"
						placeholder="Front Squat"
						v-model="workout.frontSquat"
					/>
				</div>
				<div class="field">
					<label for="zercherSquat">Zercher Squat Max:</label>
					<input
						class="input-field"
						type="text"
						name="zercherSquat"
						placeholder="Zercher Squat"
						v-model="workout.zercherSquat"
					/>
				</div>
				<div class="field">
					<label for="overheadSquat">Overhead Squat Max:</label>
					<input
						class="input-field"
						type="text"
						name="overheadSquat"
						placeholder="Overhead Squat"
						v-model="workout.overheadSquat"
					/>
				</div>
				<div class="field">
					<label for="bulgarianSplitSquat">Bulgarian Split Squat Max:</label>
					<input
						class="input-field"
						type="text"
						name="bulgarianSplitSquat"
						placeholder="Bulgarian Split Squat"
						v-model="workout.bulgarianSplitSquat"
					/>
				</div>
			</div>
			<div class="main-field deadlifts">
				<div class="field">
					<h3>Deadlifts</h3>
					<label for="conventionalDeadlift">Conventional Deadlift Max:</label>
					<input
						class="input-field"
						type="text"
						name="conventionalDeadlift"
						placeholder="Conventional Deadlift"
						v-model="workout.conventionalDeadlift"
					/>
				</div>
				<div class="field">
					<label for="sumoDeadlift">Sumo Deadlift Max:</label>
					<input
						class="input-field"
						type="text"
						name="sumoDeadlift"
						placeholder="Sumo Deadlift"
						v-model="workout.sumoDeadlift"
					/>
				</div>
			</div>
			<div class="main-field presses">
				<div class="field">
					<h3>Presses</h3>
					<label for="overheadPress">Overhead Press Max:</label>
					<input
						class="input-field"
						type="text"
						name="overheadPress"
						placeholder="Overhead Press"
						v-model="workout.overheadPress"
					/>
				</div>
				<div class="field">
					<label for="militaryPress">Military Press Max:</label>
					<input
						class="input-field"
						type="text"
						name="militaryPress"
						placeholder="Military Press"
						v-model="workout.militaryPress"
					/>
				</div>
				<div class="field">
					<label for="pushPress">Push Press Max:</label>
					<input
						class="input-field"
						type="text"
						name="pushPress"
						placeholder="Push Press"
						v-model="workout.pushPress"
					/>
				</div>
			</div>
			<div class="main-field olympic-lifts">
				<div class="field">
					<h3>Olympic Lifts</h3>
					<label for="squatClean">Squat Clean Max:</label>
					<input
						class="input-field"
						type="text"
						name="squatClean"
						placeholder="Squat Clean"
						v-model="workout.squatClean"
					/>
				</div>
				<div class="field">
					<label for="powerClean">Power Clean Max:</label>
					<input
						class="input-field"
						type="text"
						name="powerClean"
						placeholder="Power Clean"
						v-model="workout.powerClean"
					/>
				</div>
				<div class="field">
					<label for="cleanJerk">Clean & Jerk Max:</label>
					<input
						class="input-field"
						type="text"
						name="cleanJerk"
						placeholder="Clean Jerk"
						v-model="workout.cleanJerk"
					/>
				</div>
				<div class="field">
					<label for="splitJerk">Split Jerk Max:</label>
					<input
						class="input-field"
						type="text"
						name="splitJerk"
						placeholder="Split Jerk"
						v-model="workout.splitJerk"
					/>
				</div>
				<div class="field">
					<label for="pushJerk">Push Jerk Max:</label>
					<input
						class="input-field"
						type="text"
						name="pushJerk"
						placeholder="Push Jerk"
						v-model="workout.pushJerk"
					/>
				</div>
				<div class="field">
					<label for="squatJerk">Squat Jerk Max:</label>
					<input
						class="input-field"
						type="text"
						name="squatJerk"
						placeholder="Squat Jerk"
						v-model="workout.squatJerk"
					/>
				</div>
				<div class="field">
					<label for="squatSnatch">Squat Snatch Max:</label>
					<input
						class="input-field"
						type="text"
						name="squatSnatch"
						placeholder="Squat Snatch"
						v-model="workout.squatSnatch"
					/>
				</div>
				<div class="field">
					<label for="powerSnatch">Power Snatch Max:</label>
					<input
						class="input-field"
						type="text"
						name="powerSnatch"
						placeholder="Power Snatch"
						v-model="workout.powerSnatch"
					/>
				</div>
				<div class="field">
					<label for="snatchBalance">Snatch Balance Max:</label>
					<input
						class="input-field"
						type="text"
						name="snatchBalance"
						placeholder="Snatch Balance"
						v-model="workout.snatchBalance"
					/>
				</div>
			</div>

			<div class="btn">
				<button id="logWorkoutButton" type="submit">Submit Workout</button>
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
				name: '',
				domain: '',
				structure: '',
				weights: '',
				workoutTime: '',
				rounds: '',
				backSquat: '',
				frontSquat: '',
				zercherSquat: '',
				overheadSquat: '',
				bulgarianSplitSquat: '',
				conventionalDeadlift: '',
				sumoDeadlift: '',
				overheadPress: '',
				militaryPress: '',
				pushPress: '',
				squatClean: '',
				powerClean: '',
				cleanJerk: '',
				splitJerk: '',
				pushJerk: '',
				squatJerk: '',
				squatSnatch: '',
				powerSnatch: '',
				snatchBalance: '',
				completed: false,
			},
			showForm: false,
		};
	},
	methods: {
		logWorkout() {
			workoutService.logWorkout(this.workout).then((response) => {
				if (response.status == 201) {
					this.clearForm();
				}
			});
		},
		clearForm() {
			this.workout = {
				name: '',
				domain: '',
				structure: '',
				weights: '',
				workoutTime: '',
				rounds: '',
				completed: true,
				backSquat: '',
				frontSquat: '',
				zercherSquat: '',
				overheadSquat: '',
				bulgarianSplitSquat: '',
				conventionalDeadlift: '',
				sumoDeadlift: '',
				overheadPress: '',
				militaryPress: '',
				pushPress: '',
				squatClean: '',
				powerClean: '',
				cleanJerk: '',
				splitJerk: '',
				pushJerk: '',
				squatJerk: '',
				squatSnatch: '',
				powerSnatch: '',
				snatchBalance: '',
			};
		},
	},
};
</script>

<style scoped>
.enter-text h1{
    position: relative;
    font-size: 50px;
    text-align: center;
    color: white;
    font-family: Stencil;
    text-shadow: 3px 3px rgb(0, 0, 0);
}
form {
	display: grid;
	justify-content: center;
	grid-auto-flow: column;
	color: white;
}
.name {
	position: relative;
	color: white;
	position: relative;
	
}

.main-field.name {
	position: relative;
	border-radius: 10px;
	width: 240px;
	height: 800px;
	text-align: center;
	font-weight: bold;
	display: grid;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
.main-field.squats {
	position: relative;
	border-radius: 10px;
	width: 260px;
	height: 800px;
	text-align: center;
	font-weight: bold;
	display: grid;
	justify-content: center;
	color: white;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
.main-field.deadlifts {
	position: relative;
	border-radius: 10px;
	width: 240px;
	height: 550px;
	text-align: center;
	font-weight: bold;
	display: grid;
	justify-content: center;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
.main-field.presses {
	position: relative;
	border-radius: 10px;
	width: 240px;
	height: auto;
	text-align: center;
	font-weight: bold;
	display: grid;
	justify-content: center;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
.main-field.olympic-lifts {
	position: relative;
	border-radius: 10px;
	width: 240px;
	height: auto;
	text-align: center;
	font-weight: bold;
	display: grid;
	justify-content: center;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
		rgb(1, 183, 255) 0px 18px 36px -18px inset;
}

button {
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
    font-weight: 400;
	width: 350px;
	height: 50px;
	font-size: 18px;
	text-shadow: 0 1px 0 rgb(0 0 0 / 40%);
	transition: box-shadow 0.15s ease, transform 0.15s ease;
    font-family: Stencil;
}
button:hover {
	box-shadow: 0px 4px 8px rgb(45 35 66 / 40%),
		0px 7px 13px -3px rgb(45 35 66 / 30%), inset 0px -3px 30px #f700ff88;
	transform: translateY(-2px);
}
button:active {
	box-shadow: inset 0px 3px 7px #000000;
	transform: translateY(2px);
}

button.showFormBtn{
margin-bottom: 65px;
margin-top: 60px;
display: grid;
align-content: center;
margin-left: 750px

}
button#logWorkoutButton {
position: absolute;
display: grid;
align-content: center;
margin-top: 810px;
margin-left: -800px;
}
input {
	width: 200px;
	height: 30px;
	padding: 5px;
	font-size: 10px;
	color: rgb(20, 255, 247);
	border-radius: 5px;
}
h3 {
	position: relative;
	color: white;
	font-size: 40px;
	font-family: Stencil;
	text-shadow: 1.4px 1.4px black;
}
label {
	position: relative;
	color: white;
	text-shadow: 1px 1px black;
}

</style>
