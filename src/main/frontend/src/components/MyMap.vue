<template>

  <div style="height: 500px;">
    <l-map
      :zoom="zoom"
      :center="center"
      :options="mapOptions"
      class="my-map"
      ref="myMap"
    >
      <l-tile-layer
        :url="url"
        :attribution="attribution"
      />
      <l-marker v-for="marker in markerDetails" :key="marker.id"
          :lat-lng="marker.location"
          :radius="marker.radius"
          :color="marker.color"
          :fillColor="marker.fillColor"
          :fillOpacity="marker.fillOpacity"
      >
        <l-tooltip :options="tooltipOptions">{{marker.tooltip}}</l-tooltip>
      </l-marker>
    </l-map>
  </div>
</template>

<script>
import { L, Icon, latLng } from "leaflet";
import { LMap, LTileLayer, LMarker, LPopup, LTooltip } from "vue2-leaflet";

//fix map icons
delete Icon.Default.prototype._getIconUrl;
Icon.Default.mergeOptions({
  iconRetinaUrl: require('leaflet/dist/images/marker-icon-2x.png'),
  iconUrl: require('leaflet/dist/images/marker-icon.png'),
  shadowUrl: require('leaflet/dist/images/marker-shadow.png'),
});

export default {
  name: "Mymap",
  components: {
    LMap,
    LTileLayer,
    LMarker,
    LPopup,
    LTooltip
  },
  data() {
    return {
      zoom: 13,
      center: latLng(47.41322, -1.219482),
      url: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      attribution:
        '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      withPopup: latLng(47.41322, -1.219482),
      withTooltip: latLng(47.41422, -1.250482),
      currentZoom: 11.5,
      currentCenter: latLng(47.41322, -1.219482),
      showParagraph: false,
      mapOptions: {
        zoomSnap: 0.5
      },
      markerDetails: [],
      tooltipOptions: {  permanent: true }
    };
  },
  methods: {
    addMarker(datapoint) {
      this.$refs.myMap.mapObject.panTo(datapoint)
      this.markerDetails.push({
        id: this.markerDetails.length,
        location: datapoint,
        radius: 10,
        color: Math.random() > 0.5 ? 'red' : 'blue',
        fillColor: '#f03',
        fillOpacity: Math.random(),
        tooltip: "Value: " + datapoint.value,
        permanenttip: true
      });
    },
    deleteMarker() {
      this.markerDetails.shift();
    }
  }
};
</script>
