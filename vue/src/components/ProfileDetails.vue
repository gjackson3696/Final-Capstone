<template>
  <div class="profile">
    <h2>Edit Profile Information</h2>
    <form class="profile">
      <label for="firstName">First Name:</label>
      <input type="text" name="firstName" v-model="member.firstName" placeholder="First Name" />
      <label for="lastName">Last Name:</label>
      <input type="text" name="lastName" v-model="member.lastName" placeholder="Last Name" />
      <label for="email">Email:</label>
      <input type="text" name="email" v-model="member.email" placeholder="Email" />
      <button type="submit">Save</button>
    </form>

  </div>
</template>

<script>
import memberService from '../services/MemberService.js';

export default {
  name:'profile-details',
  data() {
    return {
      member: {
        firstName: "",
        lastName: "", 
        email: ""
      }
    }; 
  },
  methods: {
      save() {
      }
  },
  created() {
      memberService.getMember().then(response => {
          this.member = response.data;
      })
  }
}
</script>

<style scoped>

.profile {
  text-align: center;
  font-size: 20px;
  padding: 40px;
  border: 1px ;
  text-align: center;
}

</style>