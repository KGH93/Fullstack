package  Board.Kgh.service;

import Board.Kgh.dto.BoardDTO;
import Board.Kgh.entity.Board;
import Board.Kgh.entity.Member;
import Board.Kgh.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board create(BoardDTO dto, Member writer) {
        Board board = new Board();
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setImagePath(dto.getImagePath());
        board.setWriter(writer);
        return boardRepository.save(board);
    }

    public List<Board> list() {
        return boardRepository.findAllByOrderByIdDesc();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(()-> new NoSuchElementException("해당게시글없음"));
    }

    public void update(Long id, BoardDTO dto) {
        Board board = findById(id);
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());

        MultipartFile image = dto.getImageFile();
        if (image != null && !image.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            String fileName = image.getOriginalFilename();

            File file = new File(uploadDir + fileName);
            int count = 1;
            while (file.exists()) {
                String name = fileName.substring(0, fileName.lastIndexOf('.'));
                String ext = fileName.substring(fileName.lastIndexOf('.'));
                file = new File(uploadDir + name + "_" + count + ext);
                count++;
            }

            fileName = file.getName(); // 최종 파일명 갱신
            try {
                file.getParentFile().mkdirs();
                image.transferTo(file);
                board.setImagePath(fileName);
            } catch (IOException e) {
                throw new RuntimeException("이미지 저장 실패", e);
            }
        }
        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public List<Board> findByWriter(Member writer) {
        return boardRepository.findByWriter(writer);
    }
}
