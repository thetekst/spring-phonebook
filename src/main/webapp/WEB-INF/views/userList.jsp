<%@include file='components/header.jsp' %>
<h1>User list</h1>

<form:form method="post" action="${basePath}/user" modelAttribute="user" id="addUserForm" class="form-inline">
    <div class="form-group">
        <form:input path="username" class="form-control" id="addUsername" name="addUsername" placeholder="username"/>
    </div>
    <div class="form-group">
        <form:input path="phone" type="text" class="form-control" id="addPhone" name="addPhone" placeholder="phone"/>
    </div>
    <a class="btn btn-primary" id="addNewContact">Add</a>
</form:form>

<br/>

<c:if test="${not empty users}">
    <table class="table">
        <tr>
            <th>#</th>
            <th>Username</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>

        <c:forEach var="userObj" items="${users}">
            <tr item="${userObj.getId()}">
                <td>${userObj.getId()}</td>
                <td class="item-username">${userObj.getUsername()}</td>
                <td class="item-phone">${userObj.getPhone()}</td>
                <td><a href="#edit-${userObj.getId()}" element-id="${userObj.getId()}" data-toggle="modal"
                       data-target="#myModal"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                </td>
                <td><a href="#remove-${userObj.getId()}" element-id="${userObj.getId()}"><span
                        class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                </td>
            </tr>
        </c:forEach>

    </table>
</c:if>
<%@include file='components/modal.jsp' %>
<%@include file='components/footer.jsp' %>