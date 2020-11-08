package RecursivosSuma;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursivosSuma {

	public static void main(String[] args) {
		//Entradas
		ArrayList<Integer> numeros =  new ArrayList<Integer>(Arrays.asList(new Integer[]{10,6,5,7,1,4}));//Lista de números
        int objetivo = 15;//Número objetivo
        
        //Llamada de la función recursiva
        sumaRecursiva(numeros,objetivo,new ArrayList<Integer>());
	}
	static void sumaRecursiva(ArrayList<Integer> numeros, int objetivo, ArrayList<Integer> fragmento) {
        int suma = 0;
        for (int x: fragmento) suma += x;
        if (suma == objetivo)
             System.out.println("suma("+Arrays.toString(fragmento.toArray())+")="+objetivo);
        if (suma >= objetivo)
             return;
        for(int i=0;i<numeros.size();i++) {
        	ArrayList<Integer> restante = new ArrayList<Integer>();
        	int numero = numeros.get(i);
        	for (int j=i+1; j<numeros.size();j++)
        		restante.add(numeros.get(j));
        	ArrayList<Integer> fragmento_aux = new ArrayList<Integer>(fragmento);
        	fragmento_aux.add(numero);
        	sumaRecursiva(restante,objetivo,fragmento_aux);
        }
     }
}
