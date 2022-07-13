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
          prop="username"
          label="用户名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="password"
          label="密码">
        </el-table-column>
        <el-table-column
          prop="salt"
          label="盐">
        </el-table-column>
        <el-table-column
          prop="role"
          label="角色">
        </el-table-column>
        <el-table-column
          prop="realName"
          label="真实名">
        </el-table-column>
        <el-table-column
          prop="email"
          label="邮箱账号">
        </el-table-column>
        <el-table-column
          prop="sex"
          label="性别">
        </el-table-column>
        <el-table-column
          prop="age"
          label="年龄">
        </el-table-column>
        <el-table-column
          prop="description"
          label="个人介绍">
        </el-table-column>
        <el-table-column
          prop="avatar"
          label="头像">
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
             用户名：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.username"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             密码：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.password"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             盐：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.salt"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             角色：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.role"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             真实名：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.realName"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             邮箱账号：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.email"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             性别：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.sex"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             年龄：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.age"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             个人介绍：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.description"
               style="width: 200px"
               clearable>
             </el-input>
           </div>
           <div>
             头像：
             <el-input
               placeholder="请输入内容"
               v-model="addOrUpdateUser.avatar"
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
import {deleteUser, getAllUser, saveOrUpdateUser} from "@/api/user";

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
      addOrUpdateUser:{

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
      this.addOrUpdateUser = row
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
          let ids = []
          this.multipleSelection.forEach((val)=>{
            ids.push(val.id)
          })
          console.log(ids)
          deleteUser(ids).then(res=>{
            this.$message({
              type: 'success',
              message: res.data.message
            });
            getAllUser().then(res=>{
              this.tableData = res.data.rows
            })
          })
          this.dialogVisible = false
          this.toggleSelection(null)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        })
      }else{
        this.$message({
          message: '请先选择',
          type: 'warning'
        });
      }
    },
    saveOrUpdate(){
      saveOrUpdateUser(this.addOrUpdateUser).then(res=>{
        alert("操作成功");
        getAllUser().then(res=>{
          this.tableData = res.data.rows
        })
        this.addOrUpdateUser = {}
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
    getAllUser().then(res=>{
      this.tableData = res.data.rows
    })
  }
}
</script>

<style scoped>

</style>
