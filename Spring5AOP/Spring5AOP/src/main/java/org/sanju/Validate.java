package org.sanju;

public class Validate {

	
	public void validate(int age)throws Exception{
		if(age<18){
			throw new ArithmeticException("not valide");
		}else{
			System.out.println("ur are valide");
		}
	}
}
