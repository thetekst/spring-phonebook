<%@include file='components/header.jsp'%>
    <h1>User list</h1>

    <c:if test="${not empty users}">
        <table class="table">
            <tr>
                <th>#</th>
                <th>Username</th>
                <th>Phone</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getPhone()}</td>
                    <td><a href="#edit-${user.getId()}" element-id="${user.getId()}" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td><a href="#remove-${user.getId()}" element-id="${user.getId()}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </c:if>
<%@include file='components/modal.jsp'%>
<%@include file='components/footer.jsp'%>