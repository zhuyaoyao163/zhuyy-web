package com.zhuyy.demo.service.impl;

import com.zhuyy.demo.mapper.PlusFileMapper;
import com.zhuyy.demo.model.PlusFile;
import com.zhuyy.demo.service.PlusFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
@Service("plusFileService")
public class PlusFileServiceImpl implements PlusFileService {

    @Resource
    public PlusFileMapper plusFileMapper;

    public int insertPlsFile(PlusFile plusFile) {
        return plusFileMapper.insert(plusFile);
    }

    public PlusFile getPlusFileById(String id) {
        PlusFile plusFile = plusFileMapper.selectByPrimaryKey(id);
        return plusFile;
    }

    public List<PlusFile> getPlusFiles() {
        List<PlusFile> plusFileList = plusFileMapper.selectAllPlusFile();
        return plusFileList;
    }
}
