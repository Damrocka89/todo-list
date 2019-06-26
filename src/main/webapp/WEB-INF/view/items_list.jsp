<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learn.util.Mappings" %>
<html>
<head>
    <title>Todo items</title>
</head>
<body>
    <div align ="center">
        <c:url var="addUrl" value="${Mappings.ADD_ITEMS}"/>
        <a href="${addUrl}">New Item</a>

        <table border="1" cellpadding="5">
            <caption><h2>Todo Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="item" items="${todoData.items}">
                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEMS}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${item.title}"/> </td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${deleteUrl}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>