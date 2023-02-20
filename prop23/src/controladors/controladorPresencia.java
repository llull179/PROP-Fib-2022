package controladors;
import exceptions.fileNotFoundException;
import presencia.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 
 * (controlador) Classe que ens serveix per a controlar la presencia del nostra interfície
 * 
 * @author prop23-subgrup5
 */
@SuppressWarnings("unused")
public class controladorPresencia {
	
	/**
	 * Crida a la interficie per mostrar Alta de documents
	 */
	public static void mostraAltaDoc() {
		altaDoc a = new altaDoc();
	}
	/**
	 * Crida a la interficie per mostrar Creacrió de documents
	 */
	public static void mostraCreaDoc() {
		creaDoc a = new creaDoc();
	}
	public static void mostraCreaDocXml() {
		creaDocXml a = new creaDocXml();
	}
	/**
	 * Crida a la interficie per mostrar Menú
	 */
	public static void mostraMenu() {
		menu a = new menu();
	}
	/**
	 * Crida a la interficie per mostrar Cerca de Similars
	 */
	public static void mostraCercaSimilars() {
		cercaSimilars a = new cercaSimilars();
	}
	/**
	 * Crida a la interficie per mostrar Confirmació de modifficació
	 */
	public static void mostraConfirmMod() {
		mostraConfirmMod a = new mostraConfirmMod();
	}
	/**
	 * Crida a la interficie per donar l'OK de creació
	 */
	public static void mostraOkCreat() {
		mostraOkCreat a = new mostraOkCreat();
	}
	/**
	 * Crida a la interficie per mostrar que ja existeix un Document
	 */
	public static void mostraJaExisteix() {
		mostraJaExisteix a = new mostraJaExisteix();
	}
	/**
	 * Crida a la interficie per mostrar Carrega documents
	 */
	public static void mostraCarregaDoc() {
		carregaDoc a = new carregaDoc();
	}
	/**
	 * Crida a la interficie per mostrar Menú de cerca
	 */
	public static void mostraCerca() {
		cerca a = new cerca();
	}
	/**
	 * Crida a la interficie per mostrar Cerca de títols-autor
	 */
	public static void mostraCercaTitolAutor() {
		cercaTitAut a = new cercaTitAut();
	}
	/**
	 * Crida a la interficie per mostrar Cerca dels títols d'un autor
	 */
	public static void mostraCercaTitolsUnAutor() {
		cercaTitUnAut a = new cercaTitUnAut();
	}
	/**
	 * Crida a la interficie per mostrar Cerca d'un autor per prefix
	 */
	public static void mostraCercaAutors() {
		cercaAutors a = new cercaAutors();
	}
	/**
	 * Crida a la interficie per mostrar Confirmacio de sortida de la APP
	 */
	public static void mostraConfirmacioSortida() {
		confirmacionSalida a = new confirmacionSalida();
	}
	public static void mostraConfirmacioSortidaToLogin() {
		confirmacioSortidaToLogin a = new confirmacioSortidaToLogin();
	}
	/**
	 * Crida a la interficie per mostrar Confirmació esborrat
	 */
	public static void mostraConfirmacioEsborrat() {
		confirmacionEsborrat a = new confirmacionEsborrat();
	}
	/**
	 * Crida a la interficie per mostrar Modificació de document
	 * @throws fileNotFoundException 
	 */
	public static void mostraModDoc() throws fileNotFoundException {
		controlador.mostraModDoc();
	}
	/**
	 * Crida a la interficie per mostrar el LOG-IN
	 */
	
	public static void mostraLogIn() {
		login a = new login();
	}
	/**
	 * Crida a la interficie per mostrar la confirmació d'esborrat d'un document
	 */
	public static void mostraSeguroEliminarDoc(String titol, String autor) {
		
		EliminaDoc e = new EliminaDoc(titol,autor);
	}
	/**
	 * Crida a la interficie per mostrar errors
	 */
	public static void mostraError(String err) {
		error a = new error(err);
	}
	/**
	 * Crida a la interficie per mostrar el registre d'usuaris
	 */
	public static void mostraRegistreUsuari() {
		registrarUsuari x = new registrarUsuari();
	}
	/**
	 * Crida a la interficie per mostrar la cerca de k documents m�s rellevants
	 */
	public static void mostraKRellevants() {
		cercaKRellevants x = new cercaKRellevants();
	}
	public static void mostraExportarDoc(String t, String a) {
		exportaDoc x = new exportaDoc(t,a);
	}
	public static void mostraResultOrdreAlfTitA(String result, String autor) {
		String[] lines = result.split("\n");
		Arrays.sort(lines);		
		String result2 = "";
		for(String y: lines) {;	  
		  result2 += y +"\n";
		  
		}
		resultatCercaTitolsUnAutor rctua = new resultatCercaTitolsUnAutor(result2,autor);
	}
	public static void mostraResultOrdreAlfTitD(String result, String autor) {
		String[] lines = result.split("\n");
		Arrays.sort(lines, Collections.reverseOrder());   
		String result3 = "";
		for (String x : lines) {
			result3 += x + "\n";
		}
		resultatCercaTitolsUnAutor rctua = new resultatCercaTitolsUnAutor(result3,autor);
	}
	public static void mostraCercaBooleanaOrdreAlfPresencia() {
		Vector <String> tot = controlador.mostraCercaBooleanaOrdreAlf();
    	Collections.sort(tot);
    	cercaBooleana cb = new cercaBooleana(tot);
	}
	public static void mostraCercaBooleanaOrdreAntPresencia() {
		Vector <String> tot = controlador.mostraCercaBooleanaOrdreAnt();
		Vector <String> totrev = new Vector<String>();
    	for (int i = tot.size() - 1; i >= 0; i--) {
    		totrev.add(tot.get(i));
    	}
    	cercaBooleana cb = new cercaBooleana(totrev);
	}
	public static void mostraCercaBooleanaPresencia() {
		Vector <String> tot = controlador.mostraCercaBooleana();
		cercaBooleana cb = new cercaBooleana(tot);
	}
	public static void mostraCercaBooleanaOrdreGranPresencia() {
		Vector <String> tot = controlador.mostraCercaBooleanaOrdreGran();
		String[] arr = tot.toArray(new String[tot.size()]); //vector to array
		int n = tot.size();
		Arrays.sort(arr, Comparator.comparing(s->s.length()));
		Vector<String> vector = new Vector<String>(Arrays.asList(arr));
		
		Vector <String> totrev = new Vector<String>();
    	for (int i = tot.size() - 1; i >= 0; i--) {
    		totrev.add(vector.get(i));
    	}
		
		cercaBooleana cb = new cercaBooleana(totrev);
	}
	public static void mostraCercaBooleanaOrdrePetitPresencia() {
		Vector <String> tot = controlador.mostraCercaBooleanaOrdrePetit();
		String[] arr = tot.toArray(new String[tot.size()]); //vector to array
		int n = tot.size();
		Arrays.sort(arr, Comparator.comparing(s->s.length()));
		Vector<String> vector = new Vector<String>(Arrays.asList(arr));
		cercaBooleana cb = new cercaBooleana(vector);
	}
	public static void mostraResultCercaBooleanaOrdreAlfAutPresencia(String operacio2, Set<String> result2) {
		SortedSet<String> resultord = new TreeSet <String> ();
		resultord.addAll(result2);
		resultatCercaBooleana rcb = new resultatCercaBooleana(operacio2,resultord);
	}
	public static void mostraResultCercaBooleanaOrdreAlfTitPresencia(String operacio2, Set<String> result2) {
		SortedSet<String> resultord = new TreeSet <String> ();
		for(String x : result2) {
			String[] resOfStr = x.split("-",-2);
			String aux = resOfStr[1]+"-"+resOfStr[0];
			resultord.add(aux);
	    }
		
		Set<String> result3 = new LinkedHashSet<String> ();
		for (String y : resultord) {
			String[] resOfStr = y.split("-",-2);
			String aux = resOfStr[1]+"-"+resOfStr[0];
			result3.add(aux);
		}
		
		resultatCercaBooleana rcb = new resultatCercaBooleana(operacio2,result3);
	}
	public static void buscaAutorsPresencia(String autor) {
		String resultat = controlador.buscaAutors(autor);
		resultatCercaAutors r = new resultatCercaAutors(resultat,autor);
	}
	public static void cercaRellevantsPresencia(String par, int number) {
		TreeMap <String, Float> resultat2 = controlador.cercaRellevants(par, number);
		resultatCercaRellevants c = new resultatCercaRellevants(par,number,resultat2);
	}
	public static void mostraResultOrdreAlfPrefA(String result, String autor) {
		String[] lines = result.split("\n");

		Arrays.sort(lines);		
		String result2 = "";
		for(String y: lines) {  
		  result2 += y +"\n";
		  
		}
		
		resultatCercaAutors rca = new resultatCercaAutors(result2,autor);
	}
	public static void mostraResultOrdreAlfPrefD(String result, String autor) {
		String[] lines = result.split("\n");
		
		Arrays.sort(lines, Collections.reverseOrder());   
		String result3 = "";
		for (String x : lines) {
			result3 += x + "\n";
		}
		
		resultatCercaAutors rca = new resultatCercaAutors(result3,autor);
	}
	public static void evalPresencia(String eval) {
		
		Set<String> result = new HashSet<String>();
		
		result = controlador.eval(eval);
		
		resultatCercaBooleana rcb = new resultatCercaBooleana(eval,result);
	}
	
	public static void carregaDocumentsPresencia(File f) throws Exception {
		controlador.carregaDocuments(f);
	}
	
	public static void cercaSemblantsPresencia(String tit, String aut, int number) {
		controlador.cercaSemblants(tit,aut,number);
	}
	public static void viewContingutDocumentPresencia(String titol, String autor) {
		controlador.viewContingutDocument(titol, autor);
	}
	public static void buscaTitolsAutorPresencia(String autor) {
		controlador.buscaTitolsAutor(autor);
	}
	
	public static void carregaSessioDocuements() {
		controlador.controlador();
	}
	public static void guardaSessio() {
		controlador.serialize();	
	}
	public static void carregaSessioUsuaris() {
		controladorUsuaris.deSerializeUsers();
	}
	
	public static void guardaUsuaris() {
		controladorUsuaris.serializeUsers();
	}
	public static void CreaNouDocumentPresencia(String titol, String autor, String contingut) {
		controlador.CreaNouDocument(titol,autor,contingut);
	}
	public static boolean CreaNouDocumentXMLPresencia(String contingut) {
		return controlador.CreaNouDocumentXML(contingut);
	}
	public static boolean setEliminaDocumentPresencia(String t, String a) {
		return controlador.setEliminaDocument(t,a);
	}
	
	public static void exportaDocumentPresencia(File f, String titol, String autor, String filename) throws IOException, fileNotFoundException {
		controlador.exportaDocument(f,titol,autor,filename);
		mostraOKexportat okex = new mostraOKexportat();
	}
	
	public static boolean controlaLoginPresencia(String name, String pas) {
		return controlador.controlaLoginDomini(name, pas);
	}
	
	
	
	public static void modificaDocumentPresencia(String t, String a, String text) {
		controlador.modificaDocument(t,a,text);
	}
	public static void setModificaTextPresencia(String t, String a) {
		controlador.setModificaText(t,a);
	}
	public static boolean existeixPresencia(String t, String a) {
		return controlador.existeix(t,a);
	}
	
	public static void mostraModificarDocCreadorPresencia() throws fileNotFoundException {
		controlador.mostraModificarDocCreador();
	}
	
	public static boolean newUsuariPresencia(String name, String pas) {
		return controlador.newUsuariDomini(name,pas);
	}
	public static void log() {
		login log = new login();
	}
	
	public static void mostraExportaTots() {
		exportaTots et = new exportaTots();
	}
	
	public static void exportaTotsDocumentsPresencia(File f) {
		try {
			controlador.exportaTotsDocs(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void totsOKexportats() {
		totsOKexportats toe = new totsOKexportats();
	}
	public static void mostraNomesAdmin() {
		mostraNomesAdmin toe = new mostraNomesAdmin();
	}
	
	public static boolean usuariIniciatIsAdmin() {
		return controlador.usuariIniciatAdmin();
	}
	public static void confirmacioEsborrarTot() {
		confirmacioEsborrarTot et = new confirmacioEsborrarTot();
	}
	
	public static void esborrarTot() {
		controlador.esborrarTot();
	}
	
	public static void mostraGestorRestauracions() {
		gestorRestauracions gr = new gestorRestauracions();
	}
	
	public static void mostraFerPuntRes() {
		nouPuntRestauracio npr = new nouPuntRestauracio();
	}
	
	public static void mostraTornarPuntRes() throws fileNotFoundException {
		tornarPuntRestauracio tpr = new tornarPuntRestauracio();
	}

	public static void confirmaTornarPunt() {
		confirmaTornarPunt ctp = new confirmaTornarPunt();
	}
	public static void carregaPuntRestauracioPres(String x) {
		controlador.carregaPuntRestauracio(x);
	}
	public static void mostraEliminarUsuaris() {
		eliminarUsuaris eU = new eliminarUsuaris();
	}
	public static void mostraErrorLoginPres() {
		mostraErrorLogin me = new mostraErrorLogin();
	}
	public static void eliminaUsuari(String u) {
		if(controladorUsuaris.delete_usuari(u)) {
			mostrarOKeliminatUsuari moke = new mostrarOKeliminatUsuari();
		}
		else {
			error e = new error("errorUsari");
		}
	}
	
}
