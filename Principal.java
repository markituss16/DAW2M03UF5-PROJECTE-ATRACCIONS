package portAventura_atraccions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    /**
     * ***************MAIN**********************
     */
    public static void main(String[] args) {
        ParcAtraccio nouParc = new ParcAtraccio("Port Aventura World");
        /**
         * *********Inst�ncies ENTRADA*********
         */

        //�s de polimorfisme
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
         * *********Inst�ncies VISITANT*********
         */
        Visitant p1 = new Visitant("Pau", "Sanchez", "33245624X", 643068219, 1.50, 200, null, 1200, 0, 0);
        nouParc.afegirVisitant(p1);
        Visitant p2 = new Visitant("Manel", "Martin", "48926587O", 694851678, 1.69, 400, null, 60, 0, 0);
        nouParc.afegirVisitant(p2);
        Visitant p3 = new Visitant("Jordi", "Mart�nez", "58712682L", 623489502, 1.80, 500, null, 120, 0, 0);
        nouParc.afegirVisitant(p3);
        Visitant p4 = new Visitant("Hector", "Lopez", "19854692V", 649235791, 1.72, 600, e2, 200, 5, 0);
        nouParc.afegirVisitant(p4);
        Visitant p5 = new Visitant("Pere", "Cases", "35496125K", 658423987, 1.45, 700, null, 150, 0, 0);
        nouParc.afegirVisitant(p3);

        /**
         * *********Inst�ncies EMPLEAT*********
         */
        Empleat p7 = new Empleat("Laia", "P�rez", "33245624X", 643068219, 3, ESalariEmpleat.SUPERIOR);
        nouParc.afegirEmpleats(p7);
        Empleat p8 = new Empleat("Pau", "Rodriguez", "49368752J", 648279315, 4, ESalariEmpleat.MEDIO);
        nouParc.afegirEmpleats(p8);
        Empleat p9 = new Empleat("Marta", "Angl�s", "15846957G", 689547821, 5, ESalariEmpleat.INFERIOR);
        nouParc.afegirEmpleats(p9);

        /**
         * *********Inst�ncies ATRACCIO*********
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

        //Execuci� de les funcions
        parcTest(nouParc);
        infoParcTest(nouParc);
    }

    /**
     * Test del primer men�. Aquest porta al segon men� un cop es compra una
     * segona entrada.
     */
    public static void parcTest(ParcAtraccio p) {
        System.out.println("Benvingut a " + p.getNom() + "!");
        Scanner input = new Scanner(System.in);
        String resposta = new String();
        int opcio;

        //Opcions del primer men�
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
     * *************************TESTER_INFORMACIO*********************************
     */
    public static void infoParcTest(ParcAtraccio p) {
        Scanner input = new Scanner(System.in);
        String resposta = new String();
        int opcio;

        //Opcions del segon men�
        do {
            System.out.println("\n	INFORMACI� DEL PARC");
            System.out.println("   ---------------------------");
            System.out.println("Entra '1' si vols informaci� de les atraccions");
            System.out.println("Entra '2' si vols informaci� dels empleats del parc");
            System.out.println("Entra '3' si vols llista ordenada d'atraccions per nombre de visitants");
            System.out.println("Entra '4' si vols pujar a una atracci�");
            System.out.println("Entra '5' si vols consultar el nombre de visitants");
            System.out.println("Entra '0' si desitjes sortir del parc");
            try {
                opcio = input.nextInt();
                switch (opcio) {
                    //Execuci� de totes en cada cas seleccionat

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

                    case 3:
                        //Es llisten les atraccions i s'indica el nombre de visitants que te.
                        ordenaAtraccions(p.getAtraccions());
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 4:
                        //Acci� de pujar a l'atracci� on s'indica si es permet o no pujar en aquesta
                        pujarAtraccio(p);
                        System.out.println("Vols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;

                    case 5:
                        //Consulta el nombre de visitants que hi ha al parc en aquest moment
                        consultarNumVisit(p);
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
     * Funci� per a fer l'operaci� de compra d'entrades. Comen�a mostrant les
     * entrades disponibles al parc, on s'ha d'escollir una d'aquestes. Un cop
     * s'introdueix el n�mero identificador de visitant, es mostra la info del
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
                }
            }
            //En el for d'abaix es mostra tota la info de la compra un cop aquesta s'ha pogut realitzar
            for (int i = 0; i < p.getEntrades().size(); i++) {
                if (p.getEntrades().get(i).getIdEntrada() == eleccio) {
                    p.comprarEntrada(eleccio);
                    v.pagarEntrada(p.getEntrades().get(i).getPreu());
                    v.setEntrada(p.getEntrades().get(i));
                    System.out.println("Et queden " + v.getDiners() + " �.");
                    System.out.println("Ja tens la teva entrada!");
                    eCopia = p.getEntrades().get(i).clone();   //Es fa �s del clone per tal de tenir una copia de l'entrada que s'ha comprat.
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
     * Funci� que comprova el login dels empleats
     */
    public static void loginEmpleat(ParcAtraccio p) {
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

    public static void menuEmpleat(ParcAtraccio p) {
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
        System.out.println("Entra '0' si desitjes sortir del parc");
        try {
            opcio = input.nextInt();
            switch (opcio) {
                //Execuci� de totes en cada cas seleccionat

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
                	//Es fa fora aquell visitant que supera la condici� de nombre maxim de pujades
                    ferForaVisitant(p, p.getVisitants());
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
     * Funci� on es consulten les entrades.
     * Es llegeixen totes les entrades creades i es mostra la seva info.
     */ 
    public static void consultarEntrades(ArrayList<Entrada> entrades){
        System.out.println("Llista d'Entrades: ");
        for(int i=0; i<entrades.size(); i++){
            System.out.println(entrades.get(i).toString());
        }
    }
    
    /**
     * Funci� que modifica les dades d'una entrada.
     * En aquest cas el que es fa �s, un cop s'ha afegit la info que es vol modificar,
     * s'elimina l'entrada anterior i es crea una nova amb la info actualitzada.
     */
    public static void modificarEntrada(ParcAtraccio p, ArrayList<Entrada> entrades){
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
     * Aquesta funci� est� relacionada amb la de dalt, ja que permet introdu�r les dades en funci� d'un tipus o un altre
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
     * Funci� que elimina qualsevol entrada que s'ha creat previament.
     * 
     */
    public static void eliminarEntrada(ParcAtraccio p,ArrayList<Entrada> entrades){
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
     * Funci� que s'encarrega de crear una nova entrada
     * Es dona l'opci� de crear una entrada d'un dels dos tipus que hi ha.
     */
    public static void crearEntrada(ParcAtraccio p, ArrayList<Entrada> entrades){
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
     * Funci� que fa fora un visitant un cop aquest ha superat el maxim de pujades.
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
     * Funci� que consulta els visitans que es troben al parc, mostrant la seva informaci�
     */   
    public static void consultarVisitant(ArrayList<Visitant> visitants){
        System.out.println("Llista de visitants: ");
        for(int i=0; i<visitants.size(); i++){
            System.out.println(visitants.get(i).toString());
        }
    }
        /**
         * Funci� que llista les atraccions (sense criteri alfabetic). Recorre
         * les atraccions que hi ha i les mostra amb la quantitat de gent que
         * contenen.
         */
    public static void ordenaAtraccions(ArrayList<Atraccio> atraccions) {
        //Fa us del CompareTo que s'ha creat a la classe Atracicons per a fer l'ordenaci�
        Collections.sort(atraccions);
        for (int i = 0; i < atraccions.size(); i++) {
            System.out.println("L'atracci� " + atraccions.get(i).getNomAtraccio() + ", t� " + atraccions.get(i).getQuantitatGent() + " visitants.");
        }
    }

    /**
     * Es fa el mateix que a l'anterior. En aquest cas es mostra la seguretat de
     * cada atracci�.
     */
    public static void infoAtraccions(ArrayList<Atraccio> atraccions) {
        System.out.println("Seguretat de les atraccions:");
        for (int i = 0; i < atraccions.size(); i++) {
            System.out.println("Atracci� " + atraccions.get(i).getNomAtraccio() + ", t� " + atraccions.get(i).getSeguretatAtraccio() + ".");
        }
    }

    /**
     * Es recorre l'array l'empleats i es mostra tota la informaci� d'aquests
     */
    public static void infoTreballadors(ArrayList<Empleat> empleats) {
        for (int i = 0; i < empleats.size(); i++) {
            System.out.println(empleats.get(i).toString() + ".");
        }
    }

    /**
     * Funci� per a pujar a una atracci�. Primer es comprova el n�mero de
     * visitant i despr�s es demana l'atracci� a la que es vol pujar. Si les
     * condicions es compleixen, el visitant podr� pujar a l'atracci�.
     */
    public static void pujarAtraccio(ParcAtraccio p) {
        ArrayList<Visitant> visitants = p.getVisitants();
        Scanner input = new Scanner(System.in);
        String a, e;
        int resposta;
        boolean potPujar = false,nomIncorrecte = false;
        System.out.println("Identificat amb el nombre de visitant");
        resposta = input.nextInt();
        System.out.println("Introdueix el nom de l'atracci� a la que vols pujar");
        a = input.nextLine();
        a = input.nextLine();
        Atraccio atr = null;
        //En aquest primer for es comprova que l'atracci� introdu�da �s correcte.
        for (int i = 0; i < p.getAtraccions().size(); i++) {
            if (p.getAtraccions().get(i).getNomAtraccio().toString().equals(a)) {
                atr = p.getAtraccions().get(i);
                nomIncorrecte = true;
            }
        }
        if(!nomIncorrecte){
            System.out.println("Nom de l'atracci� incorrecte!");
        }
        
        //En aquest for hi ha un condicional el qual comprova el n�mero de visitant, que es compleixen els requisits (altura) per a pujar i que es tracta d'un objecte en aquest cas Estandar
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
       
        //Aqu� es fa el mateix que a l'anterior per� amb l'entrada de tipus ExpressPremium
        for (int i = 0; i < visitants.size(); i++) {
            if (visitants.get(i).getNumVisitant() == resposta && p.getEmpleats().get(0).comprovaEntrada(visitants.get(i)).equals("OK") && visitants.get(i).getEntrada() instanceof ExpressPremium) {
                ExpressPremium entradaPremium = (ExpressPremium) visitants.get(i).getEntrada();
                entradaPremium.vegadesPrimeraFila(visitants.get(i));
                System.out.println(visitants.get(i).pujarPrimeraFilaAtraccio(atr, p.getEmpleats().get(0)));
                potPujar = true;
            }
        }
        //En cas de no poder pujar, surt un av�s
        if(!potPujar){
            System.out.println("No pots pujar a l'atracci� !");
        }
    }

    //Aquesta funci� consulta el nombre de visitants que hi ha al parc en aquell moment.
    static public void consultarNumVisit(ParcAtraccio p) {
        System.out.println("El nombre de visitants del parc �s: " + p.getNumVisitants());
    }
}
