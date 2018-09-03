<template>
  <div id="accountApp">
    <h1>All Accounts</h1>
    <table id="accountsTable" v-show="display">
      <thead>
        <th>First Name</th>
        <th>Surname</th>
        <th>Account Number</th>
        <th>Edit</th>
        <th>Delete</th>
      </thead>

      <tbody>
        <tr v-for="account in accounts">
          <td>{{ account.firstname }}</td>
          <td>{{ account.surname }}</td>
          <td>{{ account.accountnumber }}</td>
          <td><input type="button" value="View" v-on:click= "getByID(account.id)" /></td>
          <td><input type="button" value="Delete"  v-on:click= "deleteAccount(account.id)"/></td>
        </tr>
      </tbody>
    </table>
    <input type="button" value="Hide Accounts" v-on:click="display = !display"/> <!-- hideAll-->
  </div>
</template>

<script type="text/javascript">
import axios from 'axios'
export default{
  name: 'accounttable',
  mounted:function(){
    this.getAll()
  },
  data(){
    return{
      display: true,
      accounts:[],
      methods:{
        getAll(){
          axios.get('http://localhost:8080/accounts/all')
            .then(response => {
              this.accounts = response.data;
            })
            .catch(error => {
              console.log(error)
            })
          },
          getByID(id){
            axios.get('http://localhost:8080/accounts/get/' + id)
              .then(response => {
                editAccount(response.data)
              })
              .catch(error => {
                console.log(error)
              })
            },
            deleteAccount(id){
              axios.delete('http://localhost:8080/accounts/delete/' + id)
                .then(response => {
                  alert("Account Deleted")
                  $state.reload()
                })
                .catch(error => {
                  console.log(error)
                })
              },
              editAccount(account){
                this.$router.push({name:'EditAccount',params:{ sentAccount: account}})
              }
        }
    }
  }
}
</script>

<style>
  #accountsTable {
      border-collapse: collapse;
      width: 100%;
  }

  #accountsTable td, #accountsTable th {
      border: 1px solid #ddd;
      padding: 8px;
      padding-right: 150px;
      align: center;
  }

  #accountsTable tr:nth-child(odd){background-color: #f2f2f2;}

  #accountsTable th {
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: left;
      background-color: darkred;
      color: white;
      opacity: 0.7;
  }
</style>
