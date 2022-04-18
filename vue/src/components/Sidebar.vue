<template>
	<div class="container" :class="{ show: showSidebar }">
		<div class="control">
			<i class="material-icons" @click="showNav">double_arrow</i>
		</div>
		<div class="navigation-icons">
			<i class="material-icons">home</i>
			<i class="material-icons">schedule</i>
			<i class="material-icons">settings_accessibility</i>
			<i class="material-icons">view_list</i>
			<i class="material-icons">login</i>
			<i class="material-icons">logout</i>
		</div>
		<div class="navigation-links">
			<transition-group name="fade">
				<div v-show="showLink" key="1">
					<router-link
						class="router-btn"
						v-bind:to="$store.state.token === '' ? '/' : '/dashboard'"
						>Home</router-link
					>
				</div>
				<div v-show="showLink" key="2">
					<router-link class="router-btn" v-bind:to="{ name: 'schedule' }"
						>Schedule</router-link
					>
				</div>
				<div v-show="showLink" key="3">
					<router-link class="router-btn" v-bind:to="{ name: 'workoutGoals' }"
						>My Goals</router-link
					>
				</div>
				<div v-show="showLink" key="4">
					<router-link class="router-btn" v-bind:to="{ name: 'accountDetails' }"
						>My Details</router-link
					>
				</div>
				<div v-show="showLink" key="5">
					<router-link
						class="router-btn"
						v-if="$store.state.token === ''"
						v-bind:to="{ name: 'login' }"
						>Login</router-link
					>
				</div>
				<div v-show="showLink" key="6">
					<router-link
						class="router-btn"
						v-if="$store.state.token != ''"
						v-bind:to="{ name: 'logout' }"
						>Logout</router-link
					>
				</div>
			</transition-group>
		</div>
	</div>
</template>
<script>
export default {
	data: () => {
		return {
			showSidebar: false,
			showLink: false,
		};
	},
	methods: {
		showNav() {
			if (this.showSidebar) {
				this.showLink = false;
				setTimeout(() => {
					this.showSidebar = false;
				}, 500);
			} else {
				this.showSidebar = true;
				setTimeout(() => {
					this.showLink = true;
				}, 500);
			}
		},
	},
};
</script>
<style scoped>
.container {
	position: absolute;
	top: 0;
	left: 0;
	width: 100px;
	padding: 10px;
	min-height: calc(100vh - 20px);
	/* border: solid rgb(0, 255, 247); */
	border-width: 0 1px 0 0;
	z-index: 999;
	transition: all 0.5s ease-in-out;
	background:rgba(128, 128, 128, 0.208);
	
}
.control {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 50px;
	margin-bottom: 10px;
}
.container i {
	font-size: 2rem;
	cursor: pointer;
	transition: all 0.5s ease-in-out;
}
.show{
	width: 300px;
	background-image: url('../assets/Sidebar-img.png');
	opacity: .9;
}
.control > i {
	color: rgb(0, 247, 255);
}
.navigation-icons {
	color: rgb(0, 255, 251);
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	width: 50px;
	float: left;
    /* margin-top: 140px; */
}
.navigation-icons > i {
	font-size: 3rem;
	padding: 10px 0;
	cursor: pointer;
	transition: all 0.5s ease-in-out;

}
.navigation-icons > i:hover {
	color: rgb(181, 0, 205);
}
.navigation-links {
	padding-top: 14px;
	float: left;
    /* margin-top: 140px; */
}
.navigation-links div {
	font-size: 2rem;
	padding-left: 10px;
	margin-bottom: 18px;
	cursor: pointer;
	text-decoration: none;
	color: rgb(242, 0, 255);
}

.navigation-links div:hover {
	color: aquamarine;
}
.router-btn {
	text-decoration: none;
	/* color: rgb(255, 255, 255); */
    font-weight: bold;
    text-shadow: 2px 2px rgb(123, 0, 161);
}
</style>
