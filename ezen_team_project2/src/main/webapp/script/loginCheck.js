function loginCheck() {
    // 아이디와 비밀번호 입력값 가져오기
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
  
    // 빈 공간 체크
    if (email.trim() === '' || password === '') {
      alert('아이디 혹은 비밀번호를 입력해 주세요.');
      return false;
    }
  
    // 이메일 형식 체크
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      alert('올바른 이메일 형식이 아닙니다.');
      return false;
    }
  
    return true;
  }