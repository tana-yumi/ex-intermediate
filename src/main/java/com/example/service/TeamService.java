package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チーム情報を操作するサービス.
 * @author tanaamiyumi
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * 全件検索を行うメソッド.
	 * @return 野球チーム全件情報
	 */
	public List<Team> showList(){
		List<Team> teamList = teamRepository.findAll();
		
		return teamList;
	}
	
	/**
	 * 野球チームの詳細情報を主キーで取得するメソッド.
	 * @param id 主キー
	 * @return　主キー検索
	 */
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
		
	}

}
