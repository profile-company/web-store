// Enum name class


// class old

var oldClass = ["fake"];


function Product(NameClass){
     let AdminProduct = document.getElementById("admin");
    AdminProduct.getElementsByClassName(NameClass)[0].style.display = "block"
    if(oldClass !== []){
        AdminProduct.getElementsByClassName(oldClass[oldClass.length - 1])[0].style.display = "none"
    }
    oldClass.push(NameClass)

}

function SwitchListMenu(id, Action){
    switch (id) {
        case 1 :
            Product(Action)
            break;
        case 2 :
            Product(Action)
            break;
        default :
            console.log("default")
            break;

    }
}

function ListMenu(){
    let ArrMenu = [
        {
            id : 1,
            name : "Add product",
            href : "/trinh",
            Action : "admin-product"
        },
        {
            id : 2,
            name : "Member",
            href : "/trinh",
            Action : "admin-member"
        },
        {
            id : 2,
            name : "Chart",
            href : "/trinh",
            Action : "admin-chart"
        }
    ]
    let listMenu = document.getElementById("list-menu");
    console.log(listMenu)

    ArrMenu.map((item) => {
        let list = document.createElement("a");
        list.classList.add("list-group-item")
        list.addEventListener("click", () => SwitchListMenu(item.id, item.Action))
        list.innerHTML = item.name
        listMenu.appendChild(list)
        console.log(list)
    })
}

ListMenu();

const labels = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
];

const data = {
    labels: labels,
    datasets: [{
        label: 'My First dataset',
        backgroundColor: 'rgb(255, 99, 132)',
        borderColor: 'rgb(255, 99, 132)',
        data: [0, 10, 5, 2, 20, 30, 45],
    }]
};

const config = {
    type: 'line',
    data: data,
    options: {}
};

setTimeout(()=>{
    const myChart = new Chart(
        document.getElementById('myChart'),
        config
    );
}, 2000)