<template>
  <form class="createdForm"> 
      <div>
            <label for="firstName" >First Name</label>
            <input for="firsName"  type="text"/>
      </div>
         <div class="createdForm">
            <label for="lastName" >Last Name</label>
            <input for="lastName"  type="text"/>
      </div>
         <div class="createdForm">
            <label for="email" >Email Address</label>
            <input for="email"  type="text"/>
      </div>
        <div class="createdForm">
            <label for="workoutGoal" >Workout Goals</label>
            <input for="workoutGoal"  type="text"/>
      </div>
        
           <div class="createdForm">
            <label for="workoutProfile" required>Workout Profile</label>
            <input for="workoutProfile"  type="text"/>
      </div>
  </form>
</template>

<script>
export default {
    name:'profile-details',
        data() {
            return {
                createdMember: {
                    firstName: "",
                    lastName: "", 
                    email: "",
                    workoutGoal: "",
                    workoutProfile: ""
                },
            }; 
        },
}
</script>

<style>

.createdForm {
    text-align: center;
    font-size: 20px;
      padding: 40px;
  border: 1px ;
  text-align: center;
}



</style>