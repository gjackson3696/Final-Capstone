<template>
  <div class="main-container">
    <h2 class="calendar">Schedule of Classes</h2>
    <div>
    <select name="calender dropdown" id="btn"></select>
    <option value="Full Month Schedule">Full Month Schedule</option>
    <option value="Weekly Schedule">Weekly Schedule</option>
    <option value="2 Weeks ahead">2 Weeks ahead</option>
    </div>
        <weekday-selector />
        <div class="card-container">
          <class-card class="class-card" v-bind:classItem="item" v-for="item in classFilter" :key="item.id"/>
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
        return this.$store.state.weekdaySelector == classDate.getDay() || this.$store.state.weekdaySelector == 7;
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
  }
}
</script>

<style scoped>
#btn {
  display: grid;
  justify-content: center;
  margin: 1rem;
  align-items: center;
}


.calendar {
  display: grid;
  text-align: center;
  grid-area: schedule;
  min-height: 100px;
  padding: 4rem;
}

.tableCells {
  border: 1;
  padding: 2;
}
body {
  height: 100%;
}
body {
  display: grid;
  grid-auto-columns: 2fr 2fr 2fr;

}

.card-container {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    padding: 20px;
}

.class-card {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    padding: 20px;
}
</style>
