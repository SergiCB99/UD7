import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Ex4App {

	static Hashtable <String,Double> productos = new Hashtable <String,Double>();
	static Hashtable <String,Double> cantidades = new Hashtable <String,Double>();
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void listarProductos () {
		
		Enumeration <String> llaves=productos.keys();
		while(llaves.hasMoreElements()) {
			
			//En la variable nombre guardo el indice
			String producto = llaves.nextElement();
			
			//La media la consigo usando el .get y el indice conseguido anteriormente
			Double precio = productos.get(producto);
			
			Double cantidad = cantidades.get(producto);;
			
			System.out.println("Producto "+producto+", Precio "+precio+", Cantidad "+cantidad);
		}
	}
	
	public static void listarProducto (String producto_list) {
		
		if(productos.get(producto_list) != null) {
			System.out.println("Producto "+producto_list+", Precio "+productos.get(producto_list)+", Cantidad "+cantidades.get(producto_list));
		}else {
			System.out.println("Producto no existente");
		}

	}
	
	public static void añadirProducto (String nombre_producto, Double precio_producto, Double cantidad_producto) {
		
		productos.put(nombre_producto, precio_producto);

		cantidades.put(nombre_producto,cantidad_producto);
		
	}
	
	public static void comprar () {
		
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
	
	public static void menu (int accion) {
		
		switch(accion) {
		case 1:
			System.out.println("Que producto quiere añadir?");
			String nombre_producto=teclado.next();
			
			System.out.println("Que precio tiene?");
			Double precio_producto=teclado.nextDouble();
			
			System.out.println("Cantidad?");
			Double cantidad_producto=teclado.nextDouble();
			
			añadirProducto(nombre_producto,precio_producto,cantidad_producto);
		break;
		case 2:
			listarProductos();
		break;
		case 3:
			System.out.println("Que producto quiere listar");
			String producto_list=teclado.next();
			
			listarProducto(producto_list);
		break;
		case 4:
			comprar();
		break;
		case 5:
			System.out.println("Adios, Gracias");
		break;
		
	}
	}
	
	public static void main(String[] args) {
	
		productos.put("Naranjas", 1.0);
		productos.put("Manzanas", 1.0);
		productos.put("Sandias", 1.5);
		productos.put("Melocoton", 1.0);
		productos.put("Limon", 1.0);
		productos.put("Peras", 1.0);
		productos.put("Melon", 1.5);
		productos.put("Fresas", 0.75);
		productos.put("Nisperos", 0.75);
		productos.put("Albaricoque", 0.75);
		
		cantidades.put("Naranjas", 10.0);
		cantidades.put("Manzanas", 15.0);
		cantidades.put("Sandias", 15.0);
		cantidades.put("Melocoton", 10.0);
		cantidades.put("Limon", 20.0);
		cantidades.put("Peras", 20.0);
		cantidades.put("Melon", 15.0);
		cantidades.put("Fresas", 75.0);
		cantidades.put("Nisperos", 35.0);
		cantidades.put("Albaricoque", 30.0);
		
		int accion;
		
		do {
			System.out.println("Que quiere hacer?\n1-Añadir Producto\n2-Listar todos los productos\n3-Mostrar un producto\n4-Comprar\n5-Salir");
			accion=teclado.nextInt();
			
			menu(accion);
		}while(accion!=5);
	}
	
}
