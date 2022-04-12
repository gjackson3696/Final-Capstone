<template>
  <div>
    <div class="class-card">{{ classItem.id }} {{ classItem.name }}  {{ classItem.instructor }}  {{ classItem.date }}  {{ classItem.startTime }} {{ classItem.lengthInMinuets }} 

    </div>
  </div>
</template>

<script>
export default {
  name: "schedule",
  data() {
    return {};
  },

  props: [ 'classItem' ],
  

};
</script>

<style>
.class-card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

</style>
