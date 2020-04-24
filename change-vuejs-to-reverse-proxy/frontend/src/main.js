import Vue from 'vue';
import App from './App.vue';

import ListUser from './views/ListUser.vue';
import CreateUser from './views/CreateUser.vue';
import UpdateUser from './views/UpdateUser.vue';

import VueRouter from 'vue-router';
Vue.use(VueRouter);

Vue.config.productionTip = false;

const routes = [
  {
    path : '/', 
    component : ListUser
  },
  {
    path : '/users/create', 
    component : CreateUser
  },
  {
    path : '/users/:id/update', 
    component : UpdateUser
  }
];

const router = new VueRouter({
  routes: routes
});

new Vue({
  render: h => h(App),
  router : router /* add router */
}).$mount('#app')
