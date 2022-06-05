import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

public class Match {

    private Team teamA;
    private Team teamB;
    private Referee referee;
    Time timer;

    public Match() {

    }

    public Match(String nameTeamA, String nameTeamB) {
        teamA = new Team(nameTeamA);
        teamB = new Team(nameTeamB);
        referee = new Referee(0);

    }

    public void start(int firstHalf, int halfTime, int secondHalf) {
        teamA.listTeam();
        teamB.listTeam();
        System.out.println();
        System.out.println("################################################################");
        System.out.println("Referee: " + referee.getIdentifier());
        timer = new Time(firstHalf, halfTime, secondHalf);
        listenKeyboard();

    }

    private void listenKeyboard() {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            while (line.equalsIgnoreCase("quit") == false) {
                if (reader.readLine() != null) {

                    timer.pause();
                    int option = 0;
                    do {

                        System.out.println("Select following action:");
                        System.out.println("1- Make substitution on Team " + teamA.getName());
                        System.out.println("2- Make substitution on Team " + teamB.getName());
                        System.out.println("3- Continue execution");
                        System.out.println();
                        option = in.nextInt();
                        System.out.println(option);
                    } while (option <= 0 || option > 4);

                    if (option == 3) {
                        timer.resume();
                    } else {
                        System.out.println("Insert the id of the player that will be out:");
                        System.out.println();
                        int player1 = in.nextInt();
                        System.out.println("Insert the id of the player from the bench:");
                        System.out.println();
                        int player2 = in.nextInt();

                        if (option == 1) {
                            teamA.replace(player1, player2);
                            timer.resume();
                        }
                        if (option == 2) {
                            teamB.replace(player1, player2);
                            timer.resume();
                        }

                    }
                }

            }

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                new Match("Moldova", "Romania").start(45, 15, 45);

            }
        });
        t1.start();

    }

}