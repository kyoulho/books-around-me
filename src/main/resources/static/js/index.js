let searchFromInput = document.querySelector("#search-form input[name=keyword]")
    let searchFormBtn = document.querySelector("#search-form  button");

    searchFormBtn.addEventListener("click", function (event) {
    if (searchFromInput.value == null || searchFromInput.value === "") {
    event.preventDefault();
}
});
