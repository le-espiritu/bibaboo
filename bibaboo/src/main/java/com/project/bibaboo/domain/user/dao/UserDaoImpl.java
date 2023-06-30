package com.project.bibaboo.domain.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.user.dto.UserDTO;

@Repository
public class UserDaoImpl implements UserDao {

  SqlSession sqlSession;
  
  @Autowired
  public UserDaoImpl(SqlSession sqlSession) {
    this.sqlSession=sqlSession;
  }
  
  @Override
  public UserDTO getUserByEmail(String loginUserEmail) {
    return sqlSession.selectOne("user.getUserByEmail", loginUserEmail);
  }

  @Override
  public int addUser(UserDTO userDTO) {
    return sqlSession.insert("user.addUser", userDTO);
  }

}
