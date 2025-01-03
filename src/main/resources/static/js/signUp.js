
/******************** 메인 페이지 검색 결과 가리기************************************************/
document.addEventListener("DOMContentLoaded", function() {
    var productList = document.getElementById("productList");
    var noResults = document.getElementById("noResults");

    // 결과가 있을 때만 productList 보이기
    if (document.querySelectorAll('th\\:block').length > 0) {
        productList.style.display = "block";
        noResults.style.display = "none";
    } else {
        productList.style.display = "none";
        noResults.style.display = "block";
    }
});

/********************  판매자 아이디(이메일) 중복 확인 여부*********************************/
let sellerEmailChecked = false; // 이메일 중복 확인 여부
document.addEventListener("DOMContentLoaded", function () {
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    const form = document.querySelector(".signup-form");
    const checkEmailBtn = document.getElementById("check-email-btn");

    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
    const passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*+=-])[A-Za-z\d!@#$%^&*+=-]{8,}$/;

    checkEmailBtn.addEventListener("click", function () {
        const email = emailInput.value;

        // 이메일 패턴 체크
        if (!emailPattern.test(email)) {
            alert("이메일 형식이 올바르지 않습니다.");
            return;
        }

        // 서버에 이메일 중복 확인 요청
        fetch(`/check-email?email=${email}`)
            .then(response => response.json())
            .then(data => {
                if (data.isTaken) {
                    sellerEmailChecked = false; // 이메일 중복
                } else {
                    sellerEmailChecked = true; // 이메일 사용 가능
                }
            })
            .catch(error => {
                alert("이메일 중복 확인에 실패했습니다.");
                sellerEmailChecked = false; // 실패 시 중복 확인 안됨
            });
    });

    // 폼 제출 시 비밀번호 및 이메일 검사
    form.addEventListener("submit", function (event) {
        const email = emailInput.value;
        const password = passwordInput.value;

        // 이메일 검증
        if (!emailPattern.test(email)) {
            alert("이메일은 이메일 형식으로 영문자 및 숫자 조합으로 제출해주세요.");
            event.preventDefault(); // 폼 제출 방지
        }

        //비밀번호 검증
        if (!passwordPattern.test(password)) {
            alert("비밀번호는 영문, 숫자, 특수문자 조합으로 8자리 이상이어야 합니다.");
            event.preventDefault(); // 폼 제출 방지
        }

        // 이메일 중복 확인 여부 체크
        if (!sellerEmailChecked) {
            alert("이메일 중복 확인을 먼저 해주세요.");
            event.preventDefault(); // 폼 제출 방지
        }
    });
});