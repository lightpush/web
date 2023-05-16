<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-16
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>로그인</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../css/default.css">
</head>
<body>
<%@include file="/WEB-INF/jsp/header.jsp" %>
<main>
  <h3>로그인</h3>
  <form action="signin" method="post">
    <ul class="list">
      <li><input type="email" name="email" placeholder="이메일" required
                 autofocus/></li>
      <li><input type="password" name="password" placeholder="비밀번호"
                 required/>
      </li>
    </ul>
    <p>
      <button type="submit">로그인</button>
    </p>
  </form>
  <c:if test="${param.mode=='FAILURE'}">
    <p class="warn">로그인 실패입니다.</p>
  </c:if>
</main>
</body>
</html>