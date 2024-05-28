package ru.lp.learnandplay.services.Impl;

import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ApkFileServiceImpl {


    private static final String APK_DIRECTORY = "/Learn&Play.apk";


    public Resource loadApkFile(String fileName) throws MalformedURLException {
        Path apkFilePath = Paths.get(APK_DIRECTORY).resolve(fileName).normalize();
        Resource resource = new UrlResource(apkFilePath.toUri());

        if (resource.exists()) {
            return resource;
        } else {
            throw new RuntimeException("АПК-файла не найдено: " + fileName);
        }
    }

}
