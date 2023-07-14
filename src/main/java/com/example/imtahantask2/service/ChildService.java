package com.example.imtahantask2.service;

import com.example.imtahantask2.dao.ChildDao;
import com.example.imtahantask2.entity.Child;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildDao childDao;

    public List<Child> getAllChild() {
        return childDao.getAllChild();
    }

    public Child creatChild(Child child) {
        return childDao.creatChild(child);
    }

    public Child getChildById(Long id) {
        return childDao.getChildById(id);
    }

    public void deleteChild(Long id) {
        childDao.deleteChild(id);

    }

    public Child updateChild(long id, Child child) {

        return childDao.updateChild(id,child);
    }
}
