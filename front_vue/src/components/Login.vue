<template>
  <!--  登录框  -->
  <div class="my-login-card" id="login-card" style="">
    <div class="my-card">
      <div style="width: 260px;position:relative;top: 50%;left: 50%;transform: translateY(-50%) translateX(-50%);">
        <div style="margin-bottom: 55px">
          <span class="my-weight-font" style="font-weight: bolder;font-size: 30px">读书吧</span> <br>
          <span class="my-weight-font" style="font-weight: bolder;font-size: 30px">-图书管理系统</span>
        </div>
        <div style="margin-bottom: 10px">
          <el-input
            placeholder="请输入邮箱"
            v-model="input1"
            class="input-with-select"
            suffix-icon="el-icon-user"
          >
            <template slot="prepend">
              <div class="my-weight-font">
                账号
              </div>
            </template>
          </el-input>
        </div>

        <div style="margin-bottom: 10px">
          <el-input
            placeholder="请输入密码"
            v-model="input1"
            class="input-with-select"
            suffix-icon="el-icon-ice-cream-round"
            show-password
          >
            <template slot="prepend">
              <div class="my-weight-font">
                密码
              </div>
            </template>
          </el-input>
        </div>

        <div style="margin-bottom: 10px" id="yan">
          <el-input
            placeholder="6位验证码"
            v-model="input1"
            class="input-with-select"
            suffix-icon="el-icon-s-promotion"
            show-password
          >
            <template slot="prepend">
              <el-button class="my-weight-font"  type="primary">
                <div class="my-weight-font">
                  发送验证码
                </div>
              </el-button>
            </template>
          </el-input>
        </div>

        <div>
          <el-link type="info" style="float: left;padding-top: 14px">forget password?</el-link>
          <el-link type="info" style="float: left;padding-top: 12px;margin-left: 10px" @click="toRegister">我要注册</el-link>
          <el-button type="primary" size="small" style="float: right">LOGIN</el-button>
        </div>

      </div>
    </div>
    <div class="my-login-image">

    </div>

    <back-icon-up/>
  </div>
</template>

<script>
import anime from 'animejs/lib/anime.es.js';
import BackIconUp from "@/components/BackIconUp";
export default {
  name: "Login",
  components: {BackIconUp},
  data(){
    return{
      input1:null,
      activeClass:null
    }
  },
  methods:{
    toRegister(){
      this.$router.push('/register')
    }
  },

}
</script>

<style>

</style>
