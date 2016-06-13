<%@include file="/WEB-INF/view/template/header.jsp"%>
<hr />

<div class="row">
	<div class="col-md-10 col-md-offset-3">
		<c:if test="${not empty error}">
			<div class="error" style="color: red">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg" style="color: red">${msg}</div>
		</c:if>
		<h3>Login</h3>
		<form class="form-horizontal" action="/login" method="post">
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label"> Email</label>
				<div class="col-sm-3">
					<input id="email" class="form-control" type="email" name="email"
						placeholder="email" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">
					Password</label>
				<div class="col-sm-3">
					<input type="password" id="password" class="form-control"
						name="password" placeholder="password" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-sm btn-default" value="Sign In" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</div>
		</form>
	</div>
</div>


<p class="text-center">
	<a href="/">Back</a>
</p>

<hr />
<%@include file="/WEB-INF/view/template/footer.jsp"%>