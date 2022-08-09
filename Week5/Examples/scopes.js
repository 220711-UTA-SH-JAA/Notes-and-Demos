/*  Variable scopes in JS
    The scope of a variable defines the lifetime and visibility of a variable
    - They cannot be accessed outside of their scope

    Two types of scope: Global and Local

    Global Scope:
    - accessible everywhere in the script, and has a lifetime of the application/script

    Local Scope:
    - accessible only in their location, these include Function and Block scope

    Function Scope:
    - variable declared inside of a function, and are only accessible inside of that function, and their lifetime
        is the span of the function running
    
    Block Scope:
    - introduced in ES6, variable with the keyword let or const, and defined inside of a more specific block of code
        (for loop, if statements, etc), they can only be accessed inside of their block of code, and the lifetime is
        the duration of that block of code
    
    
    Hoisting:
    Javascript will take all the of variable and function declarations and move to the top of their scope
    before the code is executed
    - Its only going to hoist the declarations, not the assignments
    - Variables with the var keyword declared in a function, will be hoisted out of any blocks inside of that function
    - Pre-ES6 there was no way to keep a variable inside of block scope
*/

function testLetHoist(str) {
    console.log("Inside test let hoist");
    console.log(str);
}

testLetHoist(global);
//testLetHoist(tryToHoist);

//Global scope
var global = 20;

//This is not possible
//console.log(functionScope);

function hoistMe(){
    //Function scope, and not accessible outside
    var functionScope = 11;
    console.log("Inside of the hoistMe function " + global);

    if(global > functionScope){
        var blockScope = 30;
    }

    //You would think, that if the blockscope var is inside of the block, you would not be able to access it
    //outside of the if statement, similar to java
    //With the var keyword, the blockscope variable still gets hoisted outside of the if statement
    console.log(blockScope);
}

hoistMe();

/*  let and const keywords
    let and const were introduced in ES6 as a means to prevent hoisting out of block scope
    
    The let keyword allows you to declare a variable in block scope without it being hoisted
    
    The const keyword allows you to declare a variable in block scope without it being hoisted, however, it is
    treated as a constant, and once it is assigned, you cannot reassign it

    It is best practice to use let and const over the var keyword
*/

function preventHoist(){
    //Function scope, and not accessible outside
    let functionScope = 11;
    console.log("Inside of the hoistMe function " + global);

    if(global > functionScope){
        let blockScope = 30;
    }

    //With the let keyword, you can no longer access the blockScope variable outside of its block of code
    //Let allows us to treat the block code and any variables inside similar to Java code
    //console.log(blockScope);
}



preventHoist();

let tryToHoist = "Testing if this will print";