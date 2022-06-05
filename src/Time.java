import javax.swing.Timer;

public class Time {

    private int firstExtraTime;
    private int secondExtraTime;
    private int runningTime;
    private Timer timer;
    private boolean paused = false;

    public Time(int firstTime, int halfTime, int secondTime) {
        this.firstExtraTime = (int) (Math.random() * 10);
        this.secondExtraTime = (int) (Math.random() * 10);
        this.runningTime = 0;
        timer = new Timer(500, ae -> {
            if (!paused) {
                if (runningTime == firstTime) {
                    System.out.println("End of first half! Starting extra time of: " + firstExtraTime);
                    System.out.println();
                }
                if (runningTime == firstTime + firstExtraTime) {

                    System.out.println("Time's up! End of first half!");
                    System.out.println("Staring Half time!");
                    System.out.println();

                }
                if (runningTime == firstTime + firstExtraTime + halfTime) {
                    System.out.println("End of Half time!");
                    System.out.println("Starting second half!");
                    System.out.println();

                }
                if (runningTime == firstTime + firstExtraTime + halfTime + secondTime) {
                    System.out.println("End of second half! Starting extra time of: " + secondExtraTime);
                    System.out.println();

                }
                if (runningTime == firstTime + firstExtraTime + halfTime + secondTime + secondExtraTime) {
                    System.out.println("Time's up!End of second half!");
                    System.out.println("End of Game!");
                    System.exit(0); // Terminate the timer thread
                }
                System.out.println("Current time: " + runningTime);
                runningTime++;
            }
        });
        timer.setDelay(500);
        System.out.println("Starting Game!!!");
        System.out.println();
        timer.start();

    }

    public void pause() {
        this.paused = true;
    }

    public void resume() {
        this.paused = false;
    }

}
