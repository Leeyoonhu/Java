package org.ai.mapper;

import java.util.List;

import org.ai.domain.Criteria;
import org.ai.domain.DiaryVO;
import org.apache.ibatis.annotations.Param;

public interface DiaryMapper {
	// 일기 쓰기
	public void insert(@Param("title")String title, @Param("writer")String writer, @Param("content") String content);
	// 일기 리스트 보기
	public List<DiaryVO> show(@Param("writer")String writer);
	// 일기 페이징 조회
	public List<DiaryVO> showPaging(@Param("writer")String writer, @Param("cri")Criteria cri);
	// 일기 보기
	public DiaryVO get(@Param("diaryNumber")Integer diaryNumber);
}
