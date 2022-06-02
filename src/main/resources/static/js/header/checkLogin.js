var span = document.getElementById("account");
var logintrue = document.getElementById("login-true")
var noLogin = document.getElementById("no-login")

let ck = document.cookie;
let a = ck.split(";")
console.log(a);

for(let i = 0; i < a.length; i++){
    // console.log(a[i])
    console.log(a[i].search("name"))
    if( a[i].search("name") > -1){
        let name = [];
        name = a[i].split("=");
        localStorage.setItem("username", `${name[name.length - 1]}`);
        // console.log(name)
        // span.innerHTML = `${name[name.length - 1]}`
        span.innerHTML = localStorage.getItem("username");
        logintrue.style.display = "block"
        noLogin.style.display = "none"
        break;
    }

}