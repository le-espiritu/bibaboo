package com.project.bibaboo.domain.alterations.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

@Repository
public class AlterationsDaoImpl implements AlterationsDao {
  
  private SqlSession sqlSession;
  
  @Autowired
  public AlterationsDaoImpl(SqlSession sqlSession) {
    this.sqlSession=sqlSession;
  }

  @Override
  public void insert(AlterationsDto alterationsDto) {
    sqlSession.insert("alterations.insert", alterationsDto);

  }

}
