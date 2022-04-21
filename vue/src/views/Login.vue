<template>
	<div id="login" class="text-center">
		<form class="form-signin" @submit.prevent="login">
			<div class="card p-5">
				<h3 class="text-center text-uppercase mb-4">Please Sign In</h3>

				<hr />
				<div class="alert alert-danger" role="alert" v-if="invalidCredentials">
					Invalid username and password!
				</div>

				<div
					class="alert alert-success"
					role="alert"
					v-if="this.$route.query.registration"
				>
					Thank you for registering, please sign in.
				</div>

				<label for="username" class="sr-only"></label>

				<div class="form-group">
					<label>Username</label>
					<input
						type="text"
						id="username"
						placeholder="Username"
						class="form-control"
						v-model="user.username"
						required
						autofocus
					/>
				</div>

				<label for="Password">Password</label>
				<div class="input-group mb-3">
					<input
						type="password"
						id="password"
						class="form-control"
						placeholder="Password"
						v-model="user.password"
						required
					/>
				</div>
				<button class="login-btn">
					Login
				</button>
				<router-link :to="{ name: 'register' }"><button class="btn btn-block btn-secondary rounded-pill mt-3">Need an account?</button></router-link>
			</div>
		</form>
	</div>
</template>

<script>
import authService from '../services/AuthService';
import classService from '../services/ClassService';
import memberService from '../services/MemberService';

export default {
	name: 'login',
	components: {},
	data() {
		return {
			user: {
				username: '',
				password: '',
			},
			invalidCredentials: false,
		};
	},
	methods: {
		login() {
			authService
				.login(this.user)
				.then((response) => {
					if (response.status == 200) {
						this.$store.commit('SET_AUTH_TOKEN', response.data.token);
						this.$store.commit('SET_USER', response.data.user);
						memberService.getMember().then((response) => {
							if (!response.data) {
								this.$router.push('/accountDetails');
							} else {
								this.$store.commit('SET_MEMBER',response.data);
							}
						});
						classService.getRegisteredClasses().then(response => {
							this.$store.commit('SET_REGISTERED_CLASS_LIST',response.data);
						})
						classService.getRegisteredClassIds().then(response => {
							this.$store.commit('SET_REGISTERED_IDS',response.data);
						})
						classService.getClasses().then(response => {
							this.$store.commit('SET_CLASS_LIST',response.data);
						})
						this.$router.push('/dashboard');
					}
				})
				.catch((error) => {
					const response = error.response;

					if (response.status === 401) {
						this.invalidCredentials = true;
					}
				});
		},
	},
};
</script>

<style scoped>
body {
	height: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
}

.text-center {
	display: flex;
	align-items: center;
	justify-content: center;
}

.form-signin {
	font-size: 20px;
	text-align: center;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.form-signin::before {
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
	background-position: center;
	opacity: 0.9;
	box-shadow: rgba(0, 229, 255, 0.279) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
}
#username, #password {
	width: 300px;
}
div.card.p-5{
	margin-top: 150px;
	background-position: center;
	word-wrap:normal;
	background-color: rgba(0, 229, 255, 0.1);
	box-shadow: rgba(0, 229, 255, 0.5) 0px 100px 100px -18px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
    border-radius: 5%;
	color: #fff;
}

.btn {
	background: #151515;
}
hr {
	border-bottom: solid white 5px;
}
.login-btn {
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
	width: 300px;
	height: 50px;
	font-size: 18px;
	text-shadow: 0 1px 0 rgb(0 0 0 / 40%);
	transition: box-shadow 0.15s ease, transform 0.15s ease;
}
.login-btn:hover {
	box-shadow: 0px 4px 8px rgb(45 35 66 / 40%),
		0px 7px 13px -3px rgb(45 35 66 / 30%), inset 0px -3px 30px #f700ff88;
	transform: translateY(-2px);
}
.login-btn:active {
	box-shadow: inset 0px 3px 7px #000000;
	transform: translateY(2px);
}
#login {
	font-family: Stencil;
}
</style>
