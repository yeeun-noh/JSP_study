function check() {
    if(document.frm.name.value == "") {
        alert("이름을 입력해주세요:");
        document.frm.name.focus();
        return false;
    } else if(document.frm.address.value == "") {
        alert("주소를 입력해주세요:");
        document.frm.address.focus();
        return false;
    } else {
        return true;
    }
}

function check2() {
    if(document.frm2.name.value == "") {
        alert("이름을 입력해주세요:");
        document.frm2.name.focus();
        return false;
    } else if(document.frm2.address.value == "") {
        alert("주소를 입력해주세요:");
        document.frm2.address.focus();
        return false;
    } else {
        return true;
    }
}