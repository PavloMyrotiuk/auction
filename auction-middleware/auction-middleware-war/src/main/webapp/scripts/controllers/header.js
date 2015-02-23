'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:HeaderController
 * @description
 * # HeaderController
 * Controller of the auctionApp
 */
auctionApp
    .controller('HeaderController', ['$scope', '$rootScope', '$location', 'AuthResource',  'AuthService',
        function ($scope, $rootScope, $location, AuthResource,  AuthService) {
            AuthService.init();

            $scope.isAuthenticated = function () {
                var result = AuthService.isAuthenticated();
                if (result) $scope.user = $rootScope.user.name;
                return result
            };

            $scope.logout =function(){
                AuthResource.logout();
                AuthService.clear();
                $location.path('/');
            };

        }]);