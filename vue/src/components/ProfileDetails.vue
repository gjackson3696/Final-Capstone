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
            <button type="button" class="btn btn-light" onclick="window.location='localhost:8080/workoutGoals'">Enter goals for yourself to track benchmarks and measure progress!</button>
      </div>
        
           <div class="createdForm">
            <button type="button" class="btn btn-light">View your fitness profile.</button>
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

<style scoped>

.createdForm {
    text-align: center;
    font-size: 20px;
      padding: 40px;
  border: 1px ;
  text-align: center;
}



</style>