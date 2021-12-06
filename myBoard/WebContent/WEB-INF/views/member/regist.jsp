<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<title>회원등록</title>

<body>

	<!-- Content Wrapper. Contains page content -->
	<div>
		<section class="content-header">
			<div class="container-fluid">
				<div class="row md-2">
					<div class="col-sm-6">
						<h1>회원등록</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item">
								<a href="#">
									<i class="fa fa-dashboard">회원관리</i>
								</a>
							</li>
							<li class="breadcrumb-item active">등록</li>
						</ol>
					</div>
				</div>
			</div>
		</section>
		<!-- Main content -->
		<section class="content register-page">
			<div class="container-fluid">
				<div class="login-logo">
<!-- 					<a href=""> -->
<!-- 						<b>회원 등록</b> -->
<!-- 					</a> -->
				</div>
				<!-- form start -->
				<div class="card">
					<div class="register-card-body">
						<form role="form" class="form-horizontal" action="regist" method="post">
							<input type="hidden" name="picture" />
							<div class="form-group" style="text-align: center;">
								<div class="mailbox-attachments clearfix" style="text-align: center;">
									<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 300px; width: 140px; margin: 0 auto;"></div>
									<div class="mailbox-attachment-info">
										<div class="input-group input-group-sm">
											<label for="inputFile" class=" btn btn-primary btn-sm btn-flat input-group-addon">파일선택</label>
											<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled />
											<span class="input-group-append-sm">
												<button type="button" class="btn btn-secondary btn-sm btn-append" onclick="upload_go();">업로드</button>
											</span>
										</div>
									</div>
								</div>
								<br />
							</div>
							<div class="form-group row">
								<label for="id" class="col-sm-3" style="font-size: 0.9em;"> <span style="color: red; font-weight: bold;">*</span>아이디
								</label>
								<div class="col-sm-9 input-group input-group-sm">
									<input name="id" onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;);" type="text" class="form-control" id="id" placeholder="13글자 영문자,숫자 조합">
									<span class="input-group-append-sm">
										<button type="button" onclick="idCheck_go();" class="btn btn-secondary btn-sm btn-append">중복확인</button>
									</span>
								</div>
							</div>
							<div class="form-group row">
								<label for="pwd" class="col-sm-3" style="font-size: 0.9em;"> <span style="color: red; font-weight: bold;">*</span>패스워드
								</label>
								<div class="col-sm-9 input-group-sm">
									<input class="form-control" name="pwd" type="password" class="form-control" id="pwd" placeholder="20글자 영문자,숫자,특수문자 조합" />
								</div>

							</div>
							<div class="form-group row">
								<label for="name" class="col-sm-3" style="font-size: 0.9em;"> <span style="color: red; font-weight: bold;">*</span>이 름
								</label>
								<div class="col-sm-9 input-group-sm">
									<input class="form-control" name="name" type="text" class="form-control" id="name" placeholder="이름을 입력하세요" onkeyup="this.value=this.value.trim();" />
								</div>

							</div>
							<div class="form-group row">
								<label for="authority" class="col-sm-3" style="font-size: 0.9em;">권 한</label>
								<div class="col-sm-9">
									<select name="authority" class="form-control" style="font-size: 0.9em;">
										<option value="ROLE_USER">사용자</option>
										<option value="ROLE_MANAGER">운영자</option>
										<option value="ROLE_ADMIN">관리자</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="email" class="col-sm-3" style="font-size: 0.9em;"><span style="color: red; font-weight: bold;">*</span>이메일</label>
								<div class="col-sm-9 input-group-sm">
									<input name="email" type="email" class="form-control" id="email" placeholder="example@naver.com">
								</div>
							</div>
							<div class="form-group row">
								<label for="phone" class="col-sm-3 control-label">전화번호</label>
								<div class="col-sm-9">
									<div class="input-group-sm">
										<select style="width: 75px;" name="phone" id="phone" class="form-control float-left">
											<option value="">-선택-</option>
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="017">017</option>
											<option value="018">018</option>
										</select> 
										<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>
										<input style="width: 68px;" name="phone" type="text" class="form-control float-left" />
										<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>
										<input style="width: 68px;" name="phone" type="text" class="form-control float-left" />
									</div>
								</div>
							</div>

							<div class="card-footer">
								<div class="row">
									<div class="col-sm-6">
										<button type="button" id="registBtn" onclick="regist_go();return false;" class="btn btn-primary">등&nbsp;&nbsp;록</button>
									</div>

									<div class="col-sm-6">
										<button type="button" id="cancelBtn" onclick="CloseWindow();" class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
									</div>

								</div>
							</div>
						</form>
					</div>
					<!-- register-card-body -->
				</div>
			</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	
	<form role="imageForm" action="upload/picture" method="post" enctype="multpart/form-data">
		<input type="file"   id="inputFile" name="pictureFile"  class="form-control" onchange="picture_go();" style="display:none;"/>
		<input type="hidden" id="oldFile"  name="oldpicture" value="" />
		<input type="hidden" name="checkUpload" value="0">
	</form>


<script>
let formData = "";
function picture_go() {
	
	formData = new FormData($('form[role="imageForm"]')[0]);
	let form = $('form[role="imageForm"]');
	let picture = form.find('[name="pictureFile"]')[0];

	//check if it is jpg
	let fileFormat = picture.value.substr(picture.value.lastIndexOf('.')+1).toUpperCase();
	if(!(fileFormat == "JPG" || fileFormat == "JPEG")){
		alert("JPEG 형식만 가능합니다.");
		picture.value = "";
		return;
	}
	
	//chaek size
	if(picture.files[0].size > 1024*1024*1){
		alert("1MB이하만 업로드 가능합니다.");
		picture.value = "";
		return;
	}
	
	form.find('[name="checkUpload"]').val(0);
	
	document.getElementById('inputFileName').value = picture.files[0].name;
	
	if(picture.files && picture.files[0]){
		let reader = new FileReader();
		reader.onload = function(e){
			$('div#pictureView').css({
				'background-image' 	  : 'url('+e.target.result+')',
				'background-position' : 'center',
				'background-size' 	  : 'cover',
				'background-repeat'	  : 'no-repeat'
			});
		}
		
		reader.readAsDataURL(picture.files[0]);
	} 
	
}

function upload_go(){
	
	if(!$('input[name="pictureFile"]').val()){
		alert("사진을 선택하세요");
		$('input[name="pictureFile"]').click();
		return;
	}
	if($('input[name="checkUpload"]').val()==1){
		alert("이미 업로드 된 사진입니다.");
		return;
	}
	
	$.ajax({
		url 		: 'picture',
		data 		: formData,
		type 		: 'post',
		processData : false,
		contentType : false,
		success 	: function(data){
			//업로드 확인 변수 세팅
			$('input[name="checkUpload"]').val(1);
			
			//저장된 파일명 저장
			$('input#oldFile').val(data);	//변경시 삭제될 파일명
			console.log(data);
			$('form[role="form"] input[name="picture"]').val(data);
			alert("사진이 업로드 되었습니다.");
		},
		error 		: function(error){
			alert("현재 사진 업로드가 불가합니다. \n 관리자에게 연락바랍니다.");
			console.log(error.status);
		}
	})
	
}	
let checkedID = "";
function idCheck_go(){
	let input_ID = $('input[name="id"]');
	
	if(!input_ID.val()){
		alert("아이디를 입력하세요.");
		input_ID.focus();
		return;
	}else{
		//아이디는 4~12자의 영문자와 숫자로만 입력
		let idReg = /^[a-z]{1}[a-zA-Z0-9]{3,12}$/;
		if(!idReg.test(input_ID.val())){
			alert("아이디는 첫글자는 영소문자이며, \n 4~13자의 영문자와 숫자로만 입력해야합니다.");
			input_ID.focus();
			return;
		}
	}
	
	$.ajax({
		url 		: 'idCheck?id='+input_ID.val().trim(),
		type 		: 'get',
		success 	: function(result){
			if(result == "DUPLICATED"){
				alert("중복된 아이디입니다.");
				$('input[name="id"]').focus();
			}else{
				alert("사용가능한 아이디입니다.");
				checkedID = input_ID.val().trim();
				input_ID.val(checkedID);
			}
		},
		error 		: function(error){
			alert("시스템 장애로 가입이 불가합니다. ")
		}
	})
}

function regist_go(){
	let input_PWD = $('input[name="pwd"]');
	
	if(!input_PWD.val()){
		alert("비밀번호를 입력하세요");
		input_PWD.focus();
		return;
	}else{
		let pwdReg = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^*+=-]).{8,20}$/;
		if(!pwdReg.test(input_PWD.val())){
			alert("비밀 번호는 8~20자로 영문자,숫자,특수문자 조합이어야합니다.");
			input_PWD.focus();
			return;
		}
	}
	
	let input_NAME = $('input[name="name"]');
	
	if(!input_NAME.val()){
		alert("이름을 입력하세요");
		input_NAME.focus();
		return;
	}
	
	let input_EMAIL = $('input[name="email"]');
	
	if(!input_EMAIL.val()){
		alert("이메일을 입력해주세요.");
		input_EMAIL.focus();
		return;
	}else{
		let emailReg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		if(!emailReg.test(input_EMAIL.val())){
			alert("이메일 형식에 맞게 입력해주세요.");
			input_EMAIL.focus();
			return;
		}
	}
	
	let input_PHONE = $('input[name="phone"]');
	
	if(input_PHONE.val()){
		let phoneReg = /^[0-9]{4}$/;
		$("input[name='phone']").each(function() {
			if(!phoneReg.test(input_PHONE.val())){
				alert("숫자만 입력 가능합니다.");
				input_PHONE.focus();
				return;
			}
		});
		
	}
	
	formDatas = $('form[role="form"]').serializeArray();
	console.log(formDatas);
	
	$.ajax({
		url 		: 'regist',
		type 		: 'post',
		dataType	: 'json',
		data 		: formDatas,
		success 	: function(result){
			if(result == "SUCCESS"){
				alert(result.name + "회원 등록에 성공했습니다.");
				window.close();
			}
		},
		error 		: function(error){
			alert("시스템 장애로 가입이 불가합니다. ")
		}
	}) 
	
	
}



</script>
</body>