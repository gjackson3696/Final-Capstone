<template>
  <div>
    <div class="class-card-container">
          <p class="class-items">Change to Add Generic Workout Photos or Icons ASK PRODUCT OWNER</p>
          <p class="class-items">Class name: {{ classItem.name }} </p>
          <p class="class-items">Instructor: {{ classItem.instructor }}  </p>
          <p class="class-items">Start Time: {{ classItem.time }} </p>
          <p class="class-items">Length of Class: {{ classItem.lengthMinutes }} mins.</p>
          <button>Register for Class</button>
    
    </div>
  </div>
</template>

<script>
export default {
  name: "schedule",
  data() {
    return {};
  },

  props: [ 'classItem' ],
  

};
</script>

<style>
.class-card-container {
  border: 5px solid rgb(90, 153, 255);
  border-radius: 10px;
  width: 250px;
  height: 270px;
  margin:10px;
  text-align: center;
}

</style>
