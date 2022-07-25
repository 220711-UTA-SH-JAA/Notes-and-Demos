# Create an RDS Instance

1. Login, or create an AWS account

- Login here: https://aws.amazon.com/
- Create an account here: https://portal.aws.amazon.com/billing/signup?nc2=h_ct&src=header_signup&redirect_url=https%3A%2F%2Faws.amazon.com%2Fregistration-confirmation#/start

2. Navigate to the RDS Dashboard by searching RDS and clicking the first result
3. Click Create database
4. We want to make the following selections:
- Standard Create
- PostgreSQL 12.5-R1
- Free Tier
- Name the db whatever you like
- Master username leave as postgres
- You whatever password you like, make sure you don't forget it
- Make sure you are using a t2.micro for your instance class
- Choose yes on public access
- We will keep the default VPC and edit it later
- Click create database
5. Now we wait for it to be created
6. After it is created, select the database and click on the default VPC
- We still need to setup rules for inbound and outbound traffic
7. Choose Actions then edit inbound rules
8. Set the source from Custom to anywhere, ideally we would set this IP address of members with priveleges to access this netword, but we will set it to anywhere for the the sake of our training
9. Do the same for outbound rules
10. Lets also turn off automatic backups so no one will get charged, choose modify in the top right on the RDS dashboard
11. Go to additional configuration, and put the Backup retention period to 0 days
12. Click continue, then modify db instance