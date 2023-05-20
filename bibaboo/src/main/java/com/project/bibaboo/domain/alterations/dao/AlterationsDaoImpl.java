package com.project.bibaboo.domain.alterations.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

@Repository
public class AlterationsDaoImpl implements AlterationsDao {

  private SqlSession sqlSession;

  @Autowired
  public AlterationsDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public int insert(AlterationsDto alterationsDto) {
    return sqlSession.insert("alterations.insert", alterationsDto);

  }

  @Override
  public int photoNameInsert(AlterPhotoDto alterPhotoDto) {
    return sqlSession.insert("alterations.fileNameInsert", alterPhotoDto);

  }

}
