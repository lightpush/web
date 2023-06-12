<!DOCTYPE html>
<html>
<head>
    <title>내정보</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/default.css">
</head>
<body>
<%@include file="/WEB-INF/jsp/header.jsp" %>
<main>
    <h3>회원 정보</h3>
    <table class="info">
        <tr>
            <th>회원번호</th>
            <td>${user.userId}</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${user.name}</td>
        </tr>
    </table>
</main>
</body>
</html>