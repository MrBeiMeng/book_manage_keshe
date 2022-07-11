<template>
  <div style="margin: 30px auto;border-radius: 10px" class="b-container">
    <div style="text-align:left;position:relative; margin-left: 20px;padding-top:10px;margin-bottom: 20px" class="my-weight-font">
      <span style="font-size: 23px;font-weight:bolder;">图书 • 推荐</span> <span style="margin-left: 15px;font-size: 12px;font-weight: bold">RECOMMEND • BOOK</span>
    </div>

    <div style="display: flex;justify-content: left;margin: 30px 40px;padding-bottom: 45px">
      <div style="border: black 1px solid;width: 300px;height: 227px;border-radius: 10px;margin: 0 10px" v-for="item in 5" :key="item">
        <div style="width: 100%;height: 160px;overflow: hidden;position: relative;text-align: center;background-image: url('../assets/image/西部牛仔.jpg')" class="b-back">
          <div style="top: 50%;position: absolute;transform: translateY(-50%);color: white;font-weight: bolder;filter: blur(0.5px)">
            获得前程是由于自己的勇往直前，仅仅由于自己的勇往直前。
          </div>
          <div style="width: 300px;">
            <img src="../assets/image/西部牛仔.jpg" alt="" style="width: 100%;">
          </div>
        </div>

        <div style="position: relative">
          <div style="display: inline-block;float: left;margin: 10px;position: relative">
            <img src="../assets/image/金牌.png" alt="" style="width: 50px">
          </div>
          <div style="display: inline-block;width: 100px;background: #42b983;border-radius: 10px 10px 10px 30px;padding: 10px;font-weight: bold;float: right;position: relative" class="my-weight-font">
            三个火枪手
          </div>
        </div>
        <div style="margin-top: 21px;">
          <div>
            作者: 大仲马
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: "BookRecommend"
}
</script>

<style scoped>

</style>
