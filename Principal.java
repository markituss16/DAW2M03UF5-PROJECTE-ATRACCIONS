package portAventura_atraccions;

import java.io.*;
import java.util.*;


public class Principal {

    /**
     * ***************MAIN
     * @throws IOException **********************
     */
    public static void main(String[] args) throws IOException {
        ParcAtraccio nouParc = new ParcAtraccio("Port Aventura World");
        /**
         * *********Instàncies ENTRADA*********
         */

        //Ús de polimorfisme
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
         * *********Instàncies VISITANT*********
         */
        
        
        Visitant p1 = new Visitant("Pau", "Sanchez", "33245624X", 643068219, 1.50, 200, null, 1200, 0, 0);
        nouParc.afegirVisitant(p1);
        Visitant p2 = new Visitant("Manel", "Martin", "48926587O", 694851678, 1.69, 400, null, 60, 0, 0);
        nouParc.afegirVisitant(p2);
        Visitant p3 = new Visitant("Jordi", "Martínez", "58712682L", 623489502, 1.80, 500, null, 120, 0, 0);
        nouParc.afegirVisitant(p3);
        Visitant p4 = new Visitant("Hector", "Lopez", "19854692V", 649235791, 1.72, 600, e2, 200, 5, 0);
        nouParc.afegirVisitant(p4);
        Visitant p5 = new Visitant("Pere", "Cases", "35496125K", 658423987, 1.45, 700, null, 150, 0, 0);
        nouParc.afegirVisitant(p5);
        Visitant p6 = new Visitant("Sheila", "Ballesteros", "48958756O", 679482478, 1.62, 800, null, 1000, 0, 0);
        nouParc.afegirVisitant(p6);

        /**
         * *********Instàncies EMPLEAT*********
         */
        Empleat p7 = new Empleat("Laia", "Pérez", "33245624X", 643068219, 3, ESalariEmpleat.SUPERIOR);
        nouParc.afegirEmpleats(p7);
        Empleat p8 = new Empleat("Pau", "Rodriguez", "49368752J", 648279315, 4, ESalariEmpleat.MEDIO);
        nouParc.afegirEmpleats(p8);
        Empleat p9 = new Empleat("Marta", "Anglès", "15846957G", 689547821, 5, ESalariEmpleat.INFERIOR);
        nouParc.afegirEmpleats(p9);

        /**
         * *********Instàncies ATRACCIO*********
         */
        Atraccio a1 = new Atraccio(ENomAtraccio.DRAGON_KHAN, 10, 1.51);
        nouParc.afegirAtraccio(a1);
        Atraccio a2 = new Atraccio(ENomAtraccio.TUTUKI_SPLASH, 15, 1.40);
        nouParc.afegirAtraccio(a2);
        Atraccio a3 = new Atraccio(ENomAtraccio.SHAMBHALA, 20, 1.50);
        nouParc.afegirAtraccio(a3);
        Atraccio a4 = new Atraccio(ENomAtraccio.HURAKAN_CONDOR, 16, 1.55);
        nouParc.afegirAtraccio(a4);
        Atraccio a5 = new Atraccio(ENomAtraccio.STAMPIDA, 24, 1.45);
        nouParc.afegirAtraccio(a5);

        //Execució de les funcions
        parcTest(nouParc);
        infoParcTest(nouParc);
    }

    /**
     * Test del primer menú. Aquest porta al segon menú un cop es compra una
     * segona entrada.
     */
    public static void parcTest(ParcAtraccio p) throws IOException{
        System.out.println("Benvingut a " + p.getNom() + "!");
        Scanner input = new Scanner(System.in);
        String resposta = new String();
        int opcio;

        //Opcions del primer menú
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
                        menuEmpleat(p);
                        break;

                    case 0:
                        System.out.println("Gràcies per comprar amb nosaltres.");
                        System.exit(0);

                    default:
                        System.out.println("Si us plau, introdueix un número vàlid.");
                        parcTest(p);

                }

            } catch (InputMismatchException e) {
                System.out.println("Si us plau, introdueix un número.");
                parcTest(p);
                break;
            }

        } while (resposta.equalsIgnoreCase("y"));
        System.out.println("Gràcies per comprar amb nosaltres.");
    }

    /**
     * *************************TESTER_INFORMACIO*********************************
     */
    public static void infoParcTest(ParcAtraccio p) {
        Scanner input = new Scanner(System.in);
        String resposta = new String();
        int opcio;

        //Opcions del segon menú
        do {
            System.out.println("\n	INFORMACIÓ DEL PARC");
            System.out.println("   ---------------------------");
            System.out.println("Entra '1' si vols informació de les atraccions");
            System.out.println("Entra '2' si vols llista d'atraccions del parc");
            System.out.println("Entra '3' si vols pujar a una atracció");
            System.out.println("Entra '4' si vols consultar el nombre de visitants");
            System.out.println("Entra '0' si desitjes sortir del parc");
            try {
                opcio = input.nextInt();
                switch (opcio) {
                    //Execució de totes en cada cas seleccionat

                    case 1:
                        //Info seguretat atraccions
                        infoAtraccions(p.getAtraccions());
                        System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 2:
                        //Es llisten les atraccions i s'indica el nombre de visitants que te.
                        ordenaAtraccions(p.getAtraccions());
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 3:
                        //Acció de pujar a l'atracció on s'indica si es permet o no pujar en aquesta
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

                    case 0:
                        System.out.println("Gràcies per acudir al parc.");
                        System.exit(0);

                    default:
                        System.out.println("Si us plau, introdueix un número vàlid.");
                        infoParcTest(p);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Si us plau, introdueix un número.");
                infoParcTest(p);
            }
        } while (resposta.equalsIgnoreCase("y"));
        System.out.println("Gràcies per acudir al parc.");
        System.exit(0);
    }

    /**
     * Funció per a fer l'operació de compra d'entrades. Comença mostrant les
     * entrades disponibles al parc, on s'ha d'escollir una d'aquestes. Un cop
     * s'introdueix el número identificador de visitant, es mostra la info del
     * proces de compra
     */
    public static void transaccioEntrades(ParcAtraccio p) {
        Entrada eCopia;
        int eleccio, numVisit;
        boolean existeix = false;
        String resposta;
        Visitant v = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Aquí pots comprar les entrades!\nSi us plau, entra un ID d'entrada:\n");
        for (int i = 0; i < p.getEntrades().size(); i++) { //Es recorren totes les entrades que hi ha disponibles.
            if (!p.getEntrades().get(i).getEstatCompra()) { //Si aquestes no han sigut comprades previament es mostren
                System.out.println("Id entrada: " + p.getEntrades().get(i).getIdEntrada() + " - " + p.getEntrades().get(i).getCategoriaEntrada());
            }
        }
        try {
            eleccio = input.nextInt();
            System.out.println("Identificat amb el nombre de visitant");
            numVisit = input.nextInt();
            
            Iterator<Visitant> vis = p.getVisitants().iterator();
            if(vis.hasNext()) {
            	Visitant i = vis.next();
            	if (i.getNumVisitant() == numVisit) { //Si el numero id del visitant concorda, s'assigna.
                    v = i;
                }
            }
            
            //En el for d'abaix es mostra tota la info de la compra un cop aquesta s'ha pogut realitzar
            for (int i = 0; i < p.getEntrades().size(); i++) {
                if (p.getEntrades().get(i).getIdEntrada() == eleccio) {
                    p.comprarEntrada(eleccio);
                    v.pagarEntrada(p.getEntrades().get(i).getPreu());
                    v.setEntrada(p.getEntrades().get(i));
                    System.out.println("Et queden " + v.getDiners() + " €.");
                    System.out.println("Ja tens la teva entrada!");
                    eCopia = p.getEntrades().get(i).clone();   //Es fa ús del clone per tal de tenir una copia de l'entrada que s'ha comprat.
                    System.out.println("Ens quedem una copia de l'entrada, que gaudeixis!");
                    existeix = true;
                } else {
                    continue;
                }
            }
            if (!existeix) {
                System.out.println("Identificador no vàlid!");
                parcTest(p);
            }

        } catch (Exception e) {
            System.out.println("Identificador ha de ser un nombre.");
        }
    }

    /**
     * Funció que comprova el login dels empleats
     */
    public static void loginEmpleat(ParcAtraccio p) throws IOException{
        ArrayList<Empleat> empleats = p.getEmpleats();
        int resposta;
        int opcio;
        boolean acces = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Per a accedir al panell dels empleats, introdueix el teu número d'empleat: ");
        resposta = input.nextInt();
        for (int i = 0; i < p.getEmpleats().size(); i++) {
            if (p.getEmpleats().get(i).getIdEmpleat() == resposta) {
                System.out.println("Accés correcte");
                acces = true;
                menuEmpleat(p);
                break;
            }
        }
        if (!acces) {
            System.out.println("Accés incorrecte");
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
        System.out.println("Entra '7' si vols informació dels empleats del parc");
        System.out.println("Entra '0' si desitjes sortir del parc");
        try {
            opcio = input.nextInt();
            switch (opcio) {
                //Execució de totes en cada cas seleccionat

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
                    consultarVisitant(p.getVisitants());
                    System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;

                case 6:
                	//Es fa fora aquell visitant que supera la condició de nombre maxim de pujades
                    ferForaVisitant(p, p.getVisitants());
                    System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;
                    
                case 7:
                	//Info referent a les dades dels treballadors
                    infoTreballadors(p.getEmpleats());
                    System.out.println("Vols continuar? Entra 'y' o 'n'.");
                    resposta = input.next();
                    break;
                
                case 0:
                    System.out.println("Gràcies per acudir al parc.");
                    System.exit(0);

                default:
                    System.out.println("Si us plau, introdueix un número vàlid.");
                    menuEmpleat(p);
            }
        }catch (InputMismatchException ex) {
                System.out.println("Si us plau, introdueix un número.");
                infoParcTest(p);
            }
        }while(resposta.equalsIgnoreCase("y"));
        }
    
    /**
     * Funció on es consulten les entrades.
     * Es llegeixen totes les entrades creades i es mostra la seva info.
     */ 
    public static void consultarEntrades(LinkedList<Entrada> entrades){
        System.out.println("Llista d'Entrades: ");
        for(int i=0; i<entrades.size(); i++){
            System.out.println(entrades.get(i).toString());
        }
    }
    
    /**
     * Funció que modifica les dades d'una entrada.
     * En aquest cas el que es fa és, un cop s'ha afegit la info que es vol modificar,
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
     * Aquesta funció està relacionada amb la de dalt, ja que permet introduïr les dades en funció d'un tipus o un altre
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
     * Funció que elimina qualsevol entrada que s'ha creat previament.
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
     * Funció que s'encarrega de crear una nova entrada
     * Es dona l'opció de crear una entrada d'un dels dos tipus que hi ha.
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
     * Funció que fa fora un visitant un cop aquest ha superat el maxim de pujades.
     * Quan el fa fora, resta el visitant.
     */
    public static void ferForaVisitant(ParcAtraccio p, ArrayList<Visitant> visitants){
        Estandar e = null;
        System.out.println("Cerquem els visitants amb entrada caducada");
        int n = visitants.size();
        
        Iterator<Visitant> vis = p.getVisitants().iterator();
        Visitant i = vis.next();
        if(vis.hasNext()) {
        	if(i.getEntrada() instanceof Estandar){
                e = (Estandar)i.getEntrada();
                if(e.getLimitAtraccions()==i.getPujades()){
                    System.out.println("S'ha fet fora" + i.toString());
                    visitants.remove(vis);
                    n = visitants.size();
                }else {
                	i = vis.next();
                }
            }
        }
              
        p.setVisitants(visitants);
    }
    
    /**
     * Funció que consulta els visitans que es troben al parc, mostrant la seva informació
     */   
    public static void consultarVisitant(ArrayList<Visitant> visitants){
        System.out.println("Llista de visitants: ");
        Iterator<Visitant> vis = visitants.iterator();
        Visitant i = vis.next();
        if(vis.hasNext()) {
        	System.out.println(i.toString());
        }
        
    }
        /**
         * Funció que llista les atraccions (sense criteri alfabetic). Recorre
         * les atraccions que hi ha i les mostra amb la quantitat de gent que
         * contenen.
         */
    public static void ordenaAtraccions(HashMap<Integer,Atraccio> atraccions) {
        //Fa us del CompareTo que s'ha creat a la classe Atracicons per a fer l'ordenació
        //Collections.sort(atraccions);
        for (int i = 1; i < atraccions.size()+1; i++) {
            System.out.println("L'atracció " + atraccions.get(i).getNomAtraccio() + ", té " + atraccions.get(i).getQuantitatGent() + " visitants.");
        }
    }

    /**
     * Es fa el mateix que a l'anterior. En aquest cas es mostra la seguretat de
     * cada atracció.
     */
    public static void infoAtraccions(HashMap<Integer,Atraccio> atraccions) {
        System.out.println("Seguretat de les atraccions:");
        for (int i = 0; i < atraccions.size(); i++) {
            System.out.println("Atracció " + atraccions.get(i).getNomAtraccio() + ", té " + atraccions.get(i).getSeguretatAtraccio() + ".");
        }
    }

    /**
     * Es recorre l'array l'empleats i es mostra tota la informació d'aquests
     * @throws IOException 
     */
    public static void infoTreballadors(ArrayList<Empleat> empleats) throws IOException {
        /* for (int i = 0; i < empleats.size(); i++) {
            System.out.println(empleats.get(i).toString() + ".");
        } */
    	
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
     * Funció per a pujar a una atracció. Primer es comprova el número de
     * visitant i després es demana l'atracció a la que es vol pujar. Si les
     * condicions es compleixen, el visitant podrà pujar a l'atracció.
     */
    public static void pujarAtraccio(ParcAtraccio p) {
    	ArrayList<Visitant> visitants = p.getVisitants();
        Scanner input = new Scanner(System.in);
        String a, e;
        int resposta;
        boolean potPujar = false,nomIncorrecte = false;
        System.out.println("Identificat amb el ID de visitant");
        resposta = input.nextInt();
        System.out.println("Introdueix el nom de l'atracció a la que vols pujar: ");
        for (int i = 0; i < p.getAtraccions().size(); i++) {
        	System.out.println(p.getAtraccions().get(i).getNomAtraccio().toString());
        }
        a = input.nextLine();
        a = input.nextLine();
        Atraccio atr = null;
        //En aquest primer for es comprova que l'atracció introduïda és correcte.
        for (int i = 0; i < p.getAtraccions().size(); i++) {
            if (p.getAtraccions().get(i).getNomAtraccio().toString().equals(a)) {
                atr = p.getAtraccions().get(i);
                nomIncorrecte = true;
            }
        }
        if(!nomIncorrecte){
            System.out.println("Nom de l'atracció incorrecte!");
        }
        
        //En aquest for hi ha un condicional el qual comprova el número de visitant, que es compleixen els requisits (altura) per a pujar i que es tracta d'un objecte en aquest cas Estandar
        
        Iterator<Visitant> vis = p.getVisitants().iterator();
        Visitant i = vis.next();
        if(vis.hasNext()) {
        	if (i.getNumVisitant() == resposta && p.getEmpleats().get(0).comprovaEntrada(i).equals("OK") && i.getEntrada() instanceof Estandar) {
                Estandar entradaEstandar = (Estandar) i.getEntrada();
                entradaEstandar.controlAtraccionsEstandar(i);
                System.out.println(i.pujarAtraccio(atr, p.getEmpleats().get(0)));
                potPujar = true;
            }
        }
        
        if(!potPujar){
            System.out.println("No pots pujar a l'atracció !");
        }
       
        //Aquí es fa el mateix que a l'anterior però amb l'entrada de tipus ExpressPremium
        
        Iterator<Visitant> vistants = p.getVisitants().iterator();
        Visitant g = vistants.next();
        if(vis.hasNext()) {
        	if (g.getNumVisitant() == resposta && p.getEmpleats().get(0).comprovaEntrada(g).equals("OK") && g.getEntrada() instanceof ExpressPremium) {
                ExpressPremium entradaPremium = (ExpressPremium) g.getEntrada();
                entradaPremium.vegadesPrimeraFila(i);
                System.out.println(g.pujarPrimeraFilaAtraccio(atr, p.getEmpleats().get(0)));
                potPujar = true;
            }
        }
        //En cas de no poder pujar, surt un avís
        if(!potPujar){
            System.out.println("No pots pujar a l'atracció !");
        }
    }

    //Aquesta funció consulta el nombre de visitants que hi ha al parc en aquell moment.
    static public void consultarNumVisit(ParcAtraccio p) {
        System.out.println("El nombre de visitants del parc és: " + p.getNumVisitants());
    }
}
