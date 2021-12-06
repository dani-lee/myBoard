<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<form role="form" class="form-horizontal" action="modify" method="post" enctype="multipart/form-data">
						<input type="hidden" name="id" value="${member.id }">
						<div class="card-body">
							<div class="row">
								<input type="hidden" name="oldPicture" value="${member.picture }" />
								<input type="file" id="inputFile" onchange="changePicture_go();" name="picture" style="display: none" />
								<div class="input-group col-md-12 text-center">
									<div class="col-md-12" style="text-align: center;">
										<div class="" id="pictureView" data-id="${member.id }" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; margin-bottom: 5px;"></div>

									</div>
								</div>
							</div>
							<input id="picture" class="form-control" type="hidden" name="uploadPicture" />
							<div class="form-group row">
									<label for="inputFile" class="col-3 btn btn-secondary btn-md btn-flat input-group-addon">사진변경</label>
									<input id="inputFileName" class="col-9 form-control" type="text" name="tempPicture" disabled value="-" />
							</div>
							<div class="form-group row">
								<label for="id" class="col-3 control-label text-center">아이디:</label>
								<%-- ${member.id } --%>
								<input type="text" class="col-9 form-control" id="id" name="id" value="${member.id }" disabled>
							</div>
							<div class="form-group row">
								<label for="pwd" class="col-3 control-label text-center">비밀번호:</label>
								<input type="password" class="col-9 form-control" id="pwd" name="pwd" value="${member.pwd }">
							</div>

							<div class="form-group row">
								<label for="email" class="col-3 control-label text-center">이메일:</label>
								<input type="email" class="col-9 form-control" id="email" value="${member.email }" name="email">
							</div>

							<div class="col-sm-12">
								<!-- select -->
								<div class="form-group row">
									<label for="enabled" class="col-3 control-label text-center">상태:</label> <select class="col-9 form-control">
										<option value="0" id="leave" ${member.enabled eq '0' ? 'selected':'' }>퇴사</option>
										<option value="1" id="employed" ${member.enabled eq '1' ? 'selected':'' }>재직</option>
										<option value="2" id="absence" ${member.enabled eq '2' ? 'selected':'' }>휴직</option>
									</select>
								</div>
							</div>

							<div class="form-group row">
								<label for="regDate" class="col-3 control-label text-center">입사일:</label>
								<input type="date" class="col-9 form-control" name="regDate" value="<fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd" />">

								<!--                             	<button type="button" class="btn btn-block btn-secondary" style="width:100px;">수정</button> -->
								<!--                             	<input type="date" class="form-control" id="regdate" name="regdate"> -->
							</div>

							<div class="form-group row">
								<label for="phone" class="col-3 control-label text-center">휴대폰번호:</label>
								<input type="text" class="col-9 form-control" id="phone" name="phone" value="${member.phone }">
							</div>

							<div class="form-group row">
								<label for="name" class="col-3 control-label text-center">이름:</label>
								<input type="text" class="col-9 form-control" id="name" name="name" value="${member.name }">
							</div>

							<div class="form-group row">
								<label for="register" class="col-3 control-label text-center">등록자:</label>
								<input type="text" class="col-9 form-control" id="register" name="register" value="${member.register }">
							</div>

							<div class="form-group row">
								<label for="address" class="col-3 control-label text-center">주소:</label>
								<input type="text" class="col-9 form-control" id="address" name="address" value="${member.address }">
							</div>

							<div class="form-group row">
								<label for="authority" class="col-3 control-label text-center">권 한</label>
								<div class="col-sm-9">
									<select name="authority" class="form-control">
										<option value="ROLE_USER" ${member.authority eq 'ROLE_USER' ? 'selected':'' }>사용자</option>
										<option value="ROLE_MANAGER" ${member.authority eq 'ROLE_MANAGER' ? 'selected':'' }>운영자</option>
										<option value="ROLE_ADMIN" ${member.authority eq 'ROLE_ADMIN' ? 'selected':'' }>관리자</option>
									</select>
								</div>
							</div>
						</div>
						<!-- /.card-body -->

						<div class="card-footer row">
							<div class="col-2"></div>
							<div class="col-8 text-center">
								<button type="button" id="modifyBtn" class="col-sm-3 btn btn-secondary" onclick="modify_go();" style="margin: 10px;">수정</button>
								<button type="button" id="cancleBtn" class="col-sm-3 btn btn-default pull-right" onclick="history.go(-1);">취소</button>
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

<script>
window.onload=function(){
   MemberPictureThumb($('#pictureView')[0], '${member.picture}', '<%=request.getContextPath()%>');
}

function changePicture_go() {
	let picture = $('input#inputFile')[0];
	let fileFormat = picture.value.substr(
			picture.value.lastIndexOf('.') + 1).toUpperCase();

	//이미지 확장자 jpg확인
	if (!(fileFormat == "JPG" || fileFormat == "JPEG")) {
		alert("이미지는 jpg형식만 가능합니다.");
		return;
	}

	//이미지 파일 용량 체크
	if (picture.files[0].size > 1024 * 1024 * 1) {
		alert("사진 용량은 1MB 이하만 가능합니다.");
		picture.value = "";
		return;
	}

	document.getElementById('inputFileName').value = picture.files[0].name;

	if (picture.files && picture.files[0]) {
		let reader = new FileReader();
		reader.onload = function(e) {
			$('div#pictureView').css({
				'background-image' : 'url(' + e.target.result + ')',
				'background-position' : 'center',
				'background-size' : 'cover',
				'background-repeat' : 'no-repeat'
			});
		}
		reader.readAsDataURL(picture.files[0]);
	}

	//이미지 변경 확인
	$('input[name="uploadPicture"]').val(picture.files[0].name);
}

function modify_go() {
	let form = $('form[role="form"]');
	form.submit();
}
</script>
</body>