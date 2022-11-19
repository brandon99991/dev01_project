package kr.co.songjava.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.songjava.mvc.domain.Board;
import kr.co.songjava.mvc.parameter.BoardParameter;
import kr.co.songjava.mvc.repository.BoardRepository;

/**
 * 게시판 서비스
 * @author note11
 *
 */
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository repository;

	/**
	 * 목록 리턴.
	 * @return
	 *
	 */
	public List<Board> getList() {
		return repository.getList();
	}

	/**
	 * 상세 정보 리턴.
	 * @param boardSeq
	 * @return
	 */
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	}

	/**
	 * 등록 처리.
	 * @param board
	 */
/*	
	public void save(BoardParameter parameter) {
		// 조회하여 리턴된 정보
		Board board = repository.get(parameter.getBoardSeq());
		if (board == null) {
//			System.out.println("update call~~~~~~~");
			repository.save(parameter);			
		}
		else {
//			System.out.println("update call~~~~~~~");
			repository.update(parameter);
		}

		//return parameter.getBoardSeq();
	}
*/

	public int save(Board board) {
		repository.save(board);
		return board.getBoardSeq();
	}

	
	/**
	 * 업데이트 처리.
	 * @param board
	 */
/*	
	public void update (Board board) {
		repository.update(board);
	}
*/
	
	/**
	 * 삭제 처리.
	 * @param boardSeq
	 */
	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	}
}
