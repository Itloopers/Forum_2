<%@include file="parts/head.jsp"%>

<title>Forum</title>

</head>
<body>

<%@include file="parts/navbar.jsp"%>

		<br />
	<div class="container jumbotron ">
				
		<div class="row">
			<div class="titleItem col-9 text-left">Topic:</div>
			<div class="titleItem col-1 text-center" >Number of posts:</div>
			<div class="titleItem col-2 text-center" >Topic author:</div>
		</div>
		<c:forEach items="${subjectList}" var="item">
				<a href="posts?subject=${item.name }">
					<div class="row shadow p-3 mb-5 bg-white rounded">
						<div class="col-9 text-left">${item.name}</div>
						<div class="col-1 text-center">${item.numberOfPosts}</div>
						<div class="col-2 text-center">${item.subjectAuthor.username }</div>
					</div>
				</a>
			
		</c:forEach>
		<div class="container">
			<form action="newSubject" method="get">
				<div class="form-group">
					<span class="text-danger">${param.error }</span>
					<input type="text" name="subject" class="form-control" />
				</div>
				<div class="form-group">
					<textarea type="text" name="content" rows=3 class="form-control"></textarea>
				</div>
				<br />
				<input class="btn btn-primary btn-block" type="submit" value="create" />
			</form>
		</div>
	</div>

</body>
</html>