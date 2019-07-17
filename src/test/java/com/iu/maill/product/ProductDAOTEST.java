package com.iu.maill.product;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.mall.product.ProductDAO;
import com.iu.mall.product.ProductVO;
import com.iu.s10.AbtractTest;
import com.iu.util.PageMaker;

public class ProductDAOTEST extends AbtractTest {
	@Inject
	private ProductDAO productDAO;
	@Test
	public void test() throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.makeRow();
		List<ProductVO> ar = productDAO.getList(pageMaker);
		System.out.println(ar.size());
		System.out.println(ar.get(0).getNailVOs().size());
	}

}
