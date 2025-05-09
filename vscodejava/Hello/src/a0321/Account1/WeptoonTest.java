package a0321.Account1;

public class WeptoonTest {
    public static void main(String[] args) {
        Webtoon levelUpUp = new Webtoon("나 혼자만 레벨업업", "판타지", "추공님");
        Webtoon sweeeHome = new Webtoon("스위트집", "스릴러", "칸비님");
        Webtoon itaewonClassic = new Webtoon("이태원클래식", "드라마", "광진님");

        // int[] a = {1,2,3};
        Webtoon[] webtoons = { levelUpUp, sweeeHome, itaewonClassic };
        for (int i = 0; i < webtoons.length; i++) {
            System.out.println(webtoons[i].toStr());
        }
        System.out.printf("웹툰 객체의 총 수 : %d", Webtoon.getCount());

    }
}

class Webtoon {
    private String title; // 제목
    private String genre; // 장르
    private String author; // 저자
    private static int count = 0; // 생성된 웹툰 객체의 수

    public Webtoon(String t, String g, String a) {
        title = t;
        genre = g;
        author = a;
        Webtoon.count++;
    }

    public static int getCount(){
        return Webtoon.count++;
    }
    public String toStr() {
        return String.format("Webtoon{title: %s, genre: %s. author: %s}", title, genre, author);
    }
}