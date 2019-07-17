package com.iu.s10;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iu.board.productQna.ProductQnaService;
import com.iu.board.productQna.ProductQnaVO;
import com.iu.util.PageMaker;

@RestController
@RequestMapping("/productQna/")
public class ProductQnaController {
	@Inject
	private ProductQnaService productQnaService;
	
	@RequestMapping(value = "/productQnaList/{id}", method = RequestMethod.GET)
	public List<ProductQnaVO> getList(PageMaker pageMaker, @PathVariable(value = "id") String pid)throws Exception{
		return  productQnaService.getList(pageMaker, pid);
	}
	
	
	@RequestMapping(value = "/productQnaSelect", method = RequestMethod.GET)
	public ProductQnaVO getSelect(int num)throws Exception{
		return productQnaService.getSelect(num);
	}
	
	@RequestMapping(value = "/productQnaWrite", method = RequestMethod.POST)
	public int setWrite(ProductQnaVO productQnaVO)throws Exception{
		return productQnaService.setWrite(productQnaVO);
	}
	
	

}
