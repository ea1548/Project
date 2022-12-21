package com.mealkit.cusboard;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mealkit.paging.Criteria;

@Service
public class CustomerBoardServiceImpl implements CustomerBoardService{
	
	@Autowired
	private CustomerBoardDao customerBoardDao;
	
	@Override
	public void customerBoardInsert(CustomerBoardVo customerBoardVo, Principal principal) {
		customerBoardDao.customerBoardInsert(customerBoardVo, principal);
		
	}

	@Override
	public List<CustomerBoardVo> getCustomerBoardList(Criteria cri) {
				
		return customerBoardDao.getCustomerBoardList(cri);
	}

	@Override
	public int listCount() {
		
		return customerBoardDao.listCount();
	}
	
	
	 @Override 
	 public CustomerBoardVo customerBoardDetail(int cus_no) {
		 CustomerBoardVo customerBoardDetail = customerBoardDao.customerBoardDetail(cus_no);
		 return customerBoardDetail; 
	 }
	  
	 @Override
	 public void updateCustomerBoard(CustomerBoardVo customerBoardVo) {
		 customerBoardDao.updateCustomerBoard(customerBoardVo); 
	 }
	  
	 @Override 
	 public void deleteCustomerBoard(int cus_no) {
		 customerBoardDao.deleteCustomerBoard(cus_no);
	  
	 }
	 


}
