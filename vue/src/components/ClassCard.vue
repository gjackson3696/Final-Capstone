<template>
  <div>
    <div :class="[registered ? 'purple-container' : 'blue-container']">
      <!-- <p class="class-items">
        Change to Add Generic Workout Photos or Icons ASK PRODUCT OWNER
      </p> -->
      <p class="class-items">Class name: {{ classItem.name }}</p>
      <p class="class-items">Instructor: {{ classItem.instructor }}</p>
      <p class="class-items">Start Time: {{ classItem.time }}</p>
      <p class="class-items">Length of Class: {{ classItem.lengthMinutes }} mins.</p>

      <button class="register-btn"  @click="toggleRegistration(classItem.id)" v-if="$store.state.token != ''">
        {{ registered ? "Unregister" : "Register" }}
      </button>
    </div>
  </div>
</template>

<script>
import classService from "../services/ClassService.js";
export default {
  name: "class-card",
  data() {
    return {

    };
  },
  computed: {
    registered() {
      return this.$store.state.registeredClassIds.includes(this.classItem.id) && this.$store.state.token !== '';
    },
  },
  methods: {
    toggleRegistration(classId) {
      if (!this.registered) {
        classService.registerForClass(classId);
        this.$store.commit("REGISTER_CLASS", classId);
      } else {
        classService.unregisterForClass(classId);
        this.$store.commit("UNREGISTER_CLASS", classId);
      }
    },
  },

  props: ["classItem"],
};
</script>

<style scoped>
.blue-container {
  position: relative;
  border-radius: 20px;
  width: 250px;
  height: 300px;
  margin: 10px;
  text-align: center;
  font-weight: bold;
  border: 3px solid purple;
}
  

.blue-container:before{
	content: '';
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(0, 229, 255, 0.279) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
  border-radius: 5%;
  
}
.blue-container > .class-items {
  margin-top: 20px;
  position: relative;
  color: white;
}
.purple-container {
  position: relative;
  border-radius: 20px;
  width: 250px;
  height: 300px;
  margin: 10px;
  text-align: center;
  font-weight: bold;
  border: 3px solid rgb(7, 247, 255)
  
}
.purple-container:before{
	content: '';
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	box-shadow: rgba(255, 0, 234, 0.279) 0px 100px 100px -12px inset,
		rgba(213, 1, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
  border-radius: 5%;
}
.purple-container > .class-items {
  margin-top: 20px;
  position: relative;
  color: white;
}
.register-btn {
  margin-left: 130px;
  margin-top: 40px;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 200px;
  height: 40px;
  text-align: center;
  color: rgb(0, 0, 0);
  font-size: 24px;
  font-family: Stencil;
  text-transform: uppercase;
  text-decoration: none;
  font-family: sans-serif;
  box-sizing: border-box;
  background: linear-gradient(90deg, rgb(0, 238, 255), rgb(0, 225, 255), rgb(247, 0, 255), rgb(13, 223, 195));
  background-size: 400%;
  border-radius: 30px;
  z-index: 1;
  opacity: .7;
}
.register-btn:hover {
  animation: animate 8s linear infinite
}
@keyframes animate {
  0% {
    background-position: 0%
  }
  100% {
    background-position: 400%;
  }
}
.register-btn:before {
  content: "";
  position: absolute;
  top: -5px;
  left: -5px;
  right: -5px;
  bottom: -5px;
  z-index: -1;
  background: linear-gradient(45deg, #00d9ff, #d501ffd8, #2de0ff);
  background-size: 400%;
  border-radius: 40px;
  opacity: 0;
  transition: 0.5%;
}
.register-btn:hover:before{
  filter: blur(20px);
  opacity: 1;
  animation: animate 8s linear infinite;
}

.lightView {
  background-color: aquamarine;
  color: black;
}
.darkView {
  background-color: blueviolet;
  color: azure;
}
</style>