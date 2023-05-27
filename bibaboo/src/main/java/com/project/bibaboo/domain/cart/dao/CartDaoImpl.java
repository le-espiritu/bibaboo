package com.project.bibaboo.domain.cart.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.cart.dto.CartDTO;

@Repository
public class CartDaoImpl implements CartDao {
  
  private SqlSession sqlSession;
  
  @Autowired
  public CartDaoImpl(SqlSession sqlSession) {
    this.sqlSession=sqlSession;
  }

  @Override
  public int addCart(CartDTO cartDTO) throws Exception {
    return sqlSession.insert("cart.addCart", cartDTO);
  }

  @Override
  public int deleteCart(int id) {
    return sqlSession.delete("cart.deleteCart", id);
  }

  @Override
  public int modifyCount(CartDTO cartDTO) {
    return sqlSession.update("cart.modifyCount", cartDTO);
  }

  @Override
  public List<CartDTO> getCart(int userId) {
    return sqlSession.selectList("cart.getCart", userId);
  }

  @Override
  public CartDTO checkCart(CartDTO cartDTO) {
    return sqlSession.selectOne("cart.checkCart", cartDTO);
  }

}
