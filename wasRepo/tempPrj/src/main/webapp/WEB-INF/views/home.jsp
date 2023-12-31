<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- summernote -->
<script src="/app999/resources/js/jquery-3.6.0.js"></script>
<script src="/app999/resources/summernote/summernote-lite.js"></script>
<script src="/app999/resources/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/app999/resources/summernote/summernote-lite.css">
</head>
<body>
	<h1>홈페이지</h1>
	<textarea id="summernote"></textarea>
	
	<script>
const fontArr = ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'];
    $('#summernote').summernote({
        height: '400', // 에디터 높이
        // minHeight: null, // 최소 높이
        // maxHeight: null, // 최대 높이
        focus: true, // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR", // 한글 설정
        placeholder: '',	//placeholder 설정
        toolbar: [
                    // [groupName, [list of button]]
                    ['fontname', ['fontname']],
                    ['fontsize', ['fontsize']],
                    ['style', ['bold','italic','underline','strikethrough','forecolor','backcolor','superscript','subscript','clear']],
                    ['color', ['forecolor','color']],
                    ['table', ['table']],
                    ['para', ['ul', 'ol', 'paragraph']],
                    ['height', ['height']],
                    ['insert',['picture','link','video']],
                    ['view', ['fullscreen', 'help']]
                  ],
        fontNames: fontArr,
        fontNamesIgnoreCheck: fontArr,
        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
        callbacks: {	//여기 부분이 이미지를 첨부하는 부분
            onImageUpload : function(files) {
            	uploadWriteImageFile(files[0],this);
            },
//             onPaste: function (e) {
//                 var clipboardData = e.originalEvent.clipboardData;
//                 if (clipboardData && clipboardData.items && clipboardData.items.length) {
//                     var item = clipboardData.items[0];
//                     if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
//                         e.preventDefault();
//                     }
//                 }
//             }
        }
    });

	/**
	* 이미지 파일 업로드
	*/
	function uploadWriteImageFile(file, editor) {
		
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/app999/test",
			contentType : false,
			processData : false,
			success : function(x) {
				alert(x);
				$(editor).summernote('insertImage', x);
			}
		});
	}
</script>
</body>
</html>