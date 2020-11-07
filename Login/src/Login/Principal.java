package Login;

import javax.swing.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lista lista = new lista();
		
		int opcion = 0;
		String opcionMenu = "";
		
		String user = "";
		String passw = "";
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int registroFallido = JOptionPane.NO_OPTION;
		int loginFallido = JOptionPane.NO_OPTION;
		do{
			
			if(registroFallido == JOptionPane.YES_OPTION) {
				opcion = 2;
			}else if(loginFallido == JOptionPane.YES_OPTION){
				opcion = 1;
			}else {
				opcionMenu = JOptionPane.showInputDialog("Que deseas hacer:"
						+ "\n1. Login"
						+ "\n2. Registro"
						+ "\n3. Salir"
						+ "\nEscoja su opcion:");
			}
			
			if(!esNumerico(opcionMenu)) {
				JOptionPane.showMessageDialog(null, "Ingrese un valor numérico");
			}else {
				opcion = Integer.parseInt(opcionMenu);
				switch(opcion) {
					case 1:
						user = JOptionPane.showInputDialog("Inicio de Sesión"
								+ "\nIngrese su nombre de usuario");
						passw = JOptionPane.showInputDialog("Inicio de Sesion"
								+ "\nIngrese su contraseña");
						if(lista.sesionIniciar(user, passw)) {
							if(lista.buscarNodo(user).primero) {
								if(lista.agregarDatos(user)) {
									JOptionPane.showMessageDialog(null, "Los datos se agregaron correctamente"
											+ "\nBienvenido " + lista.buscarNodo(user).nombre);
								}
								
							}else {
								JOptionPane.showMessageDialog(null, "Bienvenido " + lista.buscarNodo(user).nombre);
							}
							loginFallido = JOptionPane.NO_OPTION;
						}else {
							loginFallido = JOptionPane.showConfirmDialog (null, "Usuario y/o contraseña incorrectos\n¿Desea intentarlo de nuevo?","Usuario y/o contraseña incorrectos",dialogButton);
						}
						break;
					case 2:
						user = JOptionPane.showInputDialog("Registro de usuario"
								+ "\nIngrese su nombre de usuario");
						if(lista.validarUsuario(user)) {
							registroFallido = JOptionPane.showConfirmDialog (null, "El usuario ya existe\n¿Desea intentarlo con otro?","Usuario ya existe",dialogButton);
						}else {
							passw = JOptionPane.showInputDialog("Inicio de Sesion"
									+ "\nIngrese su contraseña");
							if(lista.crearUsuario(user, passw)) {
								JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
								registroFallido = JOptionPane.NO_OPTION;
							}
						}
						
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "Gracias por usar mi programa, adiós");
						
						break;
					case 4:
						lista.verLista();
						
						break;
					default:
						JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
						break;
				}
			}
		}while(opcion!=3);
	}
	
	public static boolean esNumerico(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		}catch(NumberFormatException ex) {
			return false;
		}
	}
}
