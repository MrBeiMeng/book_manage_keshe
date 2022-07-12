<template>
  <div style=" ">
    <div style="height: 500px;background: yellowgreen;border-radius: 10px" class="b-container">
      <div style="width: 100%;height: 100%;"  class="b-big-back">
        <Barrage :data='barrageData' style="height: 500px;position:absolute;width: 100%;top: 0">
          <template #default='data'>
            <div>自定义弹幕 {{ data.text }}</div>
          </template>
        </Barrage>
        <div style="position:relative;top: 50%;left:50%;transform: translateY(-50%) translateX(-50%);width: 600px">
          <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
            <el-select clearable v-model="select" slot="prepend" placeholder="请选择类别" style="width: 130px">
              <el-option label="查书名" value="1"></el-option>
              <el-option label="查句子" value="2"></el-option>
              <el-option label="查作者" value="3"></el-option>
            </el-select>
            <el-button slot="append" icon="el-icon-search" @click="searchBook"></el-button>
          </el-input>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import {searchBook} from "@/api/book";

export default {
  name: "BookSearcher",
  data(){
    return{
      barrageData: [
        { text: '第一条弹幕' },
        { text: 'text2' },
        { text: 'text3' },
      ],
      select:null,
      input3:null
    }
  },
  methods:{
    searchBook(){
      let bookName = null;
      let author = null;
      let content = null;
      switch (this.select){
        case "1": bookName = this.input3;break;
        case "2": content = this.input3;break;
        case "3": author = this.input3;break;
        default : bookName = this.input3;
      }

      console.log("bookName",bookName)
      console.log("author",author)
      console.log("content",content)
      this.$router.push({ path:'/searches', query: {
          bookName,author,content
        } })
    }
  }
}
</script>

<style scoped>
.b-big-back{
  background-image: url("../assets/image/阿尔卑斯山风景4k高清壁纸3840x2160_彼岸图网.jpg");
  background-size: 1680px;
  background-position: 0 -162px;
  border-radius: 10px;
}
</style>
