package com.example.homework.repository.mapper;

import com.example.homework.repository.vo.SearchKeywordVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("searchKeywordMapper")
public class SearchKeywordMapper {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<String> selectSearchKeyword(HashMap paramMap){
        return sqlSessionTemplate.selectList("searchKeywordMapper.selectSearchKeyword", paramMap);
    }

    public List<String> selectMySearchKeyword(SearchKeywordVo searchKeywordVo){
        return sqlSessionTemplate.selectList("searchKeywordMapper.selectMySearchKeyword", searchKeywordVo);
    }

    public int insertSearchKeyword(String keyword){
        return sqlSessionTemplate.insert("searchKeywordMapper.insertSearchKeyword", keyword);
    }

    public int updateSearchKeyword(String keyword){
        return sqlSessionTemplate.update("searchKeywordMapper.updateSearchKeyword", keyword);
    }

    public int duplicateCheck(String keyword){
        return sqlSessionTemplate.selectOne("searchKeywordMapper.duplicateCheck", keyword);
    }

}
