<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'schedule' }">Schedule</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'workoutGoals' }">My Goals</router-link>>&nbsp;|&nbsp;
      <router-link v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{name: 'logWorkout'}">Log Workout</router-link>

    </div>
    <router-view />
  </div>
</template>
