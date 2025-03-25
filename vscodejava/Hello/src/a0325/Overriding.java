package a0325;

public class Overriding {
    public static void main(String[] args) {
        play player = new play();
        play striker = new striker();
        play midfielder = new midfielder(); 


        player.pass();
        striker.pass();
        midfielder.pass();

    }
}



class play {    
    public void pass(){
        System.out.println("선수의 short pass");
    }
}


class striker extends play {
    @Override
    public void pass(){
        System.out.println("공격수의 power shoot");
    }
}

class midfielder extends play {
    @Override
    public void pass(){
        System.out.println("미드필더의 long pass");
    }
}