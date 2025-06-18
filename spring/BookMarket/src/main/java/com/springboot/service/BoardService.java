package com.springboot.service;

import com.springboot.domain.Board;
import com.springboot.domain.BoardFormDto;
import com.springboot.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardFormDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardFormDto> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardFormDto> boardDtoList = new ArrayList<>();
        for(Board board : boardList){
            BoardFormDto boardDto = BoardFormDto.builder()
                    .id(board.getId())
                    .writerid(board.getWriterid())
                    .writer(board.getWriter())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreatedDate())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    // 아이디로 찾기
    public Board getBoardById(Long id){
        Board board = boardRepository.findById(id).get();  //throw처리를 해줘야하는데 안전하다는 가정하에 get으로 바로꺼냄
        //Optional.get() 내부에 실제 객체가 있을때 꺼내는 메서드
        //없으면 NOSuchElementExcepton 예외
        return board;
    }

    //삭제하기
    public void deleteBoardById(Long id){
        boardRepository.deleteById(id);
    }


    public Page<Board> listAll(int pageNum, String sortField, String sortDir){
        int pageSize = 5;

        Pageable pageable = PageRequest.of(pageNum -1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() :  Sort.by(sortField).descending());
        return boardRepository.findAll(pageable);
    }
    //pageNum : 요청하는 페이지 번호(1부터 시작)
    //sortField : 정렬할 컬럼명(예 : title)
    //sortDir : 정렬 방향 : asc, desc(내림차순)
    //PageRequest.of : 페이지요청정보를 만드는 메서드
    //pageNum -1 : data jpa 0부터 페이지 번호 셈해서 pageNum에서 1을 뺌
    //pageSize : 한 페이지에 몇 개의 항목을 가져올지
    //sort.by(sortField) : sortField 기준정렬
    //sortDir.equals("asc") : 체크 후 오름차순인지 내림차순인지 설정
}
