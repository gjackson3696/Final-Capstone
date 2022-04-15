<template>
  <div>
    <h2 class="calendar">Schedule of Classes</h2>
        <weekday-selector @click="getClassList"/>
        <div class="card-container">
          <class-card class="class-card" v-bind:classItem="item" v-for="item in classFilter" :key="item.id" />
        </div>
    </div>
</template>

<script>
import ClassCard from "../components/ClassCard.vue";
import WeekdaySelector from "../components/WeekdaySelector.vue";
import classService from "../services/ClassService.js";
export default {
  name: "Schedule",
  data(){
    return {
      classList: []
    }
  },
  components: { ClassCard, WeekdaySelector},
  computed: {
    classFilter() {
      return this.classList.filter((classItem) => {
        const classDate = new Date(classItem.date);
        return this.$store.state.weekdaySelector == classDate.getDay();
      })
    }
  },
  methods: {
    getClassList() {
      classService.getClasses().then(response => {
        this.classList = response.data;
      })
    }
  },
  created() {
    this.getClassList();
    this.$store.state.registeredClassIds = classService.getRegisteredClasses(this.$store.state.memberId).then(response => {
      this.$store.commit('SET_CLASS_IDS',response.data);
    })
  }
}
</script>

<style scoped>
.calendar {
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

.card-container {
  display: flex;
  flex-direction: row;
}
</style>
