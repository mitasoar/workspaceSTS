package com.kh.teamprj.vo;

import java.util.List;

// 게시글VO
public class BoardVO {
	private String boardNo; // 게시글 번호
	private String boardTitle; // 게시글 제목
	private String boardContent; // 게시글 내용
	private String boardWriter; // 작성자
	private String createDate; // 작성일
	private String updateDate; // 수정일
	private String isDelete; // 삭제 여부
	private String isNotice; // 공지사항 여부
	private String isSecret; // 비밀글 여부
	private String readCnt; // 조회수
	private String replyCnt; // 댓글수
	private String fileCnt; // 첨부파일수
	private List<FileVO> fileInfos; // 첨부파일 목록
	private String cateNo; // 게시글 카테고리
	private String cateName; // 카테고리 표시를 위한 변수
	private String rn; // 글번호를 표시하기 위한 rownum 변수
	private PagingVO paging; // 페이징 처리를 위한 페이징VO
	private MemberVO member; // 게시글 작성자의 정보를 담기 위한 멤버VO
	private ReplyVO reply; // 게시글 댓글 정보를 담기 위한 리플VO
	
	public String getFileCnt() {
		return fileCnt;
	}

	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
	}

	public List<FileVO> getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(List<FileVO> fileInfos) {
		this.fileInfos = fileInfos;
	}

	public ReplyVO getReply() {
		return reply;
	}

	public void setReply(ReplyVO reply) {
		this.reply = reply;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public String getIsSecret() {
		return isSecret;
	}

	public void setIsSecret(String isSecret) {
		this.isSecret = isSecret;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getIsNotice() {
		return isNotice;
	}

	public void setIsNotice(String isNotice) {
		this.isNotice = isNotice;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public PagingVO getPaging() {
		return paging;
	}

	public void setPaging(PagingVO paging) {
		this.paging = paging;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(String readCnt) {
		this.readCnt = readCnt;
	}

	public String getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(String replyCnt) {
		this.replyCnt = replyCnt;
	}

	public String getCateNo() {
		return cateNo;
	}

	public void setCateNo(String cateNo) {
		this.cateNo = cateNo;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", isDelete=" + isDelete + ", isNotice=" + isNotice + ", isSecret=" + isSecret + ", readCnt="
				+ readCnt + ", replyCnt=" + replyCnt + ", cateNo=" + cateNo + ", rn=" + rn + ", cateName=" + cateName
				+ ", paging=" + paging + ", member=" + member + ", reply=" + reply + "]";
	}

}
