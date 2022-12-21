package com.mealkit.cusboard.re;

import java.util.List;

public interface CustomerBoardReDao {

	void replyInsert(CustomerBoardReVo customerBoardReVo);

	List<CustomerBoardReVo> getCustomerReplyList(int cus_no);

	void replyUpdate(CustomerBoardReVo customerBoardReVo);

	CustomerBoardReVo getReplyOne(int customer_reply_no);

	void replyDelete(int customer_reply_no);

}
