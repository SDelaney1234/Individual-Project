import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/components/Home'
import CreateAccount from '@/components/CreateAccount'
import ViewAccounts from '@/components/ViewAccounts'
import EditAccount from '@/components/EditAccount'

//IMPORT ALL COMPONENTS FROM COMPONENTS

Vue.use(Router)

export default new Router({
  routes:[
    {
      path: "/",
      name: 'Home',
      component: Home
    },
    {
      path: "/CreateAccount",
      name: 'CreateAccount',
      component: CreateAccount
    },
    {
      path: "/ViewAccounts",
      name: 'ViewAccounts',
      component: ViewAccounts
    },
    {
      path: "/EditAccount",
      name: 'EditAccount',
      component: EditAccount
    }
  ]
})
