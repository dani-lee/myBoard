 <%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="noticeList" value="${dataMap.noticeList }" />
<c:set var="pointList" value="${dataMap.pointList }" />
<c:set var="pageMaker" value="${dataMap.pageMaker }" />

<title>공지사항</title>

<head></head>

<body>
<div class="content-wrapper">
        <!-- Main content -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row md-2">
                    <div class="col-sm-6">
                        <h1>공지사항</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item">
                                <a href="list.do">
                                    <i class="fa fa-dashboard"></i>공지사항
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
                    <button type="button" class="btn btn-secondary"
                        onclick="OpenWindow('regist','공지사항등록',700,800);">글쓰기</button>
                    <div id="keyword" class="card-tools" style="width:550px;">
                        <div class="input-group row">
                            <!-- search bar -->

                            <!-- sort num -->
                            <select class="form-control col-md-3" name="perPageNum" id="perPageNum" onchange="list_go(1);">
								<option value="10">정렬개수</option>
								<option value="2" ${pageMaker.cri.perPageNum == 2 ? 'selected':''}>2개씩</option>
								<option value="3" ${pageMaker.cri.perPageNum == 3 ? 'selected':''}>3개씩</option>
								<option value="5" ${pageMaker.cri.perPageNum == 5 ? 'selected':''}>5개씩</option>
                            </select>

                            <!-- search bar -->
                          <%--   <select class="form-control col-md-3" name="searchType" id="searchType">
			                 	<option value=""  ${pageMaker.cri.searchType eq '' ? 'selected':'' }>검색구분</option>
			                 	<option value="i" ${pageMaker.cri.searchType eq 'i' ? 'selected':'' }>아이디</option>
			                    <option value="n" ${pageMaker.cri.searchType eq 'n' ? 'selected':'' }>이름</option>
			                    <option value="p" ${pageMaker.cri.searchType eq 'p' ? 'selected':'' }>전화번호</option>
			                    <option value="e" ${pageMaker.cri.searchType eq 'e' ? 'selected':'' }>이메일</option>
                            </select> --%>
                            <!-- keyword -->
                            <input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${pageMaker.cri.keyword }" />
                            <span class="input-group-append">
                                <button class="btn btn-secondary" type="button" id="searchBtn" data-card-widget="search" onclick="list_go(1)">
                                    <i class="fa fa-fw fa-search"></i>
                                </button>
                            </span>
                            <!-- end : search bar -->
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-bordered">
                                <tr class="text-center">
                                    <th style="width:25px;">NO</th>
                                    <th style="width:500px;">제목</th>
                                    <th>작성자</th>
                                    <th>등록날짜</th> <!-- yyyy-MM-dd  -->
                                    <th style="width:75px;">조회</th>
                                </tr>
								
									<c:forEach items="${pointList }" var="point">
									<tr onclick="location.href='detail?nno=${notice.nno}';" style="cursor:pointer; background-color:#F3F3F3;">
										<td class="text-center">${point.nno }</td>
										<%-- <c:if test="${notice.title } >= 100">
											<c:set var="title" value="${notice.title}" />
											<td>${title.substring(0,25)}</td>
										</c:if> --%>

									<c:choose>
											<c:when test="${fn:length(point.title) gt '50'}">
												<td><c:out value="📢  ${fn:substring(point.title  , 0, 49)}"/>...</td>
											</c:when>
											<c:otherwise>
												<td><c:out value="📢  ${point.title }"/></td>
											</c:otherwise>
									</c:choose>
										<td class="text-center">${point.writer }</td>
										<td class="text-center"><fmt:formatDate value="${point.regDate }" pattern="yyyy-MM-dd"/> </td>
										<td class="text-center">${point.viewCnt}</td>
									</tr>
									</c:forEach>
								
								<c:if test="${empty noticeList }">
									<tr>
										<td colspan="6" class="text-center">해당 내용이 없습니다.</td>
									</tr>
								</c:if>
								
								<c:if test="${!empty noticeList }">
									<c:forEach items="${noticeList }" var="notice">
									<tr onclick="location.href='detail?nno=${notice.nno}';" style="cursor:pointer;">
										<td class="text-center">${notice.nno }</td>
										<%-- <c:if test="${notice.title } >= 100">
											<c:set var="title" value="${notice.title}" />
											<td>${title.substring(0,25)}</td>
										</c:if> --%>
										
									<c:choose>
											<c:when test="${fn:length(notice.title ) gt '20'}">
												<td><c:out value="${fn:substring(notice.title   , 0, 19)}"/>...</td>
											</c:when>
											<c:otherwise>
												<td><c:out value="${notice.title  }"/></td>
											</c:otherwise>
									</c:choose>
										
										<td class="text-center">${notice.writer }</td>
										
										
										<td class="text-center"><fmt:formatDate value="${notice.regDate }" pattern="yyyy-MM-dd"/> </td>
										<td class="text-center">${notice.viewCnt}</td>
									</tr>
									</c:forEach>
								</c:if>
                            </table>
                        </div> <!-- col-sm-12 -->
                    </div> <!-- row -->
                </div> <!-- card-body -->
                
                <div class="card-footer">
					<%@ include file="/common/pagination.jsp" %>
	            </div>
            </div>
        </section>
    </div>
    

</body>

