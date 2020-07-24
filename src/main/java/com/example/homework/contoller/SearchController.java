package com.example.homework.contoller;

import com.example.homework.repository.mapper.SearchKeywordMapper;
import com.example.homework.repository.mapper.TfHotelTaMapper;
import com.example.homework.repository.vo.SearchKeywordVo;
import com.example.homework.repository.vo.TfHotelTaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class SearchController {

    @Autowired
    private SearchKeywordMapper searchKeywordMapper;

    @Autowired
    private TfHotelTaMapper tfHotelTaMapper;

    @GetMapping("/hw1/keyword")
    @ResponseBody
    public Map<String, String> getKeyword(Model model, String query){
        // 1. 내 최근 검색어 조회
        SearchKeywordVo paramVo = new SearchKeywordVo();
        paramVo.setKeyword(query);
        paramVo.setWriter("user");
        List<String> myKeywordList = searchKeywordMapper.selectMySearchKeyword(paramVo);

        // 2. 내 검색어가 아닌 자동 완성 키워드 조회
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("keyword", query);
        paramMap.put("keywordList", myKeywordList);
        List<String> autoKeywordList = searchKeywordMapper.selectSearchKeyword(paramMap);

        // 2. 반환할 map 에 담기
        Map<String, String> keywordMap = new LinkedHashMap<>();
        for(String tmpKeyword : myKeywordList){
            keywordMap.put(tmpKeyword, "my");
        }
        for(String tmpKeyword : autoKeywordList){
            keywordMap.put(tmpKeyword, "auto");
        }
        return keywordMap;
    }

    @GetMapping("/hw1/search")
    @ResponseBody
    public List<TfHotelTaVo> search(Model model, String keyword){
        // 1. 이미 등록된 검색어 인지 확인
        int checkCnt = searchKeywordMapper.duplicateCheck(keyword);

        // 2. 있으면 날짜 update, 없으면 insert
        if(checkCnt == 0){
            searchKeywordMapper.insertSearchKeyword(keyword);
        } else {
            searchKeywordMapper.updateSearchKeyword(keyword);
        }

        // 3. 호텔 리스트 조회
        List<TfHotelTaVo> hotelList = tfHotelTaMapper.selectHotel(keyword);

        return hotelList;
    }

}
