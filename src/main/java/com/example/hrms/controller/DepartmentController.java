package com.example.hrms.controller;

import com.example.hrms.common.ApiResponse;
import com.example.hrms.model.dto.DepartmentDTO;
import com.example.hrms.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentDTO>> create(@Valid @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO created = departmentService.create(departmentDTO);
        ApiResponse<DepartmentDTO> response = ApiResponse.success("Phòng ban đã được tạo thành công", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
