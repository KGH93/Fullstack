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

    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();



    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", boards=" + boards +
                '}';
    }

}
