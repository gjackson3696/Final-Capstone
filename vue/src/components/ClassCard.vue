<template>
  <div class="class-card">
    <div :class="[registered ? 'purple-container' : 'blue-container']">
      <h5 class="class-items">{{ classItem.name }}</h5>
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
  width: 300px;
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
  background-color: rgba(0, 229, 255, 0.279);
	box-shadow: rgba(0, 229, 255, 0.279) 0px 100px 100px 75px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px 75px inset;
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
  width: 300px;
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
	width: 250px;
	height: 50px;
	font-size: 18px;
	text-shadow: 0 1px 0 rgb(0 0 0 / 40%);
	transition: box-shadow 0.15s ease, transform 0.15s ease;
    font-family: Stencil;
}
.register-btn:hover {
	box-shadow: 0px 4px 8px rgb(45 35 66 / 40%),
		0px 7px 13px -3px rgb(45 35 66 / 30%), inset 0px -3px 30px #f700ff88;
	transform: translateY(-2px);
}
.register-btn:active {
	box-shadow: inset 0px 3px 7px #000000;
	transform: translateY(2px);
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
