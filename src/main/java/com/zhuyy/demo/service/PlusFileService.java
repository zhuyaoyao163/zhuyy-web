package com.zhuyy.demo.service;

import com.zhuyy.demo.model.PlusFile;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
public interface PlusFileService {
    int insertPlsFile(PlusFile plusFile);

    PlusFile getPlusFileById(String id);

    List<PlusFile> getPlusFiles();
}
