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
        <tr v-for="(account, pos) in accounts" v-bind:index="pos">
          <td>{{ account.firstname }}</td>
          <td>{{ account.surname }}</td>
          <td>{{ account.accountnumber }}</td>
          <td><input type="button" value="View" v-on:click= "getByID(account.id)" /></td>
          <td><input type="button" value="Delete"  v-on:click= "deleteAccount(account.id, pos)"/></td>
        </tr>
      </tbody>
    </table>
    <input type="button" value="Hide Accounts" v-on:click="display = !display"/>
  </div>
</template>

<script>
import axios from 'axios';

export default{
  name: 'accounttable',
  data(){
    return{
      display: true,
      accounts:[],
    }
  },
  mounted(){
      axios.get('http://localhost:8081/accounts/all')
        .then(response => {
          this.accounts = response.data;
        })
        .catch(error => {
          console.log(error)
        })
      },
      methods:{
          getByID(id){
            axios.get('http://localhost:8081/accounts/get/' + id)
              .then(response => {
                this.editAccount(response.data)
              })
              .catch(error => {
                console.log(error)
              })
            },
            deleteAccount(id, pos){
              axios.delete('http://localhost:8081/accounts/delete/' + id)
                .then(response => {
                  this.accounts.splice(pos,1);
                  alert("Account Deleted");
                })
                .catch(error => {
                  console.log(error)
                })
              },
              editAccount(account){
                this.$router.push({name:'EditAccount', params:{ sentAccount: account}})
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

  input[type=button] {
    background-color: darkred;
    font-size: 15px;
    color: white;
    padding: 15px 30px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: right;
    opacity: 0.7;
  }

</style>
