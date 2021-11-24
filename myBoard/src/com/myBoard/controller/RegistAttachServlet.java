package com.myBoard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/RegistAttach.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)
public class RegistAttachServlet extends HttpServlet {
	private static final String SAVE_DIR = "uploadFiles";
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appPath = request.getServletContext().getRealPath("");

		System.out.println(appPath);
		
		String savePath = appPath + File.separator + SAVE_DIR; // 서버에 savePath에 해당하는 디렉토리가 있는지 확인해서 없으면 만들어라 
		System.out.println("savePath" + savePath);
		
		File fileSaveDir = new File(savePath); 
		
		if( !fileSaveDir.exists() ) { 
			fileSaveDir.mkdir(); 
		} 
		
		for (Part part : request.getParts()) { 
			String fileName = extractFileName(part); 
			System.out.println(fileName);
			part.write(savePath + File.separator + fileName); 
		} 
		
//		request.setAttribute("message", "파일업로드에 성공 하였습니다.!"); 
//		getServletContext().getRequestDispatcher("/fileResult.jsp").forward(request, response); 
		
	}
	
		private String extractFileName(Part part) { 
			String contentDisp = part.getHeader("content-disposition"); 
			String[] items = contentDisp.split(";"); 
			for (String s : items) { 
				if (s.trim().startsWith("filename")) { 
					return s.substring(s.indexOf("=") + 2, s.length()-1); 
				} 
			} 
		return "";
		}

}

