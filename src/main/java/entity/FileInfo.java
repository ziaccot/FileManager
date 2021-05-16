package entity;

import properties.DefaultProperties;
import properties.ErrorProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class FileInfo {
    private String fileName;
    private long fileSize;
    private LocalDateTime lastModified;

    public FileInfo(Path path){
        try {
            fileName = path.getFileName().toString();
            if (Files.isDirectory(path)){
                fileSize = -1L;
            }else{
                fileSize = Files.size(path);
            }
            lastModified = LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneOffset.ofHours(0));
        }catch (IOException e){
            throw new RuntimeException(ErrorProperties.FilePathError);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        if(fileSize<0)
            return "[DIR]";
        return Long.toString(fileSize) +" bytes";
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getLastModified() {
        return lastModified.format(DateTimeFormatter.ofPattern(DefaultProperties.DateTimePattern));
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}
