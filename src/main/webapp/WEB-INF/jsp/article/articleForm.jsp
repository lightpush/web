<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-30
  Time: 오후 1:07
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>글쓰기</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../css/default.css">
  <style>
    input[type='text'] {width:90%;}
    textarea {width:90%; height:200px;}
  </style>
</head>
<body>
<%@include file="/WEB-INF/jsp/header.jsp" %>
<main>
  <h3>글쓰기</h3>
  <form action="./addArticle" method="post">
    <p><input type="text" name="title" placeholder="제목" required autofocus/></p>
    <p><textarea name="content" placeholder="내용" required></textarea></p>
    <p>
      <button type="submit">등록</button>
    </p>
  </form>
</main>
</body>
</html>