import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex3App {

	static Scanner teclado = new Scanner(System.in);
	
	//Declaro el hashtable
	static Hashtable <String,Double> productos = new Hashtable <String,Double>();
	
	public static void listarProductos () {
		
		Enumeration <String> llaves=productos.keys();
		while(llaves.hasMoreElements()) {
			
			String producto = llaves.nextElement();
			
			Double precio = productos.get(producto);
			
			System.out.println("Producto "+producto+", Precio "+precio);
		}
	}
	
	public static void listarProducto (String producto_list) {
		
		//If que controla si el producto que buscas existe usando el .get
		if(productos.get(producto_list) != null) {
			System.out.println("Producto "+producto_list+", Precio "+productos.get(producto_list));
		}else {
			System.out.println("Producto no existente");
		}

	}
	
	public static void a�adirProducto (String nombre_producto, Double precio_producto) {
		
		//A�ado el producto usuando el .get
		productos.put(nombre_producto, precio_producto);

	}
	
	public static void menu (int accion) {
		
		switch(accion) {
			case 1:
				System.out.println("Que producto quiere a�adir?");
				String nombre_producto=teclado.next();
				
				System.out.println("Que precio tiene?");
				Double precio_producto=teclado.nextDouble();
				
				a�adirProducto(nombre_producto,precio_producto);
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
				System.out.println("Adios, Gracias");
			break;
		}
	}
	
	
	public static void main(String[] args) {
		
		//Lleno el hastable con productos y precios
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
			System.out.println("Que quiere hacer?\n1-A�adir Producto\n2-Listar todos los productos\n3-Mostrar un producto\n4-Salir");
			accion=teclado.nextInt();
			
			menu(accion);
		}while(accion!=5);
			
		}
			
	}