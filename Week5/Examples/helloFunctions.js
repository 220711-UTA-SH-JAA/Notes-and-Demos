/*  Functions in Javascript:
    are peices of resuable code that be called anywhere from the program/file
    - we will use the function keyword to declare them
    - they can take as many parameters as you like
    - if you want to return a value, you can use the return keyword
    - A method outside of an object
*/

//We have the function keyword, name, parameters inside of the parenthesis
function reverseString(reverseMe){

    var reversed = '';
    //If its not a string, we can't reverse it
    if(typeof reverseMe === 'string'){
        for(var i = reverseMe.length-1; i>=0; i--){
            reversed += reverseMe.charAt(i);
        }
        return reversed;
    }else{
        console.log("This was not a string");
        return null;
    }

}

//To call the function use the name with parenthesis and any value needed
console.log(reverseString("Hello"));
console.log(reverseString(45));

//Function Expression: anonymous function/a function with no name, it is just stored in a variable
//This is because everything in JS is an object, even functions
var fizzBuzz = function(number) {

    //If divisible by 3 and 5 write fizz buzz
    if(number % 15 === 0){
        console.log("fizz buzz")
    }else if(number % 5 === 0){
        console.log("buzz");
    }else{
        console.log("fizz");
    }

}

//To call the anonymous function, simply use the variable name
fizzBuzz(10);

//Immediately Invoked Function Expressions (IIFE)
//This is an anon function that will call itself immediately
//We wrap the function expression inside of parenthesis, and use one more set to call the function
(callMeImmediately = function(){
    console.log("I was called");
})();

//Callback Function: a function passed to another function, after the first function is complete, it calls the callback
// This is useful with asynchronous code
// Possible because all functions are objects, so we can pass as many functions into the parameter list of another
//function as we like
//You can also create a callback function with the callback keyword

//Arrow Function: a new simplified way to write an anonymous function
//We wrote a function in one line
var sayHello = (name) => console.log("Hello " + name);

sayHello("Ethan");

//We can still pass as many parameters as we like, and if we want multiple lines in the expression we need curly braces
//Functions allow for default values, so if theres no value passed in, it has a default
var calculate = (num1, num2=1, func) => {
    if(func === 'add'){
        console.log(num1 + num2);
    }
    if(func === 'sub'){
        console.log(num1 - num2);
    }
    if(func === 'mult'){
        console.log(num1 * num2);
    }
    if(func === 'div'){
        console.log(num1/num2);
    }
}

calculate(3,6,'mult');

var def =  (a=1) => {
    console.log(a);
}

def(10);