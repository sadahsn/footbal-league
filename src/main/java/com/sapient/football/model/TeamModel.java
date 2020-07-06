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
public class TeamModel implements Serializable {


	private static final long serialVersionUID = 99587746221242342L;
	
	Long team_key;
	String team_name;
	public Long getTeam_key() {
		return team_key;
	}
	public void setTeam_key(Long team_key) {
		this.team_key = team_key;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

}
