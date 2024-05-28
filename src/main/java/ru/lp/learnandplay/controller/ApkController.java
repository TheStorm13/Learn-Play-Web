package ru.lp.learnandplay.controller;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ApkController {

    @GetMapping("/download_apk")
    public ResponseEntity<Resource> downloadApk() throws IOException {
        String apkDirectory = "src/main/resources/";
        String apkName="Learn&Play.apk";

        Path apkFilePath = Paths.get(apkDirectory).resolve(apkName).normalize();
        Resource apkFile = new UrlResource(apkFilePath.toUri());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + apkName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(apkFile);
    }
}