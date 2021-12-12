<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script> 
$(document).ready(function() {
    $('#userId').change(function() {
       alert('값이 바뀌었음');
        $.ajax({
                type: 'POST',
                url: 'dupId',
                dataType: "json",
                data: {"id": $('#userId').val()},
                success: function(data) {
                   // data.server에서 보낸 mapId
                    alert('성공:' + data.id);
                   if(data.id==false) { alert('중복아님'); }
                   else{ 
                      alert('중복임');
                      // 입력한 값을 지우고 
                      // focus 를 다시 이동하고
                      $('#userId').val("");
                      $('#userId').focus();
                      $('#userId').css("background-color", "yellow");
                   }
                }, 
                error: function(request,status,error) {
                   alert('에러!! : ' + request.responseText + ":"+error);
                }
         }); //end ajax 
    }); //end on 
}); </script>
</head>
<body>
<!-- form에 넣어서 최종 서버에 전달은 하지만 -->
<!-- 미리 값이 바뀌면 ID가 중복인지 체크한다. -->
<form>
   <input type="text" name="id" id="userId">
   <input type="submit" value="전송">
</form>
</body>
</html>