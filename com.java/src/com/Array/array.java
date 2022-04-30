package com.Array;

import java.util.Objects;

public class array {

	
	public static void main(String[]args) {
		
		array a1= new array();
		array a2= new array();
		
		array[] a= new array[2];
		a[0]=a1;
		a[1]=a2;
		for(array aa:a) {
			System.out.println(aa);
		}
		
	}
}

