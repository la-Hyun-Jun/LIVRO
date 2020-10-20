package com.kh.livro.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.livro.dao.BroadcastDao;
import com.kh.livro.dto.BroadcastDto;

@Repository
public class BroadcastDaoImpl implements BroadcastDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(BroadcastDao.class);

	@Override
	public List<BroadcastDto> selectList() {
		List<BroadcastDto> list = new ArrayList<BroadcastDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("[ERROR] 방송 목록 Dao 에러");
		}
		
		return list;
	}

	@Override
	public BroadcastDto selectOne(int broadcast_no) {
		BroadcastDto dto = new BroadcastDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", broadcast_no);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("[ERROR] 방송 목록 Dao 에러");
		}
		
		return dto;
	}

	@Override
	public int broadInsert(BroadcastDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("[ERROR]");
		}
		return res;
	}

	@Override
	public int broadUpdate(BroadcastDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("[ERROR]");
		}
		return res;
	}

	@Override
	public int broadDelete(int broadcast_no) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "delete", broadcast_no);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("[ERROR]");
		}
		return res;
	}


}
