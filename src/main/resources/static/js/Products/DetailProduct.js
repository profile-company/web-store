
const SizeProducts = document.getElementsByClassName("size-product");

console.log(SizeProducts[0]);

console.log(SizeProducts[0].getElementsByClassName("swatch-element"))

const SwapElement = SizeProducts[0].getElementsByClassName("swatch-element")

for(let i = 0; i < SwapElement.length; i++){
    console.log(SwapElement[i])
    SwapElement[i].addEventListener("click", (e)=>{

    })
}