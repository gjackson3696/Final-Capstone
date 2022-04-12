<template>
<div>
  <h2 class="calendar">Schedule of Classes</h2>
  <nav-bar />
  <div class="main">
  </div>
  <class-card v-bind:classItem="item" v-for="item in this.$store.state.classList" :key="item.id"/>
</div>
</template>

<script>
//create component that will filter through the classes and populate info through the id
//want to build classes in a filtered class list which will filter which day of the week has been selected 
//build class card components gets build in first component that filters through the classes based on date class' getDay() return 0-6 starting sunday. 
//filter based on id and display individual cards based on which ones are matching 

import ClassCard from '../components/ClassCard.vue'
import NavBar from '../components/NavBar.vue'
export default {
      name: "Schedule",
      components: { ClassCard, NavBar},

}

</script>

<style>
.calendar{
  text-align: center;
}

.tableCells {
  border: 1;
  padding: 2;
}
body {
  height: 100%;
}
body {
  font-family: "Roboto", sans-serif;
  display: flex;
  justify-content: left;
  align-items: center;
}
</style>
