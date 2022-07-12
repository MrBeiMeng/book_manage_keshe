<template>
<div>
  <b-header/>

  <div class="b-container">
    <div>
      <el-descriptions class="margin-top" title="书本信息" :column="3" :size="size" border>
        <template slot="extra">
          <el-button type="primary" size="small">申请借阅</el-button>
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            书名
          </template>
          {{ book.bookName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            作者
          </template>
          {{ book.author }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            出版社
          </template>
          {{ book.publisher }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            标签
          </template>
          <el-tag size="small">{{ book.tags }}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            单价
          </template>
          {{book.unitPrice}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            图片
          </template>
          {{book.imgUrl}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            出版日期
          </template>
          {{book.publishDate}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            库存剩余
          </template>
          {{book.lastNum}}
        </el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</div>
</template>

<script>
import BHeader from "@/components/layout/BHeader";
import {getBook} from "@/api/book";
export default {
  name: "DetailsView",
  components: {BHeader},
  props:["bookId"],
  data(){
    return{
      book:{
        bookName:"",
        author:"",
        publisher:"",
        publishDate:"",
        unitPrice:"",
        imgUrl:"",
        tags:"",
        lastNum:"",
      }
    }
  },
  mounted() {
    getBook(this.bookId).then(res=>{
      this.book = res.data.book
    })
  }
}
</script>

<style scoped>

</style>
