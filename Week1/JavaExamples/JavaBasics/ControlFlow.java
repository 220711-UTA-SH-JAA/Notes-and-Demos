class ControlFlow{

	public static void main(String args[]){
		//Create our object from the ControlFlow class
		ControlFlow cf = new ControlFlow();

		//Call the forLoopExample method of the ControlFlow class
		cf.forLoopExample();

		System.out.println();

		cf.forLoopThroughArray();

		System.out.println();

		double[] numbersToAvg = {4.0, 5.0, 10.0, 9.0, 12.0};

		System.out.println(cf.findAverage(numbersToAvg));

		System.out.println();

		cf.whileLoopExample();

		System.out.println();

		cf.whileLoopArray();

		System.out.println();

		cf.doWhileLoop();

		System.out.println();

		cf.ifElseExample(-4);

		System.out.println();

		cf.ifElseIfExample(-4);
		cf.ifElseIfExample(0);
		cf.ifElseIfExample(4);

		System.out.println();

		cf.switchExample('y');
		cf.switchExample('n');
		cf.switchExample('f');
	}

	/* To add logic/modify variables in Java we need to use Operators and control flow
	 *
	 * OPERATORS
	 *
	 * Arithmetic: +, -, / (divide), * (multiply), % (modulo remainder division)
	 * Relational: <, >, <=, >= (Comparing two values)
	 * Equality: == (are they equal), != (are they not equal)
	 * Bitwise: check the values bit by bit in mem, & (and), | (or), ^ (xor)
	 *	When we use & BOTH values have to equate to true
	 *		true & true = true
	 *		true & false = false
	 *		false & true = false
	 *		false & false = false
	 *	When we use | EITHER values have to equate to true
	 *		true | true = true
	 *		true | false = true
	 *		false | true = true
	 *		false | false = false
	 *	You can negate an value with a !
	 *		!true = false
	 *		!false = true
	 * Logical Operators: && (logical and), || (logical or)
	 * 	Unlike the bitwise operators, the logical operators will short circuit
	 * 	Short circuiting means that if the return of the operation can be determined by only looking at one side
	 * 	it will automatically return saving you processing power
	 * Tenary: expression ? true : false
	 * Assignment: =, +=, -=, *=, /=, %=
	 * Postfix: x++, x--
	 * 	Read the value of the variable, THEN it will increment or decrement the value in the variable
	 * Prefix: ++x, --x
	 * 	Increment or decrement the value in the variable, then read the value of the variable
	 *
	 * CONTROL FLOW
	 * 
	 * Two types of control flow in Java
	 * 	Loops
	 * 	Branching
	 *
	 * Loops are used to perform some logic repeatedly until the loop is over
	 *
	 * There is a special keyword in java that is only allowed in loops called continue
	 * When used it will stop the current in its tracks, and continue back to the top of loop logic
	 */

	void forLoopExample(){
		
		//Syntax
		//keyword for
		//followed parenthesis
		//inside of the parenthesis we have three things
		//looping variable
		//looping condition
		//looping increment/decrement
		for(int i=0; i<10; i++){
			System.out.println("Iteration: " + (i+1) + " i value: " + i);
		}
	}

	void forLoopThroughArray(){
		int[] numbers = {5,8,1,23,12,10};

		for(int i=0; i<numbers.length; i++){
			System.out.println("Value at index: " + i + " is: " + numbers[i]);
		}
	}

	double findAverage(double[] values){
		
		double runningTotal = 0.0;

		for(int i=0; i<values.length; i++){
			runningTotal = runningTotal + values[i];
		}

		return runningTotal/values.length;

	}

	
	void whileLoopExample(){
		
		//A while loop will loop until the condition passed is false
		//But they are powerful because they are more dynamic

		int i = 0;

		while(i<10){
			System.out.println("Iteration number: " + i + "value: " + (i+1));

			//We have to remember to increment or decrement otherwise we will run the risk of infinite looping
			i++;
		}

	}

	void whileLoopArray(){
		
		int[] numbers = {1,4,76,37,2,7};

		int index = 0;

		while(index < numbers.length){

			System.out.println("Value at index: " + index + " is: " + numbers[index]);

			index++;
		}
	}

	//Do while loop, similar to a while loop, except the loop is always going to execute at least one iteration
	void doWhileLoop(){
	
		int number = 10;
		
		int index = 10;

		while(index < number){
			System.out.println("In the while loop");
			index++;
		}

		do{
			System.out.println("In the do while loop");
			index++;
		} while(index < number);

	}

	/* The other type of conditionals are branching statements */

	void ifElseExample(int number){
		//All if says, is that if something is true run the block of code
		// the else says otherwise do this
		// if blocks by themselves are legal
		// else blocks without an if is NOT legal
		
		if(number < 0){
			System.out.println("Number is negative");
		}
		else{
			System.out.println("Number is positive");
		}
		
	}

	void ifElseIfExample(int number){
		//It is also posible to next an if/else inside of another if or else block
		/*
		 *	if(...){
		 *		if(...){}
		 *		else{}
		 *	}
		 *
		 */

		if(number < 0){
			System.out.println("Number is negative");
		}
		else if(number == 0){
			System.out.println("Number is zero");
		}
		else{
			System.out.println("Number is positive");
		}
	}

	//Switch is similar to an if/else block
	//The switch block reads in a value, and the case blocks define logic for each case
	void switchExample(char input){
		switch(input){
			case 'y':
				System.out.println("Yes logic");
				//You can use return without a value to break/return out of a method
				return;
			case 'Y':
				System.out.println("Also yes logic");
				//There is also a more useful key word called break
				//When used it will break out of the current block of code, must be used with control flow
				break;
			case 'n':
				System.out.println("This is no logic");
				//When using switch statements ALWAYS be sure to either break or return, otherwise you will run through
			case 'N':
				System.out.println("This is also logic");
				break;
			//We can also include default/fallback case, if the input did not match any of the ones above
			default:
				System.out.println("Not sure what you meant");
		}
	}

}
