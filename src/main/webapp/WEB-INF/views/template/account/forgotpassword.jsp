
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/forget-password.css">
<title>Forget password Template | Bootcatch themes</title>
</head>
<style>
@import url(https://fonts.googleapis.com/css?family=Poppins);

body {
	font-family: "Poppins", sans-serif;
}

.light-blue-gradient {
	/* background: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%); */
	background-image:
		url("https://bazaarvietnam.vn/wp-content/uploads/2016/04/J0A5916-copy.jpg");
}
</style>
<body>
	<div class="d-flex align-items-center light-blue-gradient"
		style="height: 100vh;">
		<div class="container">
			<div class="d-flex justify-content-center">
				<div class="col-md-7">
					<div class="card rounded-0 shadow">
						<div class="card-body">
							<h3>Forget Password</h3>
							<form action="/forgotpassword" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">User name:</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										value="${username}" required name="username"
										aria-describedby="emailHelp" placeholder="User Name">
									<i>${message}</i> <br> <label for="exampleInputEmail1">Email
										address:</label> <input type="email" class="form-control"
										id="exampleInputEmail1" value="${email}" required name="email"
										aria-describedby="emailHelp" placeholder="Enter email">
									<i>${emailerror}</i> <small id="emailHelp"
										class="form-text text-muted">"Chúng tôi sẽ gửi mật
										khẩu của bạn về email đã đăng ký tài khoản"</small><br> <small
										id="emailHelp" class="form-text text-muted">${sendmail}
										${sedmailerror}</small>
								</div>
								<button type="submit" class="btn btn-primary">Forget
									password</button>
								<a href="/login" style="text-decoration: none;"> Trở
									về</a>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- Optional JavaScript -->
			<!-- jQuery first, then Popper.js, then Bootstrap JS -->
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
				integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
				integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
				crossorigin="anonymous"></script>
		</div>
</body>
</html>