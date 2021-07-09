import javax.swing.JOptionPane;

import java.util.Enumeration;
import java.util.Hashtable;

public class Ex1App {

	public static void main(String[] args) {
		
		//Declaro el hashtable
		Hashtable <String,Double> contenedor = new Hashtable <String,Double>();
		
		String nombre;
		
		double media;
		
		boolean continuar = false;
		
		do {
			nombre = JOptionPane.showInputDialog("Introduce tu nombre");
			
			String nota1_usuario = JOptionPane.showInputDialog("Introduce la primera nota");
			String nota2_usuario = JOptionPane.showInputDialog("Introduce la segunda nota");
			
			double nota1 = Double.parseDouble(nota1_usuario);
			double nota2 = Double.parseDouble(nota2_usuario);
			
			media = (nota1+nota2)/2;
			
			//Lleno el hashtable
			contenedor.put(nombre, media);
			
			String respuesta = JOptionPane.showInputDialog("Quieres introducir mas alumnos? [Si/No]");
			
			if(respuesta.equals("No")) {
				continuar = true;
			}else if(respuesta.equals("Si")){
				continuar = false;
			}
			
		}while(continuar==false);
		
		//Uso el .keys para saber las claves
		Enumeration <String> llaves=contenedor.keys();
		while(llaves.hasMoreElements()) {
			
			//En la variable nombre guardo el indice
			nombre = llaves.nextElement();
			
			//La media la consigo usando el .get y el indice conseguido anteriormente
			media = contenedor.get(nombre);
			
			System.out.println("Nombre "+nombre+", Media "+media);
	
		}
		
	}
	
}
