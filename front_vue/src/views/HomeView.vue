<template>
  <div class="home">
    <b-header/>

    <div style=" ">
      <div style="height: 500px;background: yellowgreen;border-radius: 10px" class="b-container">
        <div>
          收
        </div>
        <Barrage :data='barrageData' style="height: 500px">
          <template #default='data'>
            <div>自定义弹幕 {{ data.text }}</div>
          </template>
        </Barrage>
      </div>
    </div>

    <book-category/>

    <book-recommend/>

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
      ]
    }
  },
}
</script>
<style scoped>
</style>
