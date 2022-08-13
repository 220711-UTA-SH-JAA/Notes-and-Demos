/* When we create a JS project with Node, it will automatically create a package.json in the root directory
    of the project

    The package.json holds information about our project including:
    - description
    - version
    - author
    - liscense information
    - entry point
    - dependencies
    - script to run it

    We types of depedencies we can use
    - dependency: are essential to running the application
    - devDependencies: are only needed during development
*/
//Use the import keyword to import some module
import {people, sayHello} from "./moduleExample.js";
import data from './data.js';

//Import just like the files from above, now you can use someone elses code in your project
import validator from 'validator';

console.log("Hello, I am Javascript running outside of the browser");

console.log(people);

sayHello(people[1]);

console.log(data);