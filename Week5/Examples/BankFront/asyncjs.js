/*  Intro to Asynchronous Javascript
    program does not need to wait for a specific task to finish to proceed

    You can start a function that will take a while, move on to a different function, and comeback when the return is
    ready
    - You send an api request, instead of waiting the response you do other work in the meanteime

    How does this work in JS?

    Javascript implements a callstack similar to java, this is where all the method calls are stored
    - It used a single thread to add and call functions on at a time
    - This is how how basic synchronous javascript works

    Javascript also has a built in queue, and using this queue along with webworkers, we can achieve an almost multithreaded
    like effect

    If there is an async call, javascript will hand that call off to webworkers and proceed to the next call
    
    Once the web workers are finished, they place the response/return of the function into the queue

    When the stack is empty, Javascript will look in the queue for any finished async functions
    - typically the return will be a value or a callback function

    The basic steps of the event loop:
    1. Async code gets added to the call stack
    2. Js hands it off to the webworker/web api and it gets processed
    3. Other functions can and will be executed while the webapi processes the other function
    4. Once the web api has a response/resolution/is done running the function, the result is put in the queue
    5. The event loop checks for results in the queue when the call stack is empty, this is to see if it needs to
        add anything to the call stack from the queue
    6. The response/call from the queue will be ran

    AJAX (Asynchronous Javascript and XML)
    the proces of exchaning data from a webserver asynchronously with the help of HTML, CSS, and Javascript

    We use it to load data from a server, and selectively update some part of our webpage without reloading
    Uses the browsers built in XMLHttpRequest Object (XHR) to send and receive data from webservices

    The AJAX workflow
    1. A client will create an event on a webpage
    2. Javascript will create that XMLHttpRequest Object
    3. The XHR will a request to the server
    4. The server will process that request
    5. The server will create a response and send the data back to the client
    6. The browser process the returned data using JS
    7. The webpage is updated with that new data using JS

    How to create an AJAX request
    There are 4 steps to creating an AJAX Request

    1. Create the XHR Object with new XMLHttpRequest()
    2. Set the readystatechange callback function
    3. Use the .open(method, url, async) method of the XHR object to open the connection to the server
        - Method is the string specifying the type of request POST, GET, PUT...
    4. Use the .send() method of the XHR object to send the data to the server

    The server then sends back a response which can be processed, this is returned in the form of:
    - responseText, is the response as a string
    - responseXML, is the resonse as XML
    - satus, the status of the response
    - statusText, is the text representation of the status code
    
    We make use of the XHR property readState and its function onreadystatechange, to watch for when the response is ready
    to be processed

    We have 5 states to the readyState:
    0. it is not initialied
    1. the connection has been established
    2. request was received by the server
    3. server is processing the request
    4. request is finished, and response is ready

    Typically, the onreadystatechange function, is overridden, listening for when the readyState is 4, and the response is
    ready to be processed

*/

let loginBtn = document.getElementById('login-btn');
loginBtn.addEventListener('click', loginUser);

function loginUser(){
    let api = "http://localhost:8080/BankAPI/api/login";
    let username = document.getElementById("username").value;
    let object = {
        username
    }

    //Step 1. Create the XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    //Step 2. Create a callback function for readystatechange
    xhttp.onreadystatechange = login = () => {
        if(xhttp.readyState === 4){
            console.log("The data is ready");

            if(xhttp.status === 200){
                let user = JSON.parse(xhttp.responseText);
                console.log(user);
                updatePageWithUser(user);
            }

            if(xhttp.status === 404){
                console.log("User did not log in");
                userNotFound()
            }
        }
    }

    //Step 3. Open the Connection to the server
    xhttp.open('POST', api);

    //Step 4. Send the request
    xhttp.send(JSON.stringify(object));
    
}

function updatePageWithUser(user){
    let userInfo = document.getElementById("user-info");
    userInfo.innerHTML = ` <h1>Welcome ${user.firstName}</h1>`
}

function userNotFound(){
    let userInfo = document.getElementById("user-info");
    userInfo.innerHTML = ` <h1>Username not found</h1>`
}