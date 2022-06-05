import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Player> team;
    private List<Player> replaces;
    private Coach coach;
    private String name;
    private int totalNumberReplacements = 5;
    private int id = (int) (Math.random() * 100);

    public Team(String name) {
        this.name = name;
        this.coach = new Coach(id++);
        this.team = new ArrayList<>();
        this.replaces = new ArrayList<>();
        startTeam();
        startReplaces();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void startReplaces() {
        try {
            for (int i = 1; i <= 5; i++) {
                Player p = new Player(id++);
                replaces.add(p);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void startTeam() {
        for (int i = 1; i <= 11; i++) {
            Player p = new Player(id++);
            p.start();
            team.add(p);
        }
    }

    public Player getPlayerById(int id) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getIdentifier() == id)
                return team.get(i);
        }
        for (int i = 0; i < replaces.size(); i++) {
            if (replaces.get(i).getIdentifier() == id)
                return replaces.get(i);
        }
        return null;
    }

    public void listTeam() {
        System.out.println();
        System.out.println("######################  Team Name: " + this.name + " ########################");
        System.out.println();
        System.out.println("Coach: " + this.coach.getIdentifier());
        System.out.println();
        System.out.println("Team Selection:");
        team.forEach(player -> System.out.println("Player " + player.getIdentifier()));
        System.out.println();
        System.out.println("Bench: ");
        replaces.forEach(player -> System.out.println("Bench Player: " + player.getIdentifier()));
    }

    public void replace(int playerOut, int playerIn) {
        if (totalNumberReplacements != 0) {
            Player out = getPlayerById(playerOut);
            Player in = getPlayerById(playerIn);

            if (out == null) {
                System.out.println(
                        "There is no Player with id: " + playerOut + ". Please, select a valid player and try again.");
                return;
            }

            if (in == null) {
                System.out.println(
                        "There is no Player with id: " + playerIn + ". Please, select a valid player and try again.");
                return;
            }

            if (in.isReplaced()) {
                System.out.println("Player with id: " + playerIn
                        + " has been replaced already. Please, select a new player and try again.");
                return;
            }

            out.setPlaying(false); // stops player out
            out.setReplaced(true); // mark player as replaced
            in.interrupt(); // wake player
            in.start(); // starts player
            team.remove(out);// remove replaced from team
            team.add(in); // add replacement to team
            replaces.remove(in); // remove replacement from team
            replaces.add(out);// add replaced to bench
            this.totalNumberReplacements--;
            System.out.println("Player " + playerOut + " replaced by " + playerIn);
            listTeam();
        } else {
            System.out.println("Maximum number of replaces already reached.");
        }

    }

}

