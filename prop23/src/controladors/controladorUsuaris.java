package controladors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import domini.ConjuntDocuments;

/**
 * 
 * (controlador) Classe que ens serveix per a controlar totes les operacions i persistencia dels usuaris.
 * 
 * @author prop23-subgrup5
 */

public class controladorUsuaris {
	
	private static HashMap<String,String> usuaris = new HashMap<String,String>();
	private static String usuariPath = System.getProperty("user.dir") + "/src/metaData/usuaris.ser";
	private static FileWriter myWriter;
	
	/**
	 * Funcio que serveix per controlar el log-in a la APP
	 * @param name
	 * Nom introduït
	 * @param pas
	 * Password intorduït
	 * @return
	 * Cert si les cerdencials son v�lides
	 */
	public static boolean controlaLogin(String name, String pas) {
		String password = usuaris.get(name);
		if(password != null && password.equals(pas)) {
			controladorPresencia.mostraMenu();

			controlador.updateUsuariIniciat(name);
			return true;
		}
		controladorPresencia.mostraErrorLoginPres();
		return false;
		
			
	}
	
	
	/**
	 * Comprova si la contrasenya es valida, no pot contenir el caracter ';' i ha de tenir alments 4 caracters
	 * @param pas
	 * Contrasenya del nou usuari
	 * @return
	 * True si la contrasenya es validda, false en cas contrari
	 */
	private static boolean isValidPasword(String pas) {
		if(pas.isEmpty()) return false;
		if(pas.length() < 4) return false;
		return true;
		
	}
	/**
	 * Funcio que crea un nou usuari, comprovant previament que no existeix i que les claus s�n v�lides.
	 * @param name
	 * Nom de l'usuari, serveix com a identificador de l'usuari
	 * @param pas
	 * Contrasenya del nou usuari
	 * @return
	 * True si l'usuari s'ha creat correctament, false en cas contrari
	 */
	public static boolean newUsuari(String name, String pas) {
		boolean creat = false;
		boolean validPas = isValidPasword(pas);
		if(validPas) {
			String control = usuaris.put(name,pas);
			
			if(control == null)creat = true;
		}	
		return creat;
	}
	
	/**
	 * Funcio que borra un usuari, nom�s pot ser cridada per l'admin.
	 * @param usuari
	 * Usuari que es vol borrar
	 * @return 
	 */
	public static boolean delete_usuari(String usuari) {
		String contra = usuaris.remove(usuari);
		System.out.print(contra);
		if(contra == null) {
			System.out.print("no existeix l'usuari");
			return false;
		}
		System.out.print(usuaris);
		return true;
	}
	
	
	
	/**
	 * Serialitza l'objecte conjuntUsuaris, guardant per una futura sessio els usuaris
	 */
	public static void serializeUsers() {
		// serialitza les dades dels usuaris
		try
		{
			FileOutputStream file = new FileOutputStream(usuariPath);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(usuaris);
			
			out.close();
			file.close();
			System.out.println("Users have been serialized");

		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		
	}
	
	public static void deSerializeUsers() {
		try
		{
			FileInputStream file = new FileInputStream(usuariPath);
			ObjectInputStream in = new ObjectInputStream(file);
			
			usuaris = (HashMap)in.readObject();
			
			in.close();
			file.close();
			
			System.out.println("Users has been deserialized ");
		}
		
		catch(IOException ex)
		{
			System.out.println("Res a serialitzar.");
			usuaris = new HashMap<String,String>();
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}
	}
	
}


