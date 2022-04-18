<template>
  <div id="app">
    
    <div id="nav">
      <!-- <router-link v-bind:to="$store.state.token === '' ? '/' : '/dashboard'">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'schedule' }">Schedule</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'workoutGoals' }">My Goals</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'accountDetails' }">Account Details</router-link>&nbsp;|&nbsp;
      <router-link v-if="$store.state.token === ''" v-bind:to="{ name: 'login' }">Login</router-link>
      <router-link v-if="$store.state.token != ''" v-bind:to="{ name: 'logout' }">Logout</router-link> -->
      <Sidebar />
    </div>
    <router-view />
  </div>
</template>

<script>
import Sidebar from './components/Sidebar.vue'
export default {
  components: { Sidebar },
  component: {
  Sidebar
  }
}
</script>

