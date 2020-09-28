<template>
  <div id="app">
    <img class="logo" alt="Nomoko" src="./assets/logo.jpg">
    <h1 class="title">Nomoko Fullstack Task</h1>
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


.logo {
  height: 100px;
  width: 100px;
  display: inline-block;
}
h1.title{
  display: inline-block;
}
</style>
