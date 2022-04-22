<template>
	<body class="main-container">
		<div>
			<div class="main-header">
				<header class="header-img">
					<div class="main-image">
						<br/>
					</div>
				</header>
				<div>
					<div class="about-card">
						<div class="title-context">
							<h3>About Me</h3>
							<h2>{{$store.state.member.firstName}} {{$store.state.member.lastName}}</h2>
							<h4>{{$store.state.member.email}}</h4>
						</div>
						<div class="profile-picture">
							<img class="main-img" src="../assets/no-profilepic.jpg" />
						</div>
						<div class="main-content"></div>
						<div class="workout-metrics"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="schedule">
			<div class="schedule-title">
				<h3 id="schedule-title">My Classes</h3>
			</div>
			<div class="card-container">
				<class-card
					class="class-card"
					v-bind:classItem="item"
					v-for="item in this.$store.state.registeredClassList"
					:key="item.id"
				/>
			</div>
		</div>
		<div>
			<log-workout />
		</div>
	</body>
</template>

<script>
import classService from '../services/ClassService';
import LogWorkout from '../components/LogWorkout';
import ClassCard from '../components/ClassCard';

export default {
	name: 'dashboard',
	data() {
		return {
		}
	},
	components: {
		LogWorkout,
		ClassCard
	},
	created() {
		classService.getRegisteredClassIds().then((response) => {
			this.$store.commit('SET_CLASS_IDS', response.data);
		});
	},
	beforeDestroy() {
		classService.getRegisteredClassIds().then((response) => {
			this.$store.commit('SET_CLASS_IDS', response.data);
		});
		classService.getRegisteredClasses().then(response => {
			this.$store.commit('SET_REGISTERED_CLASS_LIST', response.data);
		});
	}
};
</script>

<style scoped>
body {
	position: relative;
	min-height: 100%;
	min-width: 100%;
	width: 100%;
	height: 160vh;
}

body::before {
	content: '';
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-image: linear-gradient(
			180deg,
			rgba(0, 0, 0, 0.5),
			rgba(0, 0, 0, 0.5)
		),
		url('../assets/dashboard-bg-2.jpg');
	background-position: top center;
	opacity: 0.9;
	box-shadow: rgba(0, 229, 255, 0.466) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
}
.about-card {
	background: darkgrey;
	padding: 3em;
	border-radius: 10px;
	color: white;
	display: flex;
	justify-content: center;
}
.about-card > .card-title {
	display: flex;
	align-items: center;
	justify-content: center;
}
.profile-picture {
	height: 140px;
	border-radius: 50%;
	margin-left: 750px;
	position: absolute;
}
.profile-picture .main-img {
	border-radius: 50%;
}

h3 {
	color: white;
	position: relative;
	display: flex;
	justify-content: center;
	font-size: 3em;
}
h2 {
	color: white;
	position: relative;
	display: flex;
	justify-content: center;
	font-size: 4em;
}
h4 {
	color: white;
	position: relative;
	display: flex;
	justify-content: center;
	font-size: em;
}
body {
	font-family: Stencil;
}
.card-container {
	display: flex;
	flex-wrap: wrap;
	flex-direction: row;
	justify-content: space-evenly;
}

</style>
