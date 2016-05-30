package com.zhuyy.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhuyy.demo.model.PlusFile;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class Java8Test {
    private static final Logger LOGGER = Logger.getLogger(Java8Test.class);
    public static void main(String[] args) {
        List<PlusFile> files = getFiles();
//        Collections.sort(files, new Comparator<PlusFile>() {
//            public int compare(PlusFile o1, PlusFile o2) {
//                return Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId()));
//            }
//        });
        Collections.sort(files,(PlusFile o1, PlusFile o2) -> Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId())));
        LOGGER.info(JSON.toJSON(files));
    }

    public static List<PlusFile> getFiles() {
        String str = "[{\n" +
                "\t'folder': 1,\n" +
                "\t'size': '0',\n" +
                "\t'name': 'Files',\n" +
                "\t'pid': '-1',\n" +
                "\t'id': '1'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Documents',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '2'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Images',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '3'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Music',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '4'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'System',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '5'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Video',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '6'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Projects',\n" +
                "\t'pid': '2',\n" +
                "\t'id': '7'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Reports',\n" +
                "\t'pid': '2',\n" +
                "\t'id': '8'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Employees',\n" +
                "\t'pid': '3',\n" +
                "\t'id': '9'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'name': 'Product icons',\n" +
                "\t'pid': '3',\n" +
                "\t'id': '10'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'Description.rtf',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '11',\n" +
                "\t'type': 'rtf'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'n.txt',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '12',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'o.txt',\n" +
                "\t'pid': '1',\n" +
                "\t'id': '13',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file1.txt',\n" +
                "\t'pid': '2',\n" +
                "\t'id': '14',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file2.txt',\n" +
                "\t'pid': '2',\n" +
                "\t'id': '15',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file3.txt',\n" +
                "\t'pid': '3',\n" +
                "\t'id': '16',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file4.txt',\n" +
                "\t'pid': '3',\n" +
                "\t'id': '17',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file5.txt',\n" +
                "\t'pid': '4',\n" +
                "\t'id': '18',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file6.txt',\n" +
                "\t'pid': '5',\n" +
                "\t'id': '19',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file7.txt',\n" +
                "\t'pid': '6',\n" +
                "\t'id': '20',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file8',\n" +
                "\t'pid': '7',\n" +
                "\t'id': '21',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 0,\n" +
                "\t'name': 'file9',\n" +
                "\t'pid': '8',\n" +
                "\t'id': '22',\n" +
                "\t'type': 'txt'\n" +
                "},\n" +
                "{\n" +
                "\t'folder': 1,\n" +
                "\t'size': '0',\n" +
                "\t'name': 'Files',\n" +
                "\t'pid': '-1',\n" +
                "\t'id': '253'\n" +
                "}]";
        List<PlusFile> files = JSONArray.parseArray(str, PlusFile.class);
        return files;
    }
}
