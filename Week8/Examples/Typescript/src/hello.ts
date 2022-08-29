/* The biggest difference between typescript and javascript is the strict type checking similar
to java/c#
*/

//Now we must set the variable type, and obey the datatype that we set
//Our TS datatypes:
/*  Boolean: true or false
    Number: integer, decimal, postive or negative
    String: text inclosed with single or double quotes
    Undefined: same as JS
    Null: same as JS
    Any: make the variable act as a normal js variable
    Void: used for functions that do not anything
    Array: dynamic array like JS, however, they only hold one type of data
    Tuples: an array that can hold a fixed number of objects
    Enum: set of named constants
    Never: represents a type of value that can never occur
*/

//Declaring a variable in typescript
//var/let/const : datatype = value
var num : number = 10;

//This is not legal
//num = "hello";

let numberArray : number[] = new Array<number>();

numberArray.push(5);
numberArray.push(9.5);
numberArray.push(-5);

//this is not legal
//numberArray.push("hello");

/* Classes and Access Modifiers
    In TS the class keyword is used to declare class, and the new keyword is used to create an instance
    of a class

    You can also implement inheritance with typescript classes using the extends keyword

    Typescript also has access modifiers:
    - public: the default modifier, can be accessed anywhere
    - private: can only be accessed inside of the class
    - protected: can only be accessed inside of the class and children classes

    We can also mark properties of a class as readonly, with the readonly modifier
*/

// creating a class
class Animal {
    //fields/properties
    name: string;
    private species: string;

    //We must set these in a constructor or mutator, otherwise there is a type error
    constructor(name: string, species: string){
        this.name = name;
        this.species = species;
    }

    //Something cool about ts classes are the implementations of getters and setters
    //We can use the get and set keywords to set the mutators, and with these keywors they act as
    //properties rather than methods
    get getName(): string {
        //Inside of TS classes you MUST use the this keyword, otherwise it will not know what variable
        //you are talking about
        return this.name;
    } 

    set setName(name: string){
        this.name = name;
    }

    get getSpecies():string{
        return this.species;
    }

    set setSpecies(species: string){
        this.species = species;
    }

    //Have normal methods
    move(feet:number):void{
        console.log(`The animal ${this.name} moved a total of ${feet} feet!`);
    }

}

let gabi:Animal = new Animal('Gabi', 'Cat');
gabi.move(5);

//We don't need the parenthesis because we can treat the mutators like properties
console.log(gabi.getSpecies);

//Inheritance using the extends keyword
class Dog extends Animal {
    bark():void{
        console.log("arf arf");
    }
}

let leia:Dog = new Dog('Leia', 'Shihpoo');

//The Dog class will have the same properties and methods as the Animal class
console.log(leia.getSpecies);
leia.bark();
leia.move(10);

//Typescript also has abstract classes, which we can use as blueprints, these could have both concrete and
//abstract methods
abstract class Car{
    abstract drive():void;

    alarm():void{
        console.log("Beep");
        console.log("Beep");
        console.log("Beep");
        console.log("Beep");
        console.log("Beep");
    }
}

//We must extend the abstract class
class SportsCar extends Car{
    drive():void{
        console.log("Drives fast");
    }
}

let sportsCar: SportsCar = new SportsCar();

sportsCar.alarm();
sportsCar.drive();

/* Typescript Modules
    In typescript the code we write is gobally scoped by default. To restrict this, typescript provides
    modules and namespaces. All variables, classes, and functions declared inside of a module, are not
    accessible outside of the module.

    To create a module, its similar to modern JS with using the export keyword, then you import modules
    with the import keyword

    Interfaces:
    Iterfaces will allow us to create contracts that other objects can implement in TS

    You define an interface with the interface keyword, which includes the properties and types you want
    the object to have

    You can include optional properties using the ?

    The typescript compiler, does NOT include these interfaces in the transpiled JS, they are simply used
    for typechecking

*/

//Creating an interface
interface User{
    username: string;
    password: string;
    phone?:number;
    login():boolean;
}

//Using the interface
let user1: User;
user1 = {
    username: 'Leroy',
    password: 'Jenkins',
    login: (() => {return true})
};

let user2: User;

user2 = {
    username: 'Steve',
    password: 'I mine blocks',
    phone: 5555555555,
    login: (() => {return true})
}

console.log(user2);
console.log(user2.login());

/* Decorators
    A decorator is a special kind of declaration attached to a class, method, accessor, property or parameter
    They look like Java annotations

    In typescript we must enable the experimental support for decorators in the tsconfig to them

    We have several types of decorators:
    - Class: declared before a class declaration that is applied to the constructor of the class, it is used
        to observe, modify, or to replace a class definition
    - Method: declared before a method declaration, and it applied to the Property Descriptor for the method,
        they are used to observe, modify, or replace a method definition
    - Property: used to listen to state changes on a class
    - Paramter: declared before a parameter declaration and is applied to the method for a class constructor
        or method declaration
    - Accessor: applied to property desctiptor of the accessor
*/