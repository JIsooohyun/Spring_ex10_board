package com.iu.boad.qna;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.qna.QnaService;
import com.iu.s10.AbtractTest;


public class QnaServiceTest extends AbtractTest {
	
	@Inject
	private QnaService qnaService;

	@Test
	public void test() throws Exception {
		qnaService.getSelect(178);
	}

}
