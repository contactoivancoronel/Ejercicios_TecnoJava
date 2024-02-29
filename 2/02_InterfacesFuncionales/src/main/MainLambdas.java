package main;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

import funcionales.Operador;

public class MainLambdas {

	public static void main(String[] args) {
		
		Operador suma  = new Operador() {			
			@Override
			public int operar(int a , int b) {
				return a+b;
			}
		};
		
		Operador resta  = new Operador() {			
			@Override
			public int operar(int a , int b) {
				return a-b;
			}
		};

		Operador multiplicacion = (int a , int b) -> a * b;
		
		
		Operador division = (a , b) -> a / b;
		
		BinaryOperator<Integer> modulo = (a , b) -> a % b;
		
		
		int resultado = suma.operar(4, 9);
		System.out.println("suma:" + resultado);

		 resultado = resta.operar(4, 9);
		System.out.println("Resta: "+resultado);

		 resultado = multiplicacion.operar(4, 9);
		System.out.println("multiplicacion: "+resultado);
		
		 resultado = division.operar(10, 5);
		System.out.println("division: "+resultado);
		

		 resultado =modulo.apply(9, 5);
		System.out.println("modulo: "+resultado);
		
		IntBinaryOperator multi = (a,b)->a*b;
		
		

	}

}
