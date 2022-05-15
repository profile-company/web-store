function ListMenu(){
    let ArrMenu = [
        {
            name : "Member",
            href : "/trinh"
        },
        {
            name : "Post product",
            href : "/trinh"
        }
    ]
    let listMenu = document.getElementById("list-menu");
    console.log(listMenu)

    ArrMenu.map(item => {
        let list = document.createElement("a");
        list.classList.add("list-group-item")
        list.href = `${item.href}`
        list.innerHTML = item.name
        listMenu.appendChild(list)
        console.log(list)
    })
}

ListMenu();