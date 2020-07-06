package com.sapient.football.service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.CountryModel;
import com.sapient.football.model.LeagueModel;
import com.sapient.football.model.StandingsModel;
import com.sapient.football.model.TeamModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service class for Football service
 * 
 * @author sadashiv.m
 *
 */
@Service("footballService")
@Slf4j
@RequiredArgsConstructor
public class FootballService implements IFootballService {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * Method to get all countries
	 * 
	 * @return countries
	 */
	public CountryModel[] getAllCountries() {
		ResponseEntity<CountryModel[]> response = restTemplate.getForEntity(Constants.GET_COUNTRIES_URL,
				CountryModel[].class);

		return response.getBody();
	}

	/**
	 * Method to get all standings
	 * 
	 * @param league_id
	 * @return standings
	 */
	public StandingsModel[] getAllStandingsByLeagueId(Long league_id) {
		String url = Constants.GET_STANDINGS_URL.replace("<league_id>", league_id.toString());
		ResponseEntity<StandingsModel[]> response = restTemplate.getForEntity(url, StandingsModel[].class);

		return response.getBody();
	}

	/**
	 * method to get teams by league id
	 * 
	 * @param league_id
	 * @return teams
	 */
	public TeamModel[] getTeamsByLeagueId(Long league_id) {
		String url = Constants.GET_TEAM_URL.replace("<league_id>", league_id.toString());
		ResponseEntity<TeamModel[]> response = restTemplate.getForEntity(url, TeamModel[].class);

		return response.getBody();
	}

	public Long getLeaguePosition(Long league_id, Long team_id, Long country_id) throws NotFoundException {

		CountryModel[] countryModels = getAllCountries();
		StandingsModel[] standingsModels = getAllStandingsByLeagueId(league_id);
		List<StandingsModel> standingsList = Arrays.asList(standingsModels);

		CountryModel country = Arrays.asList(countryModels).stream()
				.filter(c -> c.getCountry_id().equals(country_id)).findFirst().get();

		try {
			StandingsModel s = standingsList.stream()
					.filter(standings -> standings.getLeague_id().equals(league_id)
							&& standings.getTeam_id().equals(team_id)
							&& standings.getCountry_name().equalsIgnoreCase(country.getCountry_name()))
					.findFirst().get();
			if (s != null) {
				return s.getOverall_league_position();
			}	
		} catch (NoSuchElementException e) {
			throw new NotFoundException();
		}
		
		return null;
		
	}

	/**
	 * @param country_Id
	 * @return leagues
	 */
	@Override
	public LeagueModel[] getAllLeaguesByCountryId(Long country_id) {
		String url = Constants.GET_LEAGUE_URL.replace("<country_id>", country_id.toString());
		ResponseEntity<LeagueModel[]> response = restTemplate.getForEntity(url, LeagueModel[].class);

		return response.getBody();
	}

}
