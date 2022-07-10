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

    <div style="margin: 30px auto;border-radius: 10px" class="b-container" >
      <div style="text-align:left;position:relative; margin-left: 20px;padding-top:10px;margin-bottom: 20px" class="my-weight-font">
        <span style="font-size: 23px;font-weight:bolder;">图书 • 分类</span> <span style="margin-left: 15px;font-size: 12px;font-weight: bold">CATEGORY • BOOK</span>
      </div>



      <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
        <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
          <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
            <div style="font-size: 22px;font-weight: bold">想象文学</div>
            <div>狂风卷积着乌云~</div>
          </div>
        </div>
        <div style="display: inline-block;">
          <div style="display: flex">
            <book-type type-name="小说"/>
            <book-type type-name="诗歌"/>
            <book-type type-name="散文"/>
            <book-type type-name=""/>
          </div>
        </div>
      </div>

      <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
        <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
          <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
            <div style="font-size: 22px;font-weight: bold">知识类</div>
            <div>狂风卷积着乌云~</div>
          </div>
        </div>
        <div style="display: inline-block;">
          <div style="display: flex">
            <book-type type-name="理论性书籍"/>
            <book-type type-name="实用性书籍"/>
            <book-type type-name=""/>
            <book-type type-name=""/>
          </div>
        </div>
      </div>

      <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
        <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
          <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
            <div style="font-size: 22px;font-weight: bold">资讯类</div>
            <div>狂风卷积着乌云~</div>
          </div>
        </div>
        <div style="display: inline-block;">
          <div style="display: flex">
            <book-type type-name="杂志"/>
            <book-type type-name="报刊"/>
            <book-type type-name=""/>
            <book-type type-name=""/>
          </div>
        </div>
      </div>

      <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
        <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
          <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
            <div style="font-size: 22px;font-weight: bold">其他</div>
            <div>博观而约取，厚积而薄发。</div>
          </div>
        </div>
        <div style="display: inline-block;">
          <div style="display: flex">
            <book-type type-name="人物传记"/>
            <book-type type-name="工具书"/>
            <book-type type-name=""/>
            <book-type type-name=""/>
          </div>
        </div>
      </div>

      <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
        <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
          <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
            <div style="font-size: 22px;font-weight: bold">按篇幅</div>
            <div>博观而约取，厚积而薄发。</div>
          </div>
        </div>
        <div style="display: inline-block;">
          <div style="display: flex">
            <book-type type-name="一万"/>
            <book-type type-name="三万"/>
            <book-type type-name="十万"/>
            <book-type type-name=""/>
          </div>
        </div>
      </div>

    </div>


    <b-footer/>

  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import BHeader from "@/components/layout/BHeader"
import BookType from "@/components/BookType";
import BFooter from "@/components/layout/BFooter";

export default {
  name: 'HomeView',
  components: {
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
