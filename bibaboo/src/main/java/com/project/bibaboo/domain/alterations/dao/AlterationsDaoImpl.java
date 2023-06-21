package com.project.bibaboo.domain.alterations.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterTop5DTO;
import com.project.bibaboo.global.common.dto.Criteria;

@Repository
public class AlterationsDaoImpl implements AlterationsDao {

  private SqlSession sqlSession;

  @Autowired
  public AlterationsDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public List<AlterationsDTO> selectAll() {
    return sqlSession.selectList("alterations.selectAll");
  }
  
  @Override
  public AlterationsDTO selectById(int id) {
    return sqlSession.selectOne("alterations.selectById", id);
  }
  
  @Override
  public List<AlterationsDTO> getListWithPaging(Criteria criteria) {
    return sqlSession.selectList("alterations.getListWithPaging", criteria);
  }
  
  @Override
  public int insert(AlterationsDTO alterationsDto) {
    return sqlSession.insert("alterations.insert", alterationsDto);

  }

  @Override
  public int photoNameInsert(AlterPhotoDTO alterPhotoDto) {
    return sqlSession.insert("alterations.fileNameInsert", alterPhotoDto);
  }

  @Override
  public int update(AlterationsDTO alterationsDto) {
    return sqlSession.update("alterations.update", alterationsDto);
  }
  
  @Override
  public int delete(Integer id) {
    return sqlSession.delete("alterations.delete", id);
  }

  @Override
  public int getTotal(Criteria criteria) {
    return sqlSession.selectOne("alterations.getTotal",criteria);
  }

  @Override
  public List<AlterationsDTO> getTopFive(AlterTop5DTO alterTop5DTO) {
    return sqlSession.selectList("alterations.getTopFive", alterTop5DTO);
  }

}
