import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex2App {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		//Declaro el ArrayList
		ArrayList <Double> carro = new ArrayList<>();
		ArrayList <Double> carroIVA = new ArrayList<>();
		
		boolean continuar = false;
		
		do {
			
			System.out.println("Introduce el precio del producto");
			Double precio=teclado.nextDouble();
			
			carro.add(precio);
			
			System.out.println("Que IVA tiene este producto");
			Double iva=teclado.nextDouble();
			
			carroIVA.add(precio+(precio*(iva/100)));
			
			System.out.println("Quieres añadir mas productos? [Si/No]");
			String respuesta=teclado.next();
			
			if(respuesta.equals("No")) {
				continuar = true;
			}else if(respuesta.equals("Si")){
				continuar = false;
			}
			
		}while(continuar==false);
		
		//Sumo el total utilizando el iterator
		Iterator<Double> it=carro.iterator();
		Double total = 0.0;
		while(it.hasNext()) {
			total=total+it.next();
		}
		
		Iterator<Double> itcIVA=carroIVA.iterator();
		Double totalIVA = 0.0;
		while(itcIVA.hasNext()) {
			totalIVA=totalIVA+itcIVA.next();
		}
		
		//Muestro la cantidad de productos utilizando el .size
		System.out.println("Has comprado "+carro.size()+" productos con un coste bruto de "+total);
		System.out.println("Coste neto "+totalIVA);
		
		System.out.println("Cuanto vas a pagar?");
		Double dinero=teclado.nextDouble();
		
		do {
			if(dinero>totalIVA) {
				System.out.println("Has pagado "+dinero+" por la compra con precio "+totalIVA+" se te ha devuelto "+(dinero-totalIVA));
			}else if(dinero==totalIVA){
				System.out.println("Has pagado "+dinero+" por la compra con precio "+totalIVA);
			}else {
				System.out.println("Cantidad insuficiente");
			}
		}while(dinero<totalIVA);
		
	}
	
}
