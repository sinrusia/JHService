package com.kojh.boardtest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kojh.boardtest.Board;
import com.kojh.boardtest.BoardDAO;

/**
 * 게시판 기능을 담당하는 컨트롤러
 * @author jaehag
 *
 */
@Controller
@ResponseStatus(value = HttpStatus.ACCEPTED)
public class BoardController {
	
	private final BoardDAO boardDAO;
	
	@Autowired
	public BoardController(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@RequestMapping(value="/boards", method=RequestMethod.GET)
	public @ResponseBody List<Board> getBoards() {
		return boardDAO.getBoards();
	}
	
	@RequestMapping(value="/boards/{boardId}", method=RequestMethod.GET)
	public @ResponseBody Board getBoard(@PathVariable("boardId") String boardId) {
		return boardDAO.getBoardById(boardId);
	}
	
	@RequestMapping(value="/boards", method=RequestMethod.POST)
	public @ResponseBody Board addBoard(@RequestBody Board board) {
		boardDAO.addBoard(board);
		return board;
	}
	
	@RequestMapping(value="/boards/{boardId}", method=RequestMethod.PUT)
	public @ResponseBody Board saveBoard(@RequestBody Board board) {
		boardDAO.saveBoard(board);
		return board;
	}
	
	@RequestMapping(value="/boards/{boardId}", method=RequestMethod.DELETE)
	public @ResponseBody Board remove(@PathVariable("boardId") String boardId) {
		Board board = getBoard(boardId);
		boardDAO.deleteBoard(boardId);
		return board;
	}
}
