<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<body>
<h3>회원목록</h3>
<p>페이지 : ${param.page}</p>
<ul>
    <c:forEach var="user" items="${userList}">
        <li>아이디:${user.userId}, 이름:${user.name}, 이메일:${user.email}</li>
    </c:forEach>
</ul>
</body>
</html>
