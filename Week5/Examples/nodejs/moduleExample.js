//Modules allow us to export peices of our code to be used elsewhere

//This export keyword, allows us to use this array inside of some other file
export const people = [
    {
        name: "Ethan",
        company: "Revature",
        title: "Trainer"
    },
    {
        name: "Gela",
        company:"Revature",
        title: "Associate"
    }
];

export const sayHello = (person) => {
    console.log(`Hello ${person.name}`);
}