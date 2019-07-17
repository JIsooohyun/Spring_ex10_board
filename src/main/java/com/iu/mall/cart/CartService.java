package com.iu.mall.cart;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.iu.member.MemberDTO;

@Service
public class CartService {

	@Inject
	private CartDAO cardDAO;
	
	
	public int setDelete(Integer [] num)throws Exception{
		
		return cardDAO.setDelete(num);
	}
	
	public int setUpdate(CartVO cartVO)throws Exception{
		return cardDAO.setUpdate(cartVO);
	}
	
	public int setWrite(CartVO cartVO)throws Exception{
		
		return cardDAO.setWrite(cartVO);
	}
	
	public List<CartListVO> getList(HttpSession session)throws Exception{
		String id= ((MemberDTO)session.getAttribute("member")).getId();
		return cardDAO.getList(id);
	}
}
