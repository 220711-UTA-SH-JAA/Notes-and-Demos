/*  Javascript Introduction:

    A programming/scripting lanauge that:
    High-leveled: have memory management, garbage collection, easily human readible
    Interpreted: the browser reads it in line by line
    Multi-paradigmed: support multiple paradigms such as procedural programming, object oriented, and functional
    Dynamically typed: no static type checking, no need to declare a variable return type, you can reassign
    a variable to any other you like
    Single Threaded: run off of an event look, no multi-threading is available *

    It is the most commonly used side programming language
    - Runs in the browser
    - Primarily used to create dynamic webpages
    - You CAN run it outside the browser, however, that takes a special runtime environment
    - Javascript has NOTHING to do with Java

    Javascript follows a convention/specification set out by ECMAScript
    - This is where/how javascript gets its versions
    - ES5, ES6, ES7, ES2020...
    - Browsers typically do not support the latest and greates ES Version

    Link our JS to our HTML 
    - Using the script tag, and you can write directly in these tags, or link a js file with the src attribute
    - Javascript writen inside a script tag is known as internal css
    - Javascript writen in outside files are known as external css
    - It is best practice to link you js at the end of your body

    Syntax Rules in JS
    - Case sensitive
    - Semicolons are optional (still best practice to use them)
    - Spacing/white space/tabs don't matter
    - Single and multiline comments are the same as java

    Creating variables in JS
    - Variables are used to store a reference to data
    - Use the keywords var, let, or const
    - Variables will have a name just like java
    - You can't name the variable a keyword, you cannot start with a number, or special character
        - exception being $ or _
    - You can't have spaces in a name
    - Literals in JS are fixed values, otherwise known as the primitives
*/

//Data types in JS, we have 7 of them,
//string: text enclosed in either double quotes or single quotes

var string1 = 'hello this is a valid string in js';
var string2 = "hello this is also a valid string in js";
var string3 = "You can't easily do this in java";
var string4 = 'I said: "Good day"';

//Printing something to our console similar to java
console.log(string1);
console.log(string2);
console.log(string3);
console.log(string4);

//number: positive or negative, decimal or non-decimal
//Any type of number
var num1 = 5;
var num2 = 3.14;
//Includes special datatypes such as inifinity, NaN (Not a Number), and bigInt
var inf = Infinity;

console.log(num1);
console.log(num2);
console.log(inf);

//boolean: true or false
var t = true;
var f = false;

console.log(t);
console.log(f);

//null: refer to nothing, and it not the same as an empty string or 0
var n = null;

//undefined: this is different from null, and means the object was declared but not initialized
var u;

console.log(n);
console.log(u);

//Object: a set of key value pairs, the key is a string, and the value can be anything, this include other objects,
// or event arrays
//These are what we will be using a lot

//Create an object
let object = {
    name: "Ethan",
    title: "Trainer",
    company: "Revature"
}

//Access properties in two ways:
//1. Using dot notation
console.log(object.name);
//2. Using bracket notation:
console.log(object["company"]);

//Change/update properties the same way
//1. Using dot notation
object.title = "Senior Trainer";
//2. Using Bracket notation
object["name"] = "Ethan McGill";

console.log(object);

//Arrays: objects which store a list of values
// Allowed to store any and all datatypes inside of a single array
// Index start at 0
// Values are accessed by the index in square brackets just like java
// Have a length property just like java
// Are dynamically sized, so they will automatically scale or shrink
// They come with many methods to transform them
// - .push(), .pop(), .foreach(), .filter(), .map(), .slice()
// I reccommend looking into these array methods, and seeing how to use them

var arr = [];
//Push a value at the end of the array
arr.push(string1);
arr.push(num1);
arr.push(object);

console.log(arr);

//Access the array via index
console.log(arr[2]);

//Change the value in the array at index 1
arr[1] = "I don't like numbers";

console.log(arr);

//Spread/rest operator in JS
//Spread operator is used to break apart objects or arrays
//Break apart our array from above
//Put each index of the array into its own variable
var [s1, s2, ethan] = arr;

console.log(s1);
console.log(s2);
console.log(ethan);

//Break apart objects into individual variables
var {name, title, company} = object;
console.log(name);
console.log(title);
console.log(company);

//Rest Operator, is literally varargs from Java
//Lets you input an unlimited about of variables into the parameter list of a function
//More on functions in a bit

/*  Operators and Control Flow
    Javascript operators perform some operation on a single or multiple operands and produce a result
    We have 5 different operators/types of operators
    - Arithmetic: -,+,/,%,++,--
    - Comparison: ==, ===, !=, >, <, >=, <=
    - Logical: &&, ||, !
    - Assignment: =, +=, -=, *=, /=, %=
    - Tenary: condition ? true : false

    Control Flow
    - if/else
    - for
    - for in
        - Enhanced for loop that loops through the keys of an object
    - for of
        - Enhanced for loop that loops through the elements of an array
    - while loop
    - do while loop
*/

for(var i=0; i<10; i++){
    console.log(i);
}

//The special for of loop, loops through the indexes of an array
for(var i of arr){
    console.log(i);
}

//Special for in loop, loops through the keys of the object
for(var key in object){
    console.log(key + " : " + object[key]);
}

/*  Type Coercion: the process of converting a value from one datatype to anothe datatype

    Two types of type coercion, implicit, and explicit
    Exclipit will happen when we specify it to
*/

//The string will be converted into a number
var num = new Number("3");
console.log(num);
//Implicit will happen automatically

//Convert the string 3 into a number, then divide
var div = "3"/4;

console.log(div);

/*  The difference between == and ===
    There are two ways to compare objects in javascript
    - == will compare two objects using type coercion
        - The type of the object is not taken into account when comparing
    - === will compare the objects values, and the objects type
        - This one will only return true if that are "strictly" the same
    - === does strict comparision, and == will only compare the value
*/

//This will return true, because of type corecion and the values being the same
console.log("3" == 3);

//This will return false becuase we will check the value and the type
//This will not convert any datatypes, and check against them
console.log("3" === 3);

//This one will return true, because both values are 3, and both are number types
console.log(3 === 3);

/*  Truthy vs Falsy values
    Any expression or value in javascript that would result in false, is considered falsy
    These include:
    - boolean false
    - empty string ''
    - Undefined
    - null
    - NaN
    - 0

    Everything is truthy
*/

var emptyString = null;

//What this is actually useful for, is making sure user input is not empty/undefined/null
if(emptyString){
    console.log("The string is not empty");
}else {
    console.log("The string is empty and returned falsy");
}