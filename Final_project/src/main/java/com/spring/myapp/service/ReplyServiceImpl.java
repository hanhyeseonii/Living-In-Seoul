package com.spring.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.dto.Reply;
import com.spring.myapp.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyRepository replyRepository;
	
	@Transactional
	@Override
	public int insert(Reply reply) {
		//1)글레벨+1, 글순서+1 
		reply.setRelevel(reply.getRelevel()+1);
		reply.setRestep(reply.getRestep()+1);
		//2)글순서가 현재보다 크거나 작은데이터는 +1로 수정
		replyRepository.updateRestep(reply);
		//3)저장
		return replyRepository.insert(reply);
	}

	@Override
	public List<Reply> selectList(int bnum) {
		// TODO Auto-generated method stub
		return replyRepository.selectList(bnum);
	}

	@Override
	public int delete(int rnum) {
		// TODO Auto-generated method stub
		return replyRepository.delete(rnum);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return replyRepository.update(reply);
	}

}
