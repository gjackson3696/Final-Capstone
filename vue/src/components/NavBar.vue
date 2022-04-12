<template>
  <div>
    <ul class="menu" :style="{left:positionToMove, sliderWidth}">
      <div>
        <li v-for="link in links" :key="link.id" @click:="sliderIndicator(link.id)" :ref="'menu-item_' + link.id">
          <a href="#" class="menu-link">
            <span>{{ link.text }}</span>
          </a>
        </li>
      </div>
    </ul>
  </div>
</template>

<script>
export default {
  name: "navbar",
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
      let element = this.$refs[`menu-item_${id}`][0];
      this.sliderPosition = element.offsetLeft;
      this.selectedElementWidth = element.offsetWidth;
      this.selectedIndex = id;
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
}

</script>

<style >
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
  display: inline-flex;
  border-radius: 4px;
  list-style-type: none;
  overflow: hidden;
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
/* icon */
.menu-icon {
  height: 1.5rem;
  width: 1.5rem;
  justify-content: center;
  align-items: center;
  display: inline-flex;
  margin-right: 0.2rem;
}
/* slider */
.menu-indicator {
  position: absolute;
  height: 0.25rem;
  background-color: var(--active-color);
  bottom: 0;
  left: 0;
  margin: auto;
  width: 3rem;
  transition: all ease 0.5s;
}
</style>
