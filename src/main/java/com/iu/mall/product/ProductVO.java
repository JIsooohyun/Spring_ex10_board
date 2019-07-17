package com.iu.mall.product;

import java.sql.Date;
import java.util.List;

public class ProductVO {
	private String pid;
	private String category;
	private String title;
	private int price;
	private String subContents;
	private String mainContents;
	private int amount;
	private Date reg_date;
	private List<ThumbNailVO> nailVOs;
	private List<OptionsVO> optionsVOs;
	
	
	
	
	public List<OptionsVO> getOptionsVOs() {
		return optionsVOs;
	}
	public void setOptionsVOs(List<OptionsVO> optionsVOs) {
		this.optionsVOs = optionsVOs;
	}
	public List<ThumbNailVO> getNailVOs() {
		return nailVOs;
	}
	public void setNailVOs(List<ThumbNailVO> nailVOs) {
		this.nailVOs = nailVOs;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSubContents() {
		return subContents;
	}
	public void setSubContents(String subContents) {
		this.subContents = subContents;
	}
	public String getMainContents() {
		return mainContents;
	}
	public void setMainContents(String mainContents) {
		this.mainContents = mainContents;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	

}
