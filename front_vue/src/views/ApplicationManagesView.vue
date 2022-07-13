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
          prop="bookId"
          label="图书Id"
          width="180">
        </el-table-column>
        <el-table-column
          prop="userId"
          label="用户Id">
        </el-table-column>
        <el-table-column
          prop="type"
          label="申请类型">
          <template slot-scope="scope">
            <span v-show="scope.row.type === 1">申请借阅</span>
            <span v-show="scope.row.type === 2">申请还书</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="status"
          label="申请状态">
          <template slot-scope="scope">
            <span v-show="scope.row.status === 0">未审批</span>
            <span v-show="scope.row.status === 1">已同意</span>
            <span v-show="scope.row.status === 2">已拒绝</span>
          </template>
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
             图书id：
             <el-input
               placeholder="bookId"
               v-model="addOrUpdateApplication.bookId"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             用户id：
             <el-input
               placeholder="userId"
               v-model="addOrUpdateApplication.userId"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             申请类型：
             <el-input
               placeholder="type 申请借 1  申请还 2"
               v-model="addOrUpdateApplication.type"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             申请状态：
             <el-input
               placeholder="status 0 未审批 1 同意 2 拒接"
               v-model="addOrUpdateApplication.status"
               style="width: 200px"
               clearable>
             </el-input>
           </div>

         </div>


        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate">确 定</el-button>
      </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import BHeader from "@/components/layout/BHeader";
import {deleteApplication, getAllApplication, saveOrUpdateApplication} from "@/api/application";

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
      addOrUpdateApplication:{

      }
    }
  },
  methods:{
    handleClick(row){
      console.log(row.id);
      this.$router.push(`/book_detail/${row.id}`)
    },
    handleAdd(row){
      console.log(row.id);
      this.dialogVisible = true
    },
    handleUpd(row){
      console.log(row.id);
      this.addOrUpdateApplication = row
      this.dialogVisible = true
    },
    handleClose(done) {
      // 关闭
    },
    handleDelete(){
      if (this.multipleSelection != null && this.multipleSelection.length !== 0){
        this.$confirm('此操作将永久删除这些申请, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let ids = []
          this.multipleSelection.forEach((val)=>{
            ids.push(val.id)
          })
          console.log(ids)
          deleteApplication(ids).then(res=>{
            this.$message({
              type: 'success',
              message: "删除成功"
            });
            getAllApplication().then(res=>{
              this.tableData = res.data.rows
            })
          })
          this.dialogVisible = false
          this.toggleSelection(null)
        }).catch(() => {
console.log("删除成功")
        })
      }else{
        this.$message({
          message: '请先选择',
          type: 'warning'
        });
      }
    },
    saveOrUpdate(){
      saveOrUpdateApplication(this.addOrUpdateApplication).then(res=>{
        alert("操作成功");
        getAllApplication().then(res=>{
          this.tableData = res.data.rows
        })
        this.addOrUpdateApplication = {}
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
    getAllApplication().then(res=>{
      this.tableData = res.data.rows
    })
  }
}
</script>

<style scoped>

</style>
