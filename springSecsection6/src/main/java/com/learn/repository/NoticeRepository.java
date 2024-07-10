package com.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.entity.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

	@Query(value = "from Notice n where CURRENT_DATE BETWEEN n.noticBegDt AND n.noticEndDt")
	List<Notice> findAllActiveNotices();

}
