package com.project.bibaboo.domain.order.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.order.dto.OrderCancleDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryStateDTO;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.global.common.dto.Criteria;

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

  @Override
  public int enrollOrder(OrderDTO orderDTO) {
    return sqlSession.insert("order.enrollOrder", orderDTO);
  }

  @Override
  public int enrollOrderCategory(OrderDTO orderDTO) {
    return sqlSession.insert("order.enrollOrderCategory", orderDTO);
  }

  @Override
  public List<OrderDTO> getOrderList(Criteria criteria) {
    return sqlSession.selectList("order.getOrderList", criteria);
  }

  @Override
  public int getOrderTotal(Criteria criteria) {
    return sqlSession.selectOne("order.getOrderTotal", criteria);
  }

  @Override
  public int orderCancle(OrderCancleDTO orderCancleDTO) {
    return sqlSession.update("order.orderCancle", orderCancleDTO);
  }

  @Override
  public int orderCategoryCancle(OrderCancleDTO orderCancleDTO) {
    return sqlSession.update("order.orderCategoryCancle",orderCancleDTO);
  }

  @Override
  public List<OrderCategoryDTO> getOrderCategories(int orderId) {
    return sqlSession.selectList("order.getOrderCategories", orderId);
  }

  @Override
  public List<OrderCategoryDTO> getCategoriesAndUserInfoByAlterId(Criteria criteria) {
    return sqlSession.selectList("order.getCategoriesAndUserInfoByAlterId", criteria);
  }

  @Override
  public int countOrderCategoriesByAlterId(Criteria criteria) {
    return sqlSession.selectOne("order.countOrderCategoriesByAlterId", criteria);
  }
  
  @Override
  public int updateOrderCategoryState(OrderCategoryStateDTO orderCategoryStateDTO) {
    return sqlSession.update("order.updateOrderCategoryState", orderCategoryStateDTO);
  }

  @Override
  public String orderCategoryStateCheckForReview(int orderCategoryId) {
    return sqlSession.selectOne("order.orderCategoryStateCheckForReview",orderCategoryId);
  }

}
