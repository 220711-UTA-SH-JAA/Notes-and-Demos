/*  Modules:
    Allows us to import and export peices of code in Javascript from different script files
    - These files have to be hosted, otherwise the browser has a hard time finding the modules (we will see this later)
    - To create a module you use the export keyword
    - To import a module you either use the import keyword or the require keyword, depending on the version of the runtime
    - We will see this a lot when we get to JS frameworks, such as Angular
*/

//Export something
export const doHello = () => {
    console.log("Hello");
}

//Export multiple values/functions

const funct2 = () => {
    console.log("Do something");
}

const var1 = "something";

const funct3 = () => {
    console.log("do something");
}

//You can also export multiple objects
export {funct2, var1, funct3};

/*  Iterators, Iterables, And Generators

    Iterator: an object that allows you to traverse values associated within a defined sequence
    - Iterator as a next() method that returns two values, the next value, and a true/false determing if it is done
    - You can retreive an iterator from an array with the method called iterator()
    - If the iterator is finished, each call after will return next = undefined, and done = true

    Generator: a special iterator that returns a next value everytime next() is called util it reaches a yield call
    - Generates values based on some function/algorithm, until you tell it to stop
    - create a generator with the sytax *function, then you have to implement how next creates the next value

    Iterable: an object the implements the @@iteraror method (such as an array), this allows the object to iterated over
    This means that they define the iteration behavior and can be used in constructs such as for of or for in loops
    - We make use of the yield keyword like we did in our generator function

    strict mode

    Declaring use strict in javascript, it will restrict some of javascript special quirks, such as
    - you are not allowed to have undefined variables
    - any keyword as a variable or function name
    - restricts some other very niche instances in javascript

    Was implemented in ES5

    It can be declared at a global or function level
*/