<template>
  <div>
    <div class="class-card-container">
          <p class="class-items">Change to Add Generic Workout Photos or Icons ASK PRODUCT OWNER</p>
          <p class="class-items">Class name: {{ classItem.name }} </p>
          <p class="class-items">Instructor: {{ classItem.instructor }}  </p>
          <p class="class-items">Start Time: {{ classItem.time }} </p>
          <p class="class-items">Length of Class: {{ classItem.lengthMinutes }} mins.</p>
          <!-- add dynamic styling to the on click event to toggle between registered and unregister class="lightView, base-button, darkView" -->
          <button  @click="changeText">{{ button.text }}</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "class-card",
  data() {
    return {
      registeredMember: [],
      registered: false,
      button: {
        text: 'Register For Class'
      },
    }
  },
  computed: {
// compute registered changed based on weather or not the member id is in the registered members array
  },
      methods: {
      // registeredMemberId: function() {
      //   this.changeBtn = !this.changeBtn;
      //   this.button.text = this.changeBtn ? 'Register For Class' : 'Unregister Me';
      // }
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
