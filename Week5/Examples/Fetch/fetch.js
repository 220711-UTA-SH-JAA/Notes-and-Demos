/*  Yesterday we talked about the older more difficult way to make HTTP requests to an API
    
    Fetch API:
    fetch is a more modern and easy way to send HTTP requests
    - It gets provided by the window object and you just use the window.fetch() or fetch()

    fetch() is used to send the request, a successful request gets resolved, and returns a promise
    Unsuccessful request returns an error status and will be rejected

    Response has many ways we can the information inside of the body
    - response.text() this is used if your returned data is text
    - response.json() this is used if your returned data is an object
    - response.formData() this is used if your returned data is form data
    - response.blob() binary data
    - response.arrayBuffer() low level represenation of binary data

    Promises:
    Are how javascript handles asynchronous operations, they are essentially a standin for a future value
    
    Many javascript functions that are aysnchronous will automatically create and return a promise
    - You can also create these manually

    Promises they take a callback function called the executor, this automatically runs when the object is created
    - The executor will take in two other callback functions
        - resolve(value) this callback function will return the value for the promise
        - reject(error) this callback function will return the error for the failed promise

    Promises also have a property for status, this will give us information about the satus of the object
    - pending
    - fulfilled
    - rejected

    You can consume the value from one promise into a different function with promise chaining with consumer functions

    These consumer functions are: .then(), .catch(), .finally(), these are used to consume data from the promise, and pass
    it to another function
*/

const API = "https://jsonplaceholder.typicode.com";

function getPosts(){
    //Defualt fetch method is GET
    //We must consume the return of the promise once we get the data
    //Make the request
    fetch(`${API}/posts`)
        //Once we have the returned response, we consume it
        .then((res) => res.json())
        //Once the response is sucessfully converted to a js object, we consume that
        .then((data) => console.log(data));
    
    //If we try it this way, the console.log will execute before we have the data
    //console.log(req);
}

getPosts();

/*  async/await
    Was introduced in ES8 to simplify the asnyc functionality
    The async keyword denotes a funtion will operate asynchronously via the event loop

    Any function with the async keyword will automatically return a promise
    - You can use any of the consumer functions on the return of these functions, however there is a much better way to do
        it
    
    The await keyword, only works inside of async functions
    - It tells javascript to wait for a promise to resolve before moving on
    You can use await when calling a function that returns a promise, but it must be inside of another async function
    - It allows you to gather data, or wait for something without blocking the main thread
*/

async function createPost(uid, id, title, body){

    let post = {
        userId: uid,
        id,
        title,
        body
    }

    //We have our request, the createPost function will send it, then wait for the request promise to resolve
    let req = await fetch(`${API}/posts`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(post)
    });

    //If we wanted to see headers we could use
    //req.headers;

    //After we get our response, await getting the data
    let data = await req.json();

    console.log(data);

}

createPost(1, 101, "This is a test post", "We are making a post with async and await with fetch");

/*  Errors in JS
    These are simlar to Java exceptions, when something goes wrong, an Error object is created, and there are two ways
    this could occur

    1. Runtime error: Something that happens in your code, maybe a variable didn't exist
    2. User defined error, these are like custom exceptions, we build these to nofity ourselves if something went wrong

    Handling Errors:
    You use try catch similar to java
    - Surround the risky code in try blocks
    - Handle the exception in the catch block
    - Mostly handling errors thrown by fetch when you fail to make a successful request

    Throw Errors:
    If you want to throw an error yourself, you can use the throw keyword like in java
    - You can actually throw anything you like in Javascript, but somethings wouldn't make sense

    Defining Custom Errors:
    There are two ways to do this:
    1. Create a new function with a name and message field, set the prototype to Error
    2. Create a class that extends Error, and pass in a message to the super() call in the constructor

*/

async function causeAnError(){
    //Get requests are not allowed to have a body, so this will throw an error
    //This will be useful, for checking to see if you got back a 200 of something else
    try{
        let req = fetch(`${API}/posts`, {
            body:{}
        });

        let res = req.json();
    } catch(error){
        console.log("There was an error: ", error);
    }
    
}

causeAnError();

/*  Timing Events
    These are functions attached to the global window object, and allow programmers to automate or run tasks
    after a specified amout of time

    These get handled by the event loop and threads

    setTimeout()
    window.setTimeout(callback, miliseconds) will execute a function after so many milliseconds
    - If you want to cancel the timeout you use clearTimeout(timeout)
*/

let timeout;

document.getElementById("stop-timeout").addEventListener("click", stopTheTimeout);

function timeMeOut(){
    timeout = setTimeout(() => {
        console.log("I ran after 5 seconds");
    }, 5000);
}

function stopTheTimeout(){
    clearTimeout(timeout);
}

timeMeOut();

/*  Interval is used to continously call a function after so many milliseconds, until you stop it
    setInterval(callback, milliseconds)
    - To stop it, you call clearInterval(interval)
*/

let interval;

function startCounting(){
    count = 1;
    interval = setInterval(()=>{
        console.log(count++);
    }, 1000);
}

document.getElementById("start-interval").addEventListener("click", startCounting);
document.getElementById("stop-interval").addEventListener("click", () => clearInterval(interval));