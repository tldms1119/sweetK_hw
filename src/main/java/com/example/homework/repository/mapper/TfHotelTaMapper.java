package com.example.homework.repository.mapper;

import com.example.homework.repository.vo.SearchKeywordVo;
import com.example.homework.repository.vo.TfHotelTaVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tfHotelTaMapper")
public class TfHotelTaMapper {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<TfHotelTaVo> selectHotel(String keyword){
        return sqlSessionTemplate.selectList("tfHotelTaMapper.selectHotel", keyword);
    }

}
