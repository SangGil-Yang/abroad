package com.abroad.ysg.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.abroad.ysg.domain.Board;
import com.abroad.ysg.domain.FileBoard;

@Component("fileUtil")
public class FileUtil {
	private static final String filePath = "C:\\dev\\file\\";
	

	public List<FileBoard> parseInsertFileInfo(Board board, HttpServletRequest request) throws Exception
	{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<FileBoard> fileBoards = new ArrayList<FileBoard>();
		FileBoard fileBoard = null;
		
		File file = new File(filePath);
		if(file.exists() == false)
		{
			file.mkdirs();
		}
		
		while(iterator.hasNext())
		{
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false)
			{
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				
				fileBoard = new FileBoard();
				fileBoard.setBoard(board);
				fileBoard.setOrigin_file(originalFileName);
				fileBoard.setStored_file(storedFileName);
				fileBoard.setFile_size(multipartFile.getSize());
				fileBoards.add(fileBoard);
			}
		}
		
		return fileBoards;
		
	}

}
