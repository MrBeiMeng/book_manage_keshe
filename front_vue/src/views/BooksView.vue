<template>
  <div>
    <b-header/>

    <div class="b-container">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%">
        <el-table-column
          prop="bookName"
          label="书名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="author"
          label="作者">
        </el-table-column>
        <el-table-column
          prop="publisher"
          label="出版社">
        </el-table-column>
        <el-table-column
          prop="publishDate"
          label="出版日期">
        </el-table-column>
        <el-table-column
          prop="unitPrice"
          label="单价">
        </el-table-column>
        <!--      <el-table-column-->
        <!--        prop="imgUrl"-->
        <!--        label="封面">-->
        <!--      </el-table-column>-->
        <el-table-column
          prop="allNum"
          label="总数">
        </el-table-column>
        <el-table-column
          prop="tags"
          label="标签">
        </el-table-column>
        <el-table-column
          prop="lastNum"
          label="库存剩余">
        </el-table-column>
        <el-table-column
          prop="times"
          label="借阅次数">
        </el-table-column>
        <el-table-column
          label="查看">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">详情</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import BHeader from "@/components/layout/BHeader";
import {getByCategoryId} from "@/api/book";
export default {
  name: "BooksView",
  components: {BHeader},
  props:["categoryId"],
  data(){
    return{
      tableData: [
      ],
    }
  },
  methods:{
    handleClick(row){
      console.log(row.id);
      this.$router.push(`/book_detail/${row.id}`)
    }
  },
  mounted() {
    getByCategoryId(this.categoryId).then(res=>{
      this.tableData = res.data.rows
    })
  }
}
</script>

<style scoped>

</style>
