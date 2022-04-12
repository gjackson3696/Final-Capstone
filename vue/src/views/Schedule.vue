<template>
<div>
  <h2 class="calendar">Schedule of Classes</h2>
  <h3 class = "weekly-schedule"> weekly schedule of classes"
  <class v-bind:classItem="item" v-for="item in this.$store.state.classList" :key="item.id"/>
  <calendar />
</div>
</template>

<script>
import Class from '../components/Class.vue'
import Calendar from '../components/Calendar.vue'
export default {
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
</style>