class WordRunner {
	
	public static void main(String args[]){
		
		/* If we wanted to create a new instance of our word class, we would use the constructor with the new keyword
		 * The new keyword will create a new insance our object and store it in memory
		 */
		
		Word w = new Word('h','e','l','l','o');
		System.out.println(w.size);
		System.out.println(w.characters);

	}

}
