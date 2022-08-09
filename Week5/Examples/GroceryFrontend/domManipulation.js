console.log("JS linked");

/*  this keyword in JS
    It has multiple meanings depending on where you use it
    - this alone in a JS script will refer to the global window object
    - this in an event handler refers to the HTML element that caused the event
    - this in Object Method minding refers to the object

    DOM Document Object Model
    Tree like structure that represents the HTML document known as the dom tree
    - Allow javascript to access and manipulate elements and styles on a webpage

    The root of the DOM tree is our html tag, otherwise known as the document object

    The document object gives us methods to be able to select, traverse, and manipulate the html elements
*/

//The document keyword is how you gain access to the DOM
//console.log(document);

// Selecting HTML elements
// There are several ways
//This will give us the div with an id of root
let root = document.getElementById("root");

console.log(root);

//We can select all the divs with a class of grocery-item
let items = document.getElementsByClassName("grocery-item");

console.log(items);

//document.getElementsByTagName("h1"), that would get all of the h1 tags, a collection like above
//document.querySelector("#id") or document.querySelectorAll(".grocery-item") select elements in the same way as css

/*  Traversing the DOM
    The document object also gives us ways to move from element to element in the dom, using different properties
*/

//Gain access to the top most nodes
console.log(document.documentElement); //html element
console.log(document.head); //head element
console.log(document.body); //body element

//We might use this later
let body = document.body;

//We can gain access to the parent node using two separate properties
console.log(root.parentNode); //get the parent element of root
console.log(root.parentElement); //get the parent element of root

//Gain access to the children nodes of an element
console.log(body.childNodes); //Return a collection of child nodes
console.log(root.childNodes);

console.log(root.firstChild); //Gets the first child
console.log(root.lastChild); //Gets the last child

//Gain access to sibling nodes
let firstChildOfRoot = root.firstChild;
let lastChildOfRoot = root.lastChild;

console.log(firstChildOfRoot.nextSibling); //The next sibling
console.log(lastChildOfRoot.previousSibling); //The previous

/*  DOM Manipulation: allow us to change the content of elements, and create new elements

    Use document.createElement() to create an element
    Use element.replaceChild() to remove an element from the DOM and replace it with another
    Use element.removeChild() to completely remove and element
    Use element.insertBefore() to insert an element before another
    Use element.innerText or element.textContent to set the content of the element
    Use element.innerHTML to set an entire block of HTML inside of an element
    Use element.cloneNode() to clone an element
    Use element.appendChild() to add a child

    Manage attributes of elements with:
    - element.getAttribute("name")
    - element.setAttribute("name")
    - element.removeAttribute("name")
    - element.hasAttribute("name")
*/

/* Store some state of this page, we could assume that we got this state from an external source*/
let groceries = [
    {
        itemId: 1,
        itemName: "Milk",
        itemPrice: 2.99,
        itemType: "Dairy"
    },
    {
        itemId: 2,
        itemName: "Cereal",
        itemPrice: 4.99,
        itemType: "Breakfast"
    },
    {
        itemId: 3,
        itemName: "Oatmeal",
        itemPrice: 2.99,
        itemType: "Breakfast"
    },
    {
        itemId: 4,
        itemName: "Coke Zero",
        itemPrice: 7.99,
        itemType: "Beverage"
    },
]

class State {
    //Create a private variable
    #state;

    constructor(initialState){
        this.#state=initialState;
    }

    //We can have public getters and setters
    //JS classes act similarly to C# where you can treat getters and setters as properties rather than methods

    //create a getter property
    get getState(){
        return this.#state;
    }

    //create a setter property
    set setState(newState){
        this.#state = state;
    }
}


let state = new State(groceries);

/* Our goal, is to take that state, and display all the items on the page */
// Write a function that takes the state, and displays it on the screen, then call that function
//Each grocery item should be its own element, we want to store them in the grocery-items div
//First we need to select that grocery-items div

function generateList(itemList){

    let itemsDiv = document.getElementById("grocery-items");
    let total = 0;
    //For every item, we want to make an groceryItem div, and append it our groceryItems
    //Next we want a div to store all of the grocery item information
    for(let i of itemList){
        let groceryItem = document.createElement("div");
        groceryItem.setAttribute("class", "grocery-item");

        //Create h3 for the itemName
        //Create a paragraph for the price and itemType
        let h3 = document.createElement("h2");
        h3.textContent = i.itemName;

        let p = document.createElement("h3");
        p.textContent = `Item type: ${i.itemType}, Item cost: $${i.itemPrice}`;

        //Make the h3 and p elements a child of the groceryItem
        groceryItem.appendChild(h3);
        groceryItem.appendChild(p);

        itemsDiv.appendChild(groceryItem);
        total += i.itemPrice;
    }

    let cost = document.createElement("h3");
    cost.innerHTML = `Total Cost: <strong>$</strong><small>${total}</small>`
    itemsDiv.append(cost);
}

//generateList(state.getState);