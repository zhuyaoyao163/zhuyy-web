package com.zhuyy.demo.service;

import com.alibaba.fastjson.JSON;
import com.zhuyy.demo.model.PlusFile;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by Administrator on 2016/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml",
        "classpath:spring-mybatis.xml"})
public class TestPlusFileService {
    private static final Logger LOGGER = Logger.getLogger(TestPlusFileService.class);

    @Autowired
    private PlusFileService plusFileService;

    @Test
    public void testGetPlusFileById() {
        PlusFile plusFile = plusFileService.getPlusFileById("1");
        LOGGER.info("==============" + JSON.toJSON(plusFile));
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

    @Test
    public void testJava8() {
        List<PlusFile> plusFiles = plusFileService.getPlusFiles();
//        Collections.sort(plusFiles, new Comparator<PlusFile>() {
//            public int compare(PlusFile o1, PlusFile o2) {
//                return Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId()));
//            }
//        });

//        Collections.sort(plusFiles,(PlusFile o1, PlusFile o2) -> Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId())));
//        Collections.sort(plusFiles,Comparator.comparing((PlusFile p) -> Integer.valueOf(p.getId())));
//        Collections.sort(plusFiles, comparing(PlusFile::getId));
//        plusFiles.forEach(p -> System.out.println(p.getId()));
        List<String> plusFileIdList = plusFiles.parallelStream()
                .filter(p -> p.getFolder() == 1)
                .sorted(comparing(PlusFile::getId).reversed())
                .map(PlusFile::getId)
                .collect(Collectors.toList());
        LOGGER.info(JSON.toJSON(plusFileIdList));

//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        Stream<Integer> outputStream = inputStream.
//                flatMap((childList) -> childList.stream());
////        System.out.println(outputStream.toArray()[0]);
//        Arrays.stream(outputStream.toArray()).forEach(System.out::println);
    }
}
