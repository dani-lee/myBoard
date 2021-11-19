<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<title>회원정보</title>

<head></head>

<body>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">

                <div class="card">
                    <div class="card-header">
                        <h3 class="col-9 card-title">회원 정보</h3>
                        <div class="col-3 row">
                            <a href="updatemember?id=${member.id }"><button type="button"
                                    class="btn btn-block btn-primary"
                                    style="width:100px; margin-right:10px">수정</button></a>
                            <a href="deletemember?id=${member.id }"><button type="button"
                                    class="btn btn-block btn-danger"
                                    style="width:100px;">삭제</button></a>
                        </div>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table class="table table-bordered">
                            <thead>
                                
                            </thead>
                            <tbody>
                                <tr>
                                    <td>아이디</td>
                                    <td>${member.id }</td>
                                </tr>

                                <tr>
                                    <td>비밀번호</td>
                                    <td>${member.pwd }</td>
                                </tr>

                                <tr>
                                    <td>사진</td>
                                    <td><img src="${member.picture }"></td>
                                </tr>
                                <tr>

                                    <c:choose>
                                        <c:when test="${member.enabled == 0}">
                                            <c:set var="n_enabled" value="퇴사" />
                                        </c:when>
                                        <c:when test="${member.enabled == 1}">
                                            <c:set var="n_enabled">재직</c:set>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="n_enabled">휴직</c:set>
                                        </c:otherwise>
                                    </c:choose>

                                    <td>상태</td>
                                    <td>${n_enabled }</td>
                                </tr>

                                <tr>
                                    <td>입사일</td>
                                    <td>
                                        <fmt:formatDate value="${member.regDate }"
                                            pattern="yyyy-MM-dd" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>휴대폰번호</td>
                                    <td>${member.phone }</td>
                                </tr>

                                <tr>
                                    <td>이름</td>
                                    <td>${member.name }</td>
                                </tr>

                                <tr>
                                    <td>등록자</td>
                                    <td>${member.register }</td>
                                </tr>
                                <tr>
                                    <td>주소</td>
                                    <td>${member.address }</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.card-body -->



                </div>
            </div>
        </div>
       </div>
</body>