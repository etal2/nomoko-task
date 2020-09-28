import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
//import store from './store'
//import { LMap, LTileLayer, LMarker } from 'vue2-leaflet'
import 'leaflet/dist/leaflet.css'

Vue.config.productionTip = false;

// Map components
/*Vue.component('l-map', LMap);
Vue.component('l-tile-layer', LTileLayer);
Vue.component('l-marker', LMarker);*/

// Bootstrap
Vue.use(BootstrapVue);

new Vue({
    router,
    //store,
    render: h => h(App)
}).$mount('#app');

