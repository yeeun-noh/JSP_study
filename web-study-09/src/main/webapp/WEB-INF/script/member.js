function loginCheck() {
    if(document.frm.userid.value.length == 0) {
        alert("아이디를 써주세요!");
        frm.userid.focus();
        return false; 
    }

    if(document.frm.pwd.value == "") {
        alert("비밀번호는 필수 입력입니다.");
        frm.pwd.focus();
        return false; 
    }

    return true;
}