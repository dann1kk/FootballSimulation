public class Person extends Thread {

    private int id;
    private boolean isPlaying = false;
    private boolean isReplaced = false;

    public Person(int id) {
        this.id = id;
    }

    public boolean isReplaced() {
        return isReplaced;
    }

    public void setReplaced(boolean isReplaced) {
        this.isReplaced = isReplaced;
    }

    public int getIdentifier() {
        return id;
    }

    public void setIdentifier(int id) {
        this.id = id;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    @Override
    public void run() {
        this.isPlaying = true;
        while (isPlaying) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}

