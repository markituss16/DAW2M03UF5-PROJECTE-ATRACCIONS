package portAventura_atraccions;

import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class Principal {

    /**
     * ***************MAIN**********************
     */
    public static void main(String[] args) throws IOException {
        ParcAtraccio nouParc = new ParcAtraccio("Port Aventura World");
        /**
         * *********Instï¿½ncies ENTRADA*********
         */

        //ï¿½s de polimorfisme
        Entrada e1 = new Estandar(1000, "adult", 52.10, false);
        nouParc.afegirEntrada(e1);
        Entrada e2 = new Estandar(1022, "junior/senior", 55.00, true);
        nouParc.afegirEntrada(e2);
        Entrada e3 = new ExpressPremium(1033, "junior/senior", 45.00, false, 2);
        nouParc.afegirEntrada(e3);
        Entrada e4 = new ExpressPremium(1044, "adult", 50.00, true, 2);
        nouParc.afegirEntrada(e4);
        Entrada e5 = new Estandar(1055, "junior/senior", 46.25, false);
        nouParc.afegirEntrada(e5);
        Entrada e6 = new ExpressPremium(1066, "adult", 40.00, false, 2);
        nouParc.afegirEntrada(e6);

        /**
         * *********Instï¿½ncies VISITANT*********
         */
        Visitant p1 = new Visitant("Pau", "Sanchez", "33245624X", 643068219, 1.50, 200, null, 1200, 0, 0);
        nouParc.afegirVisitant(p1);
        Visitant p2 = new Visitant("Manel", "Martin", "48926587O", 694851678, 1.69, 400, null, 2, 0, 0);
        nouParc.afegirVisitant(p2);
        Visitant p3 = new Visitant("Jordi", "Mart�nez", "58712682L", 623489502, 1.80, 500, null, 120, 0, 0);
        nouParc.afegirVisitant(p3);
        Visitant p4 = new Visitant("Hector", "Lopez", "19854692V", 649235791, 1.72, 600, e2, 200, 5, 0);
        nouParc.afegirVisitant(p4);
        Visitant p5 = new Visitant("Pere", "Cases", "35496125K", 658423987, 1.45, 700, null, 150, 0, 0);
        nouParc.afegirVisitant(p5);
        
        /**
         * *********Instï¿½ncies EMPLEAT*********
         */
        Empleat p7 = new Empleat("Laia", "P�rez", "33245624X", 643068219, 3, ESalariEmpleat.SUPERIOR);
        nouParc.afegirEmpleats(p7);
        Empleat p8 = new Empleat("Pau", "Rodriguez", "49368752J", 648279315, 4, ESalariEmpleat.MEDIO);
        nouParc.afegirEmpleats(p8);
        Empleat p9 = new Empleat("Marta", "Angl�s", "15846957G", 689547821, 5, ESalariEmpleat.INFERIOR);
        nouParc.afegirEmpleats(p9);

        /**
         * *********Instï¿½ncies ATRACCIO*********
         */
        Atraccio a1 = new Atraccio(1, ENomAtraccio.DRAGON_KHAN, 10, 1.51);
        nouParc.afegirAtraccio(a1);
        Atraccio a2 = new Atraccio(2, ENomAtraccio.TUTUKI_SPLASH, 15, 1.40);
        nouParc.afegirAtraccio(a2);
        Atraccio a3 = new Atraccio(3, ENomAtraccio.SHAMBHALA, 20, 1.50);
        nouParc.afegirAtraccio(a3);
        Atraccio a4 = new Atraccio(4, ENomAtraccio.HURAKAN_CONDOR, 16, 1.55);
        nouParc.afegirAtraccio(a4);
        Atraccio a5 = new Atraccio(5, ENomAtraccio.STAMPIDA, 24, 1.45);
        nouParc.afegirAtraccio(a5);

        //Execuciï¿½ de les funcions
        parcTest(nouParc);
        infoParcTest(nouParc);
    }
    
    public static void afegirInfoEntrades(LinkedList<Entrada> entrades) {
    	try {
    		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	Document doc = db.newDocument();
        	//Es defineix l'element arrel del document
        	Element eArrel = doc.createElement("entrades");
        	doc.appendChild(eArrel);
        	
        	//Es recorre l'arraylist
        	Iterator<Entrada> i = entrades.iterator();
        	while(i.hasNext()) {
        		Entrada e = i.next();
        		
        		//Es defineix el node que contindra l'element visitant
        		Element eEntrada = doc.createElement("entrada");
        		eArrel.appendChild(eEntrada);
        		
        		Element eId = doc.createElement("idEntrada");
        		eId.appendChild(doc.createTextNode(Integer.toString(e.getIdEntrada())));
        		eEntrada.appendChild(eId);       			       			
            		
            	Element eCategoria = doc.createElement("categoria");
            	eCategoria.appendChild(doc.createTextNode(e.getCategoriaEntrada()));
            	eEntrada.appendChild(eCategoria);
            		
            	Element ePreu = doc.createElement("preu");
            	ePreu.appendChild(doc.createTextNode(Double.toString(e.getPreu())));
        		eEntrada.appendChild(ePreu);
        		
        		Element eEstat = doc.createElement("estat");
        		eEstat.appendChild(doc.createTextNode(Boolean.toString(e.getEstatCompra())));
        		eEntrada.appendChild(eEstat);      		
        	}    		
        		
        	TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	Transformer transformer = transformerFactory.newTransformer();
        	DOMSource source = new DOMSource(doc);
        	StreamResult result = new StreamResult(new File("infoEntrades.xml"));
        	transformer.transform(source,result);
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }

    public static void afegirInfoVisitants(ArrayList<Visitant> visitants) {
    	try {
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	Document doc = db.newDocument();
        	//Es defineix l'element arrel del document
        	Element eArrel = doc.createElement("visitants");
        	doc.appendChild(eArrel);
        	
        	//Es recorre l'arraylist
        	Iterator<Visitant> i = visitants.iterator();
        	while(i.hasNext()) {
        		Visitant v = i.next();
        		
        		//Es defineix el node que contindra l'element visitant
        		Element eVisitant = doc.createElement("visitant");
        		eArrel.appendChild(eVisitant);
        		
        		Attr attr = doc.createAttribute("numVisitant");
        		attr.setValue(Integer.toString(v.getNumVisitant()));
        		eVisitant.setAttributeNode(attr);
        		
        		Element eEntrada;
        		
        		if(v.getEntrada() == null) {
        			eEntrada = doc.createElement("entrada");
        			eEntrada.appendChild(doc.createTextNode(null));
        		} else {
        			//Es defineix l'element de l'etrada
            		eEntrada = doc.createElement("entrada");
            		Attr attr2 = doc.createAttribute("id");
            		attr2.setValue(Integer.toString(v.getEntrada().getIdEntrada()));
            		eEntrada.setAttributeNode(attr2);
            		
            		Element eCategoria = doc.createElement("categoria");
            		eCategoria.appendChild(doc.createTextNode(v.getEntrada().getCategoriaEntrada()));
            		eEntrada.appendChild(eCategoria);
            		
            		Element ePreu = doc.createElement("preu");
            		ePreu.appendChild(doc.createTextNode(Double.toString(v.getEntrada().getPreu())));
            		eEntrada.appendChild(ePreu);
            		
            		Element eEstat = doc.createElement("estat");
            		eEstat.appendChild(doc.createTextNode(Boolean.toString(v.getEntrada().getEstatCompra())));
            		eEntrada.appendChild(eEstat);
        		}
        		    		
        		eVisitant.appendChild(eEntrada);
        		
        		//Es defineix l'element diners
        		Element eDiners = doc.createElement("diners");
        		eDiners.appendChild(doc.createTextNode(Double.toString(v.getDiners())));
        		eVisitant.appendChild(eDiners);
        		
        		//Es defineix l'element pujades
        		Element ePujades = doc.createElement("pujades");
        		ePujades.appendChild(doc.createTextNode(Integer.toString(v.getPujades())));
        		eVisitant.appendChild(ePujades);
        		
        		//Es defineix l'element primera fila
        		Element ePrimeraFila = doc.createElement("primeraFila");
        		ePrimeraFila.appendChild(doc.createTextNode(Integer.toString(v.getPrimeraFila())));
        		eVisitant.appendChild(ePrimeraFila);
        		
        		//Es defineix l'element altura
        		Element eAltura = doc.createElement("altura");
        		eAltura.appendChild(doc.createTextNode(Double.toString(v.getAltura())));
        		eVisitant.appendChild(eAltura);
        	}
        	TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	Transformer transformer = transformerFactory.newTransformer();
        	DOMSource source = new DOMSource(doc);
        	StreamResult result = new StreamResult(new File("infoVisitants.xml"));
        	transformer.transform(source,result);
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public static void mostrarInfoVisitants(ArrayList<Visitant> visitants) {
    	File file = new File("infoVisitants.xml");
    	NodeList nList = null;
    	try {
    		DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
    		Document doc= dBuilder.parse(file);
    		
    		doc.getDocumentElement().normalize();
    		nList = doc.getElementsByTagName("visitant");
    		
    		System.out.println("Nombre de visitants: " + nList.getLength());
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	for(int i=0; i < nList.getLength(); i++) {
    		Node nNode = nList.item(i);
    		if(nNode.getNodeType() == Node.ELEMENT_NODE) {
    			Element eElement = (Element) nNode;
    			System.out.println("\nIdentificador del visitant: " + eElement.getAttribute("numVisitant"));
    			System.out.println("Diners del visitant " + eElement.getElementsByTagName("diners").item(0).getTextContent());
	    		System.out.println("Vegades que ha pujat el visitant: " + eElement.getElementsByTagName("pujades").item(0).getTextContent());
	    		System.out.println("Cops que el visitant ha pujat a primera fila: " + eElement.getElementsByTagName("primeraFila").item(0).getTextContent());
	    		System.out.println("Altura del visitant: " + eElement.getElementsByTagName("altura").item(0).getTextContent());
	    	}
    	}
    }
    
    /**
     * Test del primer menï¿½. Aquest porta al segon menï¿½ un cop es compra una
     * segona entrada.
     */
    public static void parcTest(ParcAtraccio p) throws IOException {
        System.out.println("Benvingut a " + p.getNom() + "!");
        Scanner input = new Scanner(System.in);
        String resposta = new String();
        int opcio;

        //Opcions del primer menï¿½
        do {
            System.out.println("Entra '1' per a comprar una entrada i poder accedir al parc.");
            System.out.println("Entra '2' si ets un empleat del parc.");
            System.out.println("Entra '0' per a sortir.");
            try {
                opcio = input.nextInt();

                switch (opcio) {
                    case 1:
                        transaccioEntrades(p);
                        infoParcTest(p);
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 2:
                        loginEmpleat(p);
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        parcTest(p);
                        break;

                    case 0:
                        System.out.println("Gr�cies per comprar amb nosaltres.");
                        System.exit(0);

                    default:
                        System.out.println("Si us plau, introdueix un n�mero v�lid.");
                        parcTest(p);

                }

            } catch (InputMismatchException e) {
                System.out.println("Si us plau, introdueix un n�mero.");
                parcTest(p);
                break;
            }

        } while (resposta.equalsIgnoreCase("y"));
        System.out.println("Gr�cies per comprar amb nosaltres.");
    }

    /**
     * *************************TESTER_INFORMACIO
     * @throws IOException *********************************
     */
    public static void infoParcTest(ParcAtraccio p) throws IOException {
        Scanner input = new Scanner(System.in);
        String resposta = new String();
        int opcio;

        //Opcions del segon menï¿½
        do {
            System.out.println("\n	INFORMACI� DEL PARC");
            System.out.println("   ---------------------------");
            System.out.println("Entra '1' si vols informaci� de les atraccions");
            System.out.println("Entra '2' si vols informaci� dels empleats del parc");
            System.out.println("Entra '3' si vols pujar a una atracci�");
            System.out.println("Entra '4' si vols consultar el nombre de visitants");
            System.out.println("Entra '5' si vols afegir una atracci� a preferits");
            System.out.println("Entra '6' si vols mostrar la teva llista de preferits");
            System.out.println("Entra '0' si desitjes sortir del parc");
            try {
                opcio = input.nextInt();
                switch (opcio) {
                    //Execuciï¿½ de totes en cada cas seleccionat

                    case 1:
                        //Info seguretat atraccions
                        infoAtraccions(p.getAtraccions());
                        System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 2:
                        //Info referent a les dades dels treballadors
                        infoTreballadors(p.getEmpleats());
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    /*case 3:
                        //Es llisten les atraccions i s'indica el nombre de visitants que te.
                        //ordenaAtraccions(p.getAtraccions());
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;*/

                    case 3:
                        //Acciï¿½ de pujar a l'atracciï¿½ on s'indica si es permet o no pujar en aquesta
                        pujarAtraccio(p);
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 4:
                        //Consulta el nombre de visitants que hi ha al parc en aquest moment
                        consultarNumVisit(p);
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;
                    
                    case 5:
                        //Afegeix atracciÃ³ a llista preferits
                        afegirPreferits(p);
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 6:
                        //Llista les atraccions preferides dels visitants
                        llistarPreferits(p);
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 0:
                        System.out.println("Gr�cies per acudir al parc.");
                        System.exit(0);

                    default:
                        System.out.println("Si us plau, introdueix un n�mero v�lid.");
                        infoParcTest(p);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Si us plau, introdueix un n�mero.");
                infoParcTest(p);
            }
        } while (resposta.equalsIgnoreCase("y"));
        System.out.println("Gr�cies per acudir al parc.");
        System.exit(0);
    }

    /**
     * MÃ¨tode que permet afegir una atracciÃ³ a la llista de preferits d'un visitant.
     */
    public static void afegirPreferits(ParcAtraccio p){
        Scanner input = new Scanner(System.in);
        Visitant v = null;
        System.out.println("Identificat amb el nombre de visitant");
        int numVisit = input.nextInt();
        Atraccio atr = null;;
        System.out.println("Introdueix el nom de l'atracci� que vols afegir a preferits");
        String a = input.nextLine();
        a = input.nextLine();
        for (int i = 0; i < p.getVisitants().size(); i++) {
            if (p.getVisitants().get(i).getNumVisitant() == numVisit) { //Si el numero id del visitant concorda, s'assigna.
                v = p.getVisitants().get(i);
            }
        }
        //En aquest primer for es comprova que l'atracciï¿½ introduï¿½da ï¿½s correcte.
        for (int i = 1; i < p.getAtraccions().size()+1; i++) {
            if (p.getAtraccions().get(i).getNomAtraccio().toString().equals(a)) {
                atr = p.getAtraccions().get(i);
            }
        }

        v.afegeixPreferit(atr);
        System.out.println("Atracci� afegida correctament.");
    }

    /**
     * MÃ¨tode que permet llistar les atraccions preferides de cada visitant.
     */
    public static void llistarPreferits(ParcAtraccio p) {
        Scanner input = new Scanner(System.in);
        Visitant v = null;
        System.out.println("Identificat amb el nombre de visitant");
        int numVisit = input.nextInt();
        for (int i = 0; i < p.getVisitants().size(); i++) {
            if (p.getVisitants().get(i).getNumVisitant() == numVisit) { //Si el numero id del visitant concorda, s'assigna.
                v = p.getVisitants().get(i);
            }
        }
        
        System.out.println("Aquesta �s la llista de les teves atraccions preferides!");
        Iterator<Atraccio> i = v.getPreferits().iterator();
    	while(i.hasNext()) {
    		Atraccio a = i.next();
            System.out.println(a);
        }
    }

    /**
     * Funciï¿½ per a fer l'operaciï¿½ de compra d'entrades. Comenï¿½a mostrant les
     * entrades disponibles al parc, on s'ha d'escollir una d'aquestes. Un cop
     * s'introdueix el nï¿½mero identificador de visitant, es mostra la info del
     * proces de compra
     */
    public static void transaccioEntrades(ParcAtraccio p) {
        Entrada eCopia;
        int eleccio, numVisit;
        boolean existeix = false;
        String resposta;
        Visitant v = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Aqu� pots comprar les entrades!\nSi us plau, entra un ID d'entrada:\n");
        for (int i = 0; i < p.getEntrades().size(); i++) { //Es recorren totes les entrades que hi ha disponibles.
            if (!p.getEntrades().get(i).getEstatCompra()) { //Si aquestes no han sigut comprades previament es mostren
                System.out.println("Id entrada: " + p.getEntrades().get(i).getIdEntrada());
            }
        }
        try {
            eleccio = input.nextInt();
            
            System.out.println("Identificat amb el nombre de visitant");
            numVisit = input.nextInt();
            for (int i = 0; i < p.getVisitants().size(); i++) {
                if (p.getVisitants().get(i).getNumVisitant() == numVisit) { //Si el numero id del visitant concorda, s'assigna.
                    v = p.getVisitants().get(i);
                    System.out.println(v.toString());
                }
            }
           
            
            Entrada e = null;
            for (int i = 0; i < p.getEntrades().size(); i++) {
                if (p.getEntrades().get(i).getIdEntrada() == eleccio) {
                	e = p.getEntrades().get(i);
                }
            }
            
            ComprovarDiners<Visitant,Entrada> cd = new ComprovarDiners<Visitant,Entrada>(v,e);
            cd.dinersComprovats();
            
            //En el for d'abaix es mostra tota la info de la compra un cop aquesta s'ha pogut realitzar
            for (int i = 0; i < p.getEntrades().size(); i++) {
                if (p.getEntrades().get(i).getIdEntrada() == eleccio) {
                    p.comprarEntrada(eleccio);
                    v.pagarEntrada(p.getEntrades().get(i).getPreu());
                    v.setEntrada(p.getEntrades().get(i));
                    System.out.println("Et queden " + v.getDiners() + " �.");
                    System.out.println("Ja tens la teva entrada!");
                    eCopia = p.getEntrades().get(i).clone();   //Es fa ï¿½s del clone per tal de tenir una copia de l'entrada que s'ha comprat.
                    System.out.println("Ens quedem una copia de l'entrada, que gaudeixis!");
                    existeix = true;
                } else {
                    continue;
                }
            }
            if (!existeix) {
                System.out.println("Identificador no v�lid!");
                parcTest(p);
            }

        } catch (Exception e) {
            System.out.println("Identificador ha de ser un nombre.");
        }
    }

    /**
     * Funciï¿½ que comprova el login dels empleats
     */
    public static void loginEmpleat(ParcAtraccio p) throws IOException {
        ArrayList<Empleat> empleats = p.getEmpleats();
        int resposta;
        int opcio;
        boolean acces = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Per a accedir al panell dels empleats, introdueix el teu n�mero d'empleat: ");
        resposta = input.nextInt();
        for (int i = 0; i < p.getEmpleats().size(); i++) {
            if (p.getEmpleats().get(i).getIdEmpleat() == resposta) {
                System.out.println("Acc�s correcte");
                acces = true;
                menuEmpleat(p);
                break;
            }
        }
        if (!acces) {
            System.out.println("Acc�s incorrecte");
        }
    }

    public static void menuEmpleat(ParcAtraccio p) throws IOException{
        Scanner input = new Scanner(System.in);
        String resposta = new String();
        int opcio;
        do{
        System.out.println("\n	Menu Empleat");
        System.out.println("   ---------------------------");
        System.out.println("Entra '1' si vols consultar entrades");
        System.out.println("Entra '2' si vols modificar una entrada");
        System.out.println("Entra '3' si vols eliminar una entrada");
        System.out.println("Entra '4' si vols crear una entrada");
        System.out.println("Entra '5' si vols consultar els visitants");
        System.out.println("Entra '6' si vols fer fora els visitants amb entrada caducada");
        System.out.println("Entra '7' per exportar informe de visitants");
        System.out.println("Entra '8' per exportar informe d'entrades");
        System.out.println("Entra '9' per afegir una atracci� a la ruta de vigil�ncia");
        System.out.println("Entra '10' per consultar les atraccions de la ruta de vigil�ncia.");
        System.out.println("Entra '0' si desitjes sortir del parc");
        try {
            opcio = input.nextInt();
            switch (opcio) {
                //Execuciï¿½ de totes en cada cas seleccionat

                case 1:                   
                    consultarEntrades(p.getEntrades());
                    System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;

                case 2:                  
                    modificarEntrada(p, p.getEntrades());
                    System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;

                case 3: 
                    eliminarEntrada(p, p.getEntrades());
                    System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;

                case 4:                   
                    crearEntrada(p, p.getEntrades());
                    System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;

                case 5:                   
                	mostrarInfoVisitants(p.getVisitants());
                    System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;

                case 6:
                	//Es fa fora aquell visitant que supera la condiciï¿½ de nombre maxim de pujades
                    ferForaVisitant(p, p.getVisitants());
                    System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;
                    
                case 7:
                	afegirInfoVisitants(p.getVisitants());
                	System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;
                    
                case 8:
                	afegirInfoEntrades(p.getEntrades());
                	System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;

                case 9:
                	afegirVigilancia(p);
                	System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;
                
                case 10:
                	llistarVigilancia(p);
                	System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;
                    
                case 0:
                    System.out.println("Gr�cies per acudir al parc.");
                    System.exit(0);

                default:
                    System.out.println("Si us plau, introdueix un n�mero v�lid.");
                    infoParcTest(p);
            }
        }catch (InputMismatchException ex) {
                System.out.println("Si us plau, introdueix un n�mero.");
                infoParcTest(p);
            }
        }while(resposta.equalsIgnoreCase("y"));
        }
    
     /**
     * MÃ¨tode que permet afegir una atracciÃ³ a la llista de preferits d'un visitant.
     */
    public static void afegirVigilancia(ParcAtraccio p){
        Scanner input = new Scanner(System.in);
        Empleat e = null;
        System.out.println("Identificat amb el nombre d'empleat");
        int numEmple = input.nextInt();
        Atraccio atr = null;;
        System.out.println("Introdueix el nom de l'atracci� que vols afegir a la ruta de vigilancia");
        String a = input.nextLine();
        a = input.nextLine();
        for (int i = 0; i < p.getEmpleats().size(); i++) {
            if (p.getEmpleats().get(i).getIdEmpleat() == numEmple) { //Si el numero id del visitant concorda, s'assigna.
                e = p.getEmpleats().get(i);
            }
        }
        //En aquest primer for es comprova que l'atracciï¿½ introduï¿½da ï¿½s correcte.
        for (int i = 1; i < p.getAtraccions().size()+1; i++) {
            if (p.getAtraccions().get(i).getNomAtraccio().toString().equals(a)) {
                atr = p.getAtraccions().get(i);
            }
        }

        e.afegeixVigilancia(atr);
        System.out.println("Atracci� afegida a la ruta de vigil�ncia correctament.");
    }

    /**
     * MÃ¨tode que permet llistar les atraccions preferides de cada visitant.
     */
    public static void llistarVigilancia(ParcAtraccio p) {
        Scanner input = new Scanner(System.in);
        Empleat e = null;
        System.out.println("Identificat amb el nombre d'empleat'");
        int numEmp = input.nextInt();
        for (int i = 0; i < p.getEmpleats().size(); i++) {
            if (p.getEmpleats().get(i).getIdEmpleat() == numEmp) { //Si el numero id del visitant concorda, s'assigna.
                e = p.getEmpleats().get(i);
            }
        }
        
        System.out.println("Aquestes son les atraccions de la ruta de vigil�ncia");
        Iterator<Atraccio> i = e.getVigilancia().iterator();
    	while(i.hasNext()) {
    		Atraccio a = i.next();
            System.out.println(a);
        }
    }

    /**
     * Funciï¿½ on es consulten les entrades.
     * Es llegeixen totes les entrades creades i es mostra la seva info.
     */ 
    public static void consultarEntrades(LinkedList<Entrada> entrades){
        System.out.println("Llista d'Entrades: ");
        for(int i=0; i<entrades.size(); i++){
            System.out.println(entrades.get(i).toString());
        }
    }
    
    /**
     * Funciï¿½ que modifica les dades d'una entrada.
     * En aquest cas el que es fa ï¿½s, un cop s'ha afegit la info que es vol modificar,
     * s'elimina l'entrada anterior i es crea una nova amb la info actualitzada.
     */
    public static void modificarEntrada(ParcAtraccio p, LinkedList<Entrada> entrades){
        Scanner input = new Scanner(System.in);
        int resposta = 0;
        Entrada e = null, eaux=null;
        boolean existeixEnt = false, modificatOk = false;
        System.out.println("Introdueix l'id d'entrada a modificar");
        resposta = input.nextInt();
        for(int i = 0; i<entrades.size();i++){
            if(resposta == entrades.get(i).getIdEntrada()){
                e = entrades.get(i);
                existeixEnt = true;
                eaux = modificarDadesEntrada(e);
                if(eaux!=null){
                entrades.remove(i);
                entrades.add(eaux);
                p.setEntrades(entrades);
                modificatOk = true;
                }
            }
        }
        if(!existeixEnt){
            System.out.println("L'entrada no existeix");
        }
        if(!modificatOk){
            System.out.println("L'entrada no s'ha pogut modificar");
        }
 
    }
    
    /**
     * Aquesta funciï¿½ estï¿½ relacionada amb la de dalt, ja que permet introduï¿½r les dades en funciï¿½ d'un tipus o un altre
     */
    public static Entrada modificarDadesEntrada(Entrada e){
        Scanner input = new Scanner(System.in);
        int id = 0, primeraFila=0;
        String categoria="";
        double preu=0;
        if(e instanceof Estandar){
            System.out.println("Introdueix l'id de l'entrada");
            id = input.nextInt();
            System.out.println("Introdueix la categoria de l'entrada");
            categoria = input.nextLine();
            categoria = input.nextLine();
            System.out.println("Introdueix el preu");
            preu = input.nextDouble();
            e = new Estandar(id, categoria, preu, false);
            return e;
        }
        if(e instanceof ExpressPremium){
            System.out.println("Introdueix l'id de l'entrada");
            id = input.nextInt();
            System.out.println("Introdueix la categoria de l'entrada");
            categoria = input.nextLine();
            System.out.println("Introdueix el preu");
            preu = input.nextDouble();
            System.out.println("Introdueix la quantitat de vegades que es pot pujar primera fila");
            primeraFila = input.nextInt();
            e = new ExpressPremium(id, categoria, preu, false, primeraFila);
            return e;
        }
        return null;
    }
    
    /**
     * Funciï¿½ que elimina qualsevol entrada que s'ha creat previament.
     * 
     */
    public static void eliminarEntrada(ParcAtraccio p,LinkedList<Entrada> entrades){
        Scanner input = new Scanner(System.in);
        int resposta = 0;
        Entrada e = null;
        boolean existeixEnt = false;
        System.out.println("Introdueix l'id d'entrada a eliminar");
        resposta = input.nextInt();
        for(int i = 0; i<entrades.size();i++){
            if(resposta == entrades.get(i).getIdEntrada()){
                entrades.remove(i);
                p.setEntrades(entrades);
                System.out.println("S'ha eliminat correctament");
                existeixEnt = true;
            }
        }
        if(!existeixEnt){
            System.out.println("L'entrada no existeix");
        }
    }
    
    /**
     * Funciï¿½ que s'encarrega de crear una nova entrada
     * Es dona l'opciï¿½ de crear una entrada d'un dels dos tipus que hi ha.
     */
    public static void crearEntrada(ParcAtraccio p, LinkedList<Entrada> entrades){
        Scanner input = new Scanner(System.in);
        int r = 0, id = 0, primeraFila=0;
        String categoria="";
        double preu=0;
        Entrada e = null;
        System.out.println("'0' si vols crear una entrada Estandar");
        System.out.println("'1' si vols crear una entrada ExpressPremium");
        r = input.nextInt();
        if(r==0){
            System.out.println("Introdueix l'id de l'entrada");
            id = input.nextInt();
            System.out.println("Introdueix la categoria de l'entrada");
            categoria = input.nextLine();
            categoria = input.nextLine();
            System.out.println("Introdueix el preu");
            preu = input.nextDouble();
            e = new Estandar(id, categoria, preu, false);
            entrades.add(e);
            p.setEntrades(entrades);
        }
        if(r==1){
            System.out.println("Introdueix l'id de l'entrada");
            id = input.nextInt();
            System.out.println("Introdueix la categoria de l'entrada");
            categoria = input.nextLine();
            categoria = input.nextLine();
            System.out.println("Introdueix el preu");
            preu = input.nextDouble();
            System.out.println("Introdueix la quantitat de vegades que es pot pujar primera fila");
            primeraFila = input.nextInt();
            e = new ExpressPremium(id, categoria, preu, false, primeraFila);
            entrades.add(e);
            p.setEntrades(entrades);
        }
    }
    
    /**
     * Funciï¿½ que fa fora un visitant un cop aquest ha superat el maxim de pujades.
     * Quan el fa fora, resta el visitant.
     */
    public static void ferForaVisitant(ParcAtraccio p, ArrayList<Visitant> visitants){
        Estandar e = null;
        System.out.println("Cerquem els visitants amb entrada caducada");
        int n = visitants.size();
        for(int i = 0; i<n;i++){
            if(visitants.get(i).getEntrada() instanceof Estandar){
                e = (Estandar)visitants.get(i).getEntrada();
                if(e.getLimitAtraccions()==visitants.get(i).getPujades()){
                    System.out.println("S'ha fet fora" + visitants.get(i).toString());
                    visitants.remove(i);
                    n = visitants.size();
                    i-=1;
                }
            }
        }        
        p.setVisitants(visitants);
    }
    
    /**
     * Funciï¿½ que consulta els visitans que es troben al parc, mostrant la seva informaciï¿½
     */   
    public static void consultarVisitant(ArrayList<Visitant> visitants){
        System.out.println("Llista de visitants: ");
        for(int i=0; i<visitants.size(); i++){
            System.out.println(visitants.get(i).toString());
        }
    }
        /**
         * Funciï¿½ que llista les atraccions (sense criteri alfabetic). Recorre
         * les atraccions que hi ha i les mostra amb la quantitat de gent que
         * contenen.
         
    public static void ordenaAtraccions(HashMap<Integer,Atraccio> atraccions) {
        //Fa us del CompareTo que s'ha creat a la classe Atracicons per a fer l'ordenaciï¿½
        //Collections.sort(atraccions);
    	atraccions.forEach((k,v) -> System.out.println("L'atracciï¿½ " + v.getNomAtraccio() + ", tï¿½ " + v.getQuantitatGent() + " visitants."));
        }*/

    /**
     * Es fa el mateix que a l'anterior. En aquest cas es mostra la seguretat de
     * cada atracciï¿½.
     */
    public static void infoAtraccions(HashMap<Integer,Atraccio> atraccions) {
        System.out.println("Seguretat de les atraccions:");
        //for (int i = 0; i < atraccions.size(); i++) {
        	atraccions.forEach((k,v) -> System.out.println("Atracci� " + v.getNomAtraccio() + ", t� " + v.getSeguretatAtraccio() + ".")); //ï¿½S DE LAMBDES
    }

    /**
     * Es recorre l'array l'empleats i es mostra tota la informaciï¿½ d'aquests
     * @throws IO 
     */
    public static void infoTreballadors(ArrayList<Empleat> empleats) throws IOException {
    	String cadena;
    	File fitxer = new File("empleat.txt");
    	if(fitxer.exists()) {
    		FileReader reader = new FileReader(fitxer);
			BufferedReader b = new BufferedReader (reader);
			
			while ((cadena = b.readLine()) != null ) {
				System.out.println (cadena);
			}
			b.close();
    	}
    }

    /**
     * Funciï¿½ per a pujar a una atracciï¿½. Primer es comprova el nï¿½mero de
     * visitant i desprï¿½s es demana l'atracciï¿½ a la que es vol pujar. Si les
     * condicions es compleixen, el visitant podrï¿½ pujar a l'atracciï¿½.
     */
    public static void pujarAtraccio(ParcAtraccio p) {
        ArrayList<Visitant> visitants = p.getVisitants();
        Scanner input = new Scanner(System.in);
        String a, e;
        int resposta;
        boolean potPujar = false,nomIncorrecte = false;
        System.out.println("Identificat amb el nombre de visitant");
        resposta = input.nextInt();
        Visitant v = null;
        for (int i = 0; i < visitants.size(); i++) {
            if (visitants.get(i).getNumVisitant() == resposta) {
            	v = visitants.get(i);
            }
        }
        System.out.println("Introdueix el nom de l'atracci� a la que vols pujar");
        a = input.nextLine();
        a = input.nextLine();
        Atraccio atr = null;
        //En aquest primer for es comprova que l'atracciï¿½ introduï¿½da ï¿½s correcte.
        for (int i = 1; i < p.getAtraccions().size()+1; i++) {
            if (p.getAtraccions().get(i).getNomAtraccio().toString().equals(a)) {
                atr = p.getAtraccions().get(i);
                nomIncorrecte = true;
            }
        }
        if(!nomIncorrecte){
            System.out.println("Nom de l'atracci� incorrecte!");
        }
        
        ComprovarAltura<Visitant,Atraccio> ca = new ComprovarAltura<Visitant,Atraccio>(v,atr);
        ca.alturaComprovada();
        
        //En aquest for hi ha un condicional el qual comprova el nï¿½mero de visitant, que es compleixen els requisits (altura) per a pujar i que es tracta d'un objecte en aquest cas Estandar
        for (int i = 0; i < visitants.size(); i++) {
            if (visitants.get(i).getNumVisitant() == resposta && p.getEmpleats().get(0).comprovaEntrada(visitants.get(i)).equals("OK") && visitants.get(i).getEntrada() instanceof Estandar) {
                Estandar entradaEstandar = (Estandar) visitants.get(i).getEntrada();
                entradaEstandar.controlAtraccionsEstandar(visitants.get(i));
                System.out.println(visitants.get(i).pujarAtraccio(atr, p.getEmpleats().get(0)));
                potPujar = true;
            }
        }
        if(!potPujar){
            System.out.println("No pots pujar a l'atracci� !");
        }
       
        //Aquï¿½ es fa el mateix que a l'anterior perï¿½ amb l'entrada de tipus ExpressPremium
        for (int i = 1; i < visitants.size(); i++) {
            if (visitants.get(i).getNumVisitant() == resposta && p.getEmpleats().get(0).comprovaEntrada(visitants.get(i)).equals("OK") && visitants.get(i).getEntrada() instanceof ExpressPremium) {
                ExpressPremium entradaPremium = (ExpressPremium) visitants.get(i).getEntrada();
                entradaPremium.vegadesPrimeraFila(visitants.get(i));
                System.out.println(visitants.get(i).pujarPrimeraFilaAtraccio(atr, p.getEmpleats().get(0)));
                potPujar = true;
            }
        }
        //En cas de no poder pujar, surt un avï¿½s
        if(!potPujar){
            System.out.println("No pots pujar a l'atracci� !");
        }
    }

    //Aquesta funciï¿½ consulta el nombre de visitants que hi ha al parc en aquell moment.
    static public void consultarNumVisit(ParcAtraccio p) {
        System.out.println("El nombre de visitants del parc �s: " + p.getNumVisitants());
    }
}
