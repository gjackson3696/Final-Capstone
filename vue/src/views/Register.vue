<template>
<div class="background">
  <img id="logo" src="../assets/Small-logo.png" alt="Small CrossFit Syntactical logo">
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        size=30
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        size=30
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        size=30
        v-model="user.confirmPassword"
        required
      />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      <br>
      <router-link :to="{ name: 'login' }">Have an account?</router-link>


    </form>
  </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    this.$router.push({name: 'accountDetails'});

    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>


<style scoped>
.background {
  background-image: linear-gradient(180deg, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url(../assets/register.jpg);
    background-position: 0px 0px, 50% 50%;
    background-size: auto, cover;
    background-attachment: scroll, fixed;
    box-shadow: rgb(0 229 255 / 35%) 0px 100px 100px -12px inset, rgb(1 187 255 / 30%) 0px 18px 36px -18px inset;
}

#logo {
  position: absolute;
  max-width: 100px;
  top: 0;
  right: 0;
}

.form-register {
  font-family: Stencil;
    color: white;
    text-align: center;
    font-size: 20px;
    padding: 100px;
    text-align: center;
}

.text-center {
    text-align: center;
    font-size: 20px;
      padding: 100px;
  border: 1px ;
  text-align: center;
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

body {
font-family: Stencil;
}
input[type=text], select {
padding: 5px 0px;
margin-left: auto;
margin-right: auto;
display: list-item;
margin-bottom: 1rem;
border: 4px double #39A9DB;
border-radius: 8px;
box-sizing: border-box;
cursor: pointer;
}
input[type=password] {
display: list-item;
padding: 5px 0px;
margin-left: auto;
margin-right: auto;
border: 4px double #39A9DB;
border-radius: 8px;
box-sizing: border-box;
cursor: pointer;
margin-bottom: 1rem;
}
div.container {
border-radius: 10px;
background-color: #39A9DB;
padding: 40px;
}
</style>


