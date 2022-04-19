<template>
  <div class="main-container">
      <profile-details />
  </div>
</template>

<script>
import ProfileDetails from '../components/ProfileDetails.vue'
export default {
  components: { ProfileDetails },

}
</script>

<style scoped>
.main-container {
  background-image: linear-gradient(
			180deg,
			rgba(0, 0, 0, 0.5),
			rgba(0, 0, 0, 0.5)
		),
		url('../assets/profile-details.jpg');
}
</style>