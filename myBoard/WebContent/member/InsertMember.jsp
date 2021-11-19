<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<title>회원등록</title>

<head></head>

<body>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">

            <div class="card card-secondary">
                <div class="card-header">
                    <h3 class="card-title">회원등록</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <form action="insertmember" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="id">아이디:</label>
                            <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요" name="id">
                        </div>
                        <div class="form-group">
                            <label for="pwd">비밀번호:</label>
                            <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요"
                                name="pwd">
                        </div>

                        <div class="form-group">
                            <label for="email">이메일:</label>
                            <input type="email" class="form-control" id="email" placeholder="이메일주소를 입력하세요"
                                name="email">
                        </div>
                        <div class="form-group">
                            <label for="picture">사진:</label>
                            <div class="input-group">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="picture" name="picture">
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
                            <input type="date" class="form-control" id="regDate" name="regDate">
                        </div>

                        <div class="form-group">
                            <label for="phone">휴대폰번호:</label>
                            <input type="text" class="form-control" id="phone" name="phone">
                        </div>

                        <div class="form-group">
                            <label for="name">이름:</label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>

                        <div class="form-group">
                            <label for="register">등록자:</label>
                            <input type="text" class="form-control" id="register" name="register">
                        </div>

                        <div class="form-group">
                            <label for="address">주소:</label>
                            <input type="text" class="form-control" id="address" name="address">
                        </div>
                        
                        <div class="form-group">
                            <label for="authority">권한:</label>
                            <input type="text" class="form-control" id="authority" name="authority">
                        </div>

                        <!-- /.card-body -->

                        <div class="card-footer">
                            <button type="submit" class="btn btn-block btn-secondary" style="float:rigth;">등록</button>
                        </div>
                </form>
            </div>

        </div>
    </div>
</div>