<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>User List</h3>
<form method="post">
    <p>ID: <input name="id" value="${curentUser.id}"></p>
    <p>Password: <input name="password" value="${curentUser.password}"></p>
    <p>Admin: <input type="checkbox" name="admin" ${curentUser.admin ? "checked":""}></p>
    <button>Save</button>
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Password</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.password}</td>
            <td>${u.admin ? "Admin" : "User"}</td>
            <td>
                <a href="delete-user?id=${u.id}">Delete</a>
                <a href="update-user?id=${u.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>