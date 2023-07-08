package com.project.bibaboo.domain.user.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.user.dto.UserDTO;
import com.project.bibaboo.global.common.dto.Criteria;

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

  @Override
  public List<UserDTO> getAllUsers(Criteria criteria) {
    return sqlSession.selectList("user.selectAllUsers",criteria);
  }

  @Override
  public int countUsers(Criteria criteria) {
    return sqlSession.selectOne("user.countUsers",criteria);
  }

}
