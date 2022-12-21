package com.mealkit.image;

import java.util.Date;


public class UploadFileVo {


	private Long id;
	
	private String fileName;                
	
	private String saveFileName;            

	private String filePath;                

	private String contentType;             
	
	private long size;                      
	
	private Date registerDate;

	public UploadFileVo() {}
	
	public UploadFileVo(Long id, String fileName, String saveFileName, String filePath, String contentType, long size,
			Date registerDate) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.filePath = filePath;
		this.contentType = contentType;
		this.size = size;
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "UploadFileVo [id=" + id + ", fileName=" + fileName + ", saveFileName=" + saveFileName + ", filePath="
				+ filePath + ", contentType=" + contentType + ", size=" + size + ", registerDate=" + registerDate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	} 



}
