package com.example.curdblog.controller;

import com.example.curdblog.dao.DeleteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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
