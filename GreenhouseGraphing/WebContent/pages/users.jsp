<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
	<h2>Users</h2>
	
	<p>Add a new user</p>
	
	<form action="createUser" class="form-inline" method="post">
		<div class="form-group">
			<s:textfield name="user.username" placeholder="Username" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<s:textfield name="user.email" placeholder="Email" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<s:textfield name="user.phone" placeholder="Phone" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<s:textfield name="user.password" placeholder="Password" cssClass="form-control"/>
		</div>
		<button type="submit" class="btn btn-primary">Create</button>
	</form>
	
	<hr />
	
	<p>These values are pulled from the users table in the Derby database setup on the lab server.</p>

	<table class="table">
		<thead>
			<tr>
				<th>Delete</th>
				<th>Username</th>
				<th>Password</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="users" var="u">
				<tr>
					<td>
						<s:url action="deleteUser" var="delete">
							<s:param name="user.id">${u.id}</s:param>
						</s:url>
						<s:a href="%{delete}" cssClass="btn btn-danger btn-xs">Delete</s:a>
					</td>
					<td>${u.username}</td>
					<td>${u.password}</td>
					<td>${u.email}</td>
					<td>${u.phone}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</div>