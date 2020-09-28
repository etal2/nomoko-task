<template>
  <b-container class="main">
    <b-form novalidate>
      <b-row class="my-1">
        <b-col sm="2">
            <b-form-group
              label="Latitude:"
              label-for="latinp"
            >
              <b-form-input id="latinp" v-model="lat" :state="latvalidation" type="text"></b-form-input>
              <b-form-invalid-feedback :state="latvalidation">
              Must be a valid latitude value
              </b-form-invalid-feedback>
            </b-form-group>
        </b-col>
        <b-col sm="2">
          <b-form-group
              label="Longitude:"
              label-for="loninp"
            >
            <b-form-input id="loninp" v-model="lon" :state="lonvalidation" type="text"></b-form-input>
            <b-form-invalid-feedback :state="lonvalidation">
              Must be a valid longitude value
            </b-form-invalid-feedback>
          </b-form-group>
        </b-col>
        <b-col sm="2">
          <b-button variant="primary" @click="callGetValue()">Estimate Value</b-button>
        </b-col>
      </b-row>
    </b-form>
    <mymap ref="map"></mymap>
  </b-container>
</template>

<script>
import api from "./backend-api";
import Mymap from "./MyMap";

export default {
  name: 'Homepage',
  /*props: { hellomsg: { type: String, required: true } }*/
  components: { 
    Mymap 
  },
  data () {
      return {
        lat: null,
        lon: null,
        forcevalidate: false
      }
  },
  computed: {
      latvalidation() {
        if(this.lat === null || this.lat.trim().length == 0){
          if(this.forcevalidate === false){
             return null
          } else {
            return false
          }
        } 
        if(isNaN(this.lat)) return false
        if(this.lat > 90 || this.lat < -90) return false
        return true
      },
      lonvalidation() {
        if(this.lon === null || this.lon.trim().length == 0){
          if(this.forcevalidate === false){
             return null
          } else {
            return false
          }
        }
        if(isNaN(this.lon)) return false;
        if(this.lon > 180 || this.lon < -180) return false;
        return true;
      }
  },
  methods: {
      callGetValue () {
        if(this.lonvalidation === null || this.latvalidation === null){
          this.forcevalidate = true
          return
        }
        if(this.lonvalidation === true && this.latvalidation === true){
          this.forcevalidate = false
          api.getPropertyValue(this.lat, this.lon).then(response => {
              this.$refs.map.addMarker(response.data)
          })
          .catch(error => {
            //this.errors.push(error)
          })
        }
      }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
