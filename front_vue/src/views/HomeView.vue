<template>
  <div class="home">
    <b-header/>

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
              <el-button slot="append" icon="el-icon-search"></el-button>
            </el-input>
          </div>
        </div>

      </div>
    </div>

    <book-category/>

    <book-recommend/>

    <!--  回到顶部  -->
    <el-backtop  :bottom="100">
      <div
        style="{
        height: 100%;
        width: 100%;
        background-color: #f2f5f6;
        box-shadow: 0 0 6px rgba(0,0,0, .12);
        text-align: center;
        line-height: 40px;
        color: #1989fa;
      }"
      >
        顶
      </div>
    </el-backtop>

    <b-footer/>

  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import BHeader from "@/components/layout/BHeader"
import BookType from "@/components/BookType";
import BFooter from "@/components/layout/BFooter";
import BookCategory from "@/components/BookCategory";
import BookRecommend from "@/components/BookRecommend";

export default {
  name: 'HomeView',
  components: {
    BookRecommend,
    BookCategory,
    BFooter,
    BHeader,
    HelloWorld,
    BookType,
  },
  data() {
    return {
      barrageData: [
        { text: '第一条弹幕' },
        { text: 'text2' },
        { text: 'text3' },
      ],
      select:null,
      input3:null
    }
  },
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
