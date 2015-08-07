<%--
  Created by IntelliJ IDEA.
  User: hoon
  Date: 2015-07-25
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin - Bootstrap Admin Template</title>

  <!-- Bootstrap Core CSS -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <!--<link href="/css/sb-admin.css" rel="stylesheet"> -->

  <!-- Custom Fonts -->
  <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>
<body>
<div id="wrapper">
<h2>push 메시지 보내기</h2>
<div>Message</div>
<form action="/pushMessage" method="post">
  <input type="text" name="msg" size="40" required />
  <input type="submit" value="보내기" />
  <input type="reset" value="초기화" />

  <div class="row">
    <div class="col-lg-6">
      <h2>전체회원</h2>
      <div class="table-responsive">
        <table class="table table-bordered table-hover">
          <thead>
          <tr>
            <th></th>
            <th>이름 / 이메일</th>
            <th>지역</th>
            <th>생년월일 / 취미</th>
            <th>혈액형/종교</th>
            <th>image1</th>
          </tr>
          </thead>
          <tbody>

          <c:forEach items="${memberList}" var="memberDto">
            <tr>
              <td rowspan="2"><input type="checkbox" name="checkedList" value="${memberDto.mail}" /></td>
              <td>${memberDto.name}</td>
              <td>${memberDto.address1}</td>
              <td>${memberDto.birthday}(${memberDto.age})</td>
              <td>${memberDto.bloodType}</td>
              <td rowspan="2"><img src="/image/${memberDto.image1}" alt="Smiley face" height="84" width="84">
                <img src="/image/${memberDto.image2}" alt="Smiley face" height="84" width="84"></td>
            </tr>
            <tr>
              <td>${memberDto.mail}</td>
              <td>${memberDto.address2}</td>
              <td>${memberDto.hobby}</td>
              <td>${memberDto.religion}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
</form>
</div>
<!-- jQuery -->
<script src="/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
