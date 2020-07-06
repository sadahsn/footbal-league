package com.sapient.football.service;

public abstract class Constants {

	public static final String API = "https://apiv2.apifootball.com/";
	public static final String API_KEY = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
	public static final String GET_COUNTRIES_URL = API + "?action=get_countries&APIkey=" + API_KEY;
	public static final String GET_STANDINGS_URL = API + "?action=get_standings&league_id=<league_id>&APIkey=" + API_KEY;
	public static final String GET_TEAM_URL = API + "?action=get_teams&league_id=<league_id>&APIkey=" + API_KEY;
	public static final String GET_LEAGUE_URL = API + "?action=get_leagues&country_id=<country_id>&APIkey=" + API_KEY;
}
