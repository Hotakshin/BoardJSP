package com.yedam.notice.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.vo.NoticeVO;

public class NoticeServiceImpl extends DAO implements NoticeService{
	PreparedStatement psmt;
	ResultSet rs;
	
	// 리스트 정렬하기 > 쿼리가 중요함
	public List<NoticeVO> noticeListPaging(int page) {
		String sql = "select b.* from ( select rownum rn, a.* from "
				+ "(select * from notice order by id)a)b"
				+ " where b.rn between ? and ?";
		
		// 한페이지당 10 개씩
		int firstCnt = 0; 
		int lastCnt = 0;
		
		List<NoticeVO> list = new ArrayList();
		firstCnt = (page -1) * 10 + 1; // 1, 11	
		lastCnt = (page * 10); // 10,20
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getInt("id"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				list.add(vo);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

		
	}
	
	//전체 리스트
	@Override
	public List<NoticeVO> noticeSelectList() {
		String sql = "select * from notice order by 1";
		List<NoticeVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	
	//한건 조회
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		String sql = "select * from notice where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				hitCount(vo.getId());
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	
	//한건입력
	@Override
	public int insertNotice(NoticeVO vo) {
		String sql = "insert into notice values(notice_seq.nextval, ?,?,sysdate,0)";
		int insert = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			
			insert = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return insert;
	}

	
	//한건 수정
	@Override
	public int updateNotice(NoticeVO vo) {
		String sql = "update notice set title = ?, content =? where id = ?";
		int update = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getId());
			
			update = psmt.executeUpdate();
			System.out.println(update + "건 수정이 완료되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return update;
	}

	
	//한건 삭제
	@Override
	public int deleteNotice(NoticeVO vo) {
		return 0;
	}
	
	public void hitCount(int id) {
		String sql = "update notice set hit = hit + 1 where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void close() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
