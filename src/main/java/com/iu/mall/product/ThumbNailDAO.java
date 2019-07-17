package com.iu.mall.product;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class ThumbNailDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESAPCE="ThumbNailMapper.";
	
	//insert
	public int setWrite(ThumbNailVO thumbNailVO)throws Exception{
		return sqlSession.insert(NAMESAPCE+"setWrite", thumbNailVO);
	}

}
