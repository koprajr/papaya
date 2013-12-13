<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container container-main">
<div class="row">
    <div class="page-header">
        <h2>All Users:</h2>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>Delete</th>
            <th>Username</th>
            <%--<th>Password</th>--%>
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
                    <%--<td>${u.password}</td>--%>
                <td>${u.email}</td>
                <td>${u.phone}</td>
            </tr>
        </s:iterator>
        </tbody>
    </table>


    <div class="page-header">
        <h2>Add a new user:</h2>
    </div>
	
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

    <br>

    <div class="page-header">
        <h2>Bulk User Creation: <small>through CSV upload</small></h2>
    </div>

    <s:form action="uploadAction" method="POST" enctype="multipart/form-data">
        <s:file name="upload" size="40" ></s:file>
        <s:submit cssClass="btn btn-primary"/>
    </s:form>

</div>
</div>
