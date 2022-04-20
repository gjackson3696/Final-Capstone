<template>
	<body class="main-container">
		<div>
			<div class="main-header">
				<header class="header-img">
					<div class="main-image">
						<img class="header-logo" src="" alt="header-logo" />
					</div>
				</header>
				<div>
					<div class="about-card">
						<div class="title-context">
							<p>About Me</p>
							<h2>dynamically insert name here</h2>
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
		<div>
			<log-workout />
		</div>
		<div></div>
	</body>
</template>

<script>
import classService from '../services/ClassService';
import LogWorkout from '../components/LogWorkout';

export default {
	name: 'dashboard',
	components: {
		LogWorkout,
	},
	created() {
		classService.getRegisteredClassIds().then((response) => {
			this.$store.commit('SET_CLASS_IDS', response.data);
		});
	},
};
</script>

<style scoped>
body {
	position: relative;
	min-height: 100%;
	min-width: 100%;
	width: 100%;
	height: 160vh;
	/* display: flex;
	align-items: center;
	justify-content: center; */
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
}
.about-card > .card-title {
	display: flex;
	align-items: center;
	justify-content: flex-end;
}
.profile-picture {
	height: 140px;
	border-radius: 50%;
	position: relative;
	display: flex;
	justify-content: flex-end;
}
.profile-picture .main-img {
	border-radius: 50%;
}

p {
	color: white;
	position: relative;
	display: flex;
	justify-content: center;
}
h2 {
	color: white;
	position: relative;
	display: flex;
	justify-content: center;
	margin-right: 70px;
}
h3 {
	font-family: Stencil;
}
</style>
