import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Ex4App {

	static Hashtable <String,Double> productos = new Hashtable <String,Double>();
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void listarProductos () {
		
		Enumeration <String> llaves=productos.keys();
		while(llaves.hasMoreElements()) {
			
			//En la variable nombre guardo el indice
			String producto = llaves.nextElement();
			
			//La media la consigo usando el .get y el indice conseguido anteriormente
			Double precio = productos.get(producto);
			
			System.out.println("Producto "+producto+", Precio "+precio);
		}
	}
	
	public static void listarProducto (String producto_list) {
		
		if(productos.get(producto_list) != null) {
			System.out.println("Producto "+producto_list+", Precio "+productos.get(producto_list));
		}else {
			System.out.println("Producto no existente");
		}

	}
	
	public static void añadirProducto (String nombre_producto, Double precio_producto) {
		
		productos.put(nombre_producto, precio_producto);

	}
	
	public static void comprar () {
		
		ArrayList <Double> carro = new ArrayList<>();
		
		boolean continuar = false;
		
		do {
			
			System.out.println("Introduce el nombre del producto");
			String producto=teclado.next();
			
			//If que controla si el producto que quiere comprar existe
			if(productos.get(producto) == null){
				System.out.println("Producto no existente");	
			}else {
				carro.add(productos.get(producto));
			}
			
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
		
		Iterator<Double> it=carro.iterator();
		Double total = 0.0;
		while(it.hasNext()) {
			total=total+it.next();
		}
		
		Double precio_neto = (total+(total*iva));
		
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
		}while(dinero<(total+(total*iva)));
		
	}
	
	public static void menu (int accion) {
		
		switch(accion) {
		case 1:
			System.out.println("Que producto quiere añadir?");
			String nombre_producto=teclado.next();
			
			System.out.println("Que precio tiene?");
			Double precio_producto=teclado.nextDouble();
			
			añadirProducto(nombre_producto,precio_producto);
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
		
		int accion;
		
		do {
			System.out.println("Que quiere hacer?\n1-Añadir Producto\n2-Listar todos los productos\n3-Mostrar un producto\n4-Comprar\n5-Salir");
			accion=teclado.nextInt();
			
			menu(accion);
		}while(accion!=5);
	}
	
}
