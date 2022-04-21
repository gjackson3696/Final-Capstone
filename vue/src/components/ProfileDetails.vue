<template>
  <div class="main-div">
    <div id="profile-header">
    <h1>Edit Profile Information</h1>
    </div>
    <div id="profile-form">
    <form class="profile" v-on:submit.prevent="save">
      <label for="firstName">First Name:</label>
      <br>
      <input type="text" name="firstName" v-model="member.firstName" placeholder="First Name" size=50 required />
      <br />
      <label for="lastName">Last Name:</label>
      <br>
      <input type="text" name="lastName" v-model="member.lastName" placeholder="Last Name" size=50 required />
      <br />
      <label for="email">Email:</label>
      <br>
      <input type="text" name="email" v-model="member.email" placeholder="Email" size=50 required />
      <br />
      <button type="submit">Save</button>
    </form>
    </div>
    <div id="maximums-header">
    <h3>
      Enter Your One Rep Max for Each Movement:
    </h3>
    </div>
    <div id="form-container">
    <form
      id="frmSaveBenchmarkMovements"
      v-on:submit.prevent="saveBenchmarkMovements"
    >
      <div id="squats">
        <div>
          <h5>Squat Profile</h5>
          <input
            type="text"
            name="backSquat"
            v-model="benchmarkMovements.backSquat"
            placeholder="Back Squat"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="frontSquat"
            v-model="benchmarkMovements.frontSquat"
            placeholder="Front Squat"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="zercherSquat"
            v-model="benchmarkMovements.zercherSquat"
            placeholder="Zercher Squat"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="overheadSquat"
            v-model="benchmarkMovements.overheadSquat"
            placeholder="Overhead Squat"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="bulgarianSplitSquat"
            v-model="benchmarkMovements.bulgarianSplitSquat"
            placeholder="Bulgarian Split Squat"
            size=30
          />
        </div>
      </div>

      <div id="deadlifts">
        <div>
        <h5>Deadlift Profile</h5>
          <input
            type="text"
            name="conventionalDeadlift"
            v-model="benchmarkMovements.conventionalDeadlift"
            placeholder="Conventional Deadlift"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="sumoDeadlift"
            v-model="benchmarkMovements.sumoDeadlift"
            placeholder="Sumo Deadlift"
            size=30
          />
        </div>
      </div>
      
      <div id="presses">
        <h5>Pressing Profile</h5>
        <div>
          <input
            type="text"
            name="overheadPress"
            v-model="benchmarkMovements.overheadPress"
            placeholder="Overhead Press"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="pushPress"
            v-model="benchmarkMovements.militaryPress"
            placeholder="Military Press"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="pushPress"
            v-model="benchmarkMovements.pushPress"
            placeholder="Push Press"
            size=30
          />
        </div>
      </div>

      <div id="olympic">
        <h5>Olympic Lifting Profile</h5>
        <div>
          <input
            type="text"
            name="squatClean"
            v-model="benchmarkMovements.squatClean"
            placeholder="Squat Clean"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="powerClean"
            v-model="benchmarkMovements.powerClean"
            placeholder="Power Clean"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="cleanJerk"
            v-model="benchmarkMovements.cleanJerk"
            placeholder="Clean & Jerk"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="splitJerk"
            v-model="benchmarkMovements.splitJerk"
            placeholder="Split Jerk"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="pushJerk"
            v-model="benchmarkMovements.pushJerk"
            placeholder="Push Jerk"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="squatJerk"
            v-model="benchmarkMovements.squatJerk"
            placeholder="Squat Jerk"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="squatSnatch"
            v-model="benchmarkMovements.squatSnatch"
            placeholder="Squat Snatch"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="powerSnatch"
            v-model="benchmarkMovements.powerSnatch"
            placeholder="Power Snatch"
            size=30
          />
        </div>
        <div>
          <input
            type="text"
            name="snatchBalance"
            v-model="benchmarkMovements.snatchBalance"
            placeholder="Snatch Balance"
            size=30
          />
        </div>
      </div>
      <br>
      <button type="submit" class="btn btn-primary">Save Profile</button>
    </form>
    </div>
  </div>
</template>

<script>
import memberService from '../services/MemberService.js';
import profileService from '../services/ProfileService.js';

export default {
  name:'profile-details',
  data() {
    return {
      member: {
        firstName: "",
        lastName: "", 
        email: ""
      },
      benchmarkMovements: {
        backSquat: "",
        frontSquat: "",
        zercherSquat: "",
        overheadSquat: "",
        bulgarianSplitSquat: "",
        conventionalDeadlift: "",
        sumoDeadlift: "",
        overheadPress: "",
        militaryPress: "",
        pushPress: "",
        squatClean: "",
        powerClean: "",
        cleanJerk: "",
        splitJerk: "",
        pushJerk: "",
        squatJerk: "",
        squatSnatch: "",
        powerSnatch: "",
        snatchBalance: "",
      }
    }; 
  },
  methods: {
      save() {
          memberService.update(this.member);
          this.$store.commit('SET_MEMBER',this.member);
      },
      saveBenchmarkMovements() {
          profileService.update(this.benchmarkMovements);
      }
  },
  created() {
      memberService.getMember().then(response => {
          if(response.data.length == 0) {
              memberService.create(this.member);
          } else {
              this.member = response.data;
          }
      });
      profileService.getProfile().then(response => {
          if(response.data.length == 0) {
              profileService.create(this.benchmarkMovements);
          } else {
              this.benchmarkMovements = response.data;
          }
      });
  }
}
</script>

<style scoped>
body {
  position: relative;
}

h1, h2, h3, h4, h5, p, label {
  color: white;
  font-family: Stencil;
}

.main-div {
  display: grid;
  grid-template-rows: 5% 20% 5% 60%;
  grid-template-areas:
    ". profile-header profile-header ."
    ". profile profile ."
    ". maximums-header maximums-header ."
    ". movementsForm movementsForm .";
}

#profile-header {
  grid-area: profile-header;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

#profile-form {
  grid-area: profile;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 0 auto 20px auto;
}

#maximums-header {
  grid-area: maximums-header;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

#form-container {
  grid-area: movementsForm;
  display: flex;
  flex-direction: row;
  justify-content: center;
}


</style>