var span = document.getElementById("account");
let ck = document.cookie;
let a = ck.split(";")
a.map(i => {
    let b = i.search("name");
    var arr = []
    if(b){
        arr = i.split("=");
    }

    span.innerHTML = `${arr[arr.length -1]}`
})