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
            <router-link to="/plan" >搜书</router-link> |
            <router-link to="/schedule" >分类</router-link> |
            <router-link to="/about" >推荐</router-link>
          </nav>
          <div style="display: inline-block;margin: 0 20px">
            <nav>
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
      input2:null
    }
  }
}
</script>

<style>

</style>
