'use strict'

angular.module('football.services', []).factory('FootballService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getLeaguePosition = function(leagueId,teamId,countryId) {
				var url = CONSTANTS.getLeaguePosition +'?league_id='+leagueId+'&team_id='+teamId+'&country_id='+countryId;
				return $http.get(url);
			}
			
			service.getAllLeagues = function() {
				return $http.get(CONSTANTS.getAllLeagues);
			}
			
			service.getAllTeams = function() {
				return $http.get(CONSTANTS.getAllTeams);
			}
			
			service.getAllCountries = function() {
				return $http.get(CONSTANTS.getAllCountries);
			}
			
			return service;
		} ]);