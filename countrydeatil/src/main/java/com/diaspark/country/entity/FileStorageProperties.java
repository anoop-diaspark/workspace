package com.diaspark.country.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
	 private String uploadDir;
/* Getter and Setter for taking the destination dir where to upload and from where to download*/
	    public String getUploadDir() {
	        return uploadDir;
	    }

	    public void setUploadDir(String uploadDir) {
	        this.uploadDir = uploadDir;
	    }
}
