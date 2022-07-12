<template>
<div>
  <b-header/>

  <div class="b-container">
    <div style="width: 100%;height: 400px;overflow: hidden;">
      <img src="../assets/image/美丽雪山湖泊风景4k壁纸3840x2160_彼岸图网.jpg" alt="" style="width: 100%;position: relative;top: -79px">
    </div>

    <div style="width: 1280px;margin: 0 auto;text-align: left;position: relative;height: 128px">
      <el-avatar :size="200" :src="$store.getters.avatar" style="position: absolute;top: -100px;border: white 5px solid;display: inline-block;float: top"></el-avatar>

      <div style="display: inline-block;position: relative;margin-left: 210px;margin-top: 30px">
        <div style="font-weight: bolder" class="my-weight-font">{{$store.getters.name}}</div>
        <div>有趣的灵魂万里挑一.</div>
        <div>联系方式:  <el-link href="mailto:1192384722@qq.com">email <i class="el-icon-s-custom"></i></el-link></div>
      </div>

      <div style="display: inline-block;position: relative;margin-bottom: 100px;float: right;margin-top: 30px;margin-right: 50px;">
        <el-button type="danger" @click="logout">LOGOUT</el-button>
      </div>
    </div>
  </div>

</div>
</template>

<script>
import BHeader from "@/components/layout/BHeader";
export default {
  name: "MineView",
  components: {BHeader},
  methods:{
    logout(){
      this.loading = true
      this.$store.dispatch('user/logout').then(() => {
        this.$router.push({ path: this.redirect || '/' })
        this.loading = false
      }).catch(() => {
        this.loading = false
      })
    }
  }
}
</script>

<style scoped>

</style>
