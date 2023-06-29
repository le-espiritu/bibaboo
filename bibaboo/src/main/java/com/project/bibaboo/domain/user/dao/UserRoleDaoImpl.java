package com.project.bibaboo.domain.user.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.user.dto.UserRoleDTO;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

  SqlSession sqlSession;
  
  @Autowired
  public UserRoleDaoImpl(SqlSession sqlSession) {
    this.sqlSession=sqlSession;
  }
  
  @Override
  public List<UserRoleDTO> getUserRoleByEmail(String loginUserEmail) {
    return sqlSession.selectList("user.getUserRoleByEmail", loginUserEmail);
  }

}
