package a0327.member1;

import java.util.ArrayList;

public class MemberMager {
    // private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Member> members;

    public MemberMager(){
        members = new ArrayList<>();
    }

    public void addMember(String nname, int nage, String nemail) {
        members.add(new Member(nname,nage,nemail));
    }

    public void displayAllmember() {
        if(members.isEmpty()){  //members 리스트가 비어있으면 
            System.out.println("등록된 회원이 없습니다.");
        }else{
            System.out.println("======등록된 회원목록======");
            for(Member d: members){
                System.out.println(d);  // d.toString();
            }
        }
    }

    public Member findMember(String fname) {
        for(Member f : members){
            if (f.getName().equals(fname)){
                return f;
            }
        }
        return null;
    }

    // public void updateMember(String uname, int uage, String uemail) {
    //     Member u = findMember(uname);
    //     // 첫번째 방법 : 기존 객체의 필드값 변경
    //     if(u != null){
    //         u.setAge(uage);
    //         u.setEmail(uemail);
    //         System.out.println("회원 정보를 수정했습니다.");
    //     }else{
    //         System.out.println("회원을 찾을 수 없습니다.");
    //     }
    // }


    public void updateMember(String uname, int uage, String uemail) {
            // 두번째 방법 : 
            for(int i = 0; i < members.size(); i++){
                if(members.get(i).getName().equals(uname)){
                    members.set(i,new Member(uname, uage, uemail));
                    System.out.println("회원 정보를 수정했습니다.");
                    return;
                }
            }
            System.out.println("회원을 찾을 수 없습니다.");
    }



    public void deleteMember(String dname) {
        Member member = findMember(dname);
        if(member != null){
            members.remove(member);
        }else{
            System.out.println("회원을 찾을 수 없습니다.");
        }
    }


}
