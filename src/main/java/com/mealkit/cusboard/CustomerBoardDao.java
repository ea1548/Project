package com.mealkit.cusboard;

import java.security.Principal;
import java.util.List;

import com.mealkit.paging.Criteria;


public interface CustomerBoardDao {

	void customerBoardInsert(CustomerBoardVo customerBoardVo, Principal principal);

	List<CustomerBoardVo> getCustomerBoardList(Criteria cri);

	int listCount();
	
	CustomerBoardVo customerBoardDetail(int cus_no);

	void updateCustomerBoard(CustomerBoardVo customerBoardVo);

	void deleteCustomerBoard(int cus_no);


}
