package com.kh.app.board.vo;

import lombok.Data;

@Data
@Builder
public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private String enrollDate;
	private String delYn;
	private String writerNo;
	private String writerNick;
	
	private BoardVo(BoardTemp temp) {
		this.no = temp.no;
		this.title = temp.title;
		this.content = temp.content;
		this.enrollDate = temp.enrollDate;
		this.delYn = temp.delYn;
		this.writerNo = temp.writerNo;
		this.writerNick = temp.writerNick;
	}
	
	// BoardVo 객체 필요하면 이거 쓰세요
	public static BoardTemp builder() {
		return new BoardTemp();
	}
	
	
	static class BoardTemp {
		private String no;
		private String title;
		private String content;
		private String enrollDate;
		private String delYn;
		private String writerNo;
		private String writerNick;

		public BoardTemp no(String no) {
			this.no = no;
			return this;
		}
		public BoardTemp title(String title) {
			this.no = title;
			return this;
		}
		public BoardTemp content(String content) {
			this.no = content;
			return this;
		}
		
		public BoardVo build() {
			return new BoardVo(this);
		}
	}
}
