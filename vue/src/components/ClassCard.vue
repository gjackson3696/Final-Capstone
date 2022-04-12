<template>
  <div>
<p>{{ classItem.id }} {{ classItem.name }}  {{ classItem.instructor }}  {{ classItem.date }}  {{ classItem.startTime }} {{ classItem.lengthInMinuets }} </p>
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

</style>
