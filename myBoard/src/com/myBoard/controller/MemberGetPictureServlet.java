package com.myBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBoard.utils.FileDownloadResolver;
import com.myBoard.utils.GetUploadPath;


@WebServlet("/member/getPicture")
public class MemberGetPictureServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url=null;
      
      String fileName = request.getParameter("picture");
      String savedPath = GetUploadPath.getUploadPath("member.picture.upload");
      
      FileDownloadResolver.sendFile(fileName, savedPath, request, response);
   }

}