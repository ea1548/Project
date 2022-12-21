package com.mealkit.cusboard.re;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBoardReServiceImpl implements CustomerBoardReService {

	@Autowired
	private CustomerBoardReDao customerBoardReDao;
	
	@Override
	public void replyInsert(CustomerBoardReVo customerBoardReVo) {
		customerBoardReDao.replyInsert(customerBoardReVo);
		
	}
	
	@Override
	public List<CustomerBoardReVo> getCustomerReplyList(int cus_no) {
		List<CustomerBoardReVo> getCustomerReplyList =
		customerBoardReDao.getCustomerReplyList(cus_no);
		return getCustomerReplyList; 
	}
	 
	@Override 
	public void replyUpdate(CustomerBoardReVo customerBoardReVo) {
		customerBoardReDao.replyUpdate(customerBoardReVo);
	  
	}
	  
	
	 @Override
	 public CustomerBoardReVo getReplyOne(int customer_reply_no) {
		 CustomerBoardReVo customerBoardReVo = customerBoardReDao.getReplyOne(customer_reply_no);
		 return customerBoardReVo; 
	 }
	  
	 @Override
	 	public void replyDelete(int customer_reply_no) {
		 customerBoardReDao.replyDelete(customer_reply_no);
	  
	 }
	 

}
