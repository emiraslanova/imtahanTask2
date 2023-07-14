package com.example.imtahantask2.service;

import com.example.imtahantask2.dao.ParentDao;
import com.example.imtahantask2.entity.Child;
import com.example.imtahantask2.entity.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ParentService {
    private  final ParentDao parentDao;
    public List<Parent> getAllParent() {
        return parentDao.getAllParent();
    }

    public Parent creatParent(Parent parent) {
        return parentDao.creatParent(parent);
    }

    public Parent getParentById(long id) {
        return parentDao.getParentById(id);
    }

    public void deleteParent(long id) {
        parentDao.deleteParent(id);

    }

    public Parent updateParent(long id, Parent parent) {
        return parentDao.updateParent(id,parent);
    }
}
