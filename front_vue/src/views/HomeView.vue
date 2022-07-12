<template>
  <div class="home">
    <b-header/>

    <book-seacher/>

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
import BookSeacher from "@/components/BookSearcher";

export default {
  name: 'HomeView',
  components: {
    BookSeacher,
    BookRecommend,
    BookCategory,
    BFooter,
    BHeader,
    HelloWorld,
    BookType,
  },
  data() {
    return {

    }
  },
}
</script>
<style scoped>


</style>
