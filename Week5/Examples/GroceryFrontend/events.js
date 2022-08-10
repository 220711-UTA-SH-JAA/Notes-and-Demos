/*  Events and Listeners
    Events occur when a user interact with a webpage, or when the browser triggers one

    You can configure your HTML page to handle events with event handlers/listeners, and you can listen for
    many types of events including:
    - clicks on an element: onclick
    - onload
    - onmouseenter onmouseleave
    - when buttons are clicked: onkeydown or onkeyup
    - know when someone enters or leaves form field: onfocus or onblur
    - onsubmit and onchange, can track when the values of a form are submitted or changed

    Event Handlers/Listeners can be set one of three ways
    1. Inline, where you set the on... attribute of the html element to a predefined function in js
    2. You can set the event property of the html element to a predefined function
    3. You can use element.addEventListener(event, function, useCapture)

*/

console.log("Js connected");

//First we select the element we want a listener on
//let itemName = document.getElementById("item-name");
//Then we create the listener on that element
//itemName.addEventListener("keydown", ()=> console.log("Typed in the itemName input"));

//let submitItem = document.getElementById("submit-item");
//itemName.addEventListener("click", () => console.log("We submitted a new item to the list"));

/* The Event Object

    Is an object created when an event occurs on the HTML page

    Is a super object, that is inherited by many other "types" of events, and the base properties include:
    - bubbles: a boolean value which indicates which way the event will propagate through the html page
    - currentTarget: a reference to the DOM element whose event listener triggered the specific event
        - This COULD be different than the element that actually started the event
    - preventDefault(): prevent the default action of the event
    - stopPropagation(): prevent the event from propagating further
    - target: property that references the original element which triggered the event
    - timeStamp: when it happened in miliseconds
    - type: the type of event

    The types of events:
    There are a lot of subclasses of the Event Object, which all include their own properties, as well as the properties
    listed above

    An entire list of types can be found here: https://www.w3schools.com/jsref/obj_events.asp

    The most basic events are MouseEvent and Keyboard Event
    - MouseEvents includes knowing when things were clicked, and where the mouse is at on the screen/page
    - KeyboardEvent includes knowing when keys were pressed, and which keys were pressed

*/

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
        //Mistyped this palm through face
        this.#state = newState;
    }
}

class GroceryState extends State{
    #idCounter;
    
    constructor(initialState){
        super(initialState);
        this.#idCounter = 1;
    }

    appendNewItem(item){
        //There could be an off chance that the state isnt an array
        if(Array.isArray(this.getState)){
            let listOfItems = this.getState;
            console.log("list of items pre push", listOfItems);
            item.itemId = this.#idCounter++;
            listOfItems.push(item);
            console.log("list of items post push", listOfItems);
            this.setState = listOfItems;
        }
    }

    removeItem(item){
        if(Array.isArray(this.getState)){
            let listOfItems = this.getState;
            this.setState = listOfItems.filter((i) => {
                if(item.itemName !== i.itemName && item.itemCost !== i.itemCost && item.itemType !== i.itemType){
                    return i;
                }
            });
        }
    }

}

let state = new GroceryState([
    {
        itemId: 0,
        itemName: "Milk",
        itemCost: 2.99,
        itemType: "Dairy"
    }
]);

appendItemsToPage(state);

console.log(state);

//Register the submit for the form
let submitButton = document.getElementById("submit-item");
submitButton.addEventListener('click', addNewItem);

//e is the event object that gets created when we click the button
//its important that we get access to the is object, so we can better control our page
function addNewItem(e){
    //This will prevent the default action from happening
    //In our case, the default action is the form submitting, sending http request, and reloading the page
    e.preventDefault();
    //Whenever we submit a new item, what we want to do is
    //1. Get all the values our of the form
    //2. Create a grocery item
    //3. Add that item to the state
    let itemName = document.getElementById("item-name").value;
    let itemCost = document.getElementById("item-price").value;
    let itemType = document.getElementById("item-type").value;

    let groceryItem = {
        itemId: 0,
        itemName,
        itemCost,
        itemType
    };

    console.log(groceryItem);
    state.appendNewItem(groceryItem);
    console.log(state);

    appendItemsToPage(state);
}

function appendItemsToPage(state){

    let itemsDiv = document.getElementById("grocery-items");
    itemsDiv.innerHTML = '';
    let total = 0;
    //For every item, we want to make an groceryItem div, and append it our groceryItems
    //Next we want a div to store all of the grocery item information
    for(let i of state.getState){
        let groceryItem = document.createElement("div");
        groceryItem.setAttribute("class", "grocery-item");

        //Create h3 for the itemName
        //Create a paragraph for the price and itemType
        let h3 = document.createElement("h2");
        h3.textContent = i.itemName;

        let p = document.createElement("h3");
        p.textContent = `Item type: ${i.itemType}, Item cost: $${i.itemCost}`;

        let removeButton = document.createElement("button");
        //This is the default propagation strategy/bubbling;
        removeButton.addEventListener("click", remove);
        //Use capture
        //removeButton.addEventListener("click", remove, true);
        removeButton.setAttribute("class", "remove");
        removeButton.innerText = "Remove Item";

        //Make the h3 and p elements a child of the groceryItem
        groceryItem.appendChild(h3);
        groceryItem.appendChild(p);
        groceryItem.appendChild(removeButton);

        itemsDiv.appendChild(groceryItem);
        total += new Number(i.itemCost);
    }

    let cost = document.createElement("h3");
    cost.innerHTML = `Total Cost: <strong>$</strong><small>${total}</small>`
    itemsDiv.append(cost);

}

/*  Bubbling/Capturing

    Javascript has something called event propagation, which is essentially how the event flows through the components on the page

    We have two ways an event can propagate

    1. Bubbling
        - The default propagation strategy
        - Follows a bottom up approach
        - The event will start at the target clicked on, and work its way up to the html element
            - Every element which has an event listener for that event, will also receive the event
        - You don't need to do anything special to register event handlers for this propagation
    
    2. Capturing:
        - The opposite of bubbling, it will go from the html tag down to the target element
        - The follow the top down approach
        - This is somewhat useful for removing child elements from a parent
        - To register an event handler to allow capturing, you must set the third parameter of the addEventListener for
            capture, and set that to true
*/

//If we want to see this propagate upwards, we will need to register more event listeners

//document.getElementById("grocery-items").addEventListener("click", remove);
//document.getElementById("root").addEventListener("click", remove);

//Use capture, goes from the top down
let groceriesList = document.getElementById("grocery-items");
//groceriesList.addEventListener("click", remove);
//document.getElementById("root").addEventListener("click", remove, true);

/* To remove the item from the list, we want to register the list element with an click event listener, as well as
    the button, and go from the top down, find the element we clicked on, and remove its parent from the list */

function remove(e) {
    console.log(e);
    let item = e.target.parentElement;
    
    let itemObject = {
        itemId: 0,
        itemName: item.firstChild.innerText,
        itemType: item.firstChild.nextSibling.innerText.split(":")[1].split(",")[0].trim(),
        itemCost: new Number(item.firstChild.nextSibling.innerText.split(":")[2].split("$")[1].trim())
    }

    state.removeItem(itemObject);
    console.log(state);

    groceriesList.removeChild(item);

    appendItemsToPage(state);
}