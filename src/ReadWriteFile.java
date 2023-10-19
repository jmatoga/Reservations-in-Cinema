import java.io.*;

public class ReadWriteFile {
    Client client;
    Seance film1;
    Seance film2;
    Seance film3;
    Seance film4;
    Seance film5;

    public ReadWriteFile() throws IOException, ClassNotFoundException {
        File file = new File(".\\seance.dat");
        boolean flag=true;
        if(!file.exists() || file.length() == 0) {
            flag = false;
            // tworzymy obiekt klasy ObjectOutputStream do zapisywania do pliku
            ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(".\\seance.dat"));

            // tworzymy obiekt klasy Seance, który chcemy zapisać
            System.out.println("Oto lista dostępnych filmów:");
            Seance f1 = new Seance("Avatar", "18-10-2023", "12:30", "18");
            Seance f2 = new Seance("Odlot", "18-10-2023", "17:30", "13");
            Seance f3 = new Seance("Auto", "18-10-2023", "20:30", "7");
            Seance f4 = new Seance("Samoloty", "19-10-2023", "18:30", "16");
            Seance f5 = new Seance("Star Wars", "19-10-2023", "20:30", "16");

            Client c1 = new Client("a","a","a","a",null, null);

            fileOut.writeObject(f1);
            fileOut.writeObject(f2);
            fileOut.writeObject(f3);
            fileOut.writeObject(f4);
            fileOut.writeObject(f5);
            fileOut.close();
        }

        File file1 = new File(".\\client.dat");
        boolean flag1=true;
        if(!file1.exists() || file1.length() == 0) {
            flag1 = false;
            // tworzymy obiekt klasy ObjectOutputStream do zapisywania do pliku
            ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(".\\client.dat"));

            // tworzymy obiekt klasy Seance, który chcemy zapisać
            System.out.println("Oto lista KLIENTOW:");
            Client c1 = new Client("a","a","a","a",null, null);

            fileOut.writeObject(c1);
            fileOut.close();
        }

        // tworzymy obiekt klasy ObjectInputStream do odczytywania z pliku
        ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(".\\seance.dat"));

        // odczytujemy z pliku; (Seance) - to rzutowanie z Object na Seance
        this.film1 = (Seance) fileIn.readObject();
        this.film2 = (Seance) fileIn.readObject();
        this.film3 = (Seance) fileIn.readObject();
        this.film4 = (Seance) fileIn.readObject();
        this.film5 = (Seance) fileIn.readObject();
        fileIn.close();


        ObjectInputStream fileIn1 = new ObjectInputStream(new FileInputStream(".\\client.dat"));
        this.client = (Client) fileIn1.readObject();
        System.out.println(this.client.toString());
        fileIn1.close();

        if(flag) {
            System.out.println(this.film1.toString1());
            System.out.println(this.film2.toString1());
            System.out.println(this.film3.toString1());
            System.out.println(this.film4.toString1());
            System.out.println(this.film5.toString1());
        }

        if(flag1) {
            System.out.println(this.client.toString());
        }
    }

    public void saveSeatToFile() throws IOException {
        ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(".\\seance.dat"));

        fileOut.writeObject(this.film1);
        fileOut.writeObject(this.film2);
        fileOut.writeObject(this.film3);
        fileOut.writeObject(this.film4);
        fileOut.writeObject(this.film5);
    }

    public void saveClientToFile(Client client1) throws IOException {
        ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(".\\client.dat"));
        fileOut.writeObject(client1);
    }
}
