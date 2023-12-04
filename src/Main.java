// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
package projekt2;
import java.util.InputMismatchException;
import java.util.Scanner;


        /*
         * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
         * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
         */

/**

 */
        public class Main {
            static class booking {

                //använder private class för att göra fälten endast tillgänglig inom samma class
                private String förnamn;
                private String efternamn;
                private String kön;
                private int födelsedatum;
                private boolean fönsterPlats;


                public boolean isFönsterPlats() {
                    return fönsterPlats;
                }

                public void setFönsterPlats(boolean fönsterPlats) {
                    this.fönsterPlats = fönsterPlats;
                }
                public booking() {
                    // TODO Auto-generated constructor stub
                }


                //Använder get-method, som returnerar värde av "förnamn".

                public String getförnamn() {
                    return förnamn;
                }

                //Använder set-method, tillåter andra delar av programmet att ändra värdet av "förnamn".

                public void setgeförnamn(String förnamn ) {
                    this.förnamn = förnamn;

                }

                public String getefternamn() {
                    return efternamn;
                }

                //Använder set-method, tillåter andra delar av programmet att ändra värdet av "förnamn".

                public void setkön(String kön) {
                    this.kön = kön;
                }

                public String getkön() {
                    return kön;
                }

                //Använder set-method, tillåter andra delar av programmet att ändra värdet av "förnamn".

                public void setefternamn(String efternamn ) {
                    this.efternamn = efternamn;
                }


                public int getfödelsedatum() {
                    return födelsedatum;
                }


                //sets the date of birth

                public void Setfödelsedatum(int födelsedatum) {
                    this.födelsedatum = födelsedatum;
                }


                public String toString() {
                    return "the seat is booked for: " + förnamn+", " + födelsedatum+"" ;
                }

            }
            /**
             * @param args the command line arguments
             */
            public static void main(String[] args) {
                Scanner Scanner = new Scanner(System.in);
                //Här är en fält som innehåller 21 sittplatser
                booking[] platser = new booking[21];
                int[] LedigFönsterPlats = {1, 4, 5, 8, 9, 12, 13, 16, 17, 21};

                int alternativ=0;
                //Meny, kopplat till swtich case
                while (alternativ!= 8) {
                    System.out.println(" Booknings Meny: \n");
                    System.out.println("(1). Boka plats");
                    System.out.println("(2). Booka fönsterplats");
                    System.out.println("(3). Hitta bokning ");
                    System.out.println("(4). Avboka bokning");
                    System.out.println("(5). Ange antal lediga platser");
                    System.out.println("(6). Berakna vinst av salda biljetter");
                    //System.out.println("(7). Sortering");//Lyckades inte än
                    System.out.println("(8). Avsluta program\n");
                    System.out.println("Vad kan vi hjalpa dig med?");


                    try{
                        alternativ = Scanner.nextInt();

                        if (alternativ < 1 || alternativ > 8) {
                            System.out.println("OBS! välj nummer endast mellan  1-6 , Vänligen försök igen.\n");
                            continue;
                        }

                    }   catch(InputMismatchException e){
                        System.out.println("[Skriv endast val av nummer]\n");
                        Scanner.nextLine();
                        continue;
                    }



                    //Använder switch case som alternativ istället för massor av if-statments.
                    switch (alternativ){
                        case 1:
                            bokaPlats(platser);
                            break;
                        case 2:
                            fönsterPlats(platser);
                            break;
                        case 3:
                            hittaMittPlats(platser);
                            break;
                        case 4:
                            tabortBokning(platser);
                            break;
                        case 5:
                            LedigaPlatser(platser);
                            break;
                        case 6:
                            vinst(platser);
                            break;
                        case 7:
                            //Sortering(platser);
                            break;
                        case 8:
                            System.out.println("Exits the program");
                        default:
                            System.out.println("Ogiltig val av alternativ, valj mellan 1-4");
                            continue;
                    }
                }
            }





            static void bokaPlats(booking[] platser) {
                try{

                    //skapar en ny instans av bokningsklassen och tilldelar den till variabelbokningen.
                    booking booking = new booking();

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Ange din födelsedatum i form av YYYYMM: ");
                    int födelsedatum = scanner.nextInt();

                    System.out.println("Ange ditt förnamn: ");
                    String förnamn = scanner.next();

                    System.out.println("Ange ditt efternamn: ");
                    String efternamn = scanner.next();

                    System.out.println("Ange ditt kön: ");
                    String kön = scanner.next();

                    //Sparar data av födelsedatum
                    booking.Setfödelsedatum(födelsedatum);
                    //Sparar förnamn
                    booking.setgeförnamn(förnamn);
                    booking.setefternamn(efternamn);
                    booking.setkön(kön);


                    //Här används while loop för att hitta första lediga sittplats för bookning
                    //Loopen fortsätter tills det hittas null (ledig plats)
                    int i = 0;
                    while (i < platser.length && platser[i] != null) {
                        i++;
                    }
                    //Om "i" blir = platser.lenght innebär att att det inte finns null (lediga platser)
                    if (i == platser.length) {
                        System.out.println("Det finns inga lediga platser kvar.");
                    } else {
                        platser[i] = booking;
                        System.out.println(booking.toString());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Endast nummer, försök igen. \n ");

                }
            }




            static void fönsterPlats(booking[] platser) {

                //Här gör jag en fält av endast fönsterplatser
                int[] LedigFönsterPlats = {1, 4, 5, 8, 9, 12, 13, 16, 17, 21};

                try{
                    booking booking = new booking();

                    Scanner scanner = new Scanner(System.in);

                    //Ställer frågor för att spara informationen
                    System.out.println("Ange din födelsedatum i form av YYYYMM: ");
                    int födelsedatum = scanner.nextInt();

                    System.out.println("Ange ditt förnamn: ");
                    String förnamn = scanner.next();

                    System.out.println("Ange ditt efternamn: ");
                    String efternamn = scanner.next();

                    System.out.println("Ange ditt kön: ");
                    String kön = scanner.next();

                    //Sparar data/information
                    booking.Setfödelsedatum(födelsedatum);
                    booking.setgeförnamn(förnamn);
                    booking.setefternamn(efternamn);
                    booking.setkön(kön);

                    boolean booked = false;
                    int i = 0;
                    for(; i < platser.length; i++) {
                        //Kollar om det är fönsterplats
                        //om det är en fönsterplats, kommer den att boka plats i första hand för en fönsterplats
                        if( Modolu_FönsterPlats(i) && platser[i] == null) {
                            platser[i] = booking; // Sparar bookningen
                            booked = true;
                            break; // break the for loop
                        }
                    }
                    if(booked) {
                        System.out.println(booking.toString() + " Fönster plats nummer: " + LedigFönsterPlats[i]);
                    }
                    //Om alla siitplatser är bokade
                    //- kommer upp felmeddelande om att det går ej att boka
                    else {
                        System.out.println("Tyvär finns inga fönsterplats tillgängliga");
                    }
                } catch(InputMismatchException e) {
                    System.out.println("Endast siffra\n");

                }
            }
            static boolean Modolu_FönsterPlats(int seat) {
                // Kontrollera om platsnumret är jämnt och en multipel av 4, men inte lika med 20
                if(seat % 2 == 0 && seat % 4 == 0 && seat != 20) {
                    return true;
                }
                // Kontrollera om platsnumret är av formen 4n+1
                else if(seat % 4 == 1) {
                    return true;
                }
                // Om inga av  villkoren är uppfyllda är det inte en fönsterplats
                return false;
            }






            static void hittaMittPlats(booking[] platser) {
                try{

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Hur vill du hitta din  bokning? ");
                    System.out.println("(1) Med födelsedatum\n(2) Med namn\n");
                    int choice = scanner.nextInt();

                    if (choice < 1 || choice > 2) {
                        System.out.println("OBS! Välj nummer endast mellan [1] och [2]. Vänligen försök igen.\n");
                        return;
                    }

                    String search;
                    if (choice == 1) {
                        System.out.println("Vänligen ange födelsedatum: ");
                        int födelsedatum = scanner.nextInt();
                        //Här kollas värdet av födelseår genom anvnändning av String.valueOf
                        search = String.valueOf(födelsedatum);

                    } else {
                        System.out.println("vänligen ange förnamn: ");
                        String förnamn = scanner.next();
                        search = förnamn;
                    }

                    //Här används boolean för att undersöka om bookning hittats eller inte
                    boolean hittad = false;
                    for (int i = 0; i < platser.length; i++) {
                        booking booking = platser[i];

                        //Här anges det två vilkor som måste upfyllas för att hitta bookning
                        //Här loopas det genom alla element i fältet "platser" och undersöker att nuvarande element inte är null, och att födelsedatum inte är 0
                        //Om villkoret uppfylls så printas det ut information om bookning (hittad=true)
                        if (booking != null && booking.getfödelsedatum() != 0 &&
                                (String.valueOf(booking.getfödelsedatum()).equals(search) || booking.getförnamn().equalsIgnoreCase(search))) {
                            System.out.println("Sitt plats nummer  " + i + " är bokad för " + booking.getförnamn()  + " med födelsedatum " + booking.getfödelsedatum());
                            hittad = true;
                            break;
                        }
                    }

                    if (!hittad) {
                        System.out.println("Person kunde inte hittas");
                    }
                } catch(InputMismatchException e) {
                    System.out.println("Vänligen ange något av alternativen [1] eller [2].\n");

                }

            }




            static void tabortBokning(booking[] platser) {
                Scanner scanner = new Scanner(System.in);

                try {
                    System.out.println("Vänligen välj hur du vill avboka din bokning: \n");
                    System.out.println("(1) Med födelsedatum\n(2) Med namn\n");
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        System.out.println("Skriv in ditt födelsedatum i form av YYYYMM: ");
                        int födelsedatum = scanner.nextInt();

                        //Här loopas det enom alla sittplatser i fältet "platser"
                        //Undersöks om platser är icke null, och om födelsedatumet i någon bookning matchar angivna födelsedatum
                        //Om angivna födelsedatum matchar bookning, så sätts bokningen till null för att avboka "platser[i] = null;"
                        for (int i = 0; i < platser.length ; i++) {
                            if (platser[i] != null && platser[i].getfödelsedatum() == födelsedatum) {
                                platser[i] = null;
                                System.out.println("Bokningen har avbokats.\n");
                                //Return är typ exit
                                return;
                            }
                        }

                        System.out.println("Bokningen kunde inte hittas.\n");

                    } else if (choice == 2) {
                        System.out.println("Skriv in ditt förnamn: ");
                        String förnamn = scanner.next();

                        //här har vi liknande loop och vilkor som första, fast det loopar genom och kolla efter förnamn
                        for (int i = 0; i < platser.length; i++) {
                            if (platser[i] != null && platser[i].getförnamn().equals(förnamn)) {
                                platser[i] = null;
                                System.out.println("Bokningen har avbokats.\n");
                                return;
                            }
                        }

                        System.out.println("Bokningen kunde inte hittas.\n");

                    } else {
                        System.out.println("Ogiltigt val, vänligen försök igen.\n");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Endast nummer, försök igen. \n ");
                }
            }






            //Här är en method som innehåller en for loop.
            //här loopas det genom "platser" fältet för att kolla om indextet "i" är null (lediga paltser)
            //Sedan skrivs det ut antal ledig platser
            static void LedigaPlatser(booking[] platser) {
                int antalLedigaplatser =0;
                for (int i = 0; i < platser.length; i++) {
                    if(platser[i] == null  ) {
                        antalLedigaplatser++;
                    }
                }
                System.out.println("Antal lediga platser: " + antalLedigaplatser);
            }








            static void vinst(booking[] platser) {
                int såldaBiljetter = 0;
                //Vi skapar double variabler för olika personer och bestämmer värdet på det
                double pensionär_Pris = 199.0;
                double vuxen_Pris = 299.0;
                double barn_Pris = 149.0;


                double vinst=0;

                //Dessa variabler används för att ha koll på köp av biljet
                int antal_vuxna=0;
                int antal_pensionärer=0;
                int antal_barn=0;

                //Här skriver vi nuvarande år för att sedan ta detta MINUS året användare är född
                //genom det kan vi beräkna skillnaden och få veta ålder på person, sedan används if -statments
                int currentdate=2023;

                //Här loopar vi genom platser
                //Om index "i" är icke = null betyder det att sittplatser är inte tomma
                //För varje "i" som inte är null ökar såldabiljetter med 1 och räknar varje antal såldabiljett
                for (int i = 0; i < platser.length; i++) {
                    if (platser[i]!=null){
                        såldaBiljetter++;

                        //Som jag nämnde tidigare, currentdate har värde på 2023 (året idag)
                        //Här blir currentdate-födelsdatum, och beroende på hur mycket resultatet blir så väljs ut en av if-statements
                        int ålder = currentdate - platser[i].getfödelsedatum();
                        double biljetkostnad = 0;

                        if (ålder<18){
                            biljetkostnad = barn_Pris;
                            antal_barn++;
                        }
                        else if (ålder >=65){
                            biljetkostnad = pensionär_Pris;
                            antal_pensionärer++;
                        }
                        else{
                            biljetkostnad = vuxen_Pris;
                            antal_vuxna++;
                        }
                        vinst+=biljetkostnad;
                    }
                }

                double total_vinst = vinst * såldaBiljetter;
                System.out.println("Antal sålda biljetter: "+  såldaBiljetter);
                System.out.println("VInst: "+vinst);
                System.out.println("Antal barn: "+antal_barn);
                System.out.println("Antal pensionärer: "+antal_pensionärer);
                System.out.println("Antal vuxna: "+antal_vuxna+"\n");

            }

        }




