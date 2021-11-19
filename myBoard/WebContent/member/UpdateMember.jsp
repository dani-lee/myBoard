<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<title>회원정보 수정</title>

<head></head>

<body>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">

                <div class="card card-secondary">
                    <div class="card-header">
                        <h3 class="card-title">회원정보 수정</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- form start -->
                    <form action="updatemember" method="post">
                        <input type="hidden" name="id" value="${member.id }">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="id">아이디:</label>
                                <%-- ${member.id } --%>
                                    <input type="text" class="form-control" id="id" name="id"
                                        value="${member.id }" disabled>
                            </div>
                            <div class="form-group">
                                <label for="pwd">비밀번호:</label>
                                <input type="password" class="form-control" id="pwd" name="pwd"
                                    value="${member.pwd }">
                            </div>

                            <div class="form-group">
                                <label for="email">이메일:</label>
                                <input type="email" class="form-control" id="email" value="${member.email }"
                                    name="email">
                            </div>
                            <div class="form-group">
                                <label for="picture">사진:</label>
                                <div class="input-group">
                                    <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="picture"
                                            name="picture">
                                        <label class="custom-file-label" for="exampleInputFile">사진 선택</label>
                                    </div>
                                    <div class="input-group-append">
                                        <span class="input-group-text">Upload</span>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-12">
                                <!-- select -->
                                <div class="form-group">
                                    <label>상태:</label>
                                    <select class="custom-select">
                                        <option value="0" name="0" id="leave">퇴사</option>
                                        <option value="1" name="1" id="employed">재직</option>
                                        <option value="2" name="2" id="absence">휴직</option>
                                    </select>
                                </div>
                            </div>
                            
                             <div class="form-group">
                            	<label for="regDate">입사일:</label>
                            	<input type="date" class="form-control" name="regDate" value="<fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd" />">
                            	
<!--                             	<button type="button" class="btn btn-block btn-secondary" style="width:100px;">수정</button> -->
<!--                             	<input type="date" class="form-control" id="regdate" name="regdate"> -->
                        	</div>

                            <div class="form-group">
                                <label for="phone">휴대폰번호:</label>
                                <input type="text" class="form-control" id="phone" name="phone"
                                    value="${member.phone }">
                            </div>

                            <div class="form-group">
                                <label for="name">이름:</label>
                                <input type="text" class="form-control" id="name" name="name"
                                    value="${member.name }">
                            </div>

                            <div class="form-group">
                                <label for="register">등록자:</label>
                                <input type="text" class="form-control" id="register" name="register"
                                    value="${member.register }">
                            </div>

                            <div class="form-group">
                                <label for="address">주소:</label>
                                <input type="text" class="form-control" id="address" name="address"
                                    value="${member.address }">
                            </div>
                            
                             <div class="form-group">
                            <label for="authority">권한:</label>
                            <input type="text" class="form-control" id="authority" name="authority">
                        </div>

                            <!-- /.card-body -->

                            <div class="card-footer">
                                <button type="submit" class="btn btn-block btn-secondary"
                                    style="float:rigth;">수정</button>
                            </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
   </body>