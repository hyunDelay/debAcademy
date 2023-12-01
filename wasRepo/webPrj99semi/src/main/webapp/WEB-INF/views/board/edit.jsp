<%@page import="com.kh.app.board.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVo vo = (BoardVo) request.getAttribute("vo");
	List<CategoryVo> categoryVoList = (List<CategoryVo>) request.getAttribute("categoryVoList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<link rel="stylesheet" href="/app99/resources/css/list.css">
</head>
<body>
    <div id="wrap">

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
        <main>

            <h2>수정하기</h2>
            <form action="/app99/board/edit" method="post">
                <table>
                    <colgroup>
                        <col width="20%">
                        <col width="80%">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th scope="row">카테고리</th>
                            <td>
                                <select name="category" id="">
                                    <% for(CategoryVo categoryVo : categoryVoList){ %>
										<option value="<%= categoryVo.getNo() %>"><%= categoryVo.getName() %></option>
<%--                                     	<% if(categoryVo.getNo().equals(vo.getCategoryNo())){ %> --%>
<%--                                     		<option value="<%= categoryVo.getNo() %>" selected><%= categoryVo.getName() %></option> --%>
<%--                                    		<% } else { %> --%>
<%--                                    			<option value="<%= categoryVo.getNo() %>"><%= categoryVo.getName() %></option> --%>
<%--                                    		<% } %> --%>
                                    <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">제목</th>
                            <td><input type="text" name="title" value="<%= vo.getTitle() %>"></td>
                        </tr>
                        <tr>
                            <th scope="row">내용</th>
                            <td><textarea name="content" id="" cols="30" rows="10"><%= vo.getContent() %></textarea></td>
                        </tr>
                    </tbody>
                </table>

                <div class="btn_box">
                    <input type="submit" value="수정하기">
                </div>
				<input type="hidden" name="no" value="<%= vo.getNo() %>">
            </form>
        </main>
    </div>
    
    <script>
    	function setOptionSelected(){
    		
    		const optionTagArr = document.querySelectorAll('main select[name=category] option');
			for(let i = 0; i < optionTagArr.length; i++){
				const optionTag = optionTagArr[i]
				if(optionTag.value == <%= vo.getCategoryNo() %>){
					optionTag.selected = true;
				}
			}
    	}
    	setOptionSelected();
    	
    </script>
</body>
</html>