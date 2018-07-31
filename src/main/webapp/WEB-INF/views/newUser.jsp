<%@include file="parts/head.jsp"%>

<title>New User Account</title>
</head>
<body>

	<div class="jumbotron container mt-5" style="width: 450px;">
		<form method="post" action="newUser">
			<h1>You need to register first.</h1>
			<h2>${sessionScope.loginPageMessage }</h2>
			<div class="form-group">
				<input type="text" name="username" placeholder="login" class="form-control"  /> 
			</div>
			<div class="form-group">
				<input type="password" name="password" placeholder="password" class="form-control"  />
			</div>
			<div class="form-group">
				 <input type="password" name="password2" placeholder="retype password" class="form-control"  />
			</div>
			 <input	class="btn btn-primary btn-block" type="submit" value="Ok" />
		</form>
	</div>

</body>
</html>