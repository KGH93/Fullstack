package com.example.board01.service;

import com.example.board01.dto.BoardDTO;
import com.example.board01.entity.Board;
import com.example.board01.repository.BoardRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BoardService {

    @Autowired
    private BoardRepository boardRepository;



//생성자 방식
//    public void save(BoardDTO dto) {
//        Board board = new Board(dto.getId(), dto.getTitle(), dto.getContent(), dto.getWriter(), LocalDateTime.now());
//        boardRepository.save(board);
//    }







//Setter 방식 (비추천)
//      public void save(BoardDTO dto) {
//         Board board = new Board();
//         board.setId(dto.getId());
//         board.setTitle(dto.getTitle());
//         board.setContent(dto.getContent());
//         board.setWriter(dto.getWriter());
//         board.setCreatedDate(dto.getCreatedDate());
//         boardRepository.save(board);
//      }



//builder 방식
    public void save(BoardDTO dto){
        boardRepository.save(dto.toEntity());
    }





//생성자 방식
//    public List<BoardDTO> findAll() {
//        List<Board> boardList = boardRepository.findAll();
//        List<BoardDTO> boardDTOList = new ArrayList<>();
//        for(Board board : boardList){
//            BoardDTO dto = new BoardDTO(
//                    board.getId(),
//                    board.getTitle(),
//                    board.getContent(),
//                    board.getWriter(),
//                    board.getCreatedDate()
//            );
//            boardDTOList.add(dto);
//        }
//        return boardDTOList;

//          return boardRepository.findAll().stream()
//                .map(board -> new BoardDTO(board.getId(), board.getTitle(), board.getContent(), board.getWriter(), board.getCreatedDate()))
//                .collect(Collectors.toList());





    //Setter 방식
//        public List<BoardDTO> findAll() {
//            return boardRepository.findAll().stream()
//                    .map(board -> {
//                      BoardDTO dto = new BoardDTO();
//                      dto.setId(board.getId());
//                      dto.setTitle(board.getTitle());
//                      dto.setContent(board.getContent());
//                      dto.setWriter(board.getWriter());
//                      dto.setCreatedDate(board.getCreatedDate());
//                      return dto;
//                    }).collect(Collectors.toList());
//    }


//builder 방식
    public List<BoardDTO> findAll(){
        return boardRepository.findAll().stream()
                .map(board -> BoardDTO.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .writer(board.getWriter())
                        .createdDate(board.getCreatedDate())
                        .build())
                .collect(Collectors.toList());
    }



//생성자방식
//    public BoardDTO findById(Long id) {
//        Board board = boardRepository.findById(id).orElseThrow();
//        return new BoardDTO(board.getId(), board.getTitle(), board.getContent(), board.getWriter(), board.getCreatedDate());
//    }

//Setter방식
//        public BoardDTO findById(Long id) {
//          Board board = boardRepository.findById(id).orElseThrow();
//          BoardDTO dto = new BoardDTO();
//          dto.setId(board.getId());
//          dto.setTitle(board.getTitle());
//          dto.setContent(board.getContent());
//          dto.setWriter(board.getWriter());
//          dto.setCreatedDate(board.getCreatedDate());
//          return dto;
//        }

//builder방식
        public BoardDTO findById(Long id) {
          Board board = boardRepository.findById(id).orElseThrow();
          return  BoardDTO.builder()
                  .id(board.getId())
                  .title(board.getTitle())
                  .content(board.getContent())
                  .writer(board.getWriter())
                  .createdDate(board.getCreatedDate())
                  .build();
        }


//생성자 방식
//    public void edit(Long id, BoardDTO dto) {
//        Board board = boardRepository.findById(id).orElseThrow(()-> new RuntimeException("해당 게시글 없음"));
//        board.setTitle(dto.getTitle());
//        board.setContent(dto.getContent());
//        board.setWriter(dto.getWriter());
//        boardRepository.save(board);
//    }

//    board.update(dto.getTitle(), dto.getContent());
//    boardRepository.save(board);




//builder 방식
    public void edit(Long id, BoardDTO dto) {
        Board board = Board.builder()
                .id(id)
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .createdDate(LocalDateTime.now())
                .build();
        boardRepository.save(board);
    }


    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
