"use strict";
/* The biggest difference between typescript and javascript is the strict type checking similar
to java/c#
*/
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
var num = 10;
//This is not legal
//num = "hello";
var numberArray = new Array();
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
var Animal = /** @class */ (function () {
    //We must set these in a constructor or mutator, otherwise there is a type error
    function Animal(name, species) {
        this.name = name;
        this.species = species;
    }
    Object.defineProperty(Animal.prototype, "getName", {
        //Something cool about ts classes are the implementations of getters and setters
        //We can use the get and set keywords to set the mutators, and with these keywors they act as
        //properties rather than methods
        get: function () {
            //Inside of TS classes you MUST use the this keyword, otherwise it will not know what variable
            //you are talking about
            return this.name;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Animal.prototype, "setName", {
        set: function (name) {
            this.name = name;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Animal.prototype, "getSpecies", {
        get: function () {
            return this.species;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Animal.prototype, "setSpecies", {
        set: function (species) {
            this.species = species;
        },
        enumerable: false,
        configurable: true
    });
    //Have normal methods
    Animal.prototype.move = function (feet) {
        console.log("The animal ".concat(this.name, " moved a total of ").concat(feet, " feet!"));
    };
    return Animal;
}());
var gabi = new Animal('Gabi', 'Cat');
gabi.move(5);
//We don't need the parenthesis because we can treat the mutators like properties
console.log(gabi.getSpecies);
//Inheritance using the extends keyword
var Dog = /** @class */ (function (_super) {
    __extends(Dog, _super);
    function Dog() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Dog.prototype.bark = function () {
        console.log("arf arf");
    };
    return Dog;
}(Animal));
var leia = new Dog('Leia', 'Shihpoo');
//The Dog class will have the same properties and methods as the Animal class
console.log(leia.getSpecies);
leia.bark();
leia.move(10);
//Typescript also has abstract classes, which we can use as blueprints, these could have both concrete and
//abstract methods
var Car = /** @class */ (function () {
    function Car() {
    }
    Car.prototype.alarm = function () {
        console.log("Beep");
        console.log("Beep");
        console.log("Beep");
        console.log("Beep");
        console.log("Beep");
    };
    return Car;
}());
//We must extend the abstract class
var SportsCar = /** @class */ (function (_super) {
    __extends(SportsCar, _super);
    function SportsCar() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    SportsCar.prototype.drive = function () {
        console.log("Drives fast");
    };
    return SportsCar;
}(Car));
var sportsCar = new SportsCar();
sportsCar.alarm();
sportsCar.drive();
//Using the interface
var user1;
user1 = {
    username: 'Leroy',
    password: 'Jenkins',
    login: (function () { return true; })
};
var user2;
user2 = {
    username: 'Steve',
    password: 'I mine blocks',
    phone: 5555555555,
    login: (function () { return true; })
};
console.log(user2);
console.log(user2.login());
