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
				<button class="btn btn-block btn-secondary rounded-pill mt-3">
					Login
				</button>
				<router-link :to="{ name: 'register' }">Need an account?</router-link>
			</div>
		</form>
	</div>
</template>

<script>
import authService from '../services/AuthService';
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

div.card.p-5{
	margin-top: 150px;
  background-image: linear-gradient(
			180deg,
			rgba(0, 0, 0, 0.5),
			rgba(0, 0, 0, 0.5)
		);
	background-position: center;
	box-shadow: rgba(0, 229, 255, 0.281) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	min-width: 350px;
	word-wrap:normal;
}

.btn {
	background: #151515;
	/* background: -webkit-linear-gradient(to right); */
}
body {
	/* background: -webkit-linear-gradient(); */
}
hr {
	border-bottom: solid white 5px;
}
</style>
