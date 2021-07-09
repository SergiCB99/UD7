import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex2App {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		//Declaro el ArrayList
		ArrayList <Double> carro = new ArrayList<>();
		
		boolean continuar = false;
		
		do {
			
			System.out.println("Introduce el precio del producto");
			Double precio=teclado.nextDouble();
			
			carro.add(precio);
			
			System.out.println("Quieres añadir mas productos? [Si/No]");
			String respuesta=teclado.next();
			
			if(respuesta.equals("No")) {
				continuar = true;
			}else if(respuesta.equals("Si")){
				continuar = false;
			}
			
		}while(continuar==false);
		
		System.out.println("Que IVA tienen estos productos");
		Double iva=teclado.nextDouble();
		
		iva = iva/100;
		
		//Sumo el total utilizando el iterator
		Iterator<Double> it=carro.iterator();
		Double total = 0.0;
		while(it.hasNext()) {
			total=total+it.next();
		}
		
		Double precio_neto = (total+(total*iva));
		
		//Muestro la cantidad de productos utilizando el .size
		System.out.println("Has comprado "+carro.size()+" productos con un coste bruto de "+total);
		System.out.println("Coste neto (IVA "+iva+") "+precio_neto);
		
		System.out.println("Cuanto vas a pagar?");
		Double dinero=teclado.nextDouble();
		
		do {
			if(dinero>precio_neto) {
				System.out.println("Has pagado "+dinero+" por la compra con precio "+precio_neto+" se te ha devuelto "+(dinero-precio_neto));
			}else if(dinero==precio_neto){
				System.out.println("Has pagado "+dinero+" por la compra con precio "+precio_neto);
			}else {
				System.out.println("Cantidad insuficiente");
			}
		}while(dinero<precio_neto);
		
	}
	
}
