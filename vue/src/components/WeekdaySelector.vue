<template>
  <div>
    <ul class="menu" :style="{ left: positionToMove, sliderWidth }">
        <li v-for="link in links" :key="link.id" @click="sliderIndicator(link.id)" v-bind:class="link.id == selectedIndex ? 'active menu-link' : '' ">
              <div class="menu-link">{{ link.text }}</div>
        </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "weekday-selector",
  data() {
    return {
      sliderPosition: 0,
      selectedElementWidth: 0,
      selectedIndex: 0,
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

<style>
:root {
  --active-color: #ffee93;
  --link-text-color: #f1faee;
  --menu-background-color: #1d3557;
  --active-background-color: #132238;
}
/* ul */
.menu {
  padding: 0;
  margin: 0;
  position: relative;
  background-color: var(--menu-background-color);
  display:flex;
  border-radius: 4px;
  list-style-type: none;
  overflow: hidden;
  justify-content: space-evenly;
}
/* li */
.menu-item {
  display: inline-flex;
}
/* a */
.menu-link {
  padding: 0.75rem 1rem;
  display: inline-flex;
  align-items: center;
  color: var(--link-text-color);
  text-decoration: none;
}
.menu-link:hover,
.menu-link.active {
  color: var(--active-color);
  background-color: var(--active-background-color);
}
</style>
