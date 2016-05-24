package com.zhuyy.demo.mapper;


import com.zhuyy.demo.model.PlusFile;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlusFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlusFile record);

    int insertSelective(PlusFile record);

    PlusFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlusFile record);

    int updateByPrimaryKey(PlusFile record);

    List<PlusFile> selectAllPlusFile();
}