<%@include file="parts/head.jsp"%>

<title>Forum</title>
</head>
<body>

<%@include file="parts/navbar.jsp"%>

		<br />
	<div class="container jumbotron ">
		<span class="text-danger">${param.error }</span>
		<div class="row">
			<div class="col-12"><h2 class="text-center p-3">${param.subject }</h2></div>
			
		</div>
			<div class="col-4"><a href="subjects">forum</a></div>					
	
		<c:forEach items="${postList}" var="item">
				
					<div class="shadow p-3 mb-5 bg-white rounded">
						<div class="row" >
							<div class="col-2 mb-2" ><a href="deletePost?subject=${param.subject }&postId=${item.id}"  ${sessionScope.deleteBtn} class="btn btn-sm btn-outline-warning btn-block">Delete</a></div>
							<div class="col-7" ></div>
							<div class="col-3 mb-2 text-left" >${item.dateFormat()}</div>
						</div>
						<div class="row  border-top border-primary">
							<div class="col-2 mt-2 text-center">${item.author.username }<p class="font-weight-light">${item.author.userTitle }</p></div>
							<div class="col-10 text-left">${item.content}</div>
						</div>
					</div>
				
			
		</c:forEach>
		<div class="container">
			<form action="newPost" method="get">
				
				<input type="hidden" name="subject" value="${param.subject }" />
				<div class="form-group">
					<textarea type="text" name="content" rows=3 class="form-control"></textarea>
				
				<br />
				<input class="btn btn-primary btn-block" type="submit" value="create post" />
				</div>
			</form>
		</div>
	</div>

</body>
</html>




