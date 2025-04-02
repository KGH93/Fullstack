package a0402.movie;

import java.time.LocalDate;

public class Movie {
    private String title;
    private int runtime;
    private String posterURL;
    private LocalDate release;


    
    Movie(){
        title = null;
        runtime = 0;
        posterURL = null;
        release = null;
    }
    
    public Movie(String title, int runtime, String posterURL, LocalDate release) {
        this.title = title;
        this.runtime = runtime;
        this.posterURL = posterURL;
        this.release = release;
    }


    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public int getRuntime() {
        return runtime;
    }



    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }



    public String getPosterURL() {
        return posterURL;
    }



    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }



    public LocalDate getRelease() {
        return release;
    }



    public void setRelease(LocalDate release) {
        this.release = release;
    }




}

