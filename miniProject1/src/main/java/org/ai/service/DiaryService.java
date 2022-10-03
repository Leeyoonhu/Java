package org.ai.service;

import java.util.List;

import org.ai.domain.Criteria;
import org.ai.domain.DiaryVO;
import org.apache.ibatis.annotations.Param;

public interface DiaryService {
	public void insert(@Param("title")String title, @Param("writer")String writer, @Param("content") String content);
	public List<DiaryVO> show(@Param("writer")String writer);
	public List<DiaryVO> showPaging(@Param("writer")String writer, @Param("cri")Criteria cri);
	public DiaryVO get(@Param("diaryNumber")Integer diaryNumber);
}
