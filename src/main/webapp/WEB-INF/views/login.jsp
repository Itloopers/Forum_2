<%@include file="parts/head.jsp"%>

<title>Login Page</title>
</head>
<body>

	<div class="jumbotron container mt-5" style="width: 400px; background-color:;">
		<form method="post" action="login">
			<h2>${sessionScope.loginPageMessage }</h2>
			<div class="form-group">
				<input type="text" name="username" placeholder="login" class="form-control"  />
			</div> 
			<div class="form-group">
				<input type="password" name="password" placeholder="password" class="form-control"  /> 
			</div>
			<input class="btn btn-success btn-block" type="submit" value="login" />
		</form>
		
		<form method="get" action="newUser">
			<button class="btn btn-primary btn-block">New User?</button>
		</form>
	</div>

</body>
</html>