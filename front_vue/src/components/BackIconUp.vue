<template>
<div>
  <div id="book1" style="position:absolute; left: 200px;bottom: -300px;filter: opacity(0.3)">
    <img src="../assets/image/书架 书柜.png" alt="">
  </div>

  <div id="book2" style="position:absolute; right: 200px;top: 700px;filter: opacity(0.3)">
    <img src="../assets/image/用研.png" alt="">
  </div>

  <div id="book3" style="position:absolute; right: 412px;bottom: -360px;filter: opacity(0.1);width: 100px">
    <img src="../assets/image/资料库.png" alt="" style="width: 100px">
  </div>

  <div id="book4" style="position:absolute; left: 412px;top: 640px;filter: opacity(0.3);width: 100px">
    <img src="../assets/image/书.png" alt="" style="width: 100px">
  </div>
</div>
</template>

<script>
import anime from "animejs";

export default {
  name: "BackIconUp",
  mounted() {
    anime({
      targets: '#book1',
      translateY: -500,
      duration: 2000,
      easing: 'easeInOutExpo',
      // direction:'reverse'
    });
    anime({
      targets: '#book2',
      translateY: -500,
      duration: 1900,
      easing: 'easeInOutExpo',
      // direction:'reverse'
    });
    anime({
      targets: '#book3',
      translateY: -500,
      duration: 2300,
      easing: 'easeInOutExpo',
      // direction:'reverse'
    });
    anime({
      targets: '#book4',
      translateY: -500,
      duration: 1700,
      easing: 'easeInOutExpo',
      // direction:'reverse'
    });
  }
}
</script>

<style scoped>

</style>
