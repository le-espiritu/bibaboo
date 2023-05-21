package com.project.bibaboo.domain.alterations.dao;

import java.util.List;
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
  public List<AlterationsDto> selectAll() {
    return sqlSession.selectList("alterations.selectAll");
  }
  
  @Override
  public int insert(AlterationsDto alterationsDto) {
    return sqlSession.insert("alterations.insert", alterationsDto);

  }

  @Override
  public int photoNameInsert(AlterPhotoDto alterPhotoDto) {
    return sqlSession.insert("alterations.fileNameInsert", alterPhotoDto);

  }

  @Override
  public int delete(Integer id) {
    return sqlSession.delete("alterations.delete", id);
  }

}
