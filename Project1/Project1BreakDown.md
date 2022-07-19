Employee Reimbursement System

Week 1-3 use the application through a main method

Week 4-5 we will setup the api endpoints, and you will present the application with postman

What objects/models so we need, and what are the states held inside of those objects/models

1. Objects Needed com.revature.models:

Some type of Person Object
- Id
- First Name
- Last Name
- Username
- Email
- Password
- TypeOfUser (Is it an employee or a manager?)
- (Reference to another object)Tickets(All the tickets the person has created)[]

Some type of Ticket/Reimbursement Object
- Id
- Amount
- Description
- Status (Approved, Denied, and Pending)
- PersonSubmitedBy
- ?Date
- ?Type 

2. Figure out the logic com.revature.services:

- What info do we need to determine that a user is allowed to login?
    - login(String username, String password){//What logic?}

3. Databases to be continued