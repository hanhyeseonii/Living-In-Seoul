package com.spring.myapp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spring.myapp.advice.ErrorCode;
import com.spring.myapp.advice.ErrorCode1;
import com.spring.myapp.dto.Board;
import com.spring.myapp.dto.BoardFile;
import com.spring.myapp.dto.Page;
import com.spring.myapp.repository.BoardFileRepository;
import com.spring.myapp.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private BoardFileRepository boardFileRepository; 
	
	@Autowired
	private FileService fileService;
	
	@Override
	public List<Board> selectList(Page page) {
		//페이징 처리
		int curPage = page.getCurPage(); //현재페이지
		int perPage = page.getPerPage(); //한페이지당 게시물수
		int perBlock = page.getPerBlock(); //페이지 블럭의 수
		
		//1)게시물의 시작번호
		int startNum = (curPage-1) * perPage;
		//2)게시물의 끝번호
		int endNum = startNum + perPage -1;
		
		//3)전체페이지수
		int totalCnt = boardRepository.selectTotalCnt(page); //전체게시물수
		int totPage = totalCnt/perPage;
		if (totalCnt%perPage!=0) totPage++; //나머지가 있으면 +1
		
		//4)페이지블럭의 시작페이지
		int startPage= curPage - ((curPage-1)%perBlock);
		//5)페이지블럭의 끝페이지
		int endPage = startPage + perBlock - 1;
		if (endPage>totPage) endPage=totPage; //endPage는 totPage보다 작거나 같아야 한다

		
		//page 세팅
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		page.setStartPage(startPage);
		page.setEndPage(endPage);
		page.setTotPage(totPage);
		
		return boardRepository.selectList(page);
	}

	@Override
	public Board selectOne(int bnum) {
		return boardRepository.selectOne(bnum);
	}

	//트랜잭션 관리(commit,rollback)
	@Transactional
	@Override
	public ErrorCode1 insert(Board board) throws Exception {
		//1)게시물 추가
		//insert시 bnum세팅
		boardRepository.insert(board);
		
		//2)게시물 파일들 업로드 후 저장
		boardFilesSave(board);
		
		return ErrorCode1.SUCCESS_ADD;
		
	}

	@Override
	public int updateReadCnt(int bnum) {
		// TODO Auto-generated method stub
		return boardRepository.updateReadCnt(bnum);
	}
	
	//트랜잭션 관리
	@Transactional
	@Override
	public ErrorCode1 update(Board board, List<Integer> removeFiles) throws Exception {
		//1) 게시물수정
		boardRepository.update(board);
		//2) 게시물파일 db 삭제
		if (removeFiles!= null) {
			for(int bfnum : removeFiles) {
				boardFileRepository.delete(bfnum);
			}
		}
		//3)게시물 파일들 업로드 후 저장
		boardFilesSave(board);
		
		return ErrorCode1.SUCCESS_MODIFY;
	}
	
	private void boardFilesSave(Board board) throws Exception {
		//게시물 파일들 저장
		List<MultipartFile> files = board.getFiles();
		for(MultipartFile file:files) {
			String filename = fileService.fileUpload(file); 		//파일을 저장
			if (filename.equals("")) continue;  //파일이름이 공백일경우 저장하지 않는다

			//게시물파일db저장 
			BoardFile boardFile = new BoardFile();
			boardFile.setBnum(board.getBnum()); //게시물의 bnum세팅
			boardFile.setFilename(filename);
			boardFileRepository.insert(boardFile);
		}
	}

	@Override
	public ErrorCode1 updateRemoveyn(int bnum) {
		boardRepository.updateRemoveyn(bnum);
		return ErrorCode1.SUCCESS_REMOVE;
	}

	@Override
	public int updateLikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return boardRepository.updateLikeCnt(bnum);
	}

	@Override
	public int updateDisLikeCnt(int bnum) {
		return boardRepository.updateDisLikeCnt(bnum);
		
	}
	
	@Override
	public List<Board> selectNew(){
		return boardRepository.selectNew();
	}
	
	@Override
	public List<Board> selectHot(){
		return boardRepository.selectHot();
	}
	
	

}
