
// animation ad of brands
let listBrands = document.getElementsByClassName("nav-forward-to-brand");
let listBrandAd = document.getElementsByClassName('items-brand-advertisement').item(0).getElementsByTagName('div');

// console.log(listBrandAd);
for (let i = 0; i < listBrandAd.length; i++) {

    let img = listBrandAd.item(i).getElementsByTagName('img').item(0);
    // console.log(img);

    listBrands.item(i).addEventListener("mouseover", displayAd);
    function displayAd() {

       img.style.display = "block";
    
        // console.log("This is hover");
    }

    listBrands.item(i).addEventListener("mouseout", hiddenAd);
    function hiddenAd() {
       img.style.display = "none";
    }
}

// let brandNike = document.getElementById("nike-advertisement");
// let navNike = document.getElementsByClassName("nav-forward-to-brand").item(0);

// navNike.addEventListener("mouseover", displayAd);
// function displayAd() {

//     brandNike.getElementsByTagName('img').item(0).style.visibility = "visible";

//     console.log("This is hover");
// }
// navNike.addEventListener("mouseout", hiddenAd);
// function hiddenAd() {
//     brandNike.getElementsByTagName('img').item(0).style.visibility = "hidden";
// }

// add event hover when cursor move on a > span
// select all tag li have class name "dropdown-option-nav-site"
let liNavSite = document.getElementsByClassName("dropdown-option-nav-site");
// let a;
// console.log(liNavSite);
let divDropdown = document.getElementsByClassName('container-dropdown-brands').item(0);
 
liNavSite.item(0).addEventListener('mouseover', changeColor);
liNavSite.item(0).addEventListener('mouseout',abc);

function abc() {
    // divDropdown.style.visibility = "visible";
    divDropdown.addEventListener('mouseover', displayAllBrands);
    addEventListener('mouseout', hiddenAllBrands)
    function displayAllBrands() {
        divDropdown.style.visibility = "visible";
    }
    function hiddenAllBrands() {
        divDropdown.style.visibility = "hidden";
    }
}

function changeColor() {

    divDropdown.style.visibility = "visible";
    // console.log("Change color nav");
}

//
let divDropdownSports = document.getElementsByClassName('container-dropdown-sports').item(0);

liNavSite.item(liNavSite.length -1).addEventListener("mouseover", changeVisibility);
liNavSite.item(liNavSite.length - 1).addEventListener('mouseout', abcSports);

function changeVisibility() {
    divDropdownSports.style.visibility = "visible";
}

function abcSports() {
    divDropdownSports.addEventListener('mouseover', displayAllSports);

    addEventListener('mouseout', hiddenAllSports);

    function displayAllSports() {
        divDropdownSports.style.visibility = "visible";
    }
    function hiddenAllSports() {
        divDropdownSports.style.visibility = "hidden";
    }    
}

//
let isDisplay = false;
let divAccount = document.getElementsByClassName("account-expand").item(0);
let optionOperator = document.getElementsByClassName('options-account').item(0);

// console.log(divAccount);
divAccount.addEventListener("click", displayDivAccount);

function displayDivAccount() {
    if (!isDisplay) {
        optionOperator.style.visibility = "visible";
        isDisplay = true;
        // console.log(isDisplay);
    }
       
    else {
        optionOperator.style.visibility = "hidden";
        isDisplay = false;
       
    }
}
