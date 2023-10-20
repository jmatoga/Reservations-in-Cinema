import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner myObj = new Scanner(System.in);
        List<String> bookedSeats = new ArrayList<>();
        String name, surname, email, phoneNumber;
        int numberOfTicket=0;

        ReadWriteFile file = new ReadWriteFile();

        System.out.print("Jaki film wybierasz? Podaj numer 1-5\n>> ");
        int whichSeance = myObj.nextInt();
        Seance whichSeanceChoosed = switch (whichSeance) {
            case 1 -> file.film1;
            case 2 -> file.film2;
            case 3 -> file.film3;
            case 4 -> file.film4;
            case 5 -> file.film5;
            default -> null;
        };

        //Rezerwacja miejsc
        System.out.println("Oto lista dostępnych miejsc:");
        whichSeanceChoosed.showSeats();
        System.out.print("\nPodaj ile biletów chcesz zarezerwować:\n>>  ");
        numberOfTicket = myObj.nextInt();

        boolean ifRightSeats=false;
        for (int i=0; i<numberOfTicket;i++){
            while(!ifRightSeats) {
                System.out.print("Podaj " + (i + 1) + ". miejsce:\n>>  ");
                String temp = myObj.next();
                ifRightSeats = whichSeanceChoosed.bookSeats(temp);
                bookedSeats.add(temp);
            }
            ifRightSeats = false;
        }

        System.out.println("\nAktualny wygląd zarezerwowanych miejsc (true to miejsce zajęte): ");
        whichSeanceChoosed.showSeats();

        System.out.println("\nDane do rezerwacji biletu: ");
        System.out.print("Podaj imie:\n>> ");
        name = myObj.next();
        System.out.print("Podaj nazwisko:\n>> ");
        surname = myObj.next();
        System.out.print("Podaj email:\n>> ");
        email = myObj.next();
        System.out.print("Podaj numer telefonu:\n>> ");
        phoneNumber = myObj.next();

        Client client = new Client(name, surname,email,phoneNumber,whichSeanceChoosed,bookedSeats);
        file.saveClientToFile(client);

        // save all changes (seats) to file
        file.saveSeatToFile();

        System.out.println("Dziękujemy za pomyślną rezerwację! Życzymy udanego seansu.");
    }
}
