package com.project.bibaboo.domain.alterations.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.alterations.dto.Categories;

@Repository
public class AlterationsCategoryDao {

  private SqlSession sqlSession;
  
  @Autowired
  public AlterationsCategoryDao(SqlSession sqlSession) {
    this.sqlSession=sqlSession;
  }
  
  public int registerCategory(Categories categories) {
    return sqlSession.insert("alterationsCategory.insert", categories);
  }
}
