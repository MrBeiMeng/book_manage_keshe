<template>
  <div>
    <b-header/>
    <div class="b-container">
      <div style="width: 100%">
        <el-button type="danger" size="mini" style="float: right;margin: 10px 0 10px 20px" @click="handleDelete">删除</el-button>
        <el-button type="primary" size="mini" style="float: right;margin: 10px 0 10px 20px" @click="handleAdd">添加</el-button>
      </div>

      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="id"
          label="id"
          width="180">
        </el-table-column>
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
<!--        <el-table-column-->
<!--          prop="imgUrl"-->
<!--          label="封面">-->
<!--        </el-table-column>-->
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
          label="操作">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">详情</el-button>
            <el-button @click="handleUpd(scope.row)" type="text" size="small">修改</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog
        title="添加或修改"
        :visible="dialogVisible"
        width="30%"
        :before-close="handleClose">
         <div style="">
           <div>
             书名：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.bookName"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             作者：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.author"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             出版社：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.publisher"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             出版时间：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.publishDate"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             单价：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.unitPrice"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             图片：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.imgUrl"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             标签：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.tags"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             剩余数量：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateBook.lastNum"
               style="width: 200px"
               clearable>
             </el-input>
           </div>

         </div>


        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdateBook">确 定</el-button>
      </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {getAllBook, saveOrUpdate} from "@/api/book";
import BHeader from "@/components/layout/BHeader";

export default {
  name: "BookManagesView.vue",
  components:{
    BHeader
  },
  data(){
    return{
      tableData:[],
      multipleSelection:null,
      dialogVisible:false,
      addOrUpdateBook:{
        id:"",
        bookName:"",
        author:"",
        publisher:"",
        publishDate:"",
        unitPrice:"",
        imgUrl:"",
        tags:"",
        lastNum:"",
        times:"",
        status:"",
        sort:"",
        createTime:"",
        updateTime:"",
      }
    }
  },
  methods:{
    handleClick(row){
      console.log(row.id);
      this.$router.push(`/book_detail/${row.id}`)
    },
    handleAdd(row){
      // this.addOrUpdateBook = {}
      console.log(row.id);
      this.dialogVisible = true
    },
    handleUpd(row){
      console.log(row.id);
      this.addOrUpdateBook = row
      this.dialogVisible = true
    },
    handleClose(done) {
      // 关闭
    },
    handleDelete(){
      if (this.multipleSelection != null && this.multipleSelection.length !== 0){
        this.$confirm('此操作将永久删除这些图书, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          alert("yes")
          // todo 删除
          this.toggleSelection(null)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        })
      }
    },
    saveOrUpdateBook(){
      saveOrUpdate(this.addOrUpdateBook).then(res=>{
        alert("操作成功")
      })

      this.dialogVisible = false;
    },
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    }
  },
  mounted() {
    getAllBook().then(res=>{
      this.tableData = res.data.rows
    })
  }
}
</script>

<style scoped>

</style>
