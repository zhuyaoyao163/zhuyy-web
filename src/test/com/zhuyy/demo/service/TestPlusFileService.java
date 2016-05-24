package com.zhuyy.demo.service;

import com.alibaba.fastjson.JSON;
import com.zhuyy.demo.model.PlusFile;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application.xml",
        "classpath:spring-mybatis.xml" })
public class TestPlusFileService {
    private static final Logger LOGGER = Logger.getLogger(TestPlusFileService.class);

    @Autowired
    private PlusFileService plusFileService;

    @Test
    public void testGetPlusFileById() {
        PlusFile plusFile = plusFileService.getPlusFileById("1");
        LOGGER.info("=============="+JSON.toJSON(plusFile));
    }

    @Test
    public void testGetPlusFiles() {
        List<PlusFile> plusFiles = plusFileService.getPlusFiles();
        LOGGER.info(JSON.toJSON(plusFiles));
    }

    @Test
    public void testInsertPlsFile() {
        String str = "{'folder':'1','size':'0','name':'Files','pid':'-1','id':'253'}";
        PlusFile plusFile = JSON.parseObject(str, PlusFile.class);
        int res = plusFileService.insertPlsFile(plusFile);
        LOGGER.info(res);
    }
}
