<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>상품수정</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/26.0.0/classic/ckeditor.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<style type="text/css">


<style type="text/css">
	#result_card img{
		max-width: 100%;
	    height: auto;
	    display: block;
	    padding: 5px;
	    margin-top: 10px;
	    margin: auto;	
	}
	#result_card {
		position: relative;
	}
	.imgDeleteBtn{
	    position: absolute;
	    top: 0;
	    right: 5%;
	    background-color: #ef7d7d;
	    color: wheat;
	    font-weight: 900;
	    width: 30px;
	    height: 30px;
	    border-radius: 50%;
	    line-height: 26px;
	    text-align: center;
	    border: none;
	    display: block;
	    cursor: pointer;	
	}
	#wrap{}
#header{background-dolor : #fff}

</style>
</head>
<body>
	<div id="wrap">
		<header id ="header">
			<div class="container">              
				    <div class="header clearfix">
					    <ul class="list1 clearfix">
						    <li class="home"><a href="/">홈으로</a></li>					
					    </ul>
					        <ul class="list2">
						        <li class="log">
                                <a href="/admin/admin_main">관리자페이지</a></li>                             
                            </ul>
                    </div>                   
			</div>
		</header><!-- header -->
	</div>
	

<div class="admin_content_wrap">
	<div class="admin_content_subject"><span>상품수정</span></div>
	<div class="admin_content_main">
		
		<form action="/admin/product_modify?${_csrf.parameterName}=${_csrf.token}" method="post"  enctype="multipart/form-data">
		    <input type="hidden" name="product_number" value="${updateDetail.product_number}" />
		    <input type="hidden" name="uuid" id="uuid" />
		    <input type="hidden" name="fileName" id="fileName" />
		    <input type="hidden" name="uploadPath" id="uploadPath" />
			<div class="form_section">
				<div class="form_section_title">
					<label>상품 이름</label>
				</div>
				<div class="form_section_content">
					<input type="text" name="product_name" value="${updateDetail.product_name}">
					<span id="ck_warn productName_warn">상품이름(수정)을 입력 해주세요</span>
				</div>
			</div>
			
			<div class="form_section">
				<div class="form_section_title">
					<label>상품가격</label>
			</div>
			<div class="form_section_content">
				<input name="product_price" value="0">
				<span class="ck_warn productPrice_warn">상품 가격을 입력해주세요</span>
			</div>
		</div>
		<div class="form_section">
			<div class="form_section_title">
				<label>상품 재고</label>
			</div>
			<div class="form_section_content">
				<input name="product_stock" value="0">
				<span class="ck_warn productStock_warn">상품 재고를 입력해 주세요</span>
			</div>
		</div>
		<div class="form_section">
			<div class="form_section_title">
				<label>상품 설명</label>
			</div>
			<div class="form_section_content bit">
				<textarea rows="5" cols="30" name="product_desc" id="productText_textarea">
				
				
				</textarea>
				<span class="ck_warn productText_warn">상품 설명을 입력해주세요</span>
			</div>
		</div>
		
		
			<div class="btn_section">
			
				<button type="submit" >수정</button>
			</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>	
	
	</div>
	
</div>

      
<script>

 let enrollForm = $("#enrollForm")
	
  /*	취소버튼  */
$("cancelBtn").click(function(){

	location.href="/admin/product_manage"

});


/* 등록버튼 */
$("enrolllBtn").on(function(e){

 e.preventDefault();

 /* 체크 변수 */

	let productNameCk = false;
	let categoryCodeCk = false;
	let productPriceCk = false;
	let productStockCk = false;
	let productTextCk = false;

/* 입력값, 체크 대상 변수 */

	let productName  = $("input[name='productName']").val();  //상품 이름
	let categoryCode = $("input[name='categoryCode']").val(); // 분류 이름
	let productPrice = $("input[name='productPrice']").val(); // 상품 가격
	let productStock = $("input[name='productStock']").val(); // 상품 재고
	let productText  =  $(".bit p").html();					// 상품 설명
	
/* 공란 체크 */


if(productName){
	$(".productName_warn").css('display', 'none');
	productNameCk = true;
}else{
	$(".productName_warn").css('display', 'block');
	productNameCk = false;
}


if(categoryCode){
	$(".categoryCode_warn").css('display', 'none');
	categoryNameCk = true;
}else{
	$(".categoryCode_warn").css('display', 'block');
	categoryNameCk = false;
}

if(productPrice){
	$(".productPrice_warn").css('display', 'none');
	productPriceCk = true;
}else{
	$(".productPrice_warn").css('display', 'block');
	productPriceCk = false;
}

if(productStock){
	$(".productStock_warn").css('display', 'none');
	productStockCk = true;
}else{
	$(".productStock_warn").css('display', 'block');
	productStockCk = false;
}

if(productText != '<br data-cke-filler="true">'){
	$(".productText_warn").css('display', 'none');
	productTextCk = true;
}else{
	$(".productText_warn").css('display', 'block');
	productTextCk = false;
}

/* 최종 확인*/
if(productNameCk &&  categoryCodeCk &&  productPriceCk &&  productPriceCk &&  productText){
	//alert('통과');
	enrollForm.submit();	
}else{
	return false;
}

});
</script>
  
<script>
	/* 이미지 업로드 */
	$("input[type='file']").on("change", function(e){
		
			
		
		let formData = new FormData();
		let fileInput = $('input[name="uploadFile"]');
		let fileList = fileInput[0].files;
		let fileObj = fileList[0];
		
	
		
		if(!fileCheck(fileObj.name, fileObj.size)){
			return false;
		}
		
		formData.append("uploadFile", fileObj);
		
		
		
		var csrfToken = $('meta[name="_csrf"]').attr('content');
		var csrfHeader = $('meta[name="_csrf_header"]').attr('content');
		
		
		console.log("csrf토큰"+csrfToken);
		console.log("csrf헤더"+csrfHeader);
		
		
		$.ajax({
			url: '/uploadAjaxAction?${_csrf.parameterName}=${_csrf.token}',
	    	processData : false,
	    	contentType : false,
	    	data : formData,
	    	type : 'POST',
	    	dataType : 'json',
	    	enctype: 'multipart/form-data',	    	    	 
	    	
	    	beforeSend:(xhr)=>{
	    	    xhr.setRequestHeader('${_csrf.headerName}','${_csrf.token}');
	    	    $('#uuid').val('');
	    	},
    		success : function(result){
    			console.log(result);
    			showUploadImage(result);
    			var uuid = result[0].uuid;
    			$('#uuid').val(uuid);
    			var fileName = result[0].fileName;
    			$('#fileName').val(fileName);
    			var uploadPath = result[0].uploadPath;
    			$('#uploadPath').val(uploadPath);
    		},
    		error : function(result){
    			alert(result.status + ":" + result.textStatus );
    			alert("이미지 파일이 아닙니다.");
    		}
		});		
	});


/* var, method related with attachFile */
let regex = new RegExp("(.*?)\.(jpg|png)$");
let maxSize = 1048576; //1MB	

function fileCheck(fileName, fileSize){

	if(fileSize >= maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
		  
	if(!regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	
	return true;		
	
}

/* 이미지 출력 */
function showUploadImage(uploadResultArr){
	
	/* 전달받은 데이터 검증 */
	if(!uploadResultArr || uploadResultArr.length == 0){return}
	
	let uploadResult = $("#uploadResult");
	
	let obj = uploadResultArr[0];
	
	let str = "";
	
	let fileCallPath = encodeURIComponent(obj.uploadPath.replace(/\\/g, '/') + "/s_" + obj.uuid + "_" + obj.fileName);
	
	str += "<div id='result_card'>";
	str += "<img src='/display?fileName=" + fileCallPath +"'>";
	str += "<div class='imgDeleteBtn' data-file='" + fileCallPath + "'>x</div>";
	str += "<input type='hidden' name='imageList[0].fileName' value='"+ obj.fileName +"'>";
	str += "<input type='hidden' name='imageList[0].uuid' value='"+ obj.uuid +"'>";
	str += "<input type='hidden' name='imageList[0].uploadPath' value='"+ obj.uploadPath +"'>";	
	str += "</div>";		
	
	uploadResult.append(str);  
}
</script>

<script type="text/javascript">
/* 파일 삭제 메서드 */
function deleteFile(){
	
	let targetFile = $(".imgDeleteBtn").data("file");
	
	let targetDiv = $("#result_card");
	
	$.ajax({
		url: '/admin/deleteFile',
		data : {fileName : targetFile},
		dataType : 'text',
		type : 'POST',
		success : function(result){
			console.log(result);
			
			targetDiv.remove();
			$("input[type='file']").val("");
			
		},
		error : function(result){
			console.log(result);
			
			alert("파일을 삭제하지 못하였습니다.")
		}
	});
}

/* 이미지 삭제 버튼 동작 */
$("#uploadResult").on("click", ".imgDeleteBtn", function(e){
	
	deleteFile();
	
});


/* 파일 삭제 메서드 */
function deleteFile(){
	
	let targetFile = $(".imgDeleteBtn").data("file");
	
	let targetDiv = $("#result_card");
	
	$.ajax({
		url: '/deleteFile',
		data : {fileName : targetFile},
		dataType : 'text',
		type : 'POST',
		success : function(result){
			console.log(result);
			
			targetDiv.remove();
			$("input[type='file']").val("");
			
		},
		error : function(result){
			console.log(result);
			
			alert("파일을 삭제하지 못하였습니다.")
		}
	});
}
</script>
</body>
</html>