package Board.Kgh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;


    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer=" + writer +
                '}';
    }
}
