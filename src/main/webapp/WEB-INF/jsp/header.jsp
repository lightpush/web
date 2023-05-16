<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-16
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/">홈</a></li>
        <li><a href="../user/userList?count=20&page=1">회원목록</a></li>
        <c:choose>
            <c:when test="${empty sessionScope.me_userId}">
                <li><a href="../user/signinForm">로그인</a></li>
                <li><a href="../user/signupForm">회원가입</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="../user/myInfo">${sessionScope.me_name}님</a>
                </li>
                <li><a href="../user/signout">로그아웃</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</header>