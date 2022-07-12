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
            v-model="loginForm.username"
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
            v-model="loginForm.password"
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
            placeholder="验证码"
            v-model="loginForm.verifyCode"
            class="input-with-select"
            suffix-icon="el-icon-s-promotion"
          >
            <template slot="prepend">
              <el-button class="my-weight-font"  type="primary" @click="sendVerifyCode" :disabled="codeSendFlag">
                <div class="my-weight-font">
                  {{sendCode}}
                </div>
              </el-button>
            </template>
          </el-input>
        </div>

        <div>
          <el-link type="info" style="float: left;padding-top: 14px">forget password?</el-link>
          <el-link type="info" style="float: left;padding-top: 12px;margin-left: 10px" @click="toRegister">我要注册</el-link>
          <el-button type="primary" size="small" style="float: right" @click="handlerLogin">LOGIN</el-button>
        </div>

      </div>
    </div>
    <div class="my-login-image">

    </div>

    <back-icon-up/>
  </div>
</template>

<script>
import BackIconUp from "@/components/BackIconUp";
import {getVerifyCode} from "@/api/auth";
export default {
  name: "Login",
  components: {BackIconUp},
  data(){
    return{
      loginForm:{
        username:"",
        password:"",
        verifyCode:""
      },
      activeClass:null,


      num:60, // 发送验证码间隔
      codeSendFlag:false, // 是否已经发送过验证码
      interval:null, // num倒计时对象
    }
  },
  methods:{
    handlerLogin(){

      this.loading = true
      this.$store.dispatch('user/login', this.loginForm).then(() => {
        this.$router.push({ path: this.redirect || '/' })
        this.loading = false
      }).catch(() => {
        this.loading = false
      })
    },
    toRegister(){
      this.$router.replace('/register')
    },
    sendVerifyCode(){
      if (this.loginForm.username.length <= 3){
        this.$notify.error({
          title: '过短',
          message: '请检查账号或邮箱输入是否有误'
        });
        return;
      }

      getVerifyCode(this.loginForm.username).then((res)=>{
        this.$notify({
          title: res.data.emailNumber,
          message: '如未收到，请检查垃圾箱。',
          offset: 100,
          position: 'bottom-right'
        });
      })

      // 设置状态为已发过
      this.codeSendFlag = true

      // 倒计时 60 秒之后，将状态改成false
      this.interval = setInterval(()=>{
        this.num -= 1;
      },1000)
    }
  },
  watch:{
    num(val){
      if(val === 0){
        clearInterval(this.interval)
        this.num = 60;
        this.codeSendFlag = false
      }
    },
  },
  computed:{
    sendCode(){
      if (this.codeSendFlag){
        if(this.num === 0){
          this.num = 60;
          this.codeSendFlag = false
        }
        return "" + this.num + "秒";
      }else{
        return "发送验证码"
      }
    }
  },
  filters:{

  }

}
</script>

<style>

</style>
