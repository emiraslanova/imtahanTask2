package com.example.imtahantask2.controller;

import com.example.imtahantask2.entity.Child;
import com.example.imtahantask2.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService childService;

    @GetMapping
    public List<Child> getAllChild (){
        return childService.getAllChild();

    }
    @PostMapping
    public  Child creatChild(@RequestBody Child child){
        return childService.creatChild(child);
    }
    @GetMapping("/{id}")
    public Child getChildById(@PathVariable Long id ){
        return childService.getChildById(id );

    }
    @DeleteMapping("/{id}")
    public void deleteChild (@PathVariable Long id ){
        childService.deleteChild(id);
    }
    @PutMapping("/{id}")
    public Child updateChild(@PathVariable long id, @RequestBody Child child){
        return childService.updateChild(id ,child);
    }

}
