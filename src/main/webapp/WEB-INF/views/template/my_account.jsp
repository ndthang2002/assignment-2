<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <%@ page pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
    
    <style>
    
        .dropbtn {
        
      padding: 16px;
      font-size: 16px;
      border: none;
    }
    
    /* The container <div> - needed to position the dropdown content */
    .dropdown {
      position: relative;
      display: inline-block;
    }
    
    /* Dropdown Content (Hidden by Default) */
    .dropdown-content {
      display: none;
      position: absolute;
      
     min-width: 150px;
     height: 150px;
    
      z-index: 1;
      margin-left: -19px;
      border-radius: 10px;
      
    }
    
    /* Links inside the dropdown */
    .dropdown-content a {
      color: black;
      padding: 12px 16px;
      text-decoration: none;
      display: block;
      font-weight: bold
    }
    
    .menu-desktop ul li a
    {
    
      text-decoration: none;
    }
    .menu-desktop ul li a:after
    {
    content: "";
    position: absolute;
    background-color: #444444;
    height: 3px;
    left: 0;
    bottom:10px;
    text-decoration: none;
    transition:3s;
    
    
    
    }
    .menu-desktop ul li a:hover:after{
         width: 100%;
    }
    .menu-desktop ul li a:hover{
         color: #faee0b;
    }
    
    
    /* Change color of dropdown links on hover */
    .dropdown-content a:hover {background-color: rgb(251, 246, 246);}
    
    /* Show the dropdown menu on hover */
    .dropdown:hover .dropdown-content {display: block;}
    
    /* Change the background color of the dropdown button when the dropdown content is shown */
    
    
    .nameshop{
        justify-content: center;
        color: white;
    }
    .nameshop span{
        animation: glow 2s ease-in-out infinite;
    
    }
    @keyframes glow{
        0%,100%{
            color: #FFFFFF;
            text-shadow:0 0 20px lime ,0 0 50px lime ,0 0 100px lime;
        }
        10% ,90%{
            color:#888888;
            text-shadow:none;
    
        }
    }
    .nameshop span:nth-child(2){
       animation-delay: 0.25s;
    }
    .nameshop span:nth-child(3){
       animation-delay: 0.5s;
    }
    .nameshop span:nth-child(4){
       animation-delay: 0.75s;
    }
    .nameshop span:nth-child(5){
       animation-delay: 1s;
    }
    .nameshop span:nth-child(6){
       animation-delay: 1.25s;
    }
    .nameshop span:nth-child(7){
       animation-delay: 1.5s;
    }
    .nameshop span:nth-child(8){
       animation-delay: 1.75s;
    }
    .nameshop span:nth-child(9){
       animation-delay: 2s;
    }
    .nameshop span:nth-child(10){
       animation-delay: 2.25s;
    
    }
    
    .nameshop span:nth-child(11){
       animation-delay: 2.5s;
    }
    .login{
        display: none;
    }
    .login:target{
        display:contents ;
    }
    .Categories:hover{
        color: #fbef09;
    }
    </style>
<body>
  
    
</body>
</html>