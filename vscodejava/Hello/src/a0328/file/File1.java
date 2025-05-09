package a0328.file;

import java.io.FileOutputStream;
import java.io.IOException;

public class File1 {
    public static void main(String[] args) throws IOException{
        FileOutputStream output = new FileOutputStream("d:/out.txt");  
        output.close();
    }
}
