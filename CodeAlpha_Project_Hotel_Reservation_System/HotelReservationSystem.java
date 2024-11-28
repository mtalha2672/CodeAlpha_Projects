import java.util.*;

class Room {
    int roomNo;
    String roomType;
    String[] roomSection;
    int price;
    boolean isBooked;

    public Room(int roomNo, String roomType,int price,boolean isBooked, String[] roomSection) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomSection = roomSection;
        this.price = price;
        this.isBooked = isBooked;
    }
    @Override
    public String toString() {
        return roomNo+"";
    }

}

class Hotel{
    ArrayList<Room> rooms;
    HashMap<Integer, Room> roomMap;

    public Hotel(){
         rooms = roomsRegistration();
         roomMap = roomsOrganized(rooms);

    }
    public static ArrayList<Room> roomsRegistration(){
        ArrayList<Room> rooms = new ArrayList<Room>(10);
        rooms.add(new Room(101,"Standard",150,false,new String[]{"Kitchen","Bathroom","Standard Bed"}));
        rooms.add(new Room(102,"Standard",150,false,new String[]{"Kitchen","Bathroom","Standard Bed"}));
        rooms.add(new Room(103,"VIP",300,true,new String[]{"Kitchen","Bathroom","King Bed"}));
        rooms.add(new Room(104,"VIP",300,false,new String[]{"Kitchen","Bathroom","King Bed"}));
        rooms.add(new Room(105,"VIP",300,false,new String[]{"Kitchen","Bathroom","King Bed"}));
        rooms.add(new Room(106,"Suite",500,false,new String[]{"Kitchen","Bathroom","Queen Bed","Living Area"}));
        rooms.add(new Room(107,"Suite",500,true,new String[]{"Kitchen","Bathroom","Queen Bed","Living Area"}));
        rooms.add(new Room(108,"Suite",500,true,new String[]{"Kitchen","Bathroom","Queen Bed","Living Area"}));
        rooms.add(new Room(109,"Standard",200,false,new String[]{"Kitchen","Bathroom","Standard Bed"}));
        rooms.add(new Room(110,"Standard",200,false,new String[]{"Kitchen","Bathroom","Standard Bed"}));
        return rooms;
    }

    public HashMap<Integer,Room> roomsOrganized(ArrayList<Room> rooms){
        HashMap<Integer,Room> roomsOrganized = new HashMap<>();
        for (Room r: rooms){
            roomsOrganized.put(r.roomNo, r);
        }
        return roomsOrganized;
    }

    public void checkStatus(HashMap<Integer,Room> roomsOrganized){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Room Number : ");
        int roomNo = scanner.nextInt();
        Room room = roomsOrganized.get(roomNo);
        if (room.isBooked){
            System.out.println("Room is Available");
        } else {
            System.out.println("Room is not Available");
        }
    }

    public void availableRooms(HashMap<Integer,Room> roomsOrganized){
        for (Room r: roomsOrganized.values()){
            if (r.isBooked){
                System.out.println("Room Available : "+roomsOrganized.get(r.roomNo));
            }
        }
    }
    public void reservation(HashMap <Integer,Room> roomsOrganized){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an available Room No. : ");
        int roomNo = scanner.nextInt();

        if (roomsOrganized.get(roomNo).isBooked == false){
            System.out.println("Sorry, The room is already booked");
        } else {
            roomsOrganized.get(roomNo).isBooked = false;
            System.out.println("Reservation completed Successfully");
        }
    }

    public void roomCategorization(HashMap<Integer,Room> roomsOrganized) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an available Room No. : ");
        int roomNo = scanner.nextInt();
        Room room = roomsOrganized.get(roomNo);
        System.out.println("Room Number : " + room.roomNo);
        System.out.println("Room Category : " + room.roomType);
        System.out.println("Room Price : " + room.price);
        System.out.println("Room Available : " + room.isBooked);
        System.out.println();
        System.out.println("Room Categorization : ");
        int numbering = 1;
        for (String i : room.roomSection) {
            System.out.println(numbering + ", " + i);
            numbering++;
        }
    }

}

public class HotelReservationSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condition = true;

        Hotel hotel = new Hotel();

        while (condition){
            System.out.println("\n");
            System.out.println("\t\t\tHotel Reservation System\n\n");
            System.out.println("Press \"1\" to check available rooms");
            System.out.println("Press \"2\" to check status of a particular room");
            System.out.println("Press \"3\" to make a reservation");
            System.out.println("Press \"4\" to view room categorization");
            System.out.println("Press \"5\" to exit the program");
            System.out.println();
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice){
                case 1:
                    hotel.availableRooms(hotel.roomMap);
                    break;
                case 2:
                    hotel.checkStatus(hotel.roomMap);
                    break;

                case 3:
                    hotel.reservation(hotel.roomMap);
                    break;
                case 4:
                    hotel.roomCategorization(hotel.roomMap);
                    break;
                case 5:
                    condition = false;
                default:
                    System.out.println("Invalid choice");
            }



        }
    }
}
