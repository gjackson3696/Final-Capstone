<template>
<body class="main-container">
  <div class="main-header">
    <header class="header">
      <img class="small-logo" src="../assets/Small-logo.png" />
      <h2 class="h2-header">Syntax Line Up</h2>
    </header>
  </div>
  <div>
    <ul class="menu" :style="{ left: positionToMove, sliderWidth }">
        <li class="list-items" v-for="link in links" :key="link.id" @click="sliderIndicator(link.id)" v-bind:class="link.id == selectedIndex ? 'active menu-link' : '' ">
              <div class="menu-link">{{ link.text }}</div>
        </li>
    </ul>
  </div>
</body>
</template>

<script>
export default {
  name: "weekday-selector",
  data() {
    return {
      sliderPosition: 0,
      selectedElementWidth: 0,
      selectedIndex: 7,
      links: [
        {
          id: 0,
          text: "Sunday",
        },
        {
          id: 1,
          text: "Monday",
        },
        {
          id: 2,
          text: "Tuesday",
        },
        {
          id: 3,
          text: "Wednesday",
        },
        {
          id: 4,
          text: "Thursday",
        },
        {
          id: 5,
          text: "Friday",
        },
        {
          id: 6,
          text: "Saturday",
        },
        {
          id: 7,
          text: "All Week"
        }

      ],
    };
  },
  methods: {
    sliderIndicator(id) {
      this.selectedIndex = id;
      this.$store.state.weekdaySelector = id;
    },
  },
  computed: {
    positionToMove() {
      return this.sliderPosition + "px";
    },
    sliderWidth() {
      return this.selectedElementWidth + "px";
    },
  },
};
</script>

<style scoped>
.small-logo {
  position: relative;
  margin-left: 110px;
}
.h2-header{
  position: relative;
  color: white;
 display: flex;
 justify-content: center;
 font-size: 70px;
 text-shadow: 2px 2px purple;
 font-family: Stencil;
}
.main-container {
  position: relative;
	min-height: 100%;
	min-width: 100%;
	width: 100%;
	height: 100vh;
}
.main-container::before  {
	content: '';
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-image: linear-gradient(
      180deg,
      rgba(0, 0, 0, 0.5),
      rgba(0, 0, 0, 0.5)
    ),
    url('../assets/Schedule.jpg');
	background-position: top center;
	opacity: .9;
	box-shadow: rgba(0, 229, 255, 0.279) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, .3) 0px 18px 36px -18px inset;
}
.menu {
  padding: 1rem 1rem;
  margin-bottom: 340px;
  position: relative;
  display:flex;
  border-radius: 10px;
  list-style-type: none;
  overflow: hidden;
  justify-content: space-evenly;
  margin-left: 150px;
  margin-right: 150px;
}

.menu-link {
  position: relative;
  background-color: rgb(0, 195, 185);
  border-radius: 10px;
  font-size: 17px;
  color: rgb(0, 0, 0);
  padding: 0.8em 1.8em;
  cursor:pointer;
  user-select:none;
  text-align: center;
  text-decoration: none;
  cursor: pointer;
  transition-duration: 0.4s;
  -webkit-transition-duration: 0.4s;
  font-family: Stencil;
}
.menu-link:after {
  content: "";
  display: block;
  position: absolute;
  border-radius: 10px;
  left: 0;
  top:0;
  width: 100%;
  height: 100%;
  opacity: 0;
  transition: all 0.5s;
  box-shadow: 0 0 10px 40px rgb(2, 220, 205);
  
}
.menu-link:active:after {
  box-shadow: 0 0 0 0 rgb(2, 220, 205);
  position: absolute;
  border-radius: 10px;
  left: 0;
  top:0;
  opacity: 1;
  transition: 0s;
  border: 10px;
}
.menu-link:active{
  top: 1px;
 
}

.menu-link:hover{
  color:white;
  text-shadow: 1px 1px rgb(0, 255, 170);
  background-color: rgb(109, 0, 128);
  transition-duration: 0.1s;
}
</style>
