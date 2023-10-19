import java.io.Serial;
import java.io.Serializable;
import java.util.List;

//Klasa Klient (nazwisko, imię, mail, telefon, seans, miejsce/miejsca - kolekcja)
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = -7887612267521882048L;
    String name;
    String surname;
    String email;
    String phoneNumber;
    Seance seance;
    List<String> seats;

    public Client(String name, String surname, String email,
                  String phoneNumber, Seance seance, List<String> seats) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.seance = seance;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", seats=" + seats +
                '}';
    }
}
