<template>
  <div>
    <div style="display: flex;justify-content: center;margin-top: 10px">
      <el-input v-model="keywords" placeholder="通过用户名搜索用户..." prefix-icon="el-icon-search"
                style="width: 400px;margin-right: 10px"></el-input>
      <el-button type="primary" icon="el-icon-search" @click="doSearch">搜索</el-button>
    </div>
    <div class="admin-container">
      <el-card class="admin-card" v-for="(admin,index) in admins" :key="index">
        <div slot="header" class="clearfix">
          <span>{{admin.name}}</span>
          <el-button style="float: right; padding: 3px 0;color:red " type="text" icon="el-icon-delete"
                      @click="deleteAdmin(admin)"></el-button>
        </div>
        <div>
          <div class="img-container">
            <img :src="admin.userFace" :alt="admin.name" :title="admin.name" class="userface-img"/>
          </div>
        </div>
        <div class="userinfo-container">
          <div>用户名：{{admin.name}}</div>
          <div>手机号码：{{admin.phone}}</div>
          <div>电话号码：{{admin.telephone}}</div>
          <div>地址：{{admin.address}}</div>
          <div>用户状态：
            <el-switch
                v-model="admin.enabled"
                @change="enabledChange(admin)"
                active-color="#13ce66"
                inactive-color="#ff4949"
                active-text="启用"
                inactive-text="禁用">
            </el-switch>
          </div>
          <div>
            用户角色：
            <el-tag style="margin-right: 8px"
                type="success" v-for="(role,index) in admin.roles" :key="index">{{role.nameZh}}</el-tag>
            <el-popover
                placement="right"
                @show="showPop(admin)"
                @hide="hidePop(admin)"
                title="角色列表"
                width="200"
                trigger="click">
              <el-select v-model="selectedRoles" multiple placeholder="请选择">
                <el-option
                    v-for="(r,index) in allRoles"
                    :key="index"
                    :label="r.nameZh"
                    :value="r.id">
                </el-option>
              </el-select>
              <el-button slot="reference" type="text" icon="el-icon-more"></el-button>
            </el-popover>
          </div>
          <div>
            备注：{{admin.remark}}
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "SysAdmin",
  data(){
    return{
      admins:[],
      keywords:'',
      allRoles:[],
      selectedRoles:[]
    }
  },
  mounted() {
    this.initAdmins();
    this.initAllRoles();
  },
  methods:{
    showPop(admin){
      let roles = admin.roles;
      this.selectedRoles = [];
      roles.forEach(r=>{
        this.selectedRoles.push(r.id);
      });
    },
    hidePop(admin){
      let url = '/system/admin/role?adminId='+admin.id;
      this.selectedRoles.forEach(sr=>{
        url+='&rids='+sr;
      });
      this.postRequest(url).then(resp=>{
        if (resp){
          this.initAdmins();
        }
      })
    },
    initAllRoles(){
      this.getRequest('/system/admin/roles').then(resp=>{
        if (resp){
          this.allRoles=resp;
        }
      })
    },
    initAdmins(){
      this.getRequest('/system/admin/').then(resp=>{
        if (resp){
          this.admins=resp;
        }
      })
    },
    doSearch(){
      this.getRequest('/system/admin/?keywords='+this.keywords).then(resp=>{
        if (resp){
          this.admins=resp;
        }
      })
    },
    deleteAdmin(admin){
      this.$confirm('此操作将永久删除该['+admin.name+']操作员, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.deleteRequest('/system/admin/'+admin.id).then(resp=>{
          if (resp){
            this.initAdmins();
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    enabledChange(admin){
      this.putRequest('/system/admin/',admin).then(resp=>{
        if (resp){
          this.initAdmins();
        }
      })
    }
  }
}
</script>

<style>
  .admin-card{
    width: 350px;
    margin-bottom: 10px;
  }
  .admin-container{
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    margin-top: 20px;
  }
  .userface-img{
    width: 72px;
    height: 72px;
    border-radius: 72px;
  }
  .img-container{
    width: 100%;
    display: flex;
    justify-content: center;
  }
  .userinfo-container{
    font-size: 12px;
  }

</style>