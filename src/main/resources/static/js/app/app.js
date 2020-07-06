'use strict'

var footballApp = angular.module('football', [ 'ui.bootstrap', 'football.controllers',
		'demo.services' ]);
footballApp.constant("CONSTANTS", {
	getLeaguePosition : "/football/league-position",
	getAllCountries : "/football/countries",
	getAllTeams : "/football/teams",
	getAllLeagues : "/football/leagues"
		
});