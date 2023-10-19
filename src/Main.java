//Napisz program realizujący rezerwację/kupno biletów do kina:
//
//        Klasa Klient (nazwisko, imię, mail, telefon, seans, miejsce/miejsca - kolekcja)
//        Klasa Seans (tytuł, dzień, godzina, ograniczenia wiekowe,
//        liczba miejsc - HashMap<Character, HashMap<Integer, Boolean>>)
//        zapis/odczyt danych z pliku, serializacja.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        List<String> bookedSeats = new ArrayList<>();
        String name, surname, email, phoneNumber;
        int numberOfTicket=0;
        Seance film1 = new Seance("Avatar", "18-10-2023", "12:30", "18");
        Seance film2 = new Seance("Odlot", "18-10-2023", "17:30", "13");
        Seance film3 = new Seance("Auto", "18-10-2023", "20:30", "7");
        Seance film4 = new Seance("Samoloty", "19-10-2023", "18:30", "16");
        Seance film5 = new Seance("Star Wars", "19-10-2023", "20:30", "16");



        //Rezerwacja miejsc
        film1.showSeats();
        System.out.println("Podaj ile biletów chcesz zarezerwować:\n ");
        numberOfTicket = myObj.nextInt();
        for (int i=0; i<numberOfTicket;i++){
            System.out.println("Podaj miejsce:\n ");
            String temp = myObj.next();
            bookedSeats.add(temp);
        }
        film1.bookSeats(bookedSeats);
        film1.showSeats();



        System.out.println("Podaj dane do rezerwacji biletu:\n ");
        System.out.println("Podaj imie: ");
        name = myObj.nextLine();
        System.out.println("Podaj nazwisko: ");
        surname = myObj.nextLine();
        System.out.println("Podaj email: ");
        email = myObj.nextLine();
        System.out.println("Podaj numer telefonu: ");
        phoneNumber = myObj.nextLine();

        Client client = new Client(name, surname,email,phoneNumber,film1,null);

    }
}

