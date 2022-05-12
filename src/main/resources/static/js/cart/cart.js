if(localStorage.getItem("quantity") == null){
    localStorage.setItem("quantity", 0);
}
const qt = localStorage.getItem("quantity")
for (let i = 0; i < qt; i++){
    document.getElementById("productmain").appendChild(document.getElementById("main"))
}


