<template>
  <div id="app">
    <b-container fluid class="header">
      <b-container>
        <img class="logo" alt="Nomoko" src="./assets/logo.jpg">
        <h1 class="title">Nomoko Fullstack Task</h1>
      </b-container>
    </b-container>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app'
}
</script>

<style lang="scss">
/*#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}*/
body.mybody{
  background-color: #fafafa !important;
}

.logo {
  height: 50px;
  width: 50px;
  display: inline-block;
  margin-right: 1em;;
  
}
.header{
  padding: 1em;
}
.header h1{
  display: inline-block;
  font-size: 1.5em;
  margin-bottom: 0;
  vertical-align: middle;
}
</style>
