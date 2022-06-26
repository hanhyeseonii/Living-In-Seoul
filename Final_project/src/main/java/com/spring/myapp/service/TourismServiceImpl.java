package com.spring.myapp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spring.myapp.advice.ErrorCode1;
import com.spring.myapp.dto.Page;
import com.spring.myapp.dto.Tourism;
import com.spring.myapp.repository.TourismRepository;

@Service
public class TourismServiceImpl implements TourismService {
	@Autowired
	private TourismRepository tourismRepository;
	
	@Override
	public List<Tourism> selectList(Page page) {
		//페이징 처리
		int curPage = page.getCurPage(); //현재페이지
		int perPage = page.getPerPage(); //한페이지당 게시물수
		int perBlock = page.getPerBlock(); //페이지 블럭의 수
		
		//1)게시물의 시작번호
		int startNum = (curPage-1) * perPage + 1;
		//2)게시물의 끝번호
		int endNum = startNum + perPage -1;
		
		//3)전체페이지수
		int totalCnt = tourismRepository.selectTotalCnt(page); //전체게시물수
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
		
		return tourismRepository.selectList(page);
	}

	@Override
	public Tourism selectOne(int tnum) {
		return tourismRepository.selectOne(tnum);
	}

	@Override
	public ErrorCode1 updateRemoveyn(int tnum) {
		tourismRepository.updateRemoveyn(tnum);
		return ErrorCode1.SUCCESS_REMOVE;
	}

	@Override
	public int updateLikeCnt(int tnum) {
		// TODO Auto-generated method stub
		return tourismRepository.updateLikeCnt(tnum);
	}

	@Override
	public int updateDisLikeCnt(int tnum) {
		return tourismRepository.updateDisLikeCnt(tnum);
		
	}

	@Override
	public ErrorCode1 insert(Tourism tourism) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorCode1 update(Tourism tourism, List<Integer> removeFiles) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReadCnt(int tnum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
