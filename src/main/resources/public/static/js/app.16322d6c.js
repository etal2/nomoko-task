(function(t){function e(e){for(var n,l,i=e[0],s=e[1],u=e[2],p=0,f=[];p<i.length;p++)l=i[p],Object.prototype.hasOwnProperty.call(o,l)&&o[l]&&f.push(o[l][0]),o[l]=0;for(n in s)Object.prototype.hasOwnProperty.call(s,n)&&(t[n]=s[n]);c&&c(e);while(f.length)f.shift()();return r.push.apply(r,u||[]),a()}function a(){for(var t,e=0;e<r.length;e++){for(var a=r[e],n=!0,i=1;i<a.length;i++){var s=a[i];0!==o[s]&&(n=!1)}n&&(r.splice(e--,1),t=l(l.s=a[0]))}return t}var n={},o={app:0},r=[];function l(e){if(n[e])return n[e].exports;var a=n[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,l),a.l=!0,a.exports}l.m=t,l.c=n,l.d=function(t,e,a){l.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},l.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},l.t=function(t,e){if(1&e&&(t=l(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(l.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var n in t)l.d(a,n,function(e){return t[e]}.bind(null,n));return a},l.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return l.d(e,"a",e),e},l.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},l.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],s=i.push.bind(i);i.push=e,i=i.slice();for(var u=0;u<i.length;u++)e(i[u]);var c=s;r.push([0,"chunk-vendors"]),a()})({0:function(t,e,a){t.exports=a("56d7")},"01e8":function(t,e,a){"use strict";var n=a("9af0"),o=a.n(n);o.a},"56d7":function(t,e,a){"use strict";a.r(e);a("e260"),a("e6cf"),a("cca6"),a("a79d");var n=a("2b0e"),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("b-container",{staticClass:"header",attrs:{fluid:""}},[n("b-container",[n("img",{staticClass:"logo",attrs:{alt:"Nomoko",src:a("b640")}}),n("h1",{staticClass:"title"},[t._v("Nomoko Fullstack Task")])])],1),n("router-view")],1)},r=[],l={name:"app"},i=l,s=(a("5c0b"),a("2877")),u=Object(s["a"])(i,o,r,!1,null,null,null),c=u.exports,p=a("8c4f"),f=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("b-container",{staticClass:"main"},[a("b-form",{attrs:{novalidate:""}},[a("b-row",{staticClass:"my-1"},[a("b-col",{attrs:{sm:"4"}},[a("b-form-group",{attrs:{label:"Latitude:","label-for":"latinp"}},[a("b-form-input",{attrs:{id:"latinp",state:t.latvalidation,type:"text"},model:{value:t.lat,callback:function(e){t.lat=e},expression:"lat"}}),a("b-form-invalid-feedback",{attrs:{state:t.latvalidation}},[t._v(" Must be a valid latitude value ")])],1)],1),a("b-col",{attrs:{sm:"4"}},[a("b-form-group",{attrs:{label:"Longitude:","label-for":"loninp"}},[a("b-form-input",{attrs:{id:"loninp",state:t.lonvalidation,type:"text"},model:{value:t.lon,callback:function(e){t.lon=e},expression:"lon"}}),a("b-form-invalid-feedback",{attrs:{state:t.lonvalidation}},[t._v(" Must be a valid longitude value ")])],1)],1),a("b-col",{attrs:{sm:"4"}},[a("b-button",{attrs:{variant:"primary",block:""},on:{click:function(e){return t.callGetValue()}}},[t._v("Estimate Value")])],1)],1)],1),a("mymap",{ref:"map"})],1)},d=[],m=(a("d81d"),a("498a"),a("bc3a")),b=a.n(m),h=b.a.create({baseURL:"/api",timeout:1e3}),v={getPropertyValue:function(t,e){return h.post("/property/value",{lat:parseFloat(t),lon:parseFloat(e)})}},y=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("b-aspect",{attrs:{aspect:t.aspect}},[a("l-map",{ref:"myMap",staticClass:"my-map",attrs:{zoom:t.zoom,center:t.center,options:t.mapOptions}},[a("l-tile-layer",{attrs:{url:t.url,attribution:t.attribution}}),t._l(t.markerDetails,(function(e){return a("l-marker",{key:e.id,attrs:{"lat-lng":e.location,radius:e.radius,color:e.color,fillColor:e.fillColor,fillOpacity:e.fillOpacity}},[a("l-tooltip",{attrs:{options:t.tooltipOptions}},[t._v(t._s(e.tooltip))])],1)}))],2)],1)},g=[],O=(a("b680"),a("e11e")),k=a("2699"),_=a("a40a"),M=a("4e2b"),x=a("f60f"),j=a("31dc");delete O["Icon"].Default.prototype._getIconUrl,O["Icon"].Default.mergeOptions({iconRetinaUrl:a("584d"),iconUrl:a("6397"),shadowUrl:a("e2b9")});var w={name:"Mymap",components:{LMap:k["a"],LTileLayer:_["a"],LMarker:M["a"],LPopup:x["a"],LTooltip:j["a"]},data:function(){return{zoom:13,center:Object(O["latLng"])(47.4057257,8.5682659),url:"https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",attribution:'&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',mapOptions:{zoomSnap:.5},markerDetails:[],tooltipOptions:{permanent:!0},aspect:"2"}},methods:{addMarker:function(t){this.$refs.myMap.mapObject.panTo(t),this.markerDetails.push({id:this.markerDetails.length,location:t,radius:10,color:Math.random()>.5?"red":"blue",fillColor:"#f03",fillOpacity:Math.random(),tooltip:"Value: "+t.value.toFixed(2),permanenttip:!0})},deleteMarker:function(){this.markerDetails.shift()}}},L=w,P=Object(s["a"])(L,y,g,!1,null,null,null),C=P.exports,D={name:"Homepage",components:{Mymap:C},data:function(){return{lat:null,lon:null,forcevalidate:!1}},computed:{latvalidation:function(){return null===this.lat||0==this.lat.trim().length?!1===this.forcevalidate&&null:!isNaN(this.lat)&&!(this.lat>90||this.lat<-90)},lonvalidation:function(){return null===this.lon||0==this.lon.trim().length?!1===this.forcevalidate&&null:!isNaN(this.lon)&&!(this.lon>180||this.lon<-180)}},methods:{callGetValue:function(){var t=this;null!==this.lonvalidation&&null!==this.latvalidation?!0===this.lonvalidation&&!0===this.latvalidation&&(this.forcevalidate=!1,v.getPropertyValue(this.lat,this.lon).then((function(e){t.$refs.map.addMarker(e.data)})).catch((function(t){}))):this.forcevalidate=!0}}},S=D,T=(a("01e8"),Object(s["a"])(S,f,d,!1,null,"0dfc4db1",null)),N=T.exports;n["default"].use(p["a"]);var V=new p["a"]({mode:"history",routes:[{path:"/",component:N},{path:"*",redirect:"/"}]}),$=V,z=a("5f5b");a("f9e3"),a("2dd8"),a("6cc5");n["default"].config.productionTip=!1,n["default"].use(z["a"]),new n["default"]({router:$,render:function(t){return t(c)}}).$mount("#app")},"5c0b":function(t,e,a){"use strict";var n=a("9c0c"),o=a.n(n);o.a},"9af0":function(t,e,a){},"9c0c":function(t,e,a){},b640:function(t,e,a){t.exports=a.p+"static/img/logo.5b16712d.jpg"}});
//# sourceMappingURL=app.16322d6c.js.map