package com.example.imtahantask2.controller;

import com.example.imtahantask2.entity.Parent;
import com.example.imtahantask2.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor

public class ParentController {
    private final ParentService parentService;
    @GetMapping
    public List<Parent> getAllParent (){
        return parentService.getAllParent();

    }
    @PostMapping
    public Parent creatParent(@RequestBody Parent  parent)
    {
        return parentService.creatParent(parent);
    }
    @GetMapping("/{id}")
   public Parent getParentById(@PathVariable long id ){

        return parentService.getParentById(id);
   }
   @DeleteMapping("/{id}")
   public void deleteParent(@PathVariable long id ){

        parentService.deleteParent(id);
   }
   @PutMapping("/{id}")
   public Parent updateParent(@PathVariable long id ,@RequestBody Parent parent){
      return   parentService.updateParent(id,parent);
   }
}
