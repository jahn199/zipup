
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