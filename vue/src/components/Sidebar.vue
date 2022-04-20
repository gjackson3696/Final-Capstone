<template>
	<div class="container" :class="{ show: showSidebar }">
		<div class="control">
			<i class="material-icons" @click="showNav">double_arrow</i>
		</div>
		<div class="navigation-icons">
			<router-link v-bind:to="$store.state.token === '' ? '/' : '/dashboard'" class="material-icons">home</router-link>
			<router-link v-bind:to="{ name: 'schedule' }" class="material-icons">schedule</router-link>
			<router-link v-bind:to="{ name: 'workoutGoals' }" class="material-icons" v-if="$store.state.token !== ''">work</router-link>
			<router-link v-bind:to="{ name: 'accountDetails' }" class="material-icons" v-if="$store.state.token !== ''">view_list </router-link>
			<router-link v-bind:to="$store.state.token === '' ? '/login' : '/logout'" class="material-icons">login</router-link>
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
				<div v-show="showLink" key="3" v-if="$store.state.token !== ''">
					<router-link class="router-btn" v-bind:to="{ name: 'workoutGoals' }"
						>My Goals</router-link
					>
				</div>
				<div v-show="showLink" key="4" v-if="$store.state.token !== ''">
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
	border-width: 0 1px 0 0;
	z-index: 999;
	transition: all 0.5s ease-in-out;
	background:rgba(128, 128, 128, 0);
	
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
		background-image: linear-gradient(
			180deg,
			rgba(0, 0, 0, 0.5),
			rgba(0, 0, 0, 0.5)
		),url('../assets/Sidebar-img.png');
	width: 300px;
	
	opacity: .9;
		box-shadow: rgba(131, 0, 143, 0.11) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
}
.control > i {
color: rgb(20, 255, 247);
}
.navigation-icons {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	width: 50px;
	float: left;
}
.navigation-icons > .material-icons {
	color: rgb(20, 255, 247);
	font-size: 3rem;
	padding: 10px 0;
	cursor: pointer;
	transition: all 0.5s ease-in-out;

}
.navigation-icons > .material-icons:hover {
	color: rgb(181, 0, 205);
}
.navigation-links {
	padding-top: 14px;
	float: left;
}
.navigation-links div {
	font-size: 2rem;
	padding-left: 10px;
	margin-bottom: 18px;
	cursor: pointer;
	text-decoration: none;
	color: rgba(242, 0, 255, 0.336);
}

.navigation-links div:hover {
		color: rgb(20, 255, 247);
}
.router-btn, .material-icons{
	text-decoration: none;
    font-weight: bold;
    text-shadow: 1px 1px rgba(123, 0, 161, 0.582);
}
.material-icons{
	text-decoration: none;
}
.router-btn {
		color: rgb(20, 255, 247);
}
.router-btn:hover {
color: rgba(242, 0, 255, 0.336);
}
</style>
