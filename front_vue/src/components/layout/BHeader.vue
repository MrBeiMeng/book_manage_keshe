<template>
  <div>
    <div class="b-header">
      <div class="b-header-container b-weight-font" style="">
        <!--        logo-->
        <span  style="float: left; font-size: 30px;position: relative;">图书管理系统</span>
        <!--        搜素框-->
        <div style="display: inline-block;width: 400px;">
          <el-input
            size="small"
            placeholder="请输入内容"
            suffix-icon="el-icon-search"
            v-model="input2">
          </el-input>
        </div>
        <!--        导航列表-->
        <div style="float: right;">
          <nav>
            <a href=""  @click.stop.prevent = "scrollTo(0)">搜书</a> |
            <a href=""  @click.stop.prevent = "scrollTo(1)">分类</a> |
            <a href=""  @click.stop.prevent = "scrollTo(2)">推荐</a> |
            <router-link to="/me" >我的</router-link>
          </nav>
          <div style="display: inline-block;margin: 0 20px">
            <div v-if="isLogin">
              <el-avatar shape="square" :size="50" :src="avatar" style="position:relative;transform: translateY(17px);padding: 0"></el-avatar>
            </div>
            <nav v-else>
              <router-link to="/login" >登录/</router-link>
              <router-link to="/register" >注册</router-link>
            </nav>
          </div>

        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: 'BHeader',
  data(){
    return {
      input2:null,

    }
  },
  methods:{
    scrollTo(to){
      let arr = [100,600,1200]

      window.scrollTo({
        top: arr[to],
        behavior: "smooth"
      });
    }
  },
  computed:{
    isLogin(){
      return this.$store.getters.token !== undefined;
    },
    avatar(){
      return this.$store.getters.avatar
    }
  },

}
</script>

<style>

</style>
