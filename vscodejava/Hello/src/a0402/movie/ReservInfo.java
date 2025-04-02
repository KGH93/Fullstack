package a0402.movie;

public class ReservInfo {
    private Person person;
    private int round;
    private String seat;
    private String screenID;





    public ReservInfo(Person person, int round, String seat, String screenID) {
        this.person = person;
        this.round = round;
        this.seat = seat;
        this.screenID = screenID;
    }


    

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }
    public String getScreenID() {
        return screenID;
    }
    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }



}
