package com.myBoard.exception;

public class NotFoundIDException extends Exception{

	public NotFoundIDException() {
		super("존재하지 않는 아이디입니다.");
	}
}