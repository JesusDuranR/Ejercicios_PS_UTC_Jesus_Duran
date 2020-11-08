package PINAdivinar;

import javax.swing.*; 
import java.util.Random;

public class PINAdivinar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		String opcionMenu = "";
		do{
			opcionMenu = JOptionPane.showInputDialog("Que deseas hacer:"
					+ "\n1. Ingresar PIN"
					+ "\n2. Salir"
					+ "\nEscoja su opcion:");
			if(!isNumeric(opcionMenu)) {
				JOptionPane.showMessageDialog(null, "Ingrese un valor numérico");
			}else {
				opcion = Integer.parseInt(opcionMenu);
				switch(opcion) {
					case 1:
						String PIN = JOptionPane.showInputDialog("Ingresa tu PIN de 4 digitos");
						String generadoPIN;
						if(isNumeric(PIN)) {
							if(PIN.length() != 4)
								JOptionPane.showMessageDialog(null, "El PIN no es de 4 digitos");
							else {
								generadoPIN = adivinarPIN();
								if(PIN.equals(generadoPIN)) {
									JOptionPane.showMessageDialog(null, "El PIN del usuario fue adivinado"
											+ "\nPIN usuario: " + PIN
											+ "\nPIN generado: " + generadoPIN);
								}else {
									JOptionPane.showMessageDialog(null, "El PIN del usuario no fue adivinado"
											+ "\nPIN usuario: " + PIN
											+ "\nPIN generado: " + generadoPIN);
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "El PIN no es númerico");
						}
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Gracias por usar mi programa, adiós");
						
						break;
					default:
						JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
						break;
						
				}
			}
		}while(opcion!=2);
	}
	
	public static boolean isNumeric(String cadena) {
		try{
			Integer.parseInt(cadena);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	public static int[] PINGenerador() {
	    Random randy = new Random();
	    int[] randArray = {10,10,10,10};

	    for(int i=0;i<randArray.length;i++){
	        int temp = randy.nextInt(9);
	        while(temp == randArray[0] || temp == randArray[1] || temp == randArray[2] || temp == randArray[3]){
	            temp=randy.nextInt(9);
	        }
	        randArray[i]=temp;      
	    }
	    return randArray;
	}
	public static String adivinarPIN(){
	    String contrasena="";
	    int generador;
	    for(int i=0;i<4;i++){
	    	generador = (int)(Math.random()*10);
	    	contrasena+= generador;
	    }
	    return contrasena;
	}
}
