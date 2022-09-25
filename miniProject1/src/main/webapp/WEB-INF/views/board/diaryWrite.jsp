<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="/resources/css/diary.css" />
</head>
<body class="bodybody">
    <div class="bookcover">
      <div class="bookdot">
        <div class="page">
            <div class="contam">
                <div class="column1">
                    <div class="row1_1">
                    </div>
                    <div class="row1_2 box">
                        <img class="profile" src="https://i.ibb.co/mGCzCtg/soldier.png">
                        <div class="intro">
                        	<h2>${userInfo.nickName}</h2>
                            -----------<br>	
                            오늘 아침은 
                            소세지 야채볶음에
                            미역국이었다.
                            <br>
                            -----------
                        </div>
                    </div>
                </div>
                <div class="column2">
                    <div class="row2_1">
                        <div class="title">소중한 나의 병영 일기</div>
                        <div class="item2"></div>
                    </div>
                    <div class="row2_2 box">
                        <div class="album-box">
                            <div class="forming">
                                <div class="headerone">
                                    <input class="table_input" placeholder="제목을 입력 하세요." type="text" style="width: 430px; height: 30px; margin-right: 280px; margin-top: 4px; position:relative; right: 0px;" 
 									name="title" autofocus="autofocus" maxlength="50"><br>
         							<textarea class="table_input" rows="" cols="" style="width: 430px; height: 330px; position:relative; right:0px; resize:none; overflow-y:scroll" 
         							name="content"></textarea>
                                </div>
                                
                            </div>
                        </div>
                    </div>  
                </div>
              <div class="column3">
                <div class="sidebar">
                    <div onclick="location.href='../board/diaryWrite';" style="cursor:pointer;" class="side-menu">일기 쓰기</div>
                    <div onclick="location.href='../board/diary';" style="cursor:pointer;" class="side-menu">내 일기장</div>
                </div>
              </div>       
        </div>
    </div>
</div>
</div>
</body>
</html>