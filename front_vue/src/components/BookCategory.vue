<template>

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
          <book-type type-name="小说" type-id="2"/>
          <book-type type-name="诗歌" type-id="3"/>
          <book-type type-name="散文" type-id="4"/>
          <book-type type-name="" type-id=""/>
        </div>
      </div>
    </div>

    <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
      <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
        <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
          <div style="font-size: 22px;font-weight: bold">知识类</div>
          <div>Java 从入门到精通~</div>
        </div>
      </div>
      <div style="display: inline-block;">
        <div style="display: flex">
          <book-type type-name="理论性书籍" type-id="5"/>
          <book-type type-name="实用性书籍" type-id="6"/>
          <book-type type-name="" type-id=""/>
          <book-type type-name="" type-id=""/>
        </div>
      </div>
    </div>

    <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
      <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
        <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
          <div style="font-size: 22px;font-weight: bold">资讯类</div>
          <div>观天下~</div>
        </div>
      </div>
      <div style="display: inline-block;">
        <div style="display: flex">
          <book-type type-name="杂志" type-id="7"/>
          <book-type type-name="报刊" type-id="8"/>
          <book-type type-name="" type-id=""/>
          <book-type type-name="" type-id=""/>
        </div>
      </div>
    </div>

    <div style="display: flex;justify-content: center;align-items: center;margin-bottom: 20px">
      <div style="display: inline-block;height: 120px;width: 300px;margin-right: 20px;border-right: black 2px solid;">
        <div style="top: 50%;position: relative;transform: translateY(-50%);" class="my-weight-font">
          <div style="font-size: 22px;font-weight: bold">其他</div>
          <div>学无止境。</div>
        </div>
      </div>
      <div style="display: inline-block;">
        <div style="display: flex">
          <book-type type-name="人物传记" type-id="9"/>
          <book-type type-name="工具书" type-id="10"/>
          <book-type type-name="" type-id=""/>
          <book-type type-name="" type-id=""/>
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
          <book-type type-name="一万" type-id="11"/>
          <book-type type-name="三万" type-id="12"/>
          <book-type type-name="十万" type-id="13"/>
          <book-type type-name=""/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import bookType from "@/components/BookType";
export default {
  name: "BookCategory",
  components:{
    bookType
  },
  data(){
    return{

    }
  }
}
</script>

<style scoped>

</style>
