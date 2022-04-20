<template>
  <div id="app">
    <div id="nav">
      <Sidebar />
    </div>
    <router-view />
  </div>
</template>

<script>
import Sidebar from './components/Sidebar.vue'
export default {
  components: { Sidebar },
  component: {
  Sidebar
  }
}
</script>