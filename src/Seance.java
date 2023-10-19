import java.util.HashMap;
import java.util.List;
import java.lang.String;

public class Seance {
    String title;
    String day;
    String hour;
    String ageRequirement;
    HashMap<Character, HashMap<Integer, Boolean>> numberOfSeats;

    public Seance(String title, String day, String hour, String ageRequirement) {
        this.title = title;
        this.day = day;
        this.hour = hour;
        this.ageRequirement = ageRequirement;
        this.numberOfSeats = new HashMap<>();

        for(int i=1;i<=10;i++){
            numberOfSeats.put((char)(i+64), new HashMap<Integer,Boolean>());
            for(int j = 0; j < 10; j++){
                numberOfSeats.get((char)(i+64)).put(j, false);
            }
        }
    }

    public void showSeats(){
        for(int i=1;i<=10;i++){
            System.out.print((char)(i+64) + ": ");
            for(int j = 0; j < 10; j++){

                System.out.print(j+1 + "." + numberOfSeats.get((char)(i+64)).get(j) + " ");
            }
            System.out.println("\n");
        }
    }

    public void bookSeats(List<String> seats) {
        for (String seat : seats) {
            char row = seat.charAt(0);
            int seatNumber = Integer.parseInt(seat.substring(1)) - 1; // -1, aby uwzględnić indeksowanie od 0

            if (numberOfSeats.containsKey(row) && numberOfSeats.get(row).containsKey(seatNumber)) {
                if (!numberOfSeats.get(row).get(seatNumber)) {
                    numberOfSeats.get(row).put(seatNumber, true);
                    System.out.println("Zarezerwowano miejsce: " + seat);
                } else {
                    System.out.println("Miejsce " + seat + " jest już zajęte.");
                }
            } else {
                System.out.println("Miejsce " + seat + " nie istnieje.");
            }
        }
    }

    @Override
    public String toString() {
        return "Seance{" +
                "title='" + title + '\'' +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", ageRequirement='" + ageRequirement + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
