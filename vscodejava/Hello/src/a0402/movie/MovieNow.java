package a0402.movie;

public class MovieNow {
    private Movie movie;
    private int round;
    private String start;
    private String finish;
    private String screenID;



    MovieNow() {
		movie = null;
		round = 0;
		start = null;
		finish = null;
		screenID = null;
	}


    
    public MovieNow(Movie movie, int round, String start, String finish, String screenID) {
        this.movie = movie;
        this.round = round;
        this.start = start;
        this.finish = finish;
        this.screenID = screenID;
    }


    
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getFinish() {
        return finish;
    }
    public void setFinish(String finish) {
        this.finish = finish;
    }
    public String getScreenID() {
        return screenID;
    }
    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }
}
