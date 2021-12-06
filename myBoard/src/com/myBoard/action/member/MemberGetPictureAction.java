package com.myBoard.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBoard.action.Action;
import com.myBoard.controller.FileDownloadResolver;
import com.myBoard.utils.GetUploadPath;

public class MemberGetPictureAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String url = null;

		String fileName = request.getParameter("picture");
		String savedPath = GetUploadPath.getUploadPath("member.picture.upload");

		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
	      
		return url;
	}
}
