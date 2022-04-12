<template>
<div>
  <h2 class="calendar">Schedule of Classes</h2>
  <calendar />
  <div class="main">
  </div>
  <class v-bind:classItem="item" v-for="item in this.$store.state.classList" :key="item.id"/>

</div>
</template>

<script>
import Class from '../components/Class.vue'
import Calendar from '../components/Calendar.vue'
export default {
      name: "Schedule",
      components: { Class, Calendar },


}

</script>

<style scoped>
.calendar{
  text-align: center;
}

.tableCells {
  border: 1;
  padding: 2;
}
