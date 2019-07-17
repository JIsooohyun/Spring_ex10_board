package com.iu.transfer;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.board.BoardDTO;
import com.iu.s10.AbtractTest;

public class GoTest extends AbtractTest{

	@Inject
	private Bus bus;
	@Autowired
	private SubWay subway;

	
	@Test
	public void test() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(178);
		boardDTO.setWriter("iu");
		//bus.bus2(boardDTO);
		bus.bus("iu", 27);
		//subway.free();
		
		//subway.subway();
		
	}

}











