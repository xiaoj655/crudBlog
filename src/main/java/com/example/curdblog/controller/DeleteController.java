package com.example.curdblog.controller;

import com.example.curdblog.dao.DeleteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {
    @Autowired
    DeleteDao deleteDao;

    @PostMapping("/delete")
    public String delete(@RequestBody int id) {
        String result = null;
        result = deleteDao.delete(id);
        return result;
    }
}
