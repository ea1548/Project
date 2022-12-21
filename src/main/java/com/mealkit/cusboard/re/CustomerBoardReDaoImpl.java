package com.mealkit.cusboard.re;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerBoardReDaoImpl implements CustomerBoardReDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void replyInsert(CustomerBoardReVo customerBoardReVo) {
		sqlSession.insert("CustomerBoardRe.replyInsert", customerBoardReVo);
		
	}

	
	@Override 
	public List<CustomerBoardReVo> getCustomerReplyList(int cus_no) {
	 
		List<CustomerBoardReVo> getCustomerReplyList =
		sqlSession.selectList("CustomerBoardRe.getCustomerReplyList", cus_no);
	 
		return getCustomerReplyList; 
	 }
	 
	@Override public void replyUpdate(CustomerBoardReVo customerBoardReVo) {
		
		sqlSession.update("CustomerBoardRe.replyUpdate", customerBoardReVo);
	  
	}
	  
	 @Override
	 public CustomerBoardReVo getReplyOne(int customer_reply_no) {

		 CustomerBoardReVo customerBoardReVo =
		 sqlSession.selectOne("CustomerBoardRe.getCustomerReplyOne", customer_reply_no); 
		 return customerBoardReVo;
	 }
	  
	 @Override
	 public void replyDelete(int customer_reply_no) {

		 sqlSession.delete("CustomerBoardRe.replyDelete", customer_reply_no);
	  
	 }
	 

}
