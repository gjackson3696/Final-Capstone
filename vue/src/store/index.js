import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}
export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    classList: [{
        id: "0",
        name: "High Intensity",
        instructor: "Gary",
        //need to hook up to the backend in order to get the right date displaying.
        date: "12/12/22",
        startTime: "1600",
        lengthInMinutes: "60"
      },
      {
        id: "1",
        name: "Yoga",
        instructor: "Alex",
        date: "12/12/22",
        startTime: "1600",
        lengthInMinutes: "60"
      },
      {
        id: "2",
        name: "The Power Building",
        instructor: "Semir",
        date: "12/12/22",
        startTime: "1600",
        lengthInMinutes: "90"
      },
      {
        id: "3",
        name: "Show Me How To Run ",
        instructor: "Luke",
        date: "12/12/22",
        startTime: "1600",
        lengthInMinutes: "90"
      },
      {
        id: "4",
        name: "Coding Core Workout",
        instructor: "Scrum Lord Matt",
        date: "12/12/22",
        startTime: "1600",
        lengthInMinutes: "60"
      }
    ],
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})