'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:MainController
 * @description
 * # MainController
 * Controller of the auctionApp
 */
auctionApp
    .controller('MainController', ['$scope', 'AuthResource', 'AuthService',
        function ($scope, AuthResource, AuthService) {
            $scope.isAuthenticated = function () {
                return AuthService.isAuthenticated();
            }
        }
    ]);