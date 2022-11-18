package kr.co.songjava.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.songjava.configuration.http.BaseResponse;
import kr.co.songjava.mvc.domain.Board;
import kr.co.songjava.mvc.parameter.BoardParameter;
import kr.co.songjava.mvc.service.BoardService;

/**
 * 게시판 controller
 * @author note11
 *
 */
@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	/**
	 * 목록 리턴.
	 * @return
	 *
	 */
	@GetMapping
	@ApiOperation(value = "목록 조회", notes = "게시물 번호에 해당하는 목록정보를 조회할 수 있습니다.")
	/*
	public List<Board> getList() {
		return boardService.getList();
	}
	*/
	public BaseResponse<List<Board>> getList() {
		return new BaseResponse<List<Board>>(boardService.getList());
	}
	

	/**
	 * 상세 정보 리턴.
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/{boardSeq}")
	@ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세정보를 조회할 수 있습니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1")
	})
	/*
	public Board get(@PathVariable int boardSeq) {
		return boardService.get(boardSeq);
	}
	*/
	public BaseResponse<Board> get(@PathVariable int boardSeq) {
		return new BaseResponse<Board>(boardService.get(boardSeq));
	}
	
	/**
	 * 등록/수정(업데이트) 처리.
	 * @param board
	 */
	//@GetMapping("/save")
	/*
	@PutMapping
	@ApiOperation(value = "등록/수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트를 할 수 있습니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
		@ApiImplicitParam(name = "title", value = "제목", example = "spring"),
		@ApiImplicitParam(name = "contents", value = "내용", example = "spring 강좌")	,	
	})
	*/

	@GetMapping("/save")
	public int save(Board board) {
		return boardService.save(board);
	}

	
	/*
	public BaseResponse<Integer> save(Board board) {
		//boardService.save(parameter);
		boardService.save(board);
		return new BaseResponse<Integer>(board.getBoardSeq());
	}
*/
	
	/**
	 * 업데이트 처리.
	 * @param board
	 */
/*	
	public void update (Board board) {
		boardService.update(board);
	}
*/
	
	/**
	 * 삭제 처리.
	 * @param board
	 */
	//@GetMapping("/delete/{boardSeq}")
	@DeleteMapping("/{boardSeq}")
	@ApiOperation(value = "삭제 처리", notes = "게시물 삭제 처리")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
	})
	/*
	public boolean delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if (board == null) {
			return false;
		}
		boardService.delete(boardSeq);
		return true;
	}
	*/
	public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if (board == null) {
			return new BaseResponse<Boolean>(false);
		}
		boardService.delete(boardSeq);
		return new BaseResponse<Boolean>(true);
	}
}
