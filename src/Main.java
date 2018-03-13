import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album =  new Album("Celebration", "Madoona");
        album.addSong("Into the groove", 3.35);
        album.addSong("Celebration", 3.21);
        album.addSong("Frozen", 3.48);
        album.addSong("Like a virgin", 4.26);
        album.addSong("La Isla Bonita", 5.05);
        albums.add(album);

        album = new Album("Nevermind", "Nirvana");
        album.addSong("Teen Spirit", 4.05);
        album.addSong("Come as you are", 5.23);
        album.addSong("In Bloom", 3.25);
        album.addSong("Heart Shaped Box", 6.08);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Into the groove",playList);
        albums.get(0).addToPlayList("La Isla Bonita",playList);
        albums.get(0).addToPlayList("Frozen",playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No song in playList");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printMenu();
        }
        while(!quit) {
            int action = scan.nextInt();
            scan.nextLine();
            System.out.println("Press 0 to quit");
            switch(action) {
                case 0:
                    System.out.println("PlayList completed");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("End reached");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: "+listIterator.previous().toString());
                    } else {
                        System.out.println("Begining of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    printMenu();
                    break;

            }
        }
    }
    public static void printMenu() {
        System.out.println("To do action press button: ");
        System.out.println("0 -> quit\n1 -> next song\n2 -> previous song\n4 -> show avaible actions");
    }

}
