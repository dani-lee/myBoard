<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>회원목록</title>

<head></head>

<div class="content-wrapper">
        <!-- Main content -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row md-2">
                    <div class="col-sm-6">
                        <h1>회원목록</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item">
                                <a href="list.do">
                                    <i class="fa fa-dashboard"></i>회원관리
                                </a>
                            </li>
                            <li class="breadcrumb-item active">목록</li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>


        <section class="content">
            <div class="card">
                <div class="card-header with-border">
                    <button type="button" class="btn btn-primary"
                        onclick="OpenWindow('registForm.do','회원등록',800,700);">회원등록</button>
                    <div id="keyword" class="card-tools" style="width:550px;">
                        <div class="input-group row">
                            <!-- search bar -->

                            <!-- sort num -->
                            <select class="form-control col-md-3" name="perPageNum" id="perPageNum">
								
                            </select>

                            <!-- search bar -->
                            <select class="form-control col-md-3" name="searchType" id="searchType">
			                 	<option data-select2-id="5" value="id">아이디</option>
			                    <option data-select2-id="24" value="name">이름</option>
			                    <option data-select2-id="24" value="phone">전화번호</option>
			                    <option data-select2-id="24" value="email">이메일</option>
                            </select>
                            <!-- keyword -->
                            <input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요."
                                value="" />
                            <span class="input-group-append">
                                <button class="btn btn-primary" type="button" id="searchBtn"
                                    data-card-widget="search" onclick="">
                                    <i class="fa fa-fw fa-search"></i>
                                </button>
                            </span>
                            <!-- end : search bar -->
                        </div>
                    </div>
                </div>
                <div class="card-body" style="text-align:center;">
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-bordered">
                                <tr>
                                    <th>아이디</th>
                                    <th>패스워드</th>
                                    <th>이메일</th>
                                    <th>전화번호</th>
                                    <th>등록날짜</th> <!-- yyyy-MM-dd  -->
                                </tr>
								
<%-- 								<c:remove var="memberList" /> --%>
								<c:if test="${empty memberList }">
									<tr>
										<td colspan="5" class="text-center">해당 내용이 없습니다.</td>
									</tr>
								</c:if>
								
								<c:if test="${!empty memberList }">
									<c:forEach items="${memberList }" var="member">
									<tr>
										<td>${member.id }</td>
										<td>${member.pwd }</td>
										<td>${member.email }</td>
										
										<c:if test="${!empty member.phone }">
											<c:set var="phone"  value="${member.phone.replace('-','') }"/>
											<td>${phone.substring(0,3)}-${phone.substring(3,7)}-${phone.substring(7)}</td>
										</c:if>
										<c:if test="${empty member.phone }">
											<td></td>
										</c:if>
										
										<td><fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd"/> </td>
									</tr>
									</c:forEach>
								</c:if>
							
							
							<c:if test="${pagingVo.totalCount > 0 }">
                                            <tr>
                                                <td colspan="5" align="center">
                                                    <c:if test="${pagingVo.firstPageNo > pagingVo.pageSize }">
                                                        <a href="memberlist?pageNo=${pagingVo.firstPage - pagingVo.pageSize }">[이전]</a>
                                                    </c:if>

                                                    <c:forEach var="i" begin="${pagingVo.firstPageNo }" end="${pagingVo.lastPageNo }">
                                                        <c:if test="${i eq pagingVo.currentPageNo}">
                                                            <a style="color:blue;"
                                                                href="memberlist?pageNo=${i }">${i }</a>
                                                        </c:if>
                                                        <c:if test="${i ne pagingVo.currentPageNo}">
                                                            <a style="color:black;"
                                                                href="memberlist?pageNo=${i }">${i }</a>
                                                        </c:if>
                                                    </c:forEach>

                                                    <c:if test="${pagingVo.lastPageNo <  pagingVo.totalPageCount}">
                                                        <a href="memberlist?pageNo=${pagingVo.firstPageNo + pagingVo.pageSize }">[다음]</a>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:if>
                                        
                                        
                            </table>
                        </div> <!-- col-sm-12 -->
                    </div> <!-- row -->
                </div> <!-- card-body -->
                <div class="card-footer">

                </div>
            </div>
        </section>
    </div>

</body>

