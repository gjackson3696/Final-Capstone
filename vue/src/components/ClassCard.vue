<template>
  <div>
    <div class="class-card-container">
      <p class="class-items">
        Change to Add Generic Workout Photos or Icons ASK PRODUCT OWNER
      </p>
      <p class="class-items">Class name: {{ classItem.name }}</p>
      <p class="class-items">Instructor: {{ classItem.instructor }}</p>
      <p class="class-items">Start Time: {{ classItem.time }}</p>
      <p class="class-items">Length of Class: {{ classItem.lengthMinutes }} mins.</p>

      <button @click="toggleRegistration(classItem.id)" v-if="$store.state.token != ''">
        {{ registered ? "Unregister From Class" : "Register For Class" }}
      </button>
    </div>
  </div>
</template>

<script>
import classService from "../services/ClassService.js";
export default {
  name: "class-card",
  data() {
    return {};
  },
  computed: {
    registered() {
      return this.$store.state.registeredClassIds.includes(this.classItem.id);
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
.class-card-container {
  position: relative;
  margin-left: 150px;
  border: 5px solid rgb(90, 153, 255);
  border-radius: 20px;
  width: 250px;
  height: 270px;
  margin: 10px;
  text-align: center;
}

.base-button {
  padding: 20px;
  border-color: red;
  border-radius: 20px solid black;
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
