import Vue from 'vue'
import router from '@/router'
import App from '@/App'
//import BootstrapVue from

//Vue.config.productionTip = false

//Vue.use(BootstrapVue)

new Vue({
  render: h=>h(App),
  router
}).$mount('#app')
