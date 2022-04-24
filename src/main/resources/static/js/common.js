let searchFromInput = document.querySelector("#search-form input[name=keyword]")
let searchFormBtn = document.querySelector("#search-form  button");

searchFormBtn.addEventListener("click", function (event) {
    if (searchFromInput.value == null || searchFromInput.value === "") {
        event.preventDefault();
    }
});

$(".target").on("click", function (event) {
    event.preventDefault();
    let isbn = $(this).attr("data");
    loading();

    navigator.geolocation.getCurrentPosition((position) => {
        let lat = position.coords.latitude;
        let lng = position.coords.longitude;

        $("input[name=latitude]").val(lat);
        $("input[name=longitude]").val(lng);
        $("input[name=isbn]").val(isbn);

        console.log(lat, lng);
        $("#book-detail").submit();
        $("#load").remove();
    });
});

function loading() {
    let divNode = document.createElement("div");
    divNode.setAttribute("id", 'load');


    let imgNod = document.createElement("img");
    imgNod.setAttribute("src", '/images/Magnify-1s-200px.gif');
    divNode.append(imgNod);

    $("body").append(divNode);
}
