package kr.co.songjava.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.songjava.mvc.domain.Board;
import kr.co.songjava.mvc.parameter.BoardParameter;

/**
 * 게시판 서비스
 * @author note11
 *
 */
@Repository
public interface BoardRepository {
	List<Board> getList();
	Board get(int boardSeq);
	
	//void save(BoardParameter board);
	void save(Board board);
	void update (BoardParameter board);
	void delete(int boardSeq);
}
