<%@include file="/WEB-INF/view/template/header.jsp"%>
<hr>

<div class="row">
	
	<c:if test="${user eq 'null'}">
		<h4 class="text-center"><a href="/login">Login</a></h4>
	</c:if>
	<div class="col-md-10 col-md-offset-3">
		<c:if test="${user ne 'null'}">
		<div class="col-md-4">
			<h4>Hello, ${user.name} !</h4>
			<form action="/logout" method="post">
				<input type="submit" value="Sign Out" class="btn btn-default" /> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
		<div class="col-md-5">
			<h4>Update</h4>
			<form class="form-horizontal" action="/save" method="post">
				<div class="form-group">
					<label for="email" class="col-sm-4 control-label">Email</label>
					<div class="col-sm-8">
						<input type="email" id="email" class="form-control" name="email"
							placeholder="Email" value="${user.email}">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-4 control-label">Name</label>
					<div class="col-sm-8">
						<input type="text" id="name" class="form-control" name="name"
							placeholder="Name" value="${user.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-4 control-label">Password</label>
					<div class="col-sm-8">
						<input type="password" id="password" class="form-control"
							name="password" placeholder="Password" value="${user.password}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-3">
						<button type="submit" class="btn btn-default">Update</button>
					</div>
				</div>
				<input type="hidden" name="userId" value="${user.userId}">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>	
		</c:if>
	</div>
</div>

<hr>

<div class="row">
	<div class="col-md-10 col-md-offset-3">
		<h3>Register</h3>
		<form class="form-horizontal" action="/save" method="post">
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-3">
					<input type="email" id="email" class="form-control" name="email"
						placeholder="Email">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-3">
					<input type="text" id="name" class="form-control" name="name"
						placeholder="Name">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-3">
					<input type="password" id="password" class="form-control"
						name="password" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Create</button>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</div>

<hr>
<%@include file="/WEB-INF/view/template/footer.jsp"%>
