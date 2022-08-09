/*  OOP in Javascript
    Principles of OOP
    - Abstraction
    - Polymorphism
    - Inheritance
    - Encapsulation

    Inheritance:
    Java has what is known as prototypical inhertaince
    - All javascript objects have a proto type property __proto__ property
    - The old way of achieving inheritance is to set this proto property to the parent object you want
    - The root proto of all objects is the Object.prototype
*/

//Lets have our animal object with some set of properties and behaviors
let animal = {
    color: "gray",
    legs: 4,
    speak: () => console.log("The animal speaks")
}

animal.speak();

//We want some special type of animal
let dog = {
    run: () => console.log("The dog runs")
}

//__proto__ is the object we want to inherit behaviors and states from
dog.__proto__ = animal;
dog.speak = () => console.log("Woof");

dog.speak();

/*  Encapsulation:
    The old way of acheiving encapsulation is through a trick called a closure
    - Nested function that can access the variables and arguments of its outer function, but can on longer change
        them
    State management, with javascript frontend libraries will typically use some form of closure, so you
    will probably indirectly interact with out
*/

//state is our outer function, which will encapsulate the actual data we want to store as our component state
const state = (function(initialState){

    //Function scope, we can no longer directly access this state variable from this function
    let state = initialState;

    return{
        setState: (value) => {
            console.log("Set state function was called");
            state = value;
        },
        getState: () => {
            console.log("Get state function was called");
            return state;
        }
    }

})([]);

console.log("State currently", state.getState());

let arr = state.getState();

arr.push({
    itemId: 1,
    itemName: "Milk",
    itemPrice: 2.99,
    itemType: "Dairy"
});

state.setState(arr);

console.log("State currently", state.getState());

//This will not allows us to access the actual state variable inside of our state
//console.log(state.state);

/*  Polymorphism is achieved with type coercion
    Abstraction is achieved using classes

    JS Classes:
    Classes were introduced in ES6, and it allows us to create object templates
    - Allow you to take advantage of inheritance through the extends keyword
    - Classes even have static keywords to create class scope
    - Classes can also have constructors, which will tell JS how you want to create the object
    - Classes also allow for public and private variables, so you can even encapuslate
        - private members in js class use the #varName
*/

//Creating a class
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

/*  Template Literals
    Are a special way of declaring strings, which allow developers to embed values in the string without
    "normal" concatenation
    - These will be strings enclosed in `backticks`
    - It allows for embedded expressions/placeholers indicated by a dollar sign and curly braces
*/

let object = state.getState()[0];

//Template literal syntax
console.log(`The item is ${object.itemName}, the price is ${object.itemPrice}`);

//The old way of concatenating
console.log('The item name is ' + object.itemName + " the price is " + object.itemPrice);

//Import syntax will look something like this, but we will actually get it working with NodeJS at the end of the week
//import { doHello } from "./oddsAndEnds";
//let doHello = require("./oddsAndEnds");