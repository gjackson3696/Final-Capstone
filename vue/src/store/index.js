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
    weekdaySelector: 7,
    registeredClassIds: [],
    classList: [],
    member: {}
    },
  mutations: {
    //need a mutator that will mutate the memberId to populate it.
    //SET_MEMBER_ID takes in (state, memberId) going to sets state.memberId to memberId
    //figure out where to set the mutation.
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
    },
    REGISTER_CLASS(state,id) {
      state.registeredClassIds.push(id);
    },
    UNREGISTER_CLASS(state,id) {
      state.registeredClassIds = state.registeredClassIds.filter(element => element !== id);
    },
    SET_CLASS_IDS(state,ids) {
      state.registeredClassIds = ids;
    },
    RESET_WEEKDAY_SELECTOR(state) {
      state.weekdaySelector = 7;
    },
    SET_CLASS_LIST(state,classList) {
      state.classList = classList;
    },
    SET_MEMBER(state,member) {
      state.member = member;
    }
  }
})