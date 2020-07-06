package com.sapient.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.football.model.CountryModel;
import com.sapient.football.model.LeagueModel;
import com.sapient.football.model.StandingsModel;
import com.sapient.football.model.TeamModel;
import com.sapient.football.response.RestResponse;
import com.sapient.football.service.IFootballService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for Football
 * @author sadashiv.m
 *
 */
@RestController
@RequestMapping("/football")
@Slf4j
public class FootballController {

	@Autowired
	IFootballService footballService;
	
	@RequestMapping(method = { RequestMethod.GET},value = "/health")
    public String health() {
        return "health test api";
    }
	
	@GetMapping("/countries")
	public ResponseEntity<CountryModel[]> getCountries() {
		CountryModel[] countryModels = footballService.getAllCountries();
        return new ResponseEntity<>(countryModels, HttpStatus.OK);
    }
	
	@GetMapping("/teams")
	public ResponseEntity<TeamModel[]> getTeams(@RequestParam("league_id") Long league_id) {
		TeamModel[] teamModels = footballService.getTeamsByLeagueId(league_id);
        return new ResponseEntity<>(teamModels, HttpStatus.OK);
    }
	
	@GetMapping("/standings")
	public ResponseEntity<StandingsModel[]> getAllStandingsByLeagueId(@RequestParam("league_id") Long league_id) {
		StandingsModel[] standingsModels = footballService.getAllStandingsByLeagueId(league_id);
        return new ResponseEntity<>(standingsModels, HttpStatus.OK);
    }
	

	@GetMapping("/leagues")
	public ResponseEntity<LeagueModel[]> getAllLeagues(@RequestParam("country_id") Long country_id) {
		LeagueModel[] leagues = footballService.getAllLeaguesByCountryId(country_id);
        return new ResponseEntity<>(leagues, HttpStatus.OK);
    }
	

	@GetMapping("/league-position")
	public ResponseEntity<RestResponse<Long>> getLeaguePosition(@RequestParam("league_id") Long league_id,
			@RequestParam("team_id") Long team_id,
			@RequestParam("country_id") Long country_id) {
		RestResponse<Long> resp = new RestResponse<>();;
		try {
			Long position = footballService.getLeaguePosition(league_id, team_id, country_id);
			resp.setData(position);
			resp.setMessage("Successful");
		} catch (NotFoundException e) {
			resp.setMessage("Not ofund.");
		}
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
