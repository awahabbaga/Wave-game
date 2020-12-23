import java.util.*;
import java.text.SimpleDateFormat;

public class Test {
    
     //Date et heure
     static Date dateHeureSysteme = new Date();
     static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
 
     //Déclaratio des constantes
     final static String NOM_ENTREPRISE = "Rénovation-Pour-Tous";
     final static String ADRESSE_ENTREPRISE = "1800 boulevard Java, Informatique, QC";
     final static String NUMERO_ENTREPRISE = "(450) 281-0011";
 
     final static float PRIX_CERAMIQUE = 3.90F;
     final static float PRIX_TUILE_VINYLE = 0.50F;
     final static float PRIX_LINOLEUM = 0.75F;
     final static float PRIX_BOIS_FRANC = 2.15F;
     final static float PRIX_FLOTTANT = 1.90F;
     final static double TPS = 0.05;
     final static double TVQ = 0.09975;
     final static String MENU = "***Menu de choix***,\n 1. Facturer l’installation d’un plancher,\n 2. Afficher le nombre de planchers intallés et le montant total,\n 3. Quiter le programme";
 
     final static int OPTION_1 = 1;
     final static int OPTION_2 = 2;
     final static int OPTION_3 = 3;
     final static int CERAMIQUE = 1;
     final static int TUILES_VINYLE = 2;
     final static int LINOLEUM = 3;
     final static int BOIS_FRANC = 4;
     final static int PLANCHER_FLOTTANT = 5;
 
     final static String NOM_CERAMIQUE = "Céramique";
     final static String NOM_TUILES_VINYLE = "Tuile Vinyle";
     final static String NOM_LINOLEUM = "Linoleum";
     final static String NOM_BOIS_FRANC = "Bois Franc";
     final static String NOM_FLOTTANT = "Flottant";
     
     final static char GRAND_C = 'C'; 
     final static char PETIT_C = 'c';
     final static char GRAND_S = 'S';
     final static char PETIT_S = 's';
     final static char GRAND_D = 'D';
     final static char PETIT_D = 'd';
     
     final static char GRAND_R = 'R';
     final static char PETIT_R = 'r';
     final static char GRAND_E = 'E';
     final static char PETITT_E = 'e';
     
     static int nombrePlancher1 = 0;
     static int nombrePlancher2 = 0;
     static int nombrePlancher3 = 0;
     static int nombrePlancher4 = 0;
     static int nombrePlancher5 = 0;
 
     static double montantPlancher1 = 0;
     static double montantPlancher2 = 0;
     static double montantPlancher3 = 0;
     static double montantPlancher4 = 0;
     static double montantPlancher5 = 0;
 
     /**
      * Affiche les options
      *
      */
     public static void menu () {
 
         System.out.println ("***Menu de choix***");
         System.out.println ("1. Facturer l’installation d’un plancher");
         System.out.println ("2. Afficher le nombre de planchers intallés et le montant total");
         System.out.println ("3. Quiter le programme");
         System.out.println();
     }    
 
     /**
      * Affiche le message de bienvenue
      *
      */
     public static void afficherMessageBienvenue() {
         System.out.println("----------------------------------------------------------------------------\n"+
             "Bienvenue dans le système de facturation de Rénovation-Pour-Tous\n----------------------------------------------------------------------------");
     }
 
     /**
      * Affiche le resumer du programme
      *
      */
     public static void  afficherResumeProgramme(){
         System.out.println("-----------------------------------------------------------------------------\nCe programme permet de calculer la facture de l'installation d'un plancher\nsur une surface donnée selon le prix par pied carré et le type de plancher.\n-----------------------------------------------------------------------------");
     }
 
     /**
      * Affiche le menu
      *
      */
     public static void afficherMenu() {
         System.out.println(MENU);
     }
 
     /**
      * Saisie et validation des options. 
      *
      */
     public static int saisirValiderOption() {
         int option = 0;
         boolean estValide = true;
 
         do{
             menu();
             System.out.print("\nEntrez une option : ");
             option = Clavier.lireInt();
 
             if(option >= 1 && option <= 3){
                 estValide = true;
             }else{
                 estValide = false;
                 System.out.println("L’option choisie est invalide!");
             }
 
         }while(!estValide);
 
         return option ;
     }        
 
     /**
      * Saisir et valider le nom client le nombre minimum de caractères permis
      * est 2 et le maximum est 25. 
      *
      * @return le nom du client en String
      */
     public static String saisirValiderNomClient() {
         String nomClient = "";
         boolean estValide = true;
 
         do{
 
             System.out.print("\nEntrez le nom du client (entre 2 et 25 caractères inclusivement : " );
             nomClient = Clavier.lireString();
 
             if(nomClient.length() >= 2 && nomClient.length() <= 25){
                 estValide = true;
 
             }else{
                 estValide = false;
                 System.out.println("Le nom est invalide!");                    
             }
 
         }while(!estValide);
 
         return nomClient;
     }
 
     /**
      * Saisir et valider le prenom du client (le nombre minimum de caractères permis
      * est 2 et le maximum est 25.) 
      *
      * @return le prenom du client en String
      */
     public static String saisirValiderPrenomClient() {
         String prenomClient = "";
         boolean estValide = true;
 
         do{
 
             System.out.print("\nEntrez le prenom du client (entre 2 et 25 caractères inclusivement : " );
             prenomClient = Clavier.lireString();
 
             if(prenomClient.length() >= 2 && prenomClient.length() <= 25){
                 estValide = true;
 
             }else{
                 estValide = false;
                 System.out.println("Le prenom est invalide!");                    
             }
 
         }while(!estValide);
 
         return prenomClient;
     }
 
     /**
      * Saisir et valider le numero de telephone du client (en fortmat : NNN˽NNN-NNNN)
      *
      * @return le numero de telephone du client en String.
      */
     public static String saisirValiderNumeroTelephoneClient () {
         boolean estValide = false;
         String numeroTelephone = "";
 
         do{
 
             System.out.print("\nEntrez le numéro de téléphone du client (format : NNN NNN-NNNN): ");
             numeroTelephone = Clavier.lireString();
 
             String regex = "\\d{3}[ ]\\d{3}[-]\\d{4}";
             estValide = numeroTelephone.matches(regex);
 
             if(!estValide){
                 System.out.println("Le neméro de téléphone est invalide!");
             }
 
         }while(!estValide);
 
         return numeroTelephone;
     }
 
     /**
      * Saisir et valider l'adresse du client (le nombre de caractères permis est 
      * entre 10 et 80 caractères inclusivement)
      *
      * @return l'adresse du client en String
      */
     public static String saisirValiderAdresseClient () {
         String adresseClient = "";
 
         System.out.println("\nEntrez l'adresse du client (entre 10 et 80 caractères inclusivement) :");
         adresseClient = Clavier.lireString();
 
         while(adresseClient.length() < 10 || adresseClient.length() > 80){
             System.out.println("L’adresse du client est invalide!");
 
             System.out.println("Entrez l'adresse du client (entre 10 et 80 caractères inclusivement) :");
             adresseClient = Clavier.lireString();
         }
 
         return adresseClient;
     }
 
     /**
      * Saisir et valider le type de plancher (un nombre entier entre 1 et 5 inclusivement).
      *
      * @return le type du plancher en int
      */
     public static int saisirValiderTypePlancher() {
         int typePlancher = 0;
         boolean estValide = false;
 
         do{
 
             System.out.print("\nEntrez le type de plancher (1 pour Ceramique,\n 2 pour les tuiles de vinyle,"+
                 " 3 pour le linoléum,\n 4 pour le bois franc, et 5 pour le plancher flottant) : ");
             typePlancher = Clavier.lireInt();
 
             if(typePlancher >= 1 && typePlancher <= 5){
                 switch(typePlancher){
                     case 1: nombrePlancher1++;
                     break;
                     case 2: nombrePlancher2++;
                     break;
                     case 3: nombrePlancher3++;
                     break;
                     case 4: nombrePlancher4++;
                     break;
                     case 5: nombrePlancher5++;
                     break;
                     default:;
                 }
                 estValide = true;
             }else{
                 estValide = false;
                 System.out.println("\nle type de plancher est invalide!");
             }
 
         }while(!estValide);
 
         return typePlancher;
     }
 
     /**
      * Saisir et valider la surface à couvrir avec un nombre réel strictement
      * supérieur à 0.
      *
      * @return surface à couvrir en double
      */
     public static double saisirValiderSurfaceCouvrir() {
         double surfaceCouvrir = 0;
         boolean estValide = false;
 
         do{
             System.out.print("\nEntrez la surface à couvrir en pied carré (superieur à 0) : ");
             surfaceCouvrir = Clavier.lireDouble();
 
             if (surfaceCouvrir > 0) {
                 estValide = true;
             } else {
                 estValide = false;
                 System.out.println("La surface est invalide!");
             }
         } while(!estValide);
 
         return surfaceCouvrir;
 
     }
 
     /**
      * Saisir et valider le type batiment soit  être R, ou r pour résidentiel, E,
      * ou e pour entreprise.
      *
      * @return type batiment en char
      */
     public static char saisirValiderTypeBatiment () {
         char typeBatiment;
         boolean estValide = false;
 
         do {
 
             System.out.print("\nEntrez le type de bâtiment (R ou r pour Résidentiel, et E ou e pour Entreprise) : ");
             typeBatiment = Clavier.lireCharLn();
 
             if(typeBatiment != 'R' && typeBatiment != 'r' && typeBatiment != 'E' && typeBatiment != 'e'){
                 estValide = false;
                 System.out.println("Le type de batiment est invalide!");
             }else{
                 estValide = true;
             }
 
         }while (!estValide);
 
         return typeBatiment;
     }
 
     /**
      * Saisir et valider le mode paiement
      *
      * @return le mode de paiement en char
      */
     public static char saisirValiderModePaiement () {
         char modePaiement;
         boolean estValide = false;
 
         do {
 
             System.out.print("\nEntrez le mode de paiement (S ou s pour Cash, D ou d pour Débit, et C ou c pour Crédit) :  ");
             modePaiement = Clavier.lireCharLn();
 
             if (modePaiement != 'S' && modePaiement != 's' && modePaiement != 'D' && modePaiement != 'd'&& modePaiement != 'C' && modePaiement != 'c') {
                 estValide = false;
                 System.out.println("Le mode de paiement est invalide!");
             } else {
                 estValide = true;
             }
 
         } while(!estValide);
 
         return modePaiement;
     }
 
     /**
      * Déterminer l'installation du prix plancher par pied carre
      *
      * @param typePlancher le type de plancher
      * @return double prix installation pour le plancher
      */
     public static float determinerPrixInstallationPlancher(int typePlancher){
         float prixInstallation = 0;
         // switch case en fonction de typePlancher
         switch (typePlancher){
             case CERAMIQUE:
             prixInstallation = PRIX_CERAMIQUE;
             break; 
 
             case TUILES_VINYLE: 
             prixInstallation = PRIX_TUILE_VINYLE;
             break;
 
             case LINOLEUM: 
             prixInstallation  = PRIX_LINOLEUM;
             break;
 
             case BOIS_FRANC:
             prixInstallation = PRIX_BOIS_FRANC;
             break;
 
             case PLANCHER_FLOTTANT:
             prixInstallation = PRIX_FLOTTANT;
             break;
 
         }
 
         return prixInstallation;
     }
 
     /**
      * Elle calcule le sous total
      *
      * @param prix du plancher par pied carre
      * @param surface a couvrir en double
      * @return double calule du sous-total
      */
     public static double calculerSousTotal (float prixPlancherPiedCarre, double surfaceCouvrir){
         return prixPlancherPiedCarre * surfaceCouvrir;
     }
 
     /**
      * Elle calcule le montant TPS
      *
      * @param sousTotal, le sous-total de la facture
      * @return double le calcule TPS 
      */
     public static double calculerTPS(double sousTotal){
         return sousTotal * TPS;
     }
 
     /**
      * Elle calule le montant TVQ
      *
      * @param sousTotal le sous total de la facture
      * @return double le calcul de la TVQ
      */
     public static double calculerTVQ(double sousTotal){
         return sousTotal * TVQ;
     }
 
     /**
      * Elle calcule montant total
      *
      * @param sous total en double
      * @param tps en double
      * @param tvq en double
      * @return double calculer le montant total
      */
     public static double calculerMontantTotal (double sousTotal, double montantTps, double montantTvq){
         return sousTotal + montantTps + montantTvq;
     }
 
     /**
      * Incrémenter le numero de facture
      *
      * @param numero de facture en int
      * @return int incrémentation de la facture
      */
     public static int incrementerNumeroFacture(int numeroFacture){
         return ++numeroFacture;
     }
 
     /**
      * Incrementation du planchers de l'installation par type
      *
      * @param nombre du planchers installer par type en int
      * @return double incrementation du nombre installer par type de plancher
      */
     public static int incrementerNbrPlanchersInstallerParType (int nbrPlanchersInstallerParType){
         return ++nbrPlanchersInstallerParType;
     }
 
     /**
      * Montant total de l'installation du plancher
      *
      * @param montant total de la facture en double
      * @param montant total de l'installationtypePlancher en double
      * @return montant total de l'installation du type de plancher en double
      */
     public static double montantTotalInstallationPlancher(double montantTotalFacture,
     double montantTotalInstallationtypePlancher) {
         return montantTotalFacture + montantTotalInstallationtypePlancher;
     }
 
     /**
      * Affichage du nombre de planchers
      *
      * @param nombrePlancher1 céramique en int
      * @param nombrePlancher2 tuile de vinyle en int
      * @param nombrePlancher3 linoléum en int
      * @param nombrePlancher4 bois franc en int
      * @param nombrePlancher5 flottant en int
      * @param montantPlancher1 le montant de la céramique en double
      * @param montantPlancher2 le montant de la tuiles de vinyle en double
      * @param montantPlancher3 le montant de linoléum en double
      * @param montantPlancher4 le montant du bois franc en double
      * @param montantPlancher5 le montant du flottant en double
      */
     public static void affichageNombrePlanchers(int nombrePlancher1,int nombrePlancher2, int nombrePlancher3,int nombrePlancher4, int nombrePlancher5, double montantPlancher1, double montantPlancher2, double montantPlancher3, double montantPlancher4, double montantPlancher5){
 
         System.out.println("---------------------------------------------------------------------------------------");
         System.out.println(NOM_ENTREPRISE);
         System.out.print("Date et Heure: "+simpleDateFormat.format(dateHeureSysteme)+"\n");
         System.out.println(ADRESSE_ENTREPRISE + "\t" + NUMERO_ENTREPRISE);
         System.out.println("---------------------------------------------------------------------------------------");
         System.out.println();
         System.out.println("Le type de plancher  Le nombre de planchers installés  Le montant total des installations\n");
 
         System.out.printf("Céramique\t\t%15d\t\t\t\t%8.2f$\n",nombrePlancher1 , montantPlancher1);
         System.out.printf("Tuiles de Vinyle\t%15d\t\t\t\t%8.2f$\n",nombrePlancher2 , montantPlancher2);
         System.out.printf("Linoléum\t\t%15d\t\t\t\t%8.2f$\n",nombrePlancher3 , montantPlancher3);
         System.out.printf("Bois franc\t\t%15d\t\t\t\t%8.2f$\n",nombrePlancher4, montantPlancher4);
         System.out.printf("Flottant\t\t%15d\t\t\t\t%8.2f$\n",nombrePlancher5 , montantPlancher5);        
         System.out.println("\t----------------------------------------------------------------------------\n");
         System.out.println("\t\t\tMerci pour votre confiance!");
     }
 
     /**
      * Elle affiche la facture de l'installation du plancher
      *
      * @param numeroFacture en int
      * @param nomClient en String
      * @param prenomClient en String
      * @param numeroTelephone en String
      * @param adresseClienten String
      * @param surfaceCouvrir en double
      * @param typePlancher en int
      * @param typeBatiment en char
      * @param modePaiement en char
      */
     public static void affichageFactureInstallationPlancher(int numeroFacture, String nomClient,
     String prenomClient,String numeroTelephone,String adresseClient, double surfaceCouvrir, 
     int typePlancher,char typeBatiment,char modePaiement, float prixInstallation, double sousTotal,
     double montantTps, double montantTvq, double montantTotal) {
        
         System.out.println("---------------------------------------------------------------------------------------");
         System.out.println(NOM_ENTREPRISE);
         System.out.print("Facture No: " + numeroFacture + "\t\t\tDate et Heure: "+simpleDateFormat.format(dateHeureSysteme)+"\n");
         System.out.println(ADRESSE_ENTREPRISE + "\t" + NUMERO_ENTREPRISE);
         System.out.println("---------------------------------------------------------------------------------------");
         System.out.println();
         System.out.printf("Nom et prénom : %s %s\t\t\tTelephone : %s\n", nomClient, prenomClient, numeroTelephone);
         System.out.println("Adresse du client : " + adresseClient);
         System.out.println();
         System.out.println("La surface à couvrir : " + surfaceCouvrir + " pied carré");
         if(typeBatiment == 'E' || typeBatiment == 'e'){
             System.out.println("Le type de bâtiment : Entreprise");
         }else {
             System.out.println("Le type de bâtiment : Résidentiel");
         }
         
         if(typePlancher == CERAMIQUE){
             System.out.println("Le type de plancher : Céramique");
         }else if(typePlancher == TUILES_VINYLE){
             System.out.println("Le type de plancher : Tuilles de vinyle");
         }else if(typePlancher == LINOLEUM){
             System.out.println("Le type de plancher : Linoléum");
         } else if(typePlancher == BOIS_FRANC){
             System.out.println("Le type de plancher : Bois franc");
         } else {
             System.out.println("Le type de plancher : Flottant");
         }
         
         if(modePaiement == 'c' || modePaiement == 'C'){
             System.out.println("Le mode de paiement : Crédit");
         }else if(modePaiement == 'S' || modePaiement == 's'){
             System.out.println("Le mode de paiement : Cash");
         } else {
             System.out.println("Le mode de paiement : Débit");
         }
         
         System.out.println();
         System.out.printf("Prix par pied carré \t\t%8.2f$ \n" , prixInstallation);
         System.out.printf("Sous-total \t\t\t%8.2f$ \n" , sousTotal);
         System.out.printf("Montant TPS \t\t\t%8.2f$ \n" , montantTps);
         System.out.printf("Montant TVQ \t\t\t%8.2f$ \n" , montantTvq);
         System.out.printf("Montant total \t\t\t%8.2f$ \n" , montantTotal);
         System.out.println("\t----------------------------------------------------------------------------\n");
         System.out.println("\t\t\tMerci pour votre confiance!");
     }
 
         
         public static void main (String[]params) {
             //Déclaration des variables locales.
             int option = 0;
             int numeroFacture = 0;
             String nomClient;
             String prenomClient;
             String numeroTelephoneClient;
             String adresseClient;
             double surfaceCouvrir;
             int typePlancher;
             char typeBatiment;
             char modePaiement;
             float prixInstallation;
             double sousTotal;
             double montantTps;
             double montantTvq;
             double montantTotal;
     
             //afficher message bienvenue
             afficherMessageBienvenue();
     
             //afficher le resumer du programme
             afficherResumeProgramme();
     
             //option = saisirValiderOption();
             do{
                 //Saisir et valider l'option de l'utilisateur
                 option = saisirValiderOption();
     
                 if(option == OPTION_1){
                     //incrementation du numero de la facture;
                     numeroFacture = incrementerNumeroFacture(numeroFacture);
                     //saisir et valider le nom du client
                     nomClient = saisirValiderNomClient();
                     //saisir et valider le prénom du client
                     prenomClient =  saisirValiderPrenomClient();
                     //saisir et valider le numero de telephone du client
                     numeroTelephoneClient = saisirValiderNumeroTelephoneClient();
                     //saisir et valider l'adresse  du client
                     adresseClient = saisirValiderAdresseClient();
                     //saisir et valider le type de plancher
                     typePlancher = saisirValiderTypePlancher(); 
                     //saisir et valider la surface à couvrir
                     surfaceCouvrir = saisirValiderSurfaceCouvrir();
                     //Saisie et validation du type de batiment
                     typeBatiment = saisirValiderTypeBatiment();
                     //Saisie et validation du mode de paiement.
                     modePaiement = saisirValiderModePaiement();
                     //determination du prix d'installation
                     prixInstallation = determinerPrixInstallationPlancher(typePlancher);
                     //calculer le sous-total
                     sousTotal = calculerSousTotal(prixInstallation,surfaceCouvrir);
                     //calculer le montant tps
                     montantTps = calculerTPS(sousTotal);
                     //calculer le montant tvq
                     montantTvq = calculerTVQ(sousTotal);
                     //calcul du total de la facture
                     montantTotal = calculerMontantTotal(sousTotal, montantTps, montantTvq);
     
                     //affichage du prix par plancher
     
                     if(typePlancher == CERAMIQUE){
                         montantPlancher1 = montantTotalInstallationPlancher(montantTotal, montantPlancher1);
                     }else if(typePlancher == TUILES_VINYLE){
                         montantPlancher2 = montantTotalInstallationPlancher(montantTotal, montantPlancher2);
                     }else if(typePlancher == LINOLEUM){
                         montantPlancher3 = montantTotalInstallationPlancher(montantTotal, montantPlancher3);
                     } else if(typePlancher == BOIS_FRANC){
                         montantPlancher4 = montantTotalInstallationPlancher(montantTotal, montantPlancher4);
                     } else {
                         montantPlancher5 = montantTotalInstallationPlancher(montantTotal, montantPlancher5);
                     }
     
                     affichageFactureInstallationPlancher(numeroFacture, nomClient, prenomClient, numeroTelephoneClient, adresseClient, surfaceCouvrir, typePlancher,
                         typeBatiment, modePaiement,prixInstallation,sousTotal, montantTps, montantTvq,montantTotal );
     
                 }else if(option == OPTION_2){
                     //affichage
                     affichageNombrePlanchers(nombrePlancher1, nombrePlancher2, nombrePlancher3, nombrePlancher4, nombrePlancher5, montantPlancher1, montantPlancher2, montantPlancher3, montantPlancher4, montantPlancher5);
                     
                 }
     
             }while(option!= OPTION_3);
             //affichge option 3
             System.out.println("Merci à la prochaine!");
     
     }

    }
 
