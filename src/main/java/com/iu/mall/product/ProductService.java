package com.iu.mall.product;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.util.FileSaver;
import com.iu.util.PageMaker;
@Service
public class ProductService {
	
	@Inject
	private ProductDAO productDAO;
	@Inject
	private OptionsDAO optionsDAO;
	@Inject
	private ThumbNailDAO thumbNailDAO;
	@Inject
	private FileSaver fileSaver;
	
	//select
	public ProductVO getSelect(ProductVO productVO) throws Exception{
		return productDAO.getSelect(productVO);
	}
	
	//list
	public List<ProductVO> getList(PageMaker pageMaker)throws Exception{
		//startRow,
		pageMaker.setPerPage(9);
		pageMaker.makeRow();
		//pageing
		int totalCount = productDAO.getCount(pageMaker);
		pageMaker.makePage(totalCount);
		return productDAO.getList(pageMaker);
	}
	
	//write
	public int setWrite(ProductVO productVO, List<MultipartFile> f1, HttpSession session)throws Exception{
		//1. PID 생성
		//현재시간을 밀리세컨즈로 변환,
		Calendar ca =null;
		long time = 0;
		String realPath = null;
		String pid=null;
		int result=0;
		String fname=null;
		
		
		System.currentTimeMillis();
		ca = Calendar.getInstance();
		time = ca.getTimeInMillis();
		
		pid = productVO.getCategory()+time;
		
		//F+현재시간
		//T+현재시간
		//B+현재시간
		//2. product insert
		productVO.setPid(pid);
		result = productDAO.setWrite(productVO);
		//3. options insert
		
		//OptionsVO optionsVO = new OptionsVO();
		
		//4. File Hdd Save -> Fname
		realPath = session.getServletContext().getRealPath("/resources/mall");
		
		for(MultipartFile multipartFile: f1) {
			ThumbNailVO thumbNailVO = new ThumbNailVO();
			fname = fileSaver.saveFile(realPath, multipartFile);
			thumbNailVO.setPid(pid);
			thumbNailVO.setOname(multipartFile.getOriginalFilename());
			thumbNailVO.setFname(fname);
			result = thumbNailDAO.setWrite(thumbNailVO);
		}
		
		
		return result;
	}

}











