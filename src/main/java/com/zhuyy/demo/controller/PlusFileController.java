package com.zhuyy.demo.controller;

import com.zhuyy.demo.model.PlusFile;
import com.zhuyy.demo.service.PlusFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
@Controller
@RequestMapping("/file")
public class PlusFileController {

    @Autowired
    private PlusFileService plusFileService;

    @RequestMapping("/showFileInfo/{id}")
    public String showFileInfo(@PathVariable String id, Model model) {
        PlusFile plusFile = plusFileService.getPlusFileById(id);
        model.addAttribute("plusFileInfo", plusFile);
        return "/file/fileInfo";
    }

    @RequestMapping("/showFileInfos")
    public
    @ResponseBody
    List<PlusFile> showPlusFiles() {
        List<PlusFile> plusFiles = plusFileService.getPlusFiles();
        return plusFiles;
    }
}
