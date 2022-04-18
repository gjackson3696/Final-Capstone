<template>
  <div class="profile">
    <h2>Edit Profile Information</h2>
    <form class="profile" v-on:submit.prevent="save">
      <label for="firstName">First Name:</label>
      <input type="text" name="firstName" v-model="member.firstName" placeholder="First Name" />
      <label for="lastName">Last Name:</label>
      <input type="text" name="lastName" v-model="member.lastName" placeholder="Last Name" />
      <label for="email">Email:</label>
      <input type="text" name="email" v-model="member.email" placeholder="Email" />
      <button type="submit">Save</button>
    </form>
    <h3>Enter current max for individual movements (squats, olympic lifts, etc.)</h3>
    <h4>
      Enter one rep max for each movement
    </h4>
    <div id="form-container">
    <form
      id="frmSaveBenchmarkMovements"
      v-on:submit.prevent="saveBenchmarkMovements"
    >
      <div>
        <div id="squats">
          <h5>Squat Profile</h5>
          <input
            type="text"
            name="backSquat"
            v-model="benchmarkMovements.backSquat"
            placeholder="Back Squat"
          />
        </div>
        <div>
          <input
            type="text"
            name="frontSquat"
            v-model="benchmarkMovements.frontSquat"
            placeholder="Front Squat"
          />
        </div>
        <div>
          <input
            type="text"
            name="zercherSquat"
            v-model="benchmarkMovements.zercherSquat"
            placeholder="Zercher Squat"
          />
        </div>
        <div>
          <input
            type="text"
            name="overheadSquat"
            v-model="benchmarkMovements.overheadSquat"
            placeholder="Overhead Squat"
          />
        </div>
        <div>
          <input
            type="text"
            name="bulgarianSplitSquat"
            v-model="benchmarkMovements.bulgarianSplitSquat"
            placeholder="Bulgarian Split Squat"
          />
        </div>
      </div>

      <div id="deadlifts">
        <h5>Deadlift Profile</h5>
        <div>
          <input
            type="text"
            name="conventionalDeadlift"
            v-model="benchmarkMovements.conventionalDeadlift"
            placeholder="Conventional Deadlift"
          />
        </div>
        <div>
          <input
            type="text"
            name="sumoDeadlift"
            v-model="benchmarkMovements.sumoDeadlift"
            placeholder="Sumo Deadlift"
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
          />
        </div>
        <div>
          <input
            type="text"
            name="pushPress"
            v-model="benchmarkMovements.militaryPress"
            placeholder="Military Press"
          />
        </div>
        <div>
          <input
            type="text"
            name="pushPress"
            v-model="benchmarkMovements.pushPress"
            placeholder="Push Press"
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
          />
        </div>
        <div>
          <input
            type="text"
            name="powerClean"
            v-model="benchmarkMovements.powerClean"
            placeholder="Power Clean"
          />
        </div>
        <div>
          <input
            type="text"
            name="cleanJerk"
            v-model="benchmarkMovements.cleanJerk"
            placeholder="Clean & Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="splitJerk"
            v-model="benchmarkMovements.splitJerk"
            placeholder="Split Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="pushJerk"
            v-model="benchmarkMovements.pushJerk"
            placeholder="Push Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="squatJerk"
            v-model="benchmarkMovements.squatJerk"
            placeholder="Squat Jerk"
          />
        </div>
        <div>
          <input
            type="text"
            name="squatSnatch"
            v-model="benchmarkMovements.squatSnatch"
            placeholder="Squat Snatch"
          />
        </div>
        <div>
          <input
            type="text"
            name="powerSnatch"
            v-model="benchmarkMovements.powerSnatch"
            placeholder="Power Snatch"
          />
        </div>
        <div>
          <input
            type="text"
            name="snatchBalance"
            v-model="benchmarkMovements.snatchBalance"
            placeholder="Snatch Balance"
          />
        </div>
      </div>
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

.profile {
  text-align: center;
  font-size: 20px;
  padding: 40px;
  border: 1px ;
  text-align: center;
}

#frmSaveBenchmarkMovements {
  display: flex;
  flex-direction: row;
  align-content: space-between;
  gap: 10px;
}

#frmSaveBenchmarkMovements > .btn {
  position: absolute;
  bottom: 0;
  justify-content: center;
}

</style>