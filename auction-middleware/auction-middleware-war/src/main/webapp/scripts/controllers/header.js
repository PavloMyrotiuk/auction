'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:HeaderController
 * @description
 * # HeaderController
 * Controller of the auctionApp
 */
auctionApp
    .controller('HeaderController', ['$scope', '$rootScope', 'AuthResource',  'AuthService', 'SECURITY',
        function ($scope, $rootScope, AuthResource,  AuthService, SECURITY) {
            AuthService.init();

            $scope.isAuthenticated = function () {
                var result = $rootScope[SECURITY.AUTH_USER_KEY] !== undefined;
                if (result) $scope.user = $rootScope.user.name;
                return result
            };

            $scope.logout =function(){
                AuthResource.logout();
                AuthService.clear();
            };

        }]);