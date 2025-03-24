package a0324.도서;

public class EBook extends Book {

    private double filesize; //파일크기 (mb단위)
    private String format; //파일포멧 (ex pdf, epub)

    public EBook(String title, String author, String iSBN, double filesize, String format) {
        super(title, author, iSBN);
        this.filesize = filesize;
        this.format = format;
    }

    public double getFilesize() {
        return filesize;
    }
    public void setFilesize(double filesize) {
        this.filesize = filesize;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("file Size "+ filesize + "MB");;
        System.out.println("format "+ format);;
    }
    
}
