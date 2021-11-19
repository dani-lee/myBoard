<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>검색 : 회원목록</title>

<head></head>

<body>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="col-12 card-header">
                                <!-- 								<div class="row"> -->
                                <h3 class="col-7 card-title">회원리스트</h3>

                                <div class="col-5 card-tools">
                                    <form method="post" action="search">


                                        <div class="row">

                                            <div class="col-3">
                                                <div class="form-group">
                                                    <select name="searchOption" class="select2 select2-hidden-accessible" style="width: 100%;" data-select2-id="3" tabindex="-1" aria-hidden="true">
                                                        <option data-select2-id="5" value="id">아이디</option>
                                                        <option data-select2-id="24" value="name">이름</option>
                                                        <option data-select2-id="24" value="phone">전화번호</option>
                                                        <option data-select2-id="24" value="email">이메일</option>
                                                    </select>
                                                </div>
                                            </div>


                                            <div class="col-9 input-group input-group-sm"
                                                style="width: 150px;">
                                                <input type="text" name="keyword"
                                                    class="form-control float-right"
                                                    placeholder="Search">

                                                <div class="input-group-append">
                                                    <button type="submit" class="btn btn-default"
                                                        style="height:31px;">
                                                        <i class="fas fa-search"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>



                            <!-- /.card-header -->

                            <div class="card-body table-responsive p-0">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                        <tr>
                                            <th>아이디</th>
                                            <th>이메일</th>
                                            <th>이름</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${searchList.size() gt 0 }">
                                                <c:forEach items="${searchList }" var="member">
                                                    <tr>
                                                        <td><a href="detail?id=${member.id }">${member.id
                                                                }</a></td>
                                                        <td>${member.email }</td>
                                                        <td>${member.name }</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td colspan="4">회원정보가 없습니다.</td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:if test="${pagingVo.totalCount > 0 }">
                                            <tr>
                                                <td colspan="4" align="center">
                                                    <c:if
                                                        test="${pagingVo.firstPageNo > pagingVo.pageSize }">
                                                        <a
                                                            href="memberlist?pageNo=${pagingVo.firstPage - pagingVo.pageSize }">[이전]</a>
                                                    </c:if>

                                                    <c:forEach var="i" begin="${pagingVo.firstPageNo }" end="${pagingVo.lastPageNo }">
                                                        <c:if test="${i eq pagingVo.currentPageNo}">
                                                            <a style="color:blue;" href="memberlist?pageNo=${i }">${i}</a>
                                                        </c:if>
                                                        <c:if test="${i ne pagingVo.currentPageNo}">
                                                            <a style="color:black;" href="memberlist?pageNo=${i }">${i}</a>
                                                        </c:if>
                                                    </c:forEach>

                                                    <c:if
                                                        test="${pagingVo.lastPageNo <  pagingVo.totalPageCount}">
                                                        <a href="memberlist?pageNo=${pagingVo.firstPageNo + pagingVo.pageSize }">[다음]</a>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:if>


                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>

                <a href="insertmember"><button type="button" class="btn btn-block btn-secondary"  style="width:150px; float: right;">회원등록</button></a>

            </div>
        </div>
    </div>
</body>