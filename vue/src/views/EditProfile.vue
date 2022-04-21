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
	position: relative;
	min-height: 100%;
	min-width: 100%;
	width: 100%;
	height: 100vh;
}
.main-container::before {
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
		url('../assets/profile-details.jpg');
	background-position: top center;
	opacity: 0.9;
	box-shadow: rgba(0, 229, 255, 0.466) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>