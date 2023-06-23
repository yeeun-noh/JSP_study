 function validateForm() {
            // 이메일 형식 검사
            var email = document.forms["signupForm"]["email"].value;
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                alert("올바른 이메일 주소를 입력해주세요.");
                return false;
            }

            // 패스워드 길이 검사
            var password = document.forms["signupForm"]["password"].value;
            if (password.length < 8 || password.length > 16) {
                alert("패스워드는 8자에서 16자 사이어야 합니다.");
                return false;
            }

            // 닉네임 길이 검사
            var nickname = document.forms["signupForm"]["nickname"].value;
            if (nickname.length != 8) {
                alert("닉네임은 8자이어야 합니다.");
                return false;
            }

            // 핸드폰번호 길이 검사
            var phone = document.forms["signupForm"]["phone"].value;
            if (phone.length != 11) {
                alert("핸드폰번호는 11자여야 합니다.");
                return false;
            }

            // 주소 입력 여부 검사
            var address = document.forms["signupForm"]["address"].value;
            if (address.trim() === "") {
                alert("주소를 입력해주세요.");
                return false;
            }
        }