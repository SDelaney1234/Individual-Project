<template>
  <div class="topnav" id="myTopnav">
    <a id="active">AccountApp</a>
    <a><router-link :to="'Home'"></router-link>Dashboard</a>
    <div class="dropdown">
      <button class="dropbtn">Accounts
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a><router-link :to="'ViewAccounts'"></router-link>Get Accounts</a>
        <a><router-link :to="'CreateAccount'"></router-link>Add Account</a>
      </div>
    </div>
  </div>
</template>

<script>
export default{
  name: 'app'
}
</script>

<style>
body {margin:0;font-family:Arial}

.topnav {
  overflow: hidden;
  background-color: Gainsboro;
}

#active {
  background-color: darkred;
  color: white;
  font-size: 20px;
  opacity: 0.7;
}

.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  opacity: 0.7;
}

.topnav .icon {
  display: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 17px;
    border: none;
    outline: none;
    color: inherit;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
    opacity: 0.7;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.topnav a:hover, .dropdown:hover .dropbtn {
  background-color: lightgrey;
  color: black;
}

.dropdown-content a:hover {
    background-color: #ddd;
    color: black;
}

.dropdown:hover .dropdown-content {
    display: block;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child), .dropdown .dropbtn {
    display: none;
  }
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
  .topnav.responsive .dropdown {float: none;}
  .topnav.responsive .dropdown-content {position: relative;}
  .topnav.responsive .dropdown .dropbtn {
    display: block;
    width: 100%;
    text-align: left;
  }
}
</style>
