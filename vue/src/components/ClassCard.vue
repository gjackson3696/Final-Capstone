<template>
  <div>
    <div class="class-card-container">
          <p class="class-items">Change to Add Generic Workout Photos or Icons ASK PRODUCT OWNER</p>
          <p class="class-items">Class name: {{ classItem.name }} </p>
          <p class="class-items">Instructor: {{ classItem.instructor }}  </p>
          <p class="class-items">Start Time: {{ classItem.time }} </p>
          <p class="class-items">Length of Class: {{ classItem.lengthMinutes }} mins.</p>
          <!-- add dynamic styling to the on click event to toggle between registered and unregister class="lightView, base-button, darkView" -->
   <button  @click="toggleRegistration($store.state.memberId, classItem.id)">{{ registered ? "Unregister From Class" : "Register For Class" }}</button>
          
    </div>
  </div>
</template>

<script>
import classService from '../services/ClassService.js';
export default {
  name: "class-card",
  data() {
    return {
      registeredMemberIds: []
    }
  },
  computed: {
    registered(){
      return this.registeredMemberIds.includes(this.$store.state.memberId);
    }
  },
      methods: {
         toggleRegistration(memberId, classId) {
            if (!this.registered){
              classService.registerForClass(memberId, classId);
                this.registeredMemberIds.push(memberId);   
            }
            else{
              classService.unregisterForClass(memberId, classId);
                const filteredIds = this.registeredMemberIds.filter(element => element !== memberId);
                this.registeredMemberIds = filteredIds;
          }
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
