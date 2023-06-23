<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>제주어때 회원가입 폼</title>
    <link rel="icon" href="./images/images2/favicon.png">
    <link rel="stylesheet" href="join.css">
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
  
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</head>
<body>
     <form name="frm" method="post" action="joinServlet">
    <div class="member">
        <!-- 1. 로고 -->
        <img class="logo" src="images/logo.png">

        <!-- 2. 필드 -->
        <div class="field">
            <b>이메일</b>
            <span class="placehold-email"><input type="text"></span>
        </div>
        <div class="field">
            <b>비밀번호</b>
            <input class="userpw" type="password">
        </div>
        <div class="field">
            <b>비밀번호 재확인</b>
            <input class="userpw-confirm" type="password">
        </div>
        <div class="field">
            <b>닉네임</b>
            <input type="text">
        </div>

        <!-- 3. 필드(생년월일) -->
        <div class="field birth">
            <b>생년월일</b>
            <div>
                <input type="number" placeholder="년(4자)">                
                <select>
                    <option value="">월</option>
                    <option value="">1월</option>
                    <option value="">2월</option>
                    <option value="">3월</option>
                    <option value="">4월</option>
                    <option value="">5월</option>
                    <option value="">6월</option>
                    <option value="">7월</option>
                    <option value="">8월</option>
                    <option value="">9월</option>
                    <option value="">10월</option>
                    <option value="">11월</option>
                    <option value="">12월</option>
                </select>
                <input type="number" placeholder="일">
            </div>
        </div>
		
		<!-- 4. 주소 -->
		<div>
		<b>주소</b>
		<input type="text" id="postcode" placeholder="우편번호" readonly="readonly" name="postcode">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style='cursor:pointer;'><br>
		<input type="text" id="roadAddress" placeholder="도로명주소" readonly="readonly" name="roadAddress">
		
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="detailAddress" placeholder="상세주소" name="detailAddress">
		
		</div>
		
		
        <!-- 5. 필드(성별) -->
        <div class="field gender">
            <b>성별</b>
            <div>
                <label><input type="radio" name="gender">남자</label>
                <label><input type="radio" name="gender">여자</label>
                <label><input type="radio" name="gender">선택안함</label>
            </div>
        </div>

        <!-- 6.전화번호 -->
       
        
        <div class="field tel-number">
            <b>휴대전화</b>
            <select>
                <option value="">대한민국 +82</option>
            </select>
            <div>
                <input type="tel" placeholder="전화번호 입력">
                <input type="button" value="인증번호 받기" style='cursor:pointer;'>
            </div>
            <input type="number" placeholder="인증번호를 입력하세요">
        </div>

        <!-- 6. 가입하기 버튼 -->
        <input type="submit" value="가입하기" style='cursor:pointer;' >

        <!-- 7. 푸터 -->
        <div class="member-footer">
            <div>
                <a href="#none">이용약관</a>
                <a href="#none">개인정보처리방침</a>
                <a href="#none">책임의 한계와 법적고지</a>
                
            </div>
            <span><a href="#none">제주어때 </a></span>
        </div>
    </div>
</form>
</body>
</html>

