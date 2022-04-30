package com.Array;

public class Test {
	
	public static void main(String[]args) {
Emp e1= new Emp("vaishali",111);
Emp e2= new Emp("raman",112);

Emp[] e= new Emp[5];
e[0]=e1;
e[2]=e2;


for(int i=0;i<e.length;i++) {
	if(e[i]==null) {
		System.out.println(i);
		
	}
}

}
}
