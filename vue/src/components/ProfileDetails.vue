<template>
  <div class="main-div">
    <img
      id="logo"
      src="../assets/Small-logo.png"
      alt="CrossFit Syntactical Logo"
    />
    <div id="profile-header">
      <h1>Edit Profile Information</h1>
    </div>
    <div id="profile-form">
      <form class="profile" v-on:submit.prevent="save">
        <div class="profile-info">
          <label for="firstName">First Name:</label>
          <br />
          <input
            type="text"
            name="firstName"
            v-model="member.firstName"
            placeholder="First Name"
            size="50"
            required
          />
          <br />
          <label for="lastName">Last Name:</label>
          <br />
          <input
            type="text"
            name="lastName"
            v-model="member.lastName"
            placeholder="Last Name"
            size="50"
            required
          />
          <br />
          <label for="email">Email:</label>
          <br />
          <input
            type="text"
            name="email"
            v-model="member.email"
            placeholder="Email"
            size="50"
            required
          />
          <br />
        </div>
        <div>
        <button class="btn btn-primary" type="button" @click="save">Save</button>
      </div>
      </form>
      
    </div>
    <div id="maximums-header">
      <h3>Enter Your One Rep Max for Each Movement:</h3>
    </div>
    <div id="form-container">
      <form
        id="frmSaveBenchmarkMovements"
        v-on:submit.prevent="saveBenchmarkMovements"
      >
        <div id="squats">
          <div id="squats">
            <div>
              <h5>Squat Profile</h5>
              <label for="backSquat">Back Squat</label>
              <input
                type="text"
                name="backSquat"
                v-model="benchmarkMovements.backSquat"
                placeholder="Back Squat"
                size="30"
              />
            </div>
            <div>
              <label for="frontSquat">Front Squat</label>

              <input
                type="text"
                name="frontSquat"
                v-model="benchmarkMovements.frontSquat"
                placeholder="Front Squat"
                size="30"
              />
            </div>
            <div>
              <label for="zercherSquat">Zercher Squat</label>

              <input
                type="text"
                name="zercherSquat"
                v-model="benchmarkMovements.zercherSquat"
                placeholder="Zercher Squat"
                size="30"
              />
            </div>
            <div>
              <label for="overheadSquat">Overhead Squat</label>

              <input
                type="text"
                name="overheadSquat"
                v-model="benchmarkMovements.overheadSquat"
                placeholder="Overhead Squat"
                size="30"
              />
            </div>
            <div>
              <label for="bulgarianSplitSquat">Bulgarian Split Squat</label>

              <input
                type="text"
                name="bulgarianSplitSquat"
                v-model="benchmarkMovements.bulgarianSplitSquat"
                placeholder="Bulgarian Split Squat"
                size="30"
              />
            </div>
          </div>
        </div>
        <div id="deadlifts">
          <div>
            <div>
              <h5>Deadlift Profile</h5>
              <label for="conventionalDeadlift">Conventional Deadlift</label>

              <input
                type="text"
                name="conventionalDeadlift"
                v-model="benchmarkMovements.conventionalDeadlift"
                placeholder="Conventional Deadlift"
                size="30"
              />
            </div>
            <div>
              <label for="sumoDeadlift">Sumo Deadlift</label>

              <input
                type="text"
                name="sumoDeadlift"
                v-model="benchmarkMovements.sumoDeadlift"
                placeholder="Sumo Deadlift"
                size="30"
              />
            </div>
          </div>
        </div>
        <div id="presses">
          <div>
            <h5>Pressing Profile</h5>
            <div>
              <label for="overheadPress">Overhead Press</label>

              <input
                type="text"
                name="overheadPress"
                v-model="benchmarkMovements.overheadPress"
                placeholder="Overhead Press"
                size="30"
              />
            </div>
            <div>
              <label for="militaryPress">Military Press</label>

              <input
                type="text"
                name="militaryPress"
                v-model="benchmarkMovements.militaryPress"
                placeholder="Military Press"
                size="30"
              />
            </div>
            <div>
              <label for="pushPress">Push Press</label>

              <input
                type="text"
                name="pushPress"
                v-model="benchmarkMovements.pushPress"
                placeholder="Push Press"
                size="30"
              />
            </div>
          </div>
        </div>

        <div id="olympic">
          <div>
            <h5>Olympic Lifting Profile</h5>
            <div>
              <label for="squatClean">Squat Clean</label>

              <input
                type="text"
                name="squatClean"
                v-model="benchmarkMovements.squatClean"
                placeholder="Squat Clean"
                size="30"
              />
            </div>
            <div>
              <label for="powerClean">Power Clean</label>

              <input
                type="text"
                name="powerClean"
                v-model="benchmarkMovements.powerClean"
                placeholder="Power Clean"
                size="30"
              />
            </div>
            <div>
              <label for="cleanJerk">Clean & Jerk</label>

              <input
                type="text"
                name="cleanJerk"
                v-model="benchmarkMovements.cleanJerk"
                placeholder="Clean & Jerk"
                size="30"
              />
            </div>
            <div>
              <label for="splitJerk">Split Jerk</label>

              <input
                type="text"
                name="splitJerk"
                v-model="benchmarkMovements.splitJerk"
                placeholder="Split Jerk"
                size="30"
              />
            </div>
            <div>
              <label for="pushJerk">Push Jerk</label>

              <input
                type="text"
                name="pushJerk"
                v-model="benchmarkMovements.pushJerk"
                placeholder="Push Jerk"
                size="30"
              />
            </div>
            <div>
              <label for="squatJerk">Squat Jerk</label>

              <input
                type="text"
                name="squatJerk"
                v-model="benchmarkMovements.squatJerk"
                placeholder="Squat Jerk"
                size="30"
              />
            </div>
            <div>
              <label for="squatSnatch">Squat Snatch</label>

              <input
                type="text"
                name="squatSnatch"
                v-model="benchmarkMovements.squatSnatch"
                placeholder="Squat Snatch"
                size="30"
              />
            </div>
            <div>
              <label for="powerSnatch">Power Snatch</label>

              <input
                type="text"
                name="powerSnatch"
                v-model="benchmarkMovements.powerSnatch"
                placeholder="Power Snatch"
                size="30"
              />
            </div>
            <div>
              <label for="snatchBalance">Snatch Balance</label>

              <input
                type="text"
                name="snatchBalance"
                v-model="benchmarkMovements.snatchBalance"
                placeholder="Snatch Balance"
                size="30"
              />
            </div>
          </div>
        </div>
        <div>
          <button type="submit" class="btn btn-primary">Save Profile</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import memberService from "../services/MemberService.js";
import profileService from "../services/ProfileService.js";

export default {
  name: "profile-details",
  data() {
    return {
      member: {
        firstName: "",
        lastName: "",
        email: "",
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
      },
    };
  },
  methods: {
    save() {
      memberService.update(this.member);
      this.$store.commit("SET_MEMBER", this.member);
    },
    saveBenchmarkMovements() {
      profileService.update(this.benchmarkMovements);
    },
  },
  created() {
    memberService.getMember().then((response) => {
      if (response.data.length == 0) {
        memberService.create(this.member);
      } else {
        this.member = response.data;
      }
    });
    profileService.getProfile().then((response) => {
      if (response.data.length == 0) {
        profileService.create(this.benchmarkMovements);
      } else {
        this.benchmarkMovements = response.data;
      }
    });
  },
};
</script>

<style scoped>
body {
  position: relative;
}

#logo {
  position: absolute;
  max-width: 100px;
  top: 0;
  right: 0;
}

h1,
h2,
h3,
h4,
h5,
p,
label {
  color: white;
  font-family: Stencil;
  text-shadow: 1px 1px black;
}

.main-div {
  position: relative;
  display: grid;
  grid-template-areas:
    ". profile-header profile-header ."
    ". profile profile ."
    ". maximums-header maximums-header ."
    ". movementsForm movementsForm .";
  padding: 30px;
}
.profile-info {
  text-shadow: 1px 1px black;
  margin-left: 140px;
  width: 500px;
  height: 200px;
  position: relative;
  border-radius: 10px;
  text-align: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: rgba(0, 229, 255, 0.788) 0px 30px 100px -12px inset,
    rgb(1, 183, 255) 0px 18px 36px -18px inset;
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

.btn.btn-primary {
  position: relative;
  display: flex;
  width: 750px;
  justify-content: center;
  font-family: Stencil;
  align-items: center;
  margin-top: 30px;
}

.btn {
  position: relative;
  color: rgb(20, 255, 247);
  display: inline-block;
  outline: 0;
  border: 0;
  cursor: pointer;
  will-change: box-shadow, transform;
  background: radial-gradient(100% 100% at 100% 0%, #03ffc0f3 0%, #00e0fe 100%);
  box-shadow: 0px 2px 4px rgb(45 35 66 / 40%),
    0px 7px 13px -3px rgb(45 35 66 / 30%),
    inset 0px -3px 0px rgb(58 65 111 / 50%);
  margin: 10px;
  border-radius: 6px;
  color: rgb(0, 0, 0);
  width: 410px;
  height: 60px;
  font-size: 18px;
  text-shadow: 0 1px 0 rgb(0 0 0 / 40%);
  transition: box-shadow 0.15s ease, transform 0.15s ease;
}
.btn:hover {
  box-shadow: 0px 4px 8px rgb(45 35 66 / 40%),
    0px 7px 13px -3px rgb(45 35 66 / 30%), inset 0px -3px 30px #f700ff;
  transform: translateY(-2px);
}
.btn :active {
  box-shadow: inset 0px 3px 7px #000000;
  transform: translateY(2px);
}

#form-container {
  grid-area: movementsForm;
}

#frmSaveBenchmarkMovements > .btn {
  width: 260px;
}

#frmSaveBenchmarkMovements {
  display: flex;
  justify-content: center;
  flex-direction: row;
  flex-wrap: wrap;
  margin: 0px 60px 0px 60px;
}
#olympic {
  position: relative;
  border-radius: 10px;
  height: 550px;
  width: 17.5rem;
  text-align: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
    rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#squats {
  position: relative;
  border-radius: 10px;
  height: 350px;
  width: 17.5rem;
  text-align: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
    rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#presses {
  position: relative;
  border-radius: 10px;
  height: 350px;
  width: 17.5rem;
  text-align: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
    rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
#deadlifts {
  position: relative;
  border-radius: 10px;
  height: 350px;
  width: 17.5rem;
  text-align: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: rgba(0, 229, 255, 0.733) 0px 30px 100px -12px inset,
    rgb(1, 183, 255) 0px 18px 36px -18px inset;
}
</style>