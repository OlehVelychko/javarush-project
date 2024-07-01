package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream zOS = new ZipOutputStream(Files.newOutputStream(zipFile));
             InputStream inputStream = Files.newInputStream(source)) {

            String entryName = source.getFileName().toString();
            ZipEntry zipEntry = new ZipEntry(entryName);

            zOS.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {
                zOS.write(buffer, 0, length);
            }

            zOS.closeEntry();
        } catch (IOException e) {
            throw new Exception("Failed to create ZIP archive", e);
        }
    }
}
