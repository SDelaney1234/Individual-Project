import Vue from 'vue'
import Router from 'vue-router'

import App from './App.vue'
import Home from './components/Home.vue'
import CreateAccount from './components/CreateAccount.vue'
import ViewAccounts from './components/ViewAccounts.vue'
import EditAccount from './components/EditAccount.vue'

//IMPORT ALL COMPONENTS FROM COMPONENTS
Vue.config.productionTip = false

Vue.use(Router);

const router= new Router({
  routes:[
    {
      path: "/Home",
      component: Home
    },
    {
      path: "/CreateAccount",
      component: CreateAccount
    },
    {
      path: "/ViewAccounts",
      component: ViewAccounts
    },
    {
      path: "/EditAccount",
      name: "EditAccount",
      component: EditAccount
    }
  ]
})

const app= new Vue({
  el: '#app',
  router,
  render: h => h(App),
}).$mount('#app')
