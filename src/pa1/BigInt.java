package pa1;



public class BigInt {
	
	//fields
	//A string representation of the large integer
	private String number;
	
	//True if the large integer is negative i.e. it begins with the char '-'
	private boolean isNeg;
	
	//An integer array of the large integer
	private int[] ar;
	
	//constructors
	public BigInt(String val){
		//test for negative and truncate leading zeroes
		int i;
		if (val.charAt(0) == '-'){
			isNeg = true;
			i = 1;
		}
		else{
			isNeg = false;
			i = 0;
		}
			while (i < val.length()){
				if (val.charAt(i) != '0'){
					number = val.substring(i);
					i += val.length();
				}
				else if (val.charAt(i) == '0' && i == val.length() - 1){
					number = "0";
				}
				else{
					i++;
				}
			}
			//initialize the integer array to the length of the string representation
			ar = new int[number.length()];
			
			//populate the integer array with the integer values from the string representation
			for (int j = 0; j < ar.length; j++){
				ar[j] = Character.digit(number.charAt(j), 10);
			}
		
	}

	//methods
	/**
	 * A method to return String representation of a BigInt Object
	 * @return The String representation
	 */
	public String toString(){
		if (isNeg == true)
			return "-" + number;
		else
			return number;
	}
	
	/**
	 * A method to return the BigInt object with the larger absolute value
	 * This is a helper method to the min and max methods
	 * @param The BigInt object to compare to the calling object
	 * @return The larger of the two objects
	 */
	private BigInt maxAbs(BigInt val){
		if (this.number.length() > val.number.length())
			return this;
		else if (val.number.length() > this.number.length())
			return val;
		else{
			for (int i = 0; i < this.number.length(); i++){
				if (this.ar[i] == val.ar[i])
					i++;
				else if (this.ar[i] > val.ar[i])
					return this;
				else
					return val;
			}
			return this;
		}
		
	}
	
	/**
	 * A method to return the BigInt object with the smaller absolute value
	 * This is a helper method to the min and max methods
	 * @param The BigInt object to compare to the calling object
	 * @return The smaller of the two objects
	 */
	private BigInt minAbs(BigInt val){
		if (this.number.length() < val.number.length())
			return this;
		else if (val.number.length() < this.number.length())
			return val;
		else{
			for (int i = 0; i < this.number.length(); i++){
				if (this.ar[i] == val.ar[i])
					i++;
				else if (this.ar[i] < val.ar[i])
					return this;
				else
					return val;
			}
			return this;
		}
	}
	
	/**
	 * A method to return the larger BigInt object between the calling object
	 * and the parameter object.
	 * @param The BigInt object to compare to the calling object
	 * @return The larger of the two objects
	 */
	public BigInt max(BigInt val){
		//Return parameter object if it is positive and this is negative
		if (this.isNeg == true && val.isNeg == false)
			return val;
		
		//Return calling object if it is positive and parameter is negative
		else if (val.isNeg == true && this.isNeg == false)
			return this;
		
		//If both this and parameter objects are positive, return the larger
		else if (this.isNeg == false && val.isNeg == false)
			return this.maxAbs(val);
		
		
		//If both this and parameter objects are negative, return the "less negative" one
		//i.e. the object with the lower absolute value
		else 
			return this.minAbs(val);
		
	}
	
	/**
	 * A method to return the smaller BigInt object between the calling object
	 * and the parameter object.
	 * @param The BigInt object to comapre to the calling object
	 * @return The smaller of the two objects
	 */
	public BigInt min(BigInt val){
		if (this.isNeg == true && val.isNeg == false)
			return this;
		else if (this.isNeg == false && val.isNeg == true)
			return val;
		else if (this.isNeg == false && val.isNeg == false)
			return this.minAbs(val);
		else
			return this.maxAbs(val);
	}
	
	/**
	 * A method to return the sum of two BigInt objects
	 * @param The BigInt object to be added to the calling object
	 * @return The sum of the two BigInt objects
	 */
	public BigInt add(BigInt val){
		int[] sum = new int[maxAbs(val).number.length() + 1];
		
		int sumStore;
		
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInt a = new BigInt("-0000987675643557743");
		for (int i = 0; i < a.ar.length; i++){
			System.out.println(a.ar[i] + "\n");
		}

	}

}
