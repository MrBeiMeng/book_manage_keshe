<template>
  <div style="width: 260px;padding: 10px;border-right: #42b983 2px solid">
    <span class="my-weight-font" style="font-weight: bold">
      <router-link :to="'/books/' + typeId" style="color: #2c3e50;text-decoration: none">{{typeName}} <i v-if="typeName !==  ''" class="el-icon-caret-right"></i></router-link>
    </span>
  </div>
</template>

<script>
export default {
  name: "BookType",
  props:["typeName","typeId"],
  data(){
    return{
    }
  },
  filters:{
  }
}
</script>

<style scoped>

</style>
