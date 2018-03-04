package orderedStructures;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException{
		if(!this.firstValue)
			throw new IllegalStateException("You haven't execute firstValue method");
		current = current + commonDifference; 
		return current;
	}
	
	@Override 
	public String toString(){
		
		return "Arith(" + (int) this.firstValue() + "," + (int) commonDifference + ")";
		
	}
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		double value = (this.firstValue() + commonDifference * (n-1)); 
		
		return value; 
	}

	@Override
	public Progression addto(Arithmetic c2) {
		double newfirst = this.firstValue() + c2.firstValue();
		double newdif = this.commonDifference + c2.commonDifference;
		Progression newP = new Arithmetic(newfirst,newdif);
		return newP;
		
	}

	@Override
	public Progression substractFrom(Arithmetic c2) {
		double newfirst = this.firstValue() - c2.firstValue();
		double newdif = this.commonDifference - c2.commonDifference;
		Progression newP = new Arithmetic(newfirst,newdif);
		return newP;
	}
	

}
