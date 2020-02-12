package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

@Repository
public class TeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Team> TEAM_ROW_MAPPER= (rs,i)->{
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getDate("inauguration"));
		team.setHistory(rs.getString("history"));
		
		return team;
	
	};
	
	public List<Team> findAll(){
		String sql = "SELECT id,league_name,team_name, headquarters,inauguration,history From teams ORDER BY inauguration;";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}
	public Team load(Integer id) {
		String sql = "SELECT team_name, headquarters,inauguration FROM teams WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource("id",id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		
		return team;
	}
	
	
	
}
