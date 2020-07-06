'use strict'

var module = angular.module('football.controllers', []);
module.controller("FootballController", [ "$scope", "FootballService",
		function($scope, FootballService) {

			$scope.userDto = {
				userId : null,
				userName : null,
				skillDtos : []
			};
			
			FootballService.getLeaguePosition(148,2611,41).then(function(value) {
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.find() = function() {
				$scope.userDto.skillDtos = $scope.skills.map(skill => {
					return {skillId: null, skillName: skill};
				});
				FootballService.findPosition($scope.userDto).then(function() {
					console.log("works");
					$scope.skills = [];
					$scope.userDto = {
						userId : null,
						userName : null,
						skillDtos : []
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
		} ]);

$scope.init() = function($scope) {
	FootballService.getAllCountries().then(function(resp) {
		console.log("works");
		$scope.countries = resp;
	}, function(reason) {
		console.log("error occured");
	}, function(value) {
		console.log("no callback");
	});
}
} ]);
