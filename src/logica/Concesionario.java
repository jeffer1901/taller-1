package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Concesionario {
	private Auto auto=new Auto();
	private Moto moto=new Moto();
	public static ArrayList<Vehiculo> vehiculos_disponibles=new ArrayList<Vehiculo>();
	public static ArrayList<Vehiculo> vehiculos_vendidos=new ArrayList<Vehiculo>();
	/*
	 * este metodo recolecta los datos del vehiculo y lo agrega a un arratlist 
	 */
	public void agrega_vehiculo(int tipo) {
			if(tipo==1){
				String placa=JOptionPane.showInputDialog("digite la placa");String referencia=JOptionPane.showInputDialog("digite la referencia");
				String marca=JOptionPane.showInputDialog("digite la marca");String modelo=JOptionPane.showInputDialog("digite el modelo");
				int numPuertas=Integer.parseInt(JOptionPane.showInputDialog("digite el numero de puertas"));
				int numRuedas=Integer.parseInt(JOptionPane.showInputDialog("digite el numero de Ruedas"));
				boolean gasolina=Boolean.valueOf(JOptionPane.showInputDialog("es a gasolina?"));
				int precio=Integer.parseInt(JOptionPane.showInputDialog("digite el valor del vehiculo"));	
			auto.setMarca(marca);  auto.setPlaca(placa);  auto.setReferencia(referencia);
			auto.setModelo(modelo); auto.setNum_puertas(numPuertas); auto.setNum_ruedas(numRuedas);		
			auto.setIs_gasolina(gasolina); auto.setPrecio(precio);
			vehiculos_disponibles.add(auto);
		}else {
			String placa=JOptionPane.showInputDialog("digite la placa");String referencia=JOptionPane.showInputDialog("digite la referencia");
			String marca=JOptionPane.showInputDialog("digite la marca");String modelo=JOptionPane.showInputDialog("digite el modelo");
			int numRuedas=Integer.parseInt(JOptionPane.showInputDialog("digite el numero de Ruedas"));
			int cilindraje=Integer.parseInt(JOptionPane.showInputDialog("digite el cilindraje de la moto"));
			double tamTanque=Double.parseDouble(JOptionPane.showInputDialog("digite el cilindraje de la moto"));
			int precio=Integer.parseInt(JOptionPane.showInputDialog("digite el valor del vehiculo"));	
			moto.setMarca(marca);moto.setPlaca(placa);moto.setReferencia(referencia);
			moto.setModelo(modelo);moto.setNum_ruedas(numRuedas);moto.setCilindraje(cilindraje);
			moto.setTam_tanque(tamTanque);moto.setPrecio(precio);
			vehiculos_disponibles.add(moto);
		}
		
	}
	/*
	 * el metodo buscar ayuda a encontrar un vehiculo mediante su placa
	 */
	public void buscar_vehiculo() {
		int opcion=Integer.parseInt(JOptionPane.showInputDialog("1. Buscar en vehiculos disponibles"
				+ "\n2. Buscar en vehiculos vendidos "));
		String dato=JOptionPane.showInputDialog("Digita la placa del vehiculo que deseas buscar");
		if(opcion==1) {
			for(int i=0;i<vehiculos_disponibles.size();i++) {
				if(vehiculos_disponibles.get(i).getPlaca().equals(dato)) {
					JOptionPane.showMessageDialog(null,vehiculos_disponibles.get(i).toString());
				}else {
					JOptionPane.showMessageDialog(null,"Vehiculo no esta registrado o ya se vendio");
				}
			}
		}else {
			for(int i=0;i<vehiculos_vendidos.size();i++) {
				if(vehiculos_vendidos.get(i).getPlaca().equals(dato)) {
					JOptionPane.showMessageDialog(null,vehiculos_vendidos.get(i).toString());
				}else {
					JOptionPane.showMessageDialog(null,"vehiculo no encontrado");
				}
			}
		}
	}
	/*
	 * el metodo vender agarra un vehiculo que este disponible elegido por el usuario y lo elimina del arraylist 
	 * disponible y lo agrega en la arraylist de vehiculos vendidos
	 */
public void vender_vehiculos() {
		String dato=JOptionPane.showInputDialog("Digita la placa del vehiculo que deseas vender");
		for(int i=0;i<vehiculos_disponibles.size();i++) {
			if(vehiculos_disponibles.get(i).getPlaca().equals(dato)) {
				vehiculos_vendidos.add(vehiculos_disponibles.get(i));
				vehiculos_disponibles.remove(i);
			}else {
				JOptionPane.showMessageDialog(null,"Vehiculo no encontrado");
			}
		}
	}

/*
 * el metodo mostrar ayuda a visualizar todos los vehiculos que esten disponibles
 */
public void mostrar_disponibles() {
		for(int i=0;i<vehiculos_disponibles.size();i++) {
			System.out.println(i+". "+vehiculos_disponibles.toString());
		}
	}
/*
 * el metodo cantidades cuenta cuantos vehiculos estan vendidos cuantos disponibles y cuantos son autos o motos	
 */
public void cantidades() {
		int cantidad_motos=0; int cantidad_autos=0;
		int cantidad_vendidos=0; int cantidad_disponibles=0;
		
		for(int i=0;i<vehiculos_disponibles.size();i++) {
			if(vehiculos_disponibles.size()==0) {
				
			}else {
				cantidad_disponibles++;
				if(vehiculos_disponibles.get(i).getClass().equals(auto.getClass())) {
					cantidad_autos++;
				}else if(vehiculos_disponibles.get(i).getClass().equals(moto.getClass())) {
					cantidad_motos++;
				}
			}
		}
		for(int j=0;j<vehiculos_vendidos.size();j++) {
			if(vehiculos_vendidos.size()==0) {
				
			}else {
				cantidad_vendidos++;
			}
		}
		
		JOptionPane.showMessageDialog(null, "cantidad de vehiculos disponibles: "+cantidad_disponibles+"\n"
				+ "cantidad de autos: "+cantidad_autos+"\ncantidad de motos: "+cantidad_motos+
				"\ncantidad de vehiculos vendidos: "+cantidad_vendidos);
	}
/*
 * el total ventas lleva la suma total de vehiculos vendidos
 */
	public void total_ventas() {
		int total=0;
		for(int i=0;i<vehiculos_vendidos.size();i++) {
			if(vehiculos_vendidos.size()==0) {
				JOptionPane.showMessageDialog(null, "No hay vehiculos vendidos");
			}else {
				total+=vehiculos_vendidos.get(i).getPrecio();
				JOptionPane.showMessageDialog(null, "El total de ventas a sido de: "+total);
			}
		}
	}
/*
 * el metodo eliminar ayuda a borrar vehiculos que esten disponibles buscandolos por medio de la placa	
 */
public void eliminar_vehiculo() {
		String dato=JOptionPane.showInputDialog("Digita la placa del vehiculo que deseas eliminar");
		for(int i=0;i<vehiculos_disponibles.size();i++) {
			if(dato.equals(vehiculos_disponibles.get(i).getPlaca())) {
				vehiculos_disponibles.remove(i);
			}else {
				JOptionPane.showMessageDialog(null, "Vehiculo no encontrado");
			}
		}
	}
/*
 * el metodo actualizar ayuda a modificar los datos del vehiculo y se busca por medio de la placa
 */
	
public void actualizar_vehiculo() {
		String placaTemp=JOptionPane.showInputDialog("digite la placa del vehiculo que desea actualizar");
		for(int i=0;i<vehiculos_disponibles.size();i++) {
			if(placaTemp.equals(vehiculos_disponibles.get(i).getPlaca())) {
				String opcion=JOptionPane.showInputDialog("Que desea Actualizar: \nMarca\nModelo\nReferencia"
						+ "\nNumero de ruedas\nPrecio");
				switch(opcion) {
				case "marca":
					vehiculos_disponibles.get(i).setMarca(JOptionPane.showInputDialog("Digite la marca"));
					JOptionPane.showMessageDialog(null,"Marca Actualizada");
					break;
				case "modelo":
					vehiculos_disponibles.get(i).setModelo(JOptionPane.showInputDialog("Digite el modelo"));
					JOptionPane.showMessageDialog(null,"Modelo Actualizado");
					break;
				case "referencia":
					vehiculos_disponibles.get(i).setReferencia(JOptionPane.showInputDialog("Digite la referencia"));
					JOptionPane.showMessageDialog(null,"Referencia Actualizada");
					break;
				case "numero de ruedas":
					vehiculos_disponibles.get(i).setNum_ruedas(Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de ruedas")));
					JOptionPane.showMessageDialog(null,"numero de ruedas ha sido actualizado");
					break;
				case "precio":
					vehiculos_disponibles.get(i).setPrecio(Integer.parseInt(JOptionPane.showInputDialog("Digite el Precio")));
					JOptionPane.showMessageDialog(null,"Precio Actualizado");
					break;
				}
			}else {
				JOptionPane.showMessageDialog(null,"Vehiculo no encontrado");
			}
		}
	}
/*
 * el metodo menu es el que muestra y le pregunta al usuario que opcion quiere elegir 
 */
	public void menu() {
		int opcion=9;
			while (opcion!=0) {
				opcion=Integer.parseInt(JOptionPane.showInputDialog("1.Agregar Vehiculo."+
						"\n2.Buscar Vehiculo."+"\n3.Ver vehiculos disponibles."+"\n4.Vender vehiculos"+
								"\n5.Ver cantidades."+"\n6.Actualizar Datos."+"\n7.Ver ventas totales"+
						"\n8.Eliminar vehiculos"+"\n0.Salir"));
				switch (opcion) {
				case 1:
					int tipo=Integer.parseInt(JOptionPane.showInputDialog("1.Auto"+"\n2.Moto"));
					agrega_vehiculo(tipo);
					break;
				case 2:
					buscar_vehiculo();
					break;
				case 3:
					mostrar_disponibles();
					break;
				case 4:
					vender_vehiculos();
					break;
				case 5:
					cantidades();
					break;
				case 6:
					actualizar_vehiculo();
				case 7:
					total_ventas();
					break;
				case 8:
					eliminar_vehiculo();
					break;
				}
			}
	}
}
