package com.myBoard.action.member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import com.myBoard.action.Action;
import com.myBoard.controller.MultipartHttpServletRequestParser;
import com.myBoard.controller.SaveFileResolver;
import com.myBoard.exception.NotMultipartFormDataException;
import com.myBoard.service.MemberService;
import com.myBoard.utils.GetUploadPath;

public class PictureUploadMemberAction implements Action {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500KB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1; // 1MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2MB

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String url=null;
		
		String uploadFileName = null;
		
		try {
			// 1. request 변환
			MultipartHttpServletRequestParser multi = new MultipartHttpServletRequestParser(request,MEMORY_THRESHOLD, 
														     MAX_FILE_SIZE, 
														     MAX_REQUEST_SIZE);
			// 2. 저장할 경로		
			String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
			
			// 3. 업로드된 이미지 저장
			FileItem[] items = multi.getFileItems("pictureFile");
			
			List<File> uploadFiles 	= SaveFileResolver.fileUpload(items,uploadPath);
			
			uploadFileName = uploadFiles.get(0).getName();
			
			// 4. 이전 이미지 삭제
			String oldPicture = multi.getParameter("oldPicture");
			File oldFile = new File(uploadPath + File.separator + oldPicture);
			if (oldFile.exists()) {
				oldFile.delete();
			}
			
			// 5. 저장한 파일명 보내기
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(uploadFileName);
			
		} catch (NotMultipartFormDataException e) {
			response.sendError(response.SC_BAD_REQUEST); // 400
			url=null;
		} catch (FileUploadException e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR); // 500
			url=null;
		}catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url=null;
		}
		
		return url;
	}

}
