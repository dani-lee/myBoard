<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>공지사항조회</title>
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
                            <li class="breadcrumb-item active">조회</li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>


        <section class="content">
            <div class="card">
                <!-- <div class="card-header with-border">
                </div> -->
                <div class="card-body">
                	<table class="table table-sm">
                    
                  <tbody>
                  	<tr>
                      <td style="width:150px; font-weight:bold;">제목</td>
					  <td colspan="3">${notice.title }</td>
                    </tr>
                    <tr>
                      <td style="font-weight:bold;">작성자</td>
                      <td>${notice.writer }</td>
                      <td style="width:150px; font-weight:bold;">작성일</td>
                      <td><fmt:formatDate value="${notice.regDate }" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    <tr>
                      <td style="font-weight:bold;">조회수</td>
                      <td colspan="3">${notice.viewCnt }</td>
                    </tr>
                    <tr>
                    	<td colspan="4">${notice.content }</td>
                    </tr>
                  </tbody>
                </table>
                </div> <!-- card-body -->
            </div>
            <div class="card-footer">
            
            	<table>
            		 <tr>
                    	<td style="font-weight:bold;">이전글</td>
                    	<td colspan="3">${noticePrevNext.prevTitle }</td>
                    </tr>
                    <tr>
                    	<td style="font-weight:bold;">다음글</td>
                    	<td colspan="3">${noticePrevNext.nextTitle }</td>
                    </tr>
            	</table>
	        </div>
        </section>
</div>

</body>