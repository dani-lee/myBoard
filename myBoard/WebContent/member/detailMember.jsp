<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<title>회원정보</title>

<head></head>

<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">

				<div class="card card-secondary">
					<div class="card-header">
						<h3 class="card-title">회원 정보</h3>
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
									<td>
										<div id="pictureView" data-id="${member.id }" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
									</td>
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
									<td><fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd" /></td>
								</tr>
								<tr>
									<td>휴대폰번호</td>
									<c:if test="${!empty member.phone }">
									<c:set var="phone" value="${member.phone.replace('-','') }" />
									<td>${phone.substring(0,3)}-${phone.substring(3,7)}-${phone.substring(7)}</td>
							</c:if>
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
					<div class="card-footer" style="padding: 5px 0;">
					<div class="row">
						<%-- 	<c:if test="${loginUser.id eq member.id }"> --%>
						<div class="col-sm-3 text-center">
							<button type="button" onclick="location.href='modify?id=${member.id}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
						</div>

						<div class="col-sm-3 text-center">
							<button type="button" onclick="" id="deleteBtn" class="btn btn-danger">삭 제</button>
						</div>

						<div class="col-sm-3 text-center">
							<c:if test="${member.enabled ne 0}">
								<button type="button" onclick="" id="stopBtn" class="btn btn-btn-info">비활성</button>
							</c:if>
							<c:if test="${member.enabled eq 0}">
								<button type="button" onclick="" id="activeBtn" class="btn btn-btn-info">활&nbsp;&nbsp;성</button>
							</c:if>
						</div>
						<%-- </c:if> --%>

						<div class="col-sm-3 text-center">
							<button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-btn-info pull-right">닫 기</button>
						</div>
					</div>
				</div>


				</div>
			</div>
		</div>
	</div>

	<script>

window.onload=function(){
   MemberPictureThumb(document.querySelector('[data-id="${member.id}"]'), '${member.picture}', '<%= request.getContextPath()%>');
}
</script>
</body>