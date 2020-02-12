package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothe;

@Repository
public class ClotheRepository {

	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Clothe> Clothe_ROW_MAPPER = (rs,i)->{
		Clothe clothe = new Clothe();
		clothe.setId(rs.getInt("id"));
		clothe.setCategory(rs.getString("category"));
		clothe.setGenre(rs.getString("genre"));
		clothe.setGender(rs.getInt("gender"));
		clothe.setColor(rs.getString("color"));
		clothe.setPrice(rs.getInt("price"));
		clothe.setCategory(rs.getString("size"));
		
		return clothe;
	};

}
