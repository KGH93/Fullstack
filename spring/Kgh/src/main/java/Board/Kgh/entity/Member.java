package Board.Kgh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    //회원이 작성한 글
    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();
    //Member를 삭제할 때 해당 Member가 작성한 모든 Board도 같이 삭제됌
// user 는 한명이고 여러 보드를 가질 수 있다.
// board는 하나의 user만(writer) 가진다.
// board가 연관관계의 주인과 User는 mappedBy로 관꼐만 나타냄

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
