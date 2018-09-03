<template>
<div id="accountApp">
  <h1>Add Account</h1>
  <div class="container">
    <form action="action_page.php">
      <div class="row">
        <div class="col-15">
          <label for="fname">First Name:</label>
        </div>
        <div class="col-75">
          <input type="text" id="fname" name="firstname" placeholder="First name.." v-model= "fname">
        </div>
      </div>
      <div class="row">
        <div class="col-15">
          <label for="lname">Last Name:</label>
        </div>
        <div class="col-75">
          <input type="text" id="lname" name="lastname" placeholder="Last name.." v-model= "sname">
        </div>
      </div>
      <div class="row">
        <div class="col-15">
          <label for="lname">Account Number:</label>
        </div>
        <div class="col-75">
          <input type="text" id="acnum" name="accountnumber" placeholder="Account number.." v-model= "acc">
        </div>
      </div>
      <div class="row">
        <input type="button" value="Add Employee" v-on:click= "addAccount">
      </div>
    </form>
  </div>
</div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return{
        fname:"",
        sname:"",
        acc:""
      }
    },
        methods:{
          addAccount(){
            axios.post('http://localhost:8081/accounts/create' , {
              firstname: this.fname,
              surname: this.sname,
              accountnumber: this.acc
            })
              .then(response => {
                alert("Account Added")
                this.fname=""
                this.sname=""
                this.acc=""
              })
              .catch(error => {
                console.log(error)
              })
            }
          }
        };
</script>

<style>

/* Style inputs, select elements and textareas */
input[type=text], select, textarea{
  width: 100%;
  padding: 12px;
  font-size: 17px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  resize: vertical;
}

/* Style the label to display next to the inputs */
label {
  color: black;
  padding: 12px 12px 12px 0;
  display: inline-block;
  text-decoration: none;
  font-size: 17px;
  opacity: 0.8;
}

/* Style the submit button */
input[type=submit] {
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

/* Style the container */
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

/* Floating column for labels: 10% width */
.col-15 {
  float: left;
  width: 15%;
  margin-top: 6px;
}

/* Floating column for inputs: 75% width */
.col-75 {
  float: left;
  width: 85%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

</style>
