<template>
<div>
  <div class="my-register-view" style="">

    <register :class="activeClass"/>
  </div>
</div>
</template>

<script>
import Login from "@/components/Login";
import Register from "@/components/Register";
export default {
  name: "LoginView",
  components: {
    Register,
    Login
  },

  data(){
    return{
      input1:null,
      activeClass:null
    }
  },
  methods:{
  }
}
</script>

<style>


.my-register-view{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 100vh;
  position: absolute;
  overflow: hidden;
}

</style>
