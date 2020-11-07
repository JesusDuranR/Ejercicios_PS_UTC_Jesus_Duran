package Login;

import javax.swing.*;

public class lista {
	
	nodo primero;
	nodo ultimo;
	
	public lista() {
		primero = null;
		ultimo = null;
	}
	public boolean crearUsuario(String user, String passw) {
		nodo nodoNuevo = new nodo();
		nodoNuevo.user = user;
		nodoNuevo.passw = passw;
		nodoNuevo.edad = 0;
		nodoNuevo.nombre = null;
		nodoNuevo.primero = true;
		boolean registrado = false;
		
		if(validarUsuario(user) == true) {
			registrado = false;
		}else {
			if(primero==null) {
				primero = nodoNuevo;
				primero.siguiente = null;
				ultimo = primero;
			}else {
				ultimo.siguiente = nodoNuevo;
				nodoNuevo.siguiente = null;
				ultimo = nodoNuevo;
			}
			registrado = true;
		}
		return registrado;
	}
	
	public nodo buscarNodo(String user) {
		nodo actual = new nodo();
		actual = primero;
		nodo datos = new nodo();
		boolean encontrado = false;
		while(actual!=null && encontrado==false) {
			if(actual.user.equals(user)) {
				datos = actual;
				encontrado = true;
			}else {
				datos = null;
				encontrado = false;
			}
			
			actual = actual.siguiente;
		}
		return datos;
	}
	
	public boolean sesionIniciar(String user,String passw) {
		nodo actual = new nodo();
		actual = primero;
		boolean correcto = false;
		while(actual!=null && correcto == false) {
			if(actual.user.equals(user) && actual.passw.equals(passw)) {
				correcto = true;
			}else {
				correcto = false;
			}
			
			actual = actual.siguiente;
		}
		return correcto;
	}
	
	public boolean validarUsuario(String user) {
		nodo actual = new nodo();
		actual = primero;
		boolean encontrado = false;
		while(actual!=null && encontrado == false) {
			if(actual.user.equals(user)) {
				encontrado = true;
			}else {
				encontrado = false;
			}
			
			actual = actual.siguiente;
		}
		return encontrado;
	}
	
	public boolean agregarDatos(String user) {
		String nombre = "";
		String edad = "";
		nodo actual = buscarNodo(user);
		JOptionPane.showMessageDialog(null, "A continuacion se le pedira la siguiente informacion por ser su priumer inicio, no deben estar vacios");
		boolean agregado = false;
		boolean edadInt = false;
		while (agregado == false) {
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
		
			if(nombre.length() != 0) {
				while(!edadInt) {
					edad = JOptionPane.showInputDialog("Ingresa la edad del usuario");
					if(edad.length() != 0) {
						if(esNumerico(edad)) {
							actual.nombre = nombre;
							actual.edad = Integer.parseInt(edad);
							actual.primero = false;
							agregado = true;
							edadInt = true;
						}else {
							JOptionPane.showMessageDialog(null, "Ingrese una edad correcta");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Debe ingresar información en la edad");
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe ingresar información en el nombre");
			}
			
		}
		return agregado;
	}
	
	private boolean esNumerico(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		}catch(NumberFormatException ex) {
			return false;
		}
	}
	
	public void verLista() {
		nodo actual = new nodo();
		actual = primero;
		while(actual != null) {
			System.out.println(actual.user + ", " + actual.passw + ", " + actual.primero  + ", " + actual.nombre+ ", " + actual.edad);
			actual = actual.siguiente;
		}
	}
}
