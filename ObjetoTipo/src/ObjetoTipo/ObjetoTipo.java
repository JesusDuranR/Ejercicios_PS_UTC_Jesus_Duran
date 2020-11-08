package ObjetoTipo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjetoTipo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variable de texto
		String palabra = "Esta es una palabra";
		
		//Variables numericas
		int num1 = 8;
		double num2 = 8.8;
		float num3 = (float) 2.2;
		long num4 = 8888888;
		short num5 = 888;
		
		//variable de tipo boolean
		boolean verdadero = false;
		
		//Variable de tipo char
		char letra = 'M';
		
		//Elementos de tipo listas
		List<Integer> lista1 = new ArrayList<Integer>();
		lista1.add(1);
		lista1.add(2);
		lista1.add(3);
		lista1.add(4);
		ArrayList<String> lista2 = new ArrayList<String>();
		lista2.add("Una");
		lista2.add("Otra");
		lista2.add("Y otra");
		int[] arreglo = {2,3,4,6,7};
		
		//Llamada de la funcion
		System.out.print(palabra+"->");verificarObjeto(palabra);
		System.out.print(num1+"->");verificarObjeto(num1);
		System.out.print(num2+"->");verificarObjeto(num2);
		System.out.print(num3+"->");verificarObjeto(num3);
		System.out.print(num4+"->");verificarObjeto(num4);
		System.out.print(num5+"->");verificarObjeto(num5);
		System.out.print(verdadero+"->");verificarObjeto(verdadero);
		System.out.print(letra+"->");verificarObjeto(letra);
		System.out.print(lista1+"->");verificarObjeto(lista1);
		System.out.print(lista2+"->");verificarObjeto(lista2);
		System.out.print(arreglo+"->");verificarObjeto(arreglo);
	}
	public static void verificarObjeto(Object objeto) {
		if(objeto.getClass() == Integer.class || objeto.getClass() == Long.class || objeto.getClass() == Double.class || objeto.getClass() == Short.class || objeto.getClass() == Float.class) {
			System.out.println("Eres número");
		}else if(objeto.getClass() == String.class){
			System.out.println("Eres una palabra");
		}else if(objeto.getClass() == List.class || objeto.getClass() == ArrayList.class || objeto.getClass() == Arrays.class || objeto instanceof int[] || objeto instanceof double[] || objeto instanceof float[] || objeto instanceof long[] || objeto instanceof short[] || objeto instanceof String[] || objeto instanceof char[] || objeto instanceof int[]){
			System.out.println("Eres una lista");
		}else {
			System.out.println("Eres de otro tipo");
		}
	}
}
