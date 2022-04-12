<template>
  <div>
    <div>{{ classItem.id }} {{ classItem.name }}  {{ classItem.instructor }}  {{ classItem.date }}  {{ classItem.startTime }} {{ classItem.lengthInMinuets }} 

    </div>
   <div> 
      {{Calendar}}
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

<style></style>
