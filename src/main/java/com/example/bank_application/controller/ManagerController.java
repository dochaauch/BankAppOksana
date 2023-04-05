package com.example.bank_application.controller;

import com.example.bank_application.dto.ManagerCreateDto;
import com.example.bank_application.dto.ManagerDto;
import com.example.bank_application.dto.ManagerListDto;
import com.example.bank_application.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/managers")
@RequiredArgsConstructor
public class ManagerController {
    public final ManagerService managerService;

    @GetMapping(value = "/id/{managerId}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDto getManagerById(@PathVariable("managerId") String managerId) {
        return managerService.getManagerById(managerId);
    }
    @GetMapping(value="/all/withClients")
    @ResponseStatus(HttpStatus.OK)
    public ManagerListDto getAllManagers() {
        return managerService.getAllManagersWithClients();
    }
    @PostMapping( value = "/new")
//    @PostMapping( value = "/new", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewManager(@RequestBody ManagerCreateDto managerCreateDto) {
        managerService.managerNewCreate(managerCreateDto);
    }

}
