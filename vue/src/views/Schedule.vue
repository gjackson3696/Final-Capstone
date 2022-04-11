<template>
<div>
  <h2 class="calendar">Schedule of Classes</h2>
  <class v-bind:classItem="item" v-for="item in this.$store.state.classList" :key="item.id"/>
  
</div>
</template>

<script>
import Class from '../components/Class.vue'
export default {
      components: { Class },
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
</style>