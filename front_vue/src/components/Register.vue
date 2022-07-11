<template>
  <!--  注册框  -->
  <div class="my-login-card" style="">
    <div class="my-register-image">

    </div>

    <div class="my-card">
      <div style="width: 260px;position:relative;top: 50%;left: 50%;transform: translateY(-50%) translateX(-50%);margin-right: 35px">
        <div style="margin-bottom: 55px">
          <span class="my-weight-font" style="font-weight: bolder;font-size: 30px">现在注册</span> <br>
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

        <div style="margin-bottom: 10px">
          <el-input
            placeholder="6位验证码"
            v-model="input1"
            class="input-with-select"
            suffix-icon="el-icon-s-promotion"
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
          <el-link type="info" style="float: left;padding-top: 12px;margin-left: 10px" @click="toLogin">我要登录</el-link>
          <el-button type="primary" size="small" style="float: right">注册</el-button>
        </div>

      </div>
    </div>
    <back-icon-up/>
  </div>
</template>

<script>
import BackIconUp from "@/components/BackIconUp";
export default {
  name: "Register",
  components: {BackIconUp},
  data(){
    return{

    }
  },
  methods:{
    toLogin(){

      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
.my-register-image{
  width: 458px;
  /*height: 800px;*/
  background-image: url("../assets/image/1000.jpg");
  background-size: 343px;
  background-repeat: no-repeat;
  margin-left: 40px;
}

</style>
