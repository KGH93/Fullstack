package BOARD.KGH.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class BoardDTO {
    private String title;
    private String content;
    private MultipartFile imageFile;
    private String imagePath;
}
