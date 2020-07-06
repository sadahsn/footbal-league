package com.sapient.football.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LeagueModel implements Serializable {
	private static final long serialVersionUID = 242534525124352L;

	Long country_id;
	String country_name;
	String country_logo;
	Long league_id;
	String league_name;

	
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
	public Long getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Long country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getCountry_logo() {
		return country_logo;
	}
	public void setCountry_logo(String country_logo) {
		this.country_logo = country_logo;
	}
}
