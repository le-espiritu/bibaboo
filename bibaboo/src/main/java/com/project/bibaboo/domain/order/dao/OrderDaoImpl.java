package com.project.bibaboo.domain.order.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;

@Repository
public class OrderDaoImpl implements OrderDao {

  SqlSession sqlSession;
  
  @Autowired
  public OrderDaoImpl(SqlSession sqlSession) {
    this.sqlSession=sqlSession;
  }
  
  @Override
  public OrderPageCategoryDTO getGoodsInfoForOrder(int categoryId) {
    return sqlSession.selectOne("order.getGoosInfoForOrder", categoryId);
  }

}
