<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <base href="${pageContext.servletContext.contextPath}/"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

</head>
<style>

.stylish-form 
    {
      background-image:url('https://www.elle.vn/wp-content/uploads/2019/02/27/elle-viet-nam-streetstyle-tuan-le-thoi-trang-35.jpg'); 
      padding:10px;
    }
    .stylish-form h2 {
      color:#ffe502;
      margin-top:50px;
      font-style: italic;
      font-weight: bolder;
      font-weight: bold;
      text-transform: uppercase;
      
    }
    .font_white {
      color:#fff !important;
    }
    .mar20 
    {
      margin:20px;
    }
    .inner-section {
      background-color:rgba(12, 3, 3, 0.5) !important;
      width:350px;
      display:block;
      margin:0 auto;
    }
    .inside-form{
      border-radius:8px;
      padding-top:30px;
      padding-bottom:30px;
    }
    .inside-form h2 {
      font-weight:700;
    }
    .inside-form ul {
      list-style-type:none;
      text-align:center;
      margin-top:30px;
    }
    .inside-form ul >li {
      display:inline-block;
    }
    .inside-form ul >li > i {
      margin-top:18px;
    }
    .icon-holder {
      background: rgb(247, 243, 243);
      border-radius: 50%;
      vertical-align: middle;
      height: 50px;
      width: 50px;
      text-align: center;
      margin-right: 20px;
    }

    .dsp-flex {
      display: -webkit-box; /* OLD - iOS 6-, Safari 3.1-6 */
      display: -moz-box; /* OLD - Firefox 19- (buggy but mostly works) */
      display: -ms-flexbox; /* TWEENER - IE 10 */
      display: -webkit-flex; /* NEW - Chrome */
      display: flex; /* NEW, Spec - Opera 12.1, Firefox 20+ */
      align-items: center;
      -webkit-align-items: center;
      justify-content: center
    }
    .input-group, .form-group {
      margin-bottom: 10px;
    }
    .input-group-addon {
      background-color: rgba(255, 255, 255, 0.1);
      border: none;
      color: #FFFFFF;
      border-radius:25px;
    }
    .form-control,.form-control:focus,.form-control:hover
    {
      background-color: rgba(255, 255, 255, 0.1);
      color: #FFFFFF;
      border-radius:25px;
      border:none;
      font-size:14px;
    }
    ::-webkit-input-placeholder { /* Chrome/Opera/Safari */
      color: #fff !important;
    }
    ::-moz-placeholder { /* Firefox 19+ */
      color: #fff !important;
    }
    :-ms-input-placeholder { /* IE 10+ */
      color: #fff !important;
    }
    :-moz-placeholder { /* Firefox 18- */
      color: #fff !important;
    }
    .footer {
      margin-top:40px;
      margin-bottom:40px;
    }
    input::placeholder {
      color: #fff !important;
    }
    .btn-lg {
      font-size: 1em;
      border-radius: 0.25rem;
      padding: 15px 48px;
    }
    .btn-round {
      border-width: 1px;
      border-radius: 30px !important;
      padding: 11px 23px;
    }
    .btn-neutral,.btn-neutral:focus,.btn-neutral:hover {
      background-color: #FFFFFF;
      color: #f96332;
    }
</style>
<body>
   
    
    <script src="https://use.fontawesome.com/1dec14be15.js"></script>
    <div class="container-fluid stylish-form">
      <h2 class="text-center">Mang cả thế giới về tủ đồ của bạn</h2>
      <div class="row mar20" >
        <div class="col-md-12 col-sm-12 col-xs-12">
          <div class="inner-section">
            <form method="POST" action="/account/signup"  enctype="multipart/form-data" modelAttribute="account">
              <div class="mar20 inside-form">
                <h2 class="font_white text-center">SIGN UP</h2>
                <ul>
                  <li class="icon-holder dsp-flex">
                    <i class="fa fa-facebook "></i>
                  </li>
                  <li class="icon-holder dsp-flex">
                    <i class="fa fa-twitter "></i>
                  </li>
                  <li class="icon-holder dsp-flex">
                    <i class="fa fa-instagram "></i>
                  </li>
                </ul>
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-pencil "></i></span>
                  <input type="text" class="form-control" name="username" required placeholder="User Name...">
                 
                </div>
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-envelope "></i></span>
                  <input type="email" class="form-control" name="email" required placeholder="Email...">
                </div>
             
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-lock "></i></span>
                  <input type="password" class="form-control" name="password" required placeholder="Password...">
                </div>  

                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-pencil "></i></i></span>
                  <input type="text" class="form-control" name="fullname" required placeholder="Full Name...">
                </div>

                <div class="input-group">
                  <span class="input-group-addon">Photo: </span>
                  <input type="file" class="form-control" name="photo" required placeholder="Photo...">
                </div>

                <i style="color: #FFFFFF;">${message}</i>
             
                <div class="footer text-center">
                 <button class="btn btn-neutral btn-round btn-lg">Get Started</a> </button> 
                  <!-- <a href="http://vijender.in/" class="btn btn-neutral btn-round btn-lg">Get Started</a> -->
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      <a href="fb.com/ervijender"><h2 class="text-center font_warning text-warning">Cảm ơn đã ghé thăm chúng tôi</h2></a>
    </div>
</body>
</html>