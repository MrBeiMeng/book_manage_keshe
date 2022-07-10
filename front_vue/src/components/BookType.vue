<template>
  <div style="width: 260px;padding: 10px;border-right: #42b983 2px solid">
    <span class="my-weight-font" style="font-weight: bold">{{typeName}}</span> <i v-if="typeName !==  ''" class="el-icon-caret-right"></i>
  </div>
</template>

<script>
export default {
  name: "BookType",
  props:["typeName"],
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
