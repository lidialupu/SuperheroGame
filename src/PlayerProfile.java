import java.util.Date;

abstract class PlayerProfile implements Cloneable {
    private final String username;
    private String email;
    private Date creationDate;
    private int noPlayedSessions;
    private int[] minutesPlayedPerSession;

    private static int maxPlayedMinutes;

    public PlayerProfile(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalPlayedTime() {
        int totalPlayedTime = 0;
        for(int minutes: minutesPlayedPerSession) {
            totalPlayedTime += minutes;
        }

        return totalPlayedTime;
    }

    public long getPlayerAgeInDays() {
        Date currentDate = new Date();

        //the result is in miliseconds
        long timePassed = currentDate.getTime() - creationDate.getTime();
        long ageInMinutes = timePassed / (1000 * 60);

        return ageInMinutes;
    }

    public int getMaxPlayedMinutes() {
        return maxPlayedMinutes;
    }

    public void addNewPlaySession() {
        noPlayedSessions++;
    }

    public void updateLastPlayedTime(int time) {
        minutesPlayedPerSession[minutesPlayedPerSession.length - 1] = time;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

