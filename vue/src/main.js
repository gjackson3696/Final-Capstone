import Vue from 'vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import VueGoogleCharts from 'vue-google-charts'


Vue.use(VueGoogleCharts)

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
