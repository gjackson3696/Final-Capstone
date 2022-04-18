<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      
      <div class="card shadow p-5">
        
       <h3 class="text-center text-uppercase mb-4">Please Sign In</h3>
     
      <hr>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
     
     
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>


      <label for="username" class="sr-only"></label>

      <div class="form-group">
            <label>Username</label>
            <input type="username"
            placeholder="Username"
            class="form-control">
          </div>

          <label for="Password">Password</label>
          <div class="input-group mb-3">
            <input
           type="password"
           name="password"
           id="password"
           class="form-control"
           placeholder="Enter Password"
           aria-label="Enter Password"
            aria-describedby="basic-addon2">
            <div class="input-group-append">
              </div>
              
            </div>
              <button class="btn btn-block btn-secondary rounded-pill mt-3">Login
              </button>
              <router-link :to="{ name: 'register' }">Need an account?</router-link> 
          </div>


           
  
    </form>
  </div>
  
</template>





<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>





<style scoped>
body {
  height: 100%;
}

.form-signin {
	background-image: url(../assets/goals_page.jpg);
    background-color: #151515;
    text-align: center;
    font-size: 20px;
    padding: 500px;
    text-align: center;
    background-repeat: no-repeat;
    background-position: center;
    height: 100%;
    margin-top: 50px;
    margin-bottom: 50px;

}
.btn {
  background: #151515;
  background : -webkit-linear-gradient(to right,)
}
body {

  background: -webkit-linear-gradient(
   
  );}
  hr {
  border-bottom: solid white 5px;}

</style>