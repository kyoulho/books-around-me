let searchFromInput = document.querySelector("#search-form input[name=keyword]")
let searchFormBtn = document.querySelector("#search-form  button");

searchFormBtn.addEventListener("click", function (event) {
    if (searchFromInput.value == null || searchFromInput.value === "") {
        event.preventDefault();
    }
});

$(".target").on("click", function (event) {
    event.preventDefault();

    let imgNode = $(this).find("img");
    let imgSrc = imgNode.attr("src");

    imgNode.attr("src", "/images/book.gif");
    let isbn = $(this).attr("data");

    navigator.geolocation.getCurrentPosition((position) => {
        let lat = position.coords.latitude;
        let lng = position.coords.longitude;

        $("input[name=latitude]").val(lat);
        $("input[name=longitude]").val(lng);
        $("input[name=isbn]").val(isbn);
        imgNode.attr("src", imgSrc);
        $("#book-detail").submit();
    });
});