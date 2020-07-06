package com.sapient.football.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sapient.football.model.CountryModel;
import com.sapient.football.model.LeagueModel;
import com.sapient.football.model.StandingsModel;
import com.sapient.football.model.TeamModel;

public interface IFootballService {
	public CountryModel[] getAllCountries();
	public StandingsModel[] getAllStandingsByLeagueId(Long league_id);
	public TeamModel[] getTeamsByLeagueId(Long league_id);
	public LeagueModel[] getAllLeaguesByCountryId(Long country_Id);
	public Long getLeaguePosition(Long league_id, Long team_id, Long country_id) throws NotFoundException ;
}
