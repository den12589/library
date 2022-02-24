package com.library.library.controller;

import com.library.library.service.ExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
public class ExportController {
    private final ExportService exportService;

    @GetMapping("/export")
    @ResponseStatus(HttpStatus.OK)
    public File getCsv() throws SQLException {
        return exportService.getCSV();
    }
}
