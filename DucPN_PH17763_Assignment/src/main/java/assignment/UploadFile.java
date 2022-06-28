package assignment;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFile {
	public File handleUploadFile(MultipartFile uploadFile) {
		String fordelPath = "D:\\Ki6\\Java 5\\DucPN_PH17763_Assignment\\DucPN_PH17763_Assignment\\src\\main\\webapp\\photo";
		File myupload = new File(fordelPath);
		if (!myupload.exists()) {
			myupload.mkdirs();
		}
		File saveFile = null;
		try {
			String fileName = uploadFile.getOriginalFilename();
			saveFile = new File(myupload, fileName);
			uploadFile.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFile;
	}
}
