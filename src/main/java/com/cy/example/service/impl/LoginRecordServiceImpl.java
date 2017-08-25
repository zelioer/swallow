package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.example.Vo.PageVo;
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.mapper.LoginRecordMapper;
import com.cy.example.service.LoginRecordService;

@Service
public class LoginRecordServiceImpl implements LoginRecordService{

	@Autowired
	private LoginRecordMapper loginRecordMapper;
	
	public int add(LoginRecordEntity loginRecord) {
		// TODO Auto-generated method stub
		return loginRecordMapper.add(loginRecord);
	}

	public List<LoginRecordEntity> findAll(PageVo page) {
		return loginRecordMapper.findAll(page);
	}

	public int findAllCount(PageVo page) {
		return loginRecordMapper.findAllCount(page);
	}

	public List<LoginRecordEntity> searchAll(LoginRecordEntity loginRecord,
			PageVo page) {
		// TODO Auto-generated method stub
		return loginRecordMapper.searchAll(loginRecord, page);
	}

	public int searchAllCount(LoginRecordEntity loginRecord, PageVo page) {
		// TODO Auto-generated method stub
		return loginRecordMapper.searchAllCount(loginRecord, page);
	}

}
