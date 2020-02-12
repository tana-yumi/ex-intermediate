package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * 野球チーム一覧表示と詳細表示を制御するコントローラー.
 * @author tanaamiyumi
 *
 */
@Controller
@RequestMapping("/ex01")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	/**
	 * 一覧表示画面を表示させるメソッド.
	 * @param model　リクエストスコープ
	 * @return 野球チーム一覧表画面へ遷移
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList);
		return "team/teamlist";
	}
	
	/**
	 * 詳細表示画面を表示させるメソッド.
	 * @param id 主キー
	 * @param model　リクエストスコープ
	 * @return　詳細画面へ遷移
	 */
	@RequestMapping("/showDetile")
	public String showDetail(Integer id, Model model) {
		Team team = teamService.showDetail(id);
		model.addAttribute("team", team);
		return "team/detail";

	}
	
}
