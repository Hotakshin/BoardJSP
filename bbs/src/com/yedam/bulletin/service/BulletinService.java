package com.yedam.bulletin.service;

import java.util.List;

import com.yedam.bulletin.vo.BulletinVO;

public interface BulletinService {
	//리스트, 한건조회, 입력, 수정 , 삭제 
	
	List<BulletinVO> bulletinSelectList();
	BulletinVO bulletinSelect(BulletinVO vo);
	int insertBulletin(BulletinVO vo);
	int updateBulletin(BulletinVO vo);
	int deleteBulletin(BulletinVO vo);
}
