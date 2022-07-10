import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import '@/assets/style/mystyle.css'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import Barrage from 'vue-custom-barrage';

Vue.config.productionTip = false

Vue.use(Barrage)
Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
