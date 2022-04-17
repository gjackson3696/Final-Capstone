<template>
  <div>
    <div class="class-card-container">
          <p class="class-items">Workout: {{ classItem.workout }} </p>
          <p class="class-items">Machine: {{ classItem.Machine }}  </p>
          <p class="class-items">Start Date: {{ classItem.Date }} </p>
          <p class="class-items">Start Time: {{ classItem.time }} </p>
          <p class="class-items">Heavy Weights: {{ classItem.time }} </p>
         <p class="class-items">Number Of Reps: {{ classItem.NumberOfReps }} </p>
  
          <button  @click="changeText">{{ button.text }}</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "class-card",
  data() {
    return {
      changeBtn: false,
      button: {
        text: 'Register For workout'
      },
    }
  },
      methods: {
      changeText: function() {
        this.changeBtn = !this.changeBtn;
        this.button.text = this.changeBtn ? 'Register For workout' : 'Unregister workout';
      }
  },

  props: [ 'classItem' ],   
  
};
</script>

<style>
.class-card-container {
  border: 5px solid rgb(90, 153, 255);
  border-radius: 20px;
  width: 250px;
  height: 270px;
  margin:10px;
  text-align: center;
}

.base-button{
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

