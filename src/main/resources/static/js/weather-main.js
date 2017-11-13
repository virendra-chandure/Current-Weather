angular.module('myApp', []).controller('myCtrl',
		[ '$scope', '$http', function($scope, $http) {
			$scope.error = {
				code : '',
				message : ''
			};
			$scope.locations = [];
			$scope.summary = {};

			$http({
				method : "GET",
				url : "/locations"
			}).then(function mySuccess(response) {
				$scope.locations = response.data.locations;
				$scope.selectedCity = $scope.locations[0];
				$scope.updateData();
			}, function myError(response) {
				$scope.error = response.statusText;
			});

			$scope.updateData = function() {
				$http({
					method : "GET",
					url : "/summary/" + $scope.selectedCity.country + "/" + $scope.selectedCity.city
				}).then(function mySuccess(response) {
					$scope.summary = response.data.summary;
				}, function myError(response) {
					$scope.error = response.statusText;
				});
			}

		} ]);
