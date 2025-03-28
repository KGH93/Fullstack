package a0328.도서;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileClass {
    private File file;
    private String dir;
    private String filename;


    public FileClass() {
        file = new File("d:\\");
    }

    public FileClass(String dir, String filename) {
        this.dir = "d:\\" + dir;
        this.filename = filename + ".txt";
        file = new File(this.dir + "\\" + this.filename);
    }





    private boolean check(File file) {
        if(file.exists()){
            return true;
        }else{
            return false;
        }
    }


    public void create() throws Exception{
        boolean exist = check(file);
        if(exist){
            file.delete();
            file.createNewFile(); 
        }else{
            File dirty = new File(dir);
            if(!dirty.exists()){
                dirty.mkdir();
            }
            file = new File(dir + "\\" + filename);
            file.createNewFile();
        }
    }

    

    public void write(String str) throws Exception{
        FileWriter fw = new FileWriter(file);  //파일에 문자 데이터를 쓰기 위한 클래스
        PrintWriter pw = new PrintWriter(fw);  //문자 출력 스트림을 위한 클래스
        pw.println(str);  // str 문자를 파일에 작성
        fw.close();
        pw.close();
    }

    public void read() throws Exception{
        boolean exist = check(file);
        if(exist){
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;

            while ((str = br.readLine())!= null) {
                System.out.println((str));
            }
            fr.close();
            br.close();;
        }else{
            System.out.println("읽을 파일이 없습니다.");
        }
    }
}


