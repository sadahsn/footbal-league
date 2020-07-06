package com.sapient.football.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class StandingsModel implements Serializable{
	
	private static final long serialVersionUID = 293425345251242342L;
	
	String country_name;
	Long league_id;
	String league_name;
	Long team_id;
	String team_name;
	Long overall_league_position;

	
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public Long getLeague_id() {
		return league_id;
	}
	public void setLeague_id(Long league_id) {
		this.league_id = league_id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	public Long getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public Long getOverall_league_position() {
		return overall_league_position;
	}
	public void setOverall_league_position(Long overall_league_position) {
		this.overall_league_position = overall_league_position;
	}
}
