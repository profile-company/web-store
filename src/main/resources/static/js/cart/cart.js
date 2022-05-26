// if(localStorage.getItem("quantity") == null){
//     localStorage.setItem("quantity", 0);
// }
// const qt = localStorage.getItem("quantity")
// for (let i = 0; i < qt; i++){
//     document.getElementById("productmain").appendChild(document.getElementById("main"))
// }

function numberWithCommas(x) {
    return x.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}
// summary price
let summaryPrice = document.querySelector('#summary-price');

let x = document.getElementsByClassName("text-start text-md-center")
let tagStrong = x.item(0).getElementsByTagName("strong").item(0);

let myArrayPrice = tagStrong.textContent.split(" ");
let strPrice = myArrayPrice[0];
let vnd = myArrayPrice[1];

let price = parseInt(strPrice);
// console.log(typeof(price));

tagStrong.innerHTML = numberWithCommas(tagStrong.innerHTML);

const inputQuantity = document.querySelector(".form-control")

inputQuantity.addEventListener('input', updatePrice)
function updatePrice() {

    let resultPrice = price * inputQuantity.value + " " + vnd;
    
    tagStrong.innerHTML = numberWithCommas(resultPrice);
    summaryPrice.innerHTML = resultPrice;
    // console.log(resultPrice);
}