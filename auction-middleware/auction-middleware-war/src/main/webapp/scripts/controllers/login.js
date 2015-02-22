'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:LoginController
 * @description
 * # LoginController
 * Controller of the auctionApp
 */
auctionApp
    .controller('LoginController', ['$scope', 'AuthResource', 'AuthService',
        function ($scope, AuthResource, AuthService) {

            $scope.credentials = {
                username: '',
                password: ''
            };

            var resetCredentials = function () {
                $scope.credentials = {
                    username: '',
                    password: ''
                };
            }

            var resetPassword = function () {
                $scope.credentials.password = '';
            }

            $scope.login = function (credentials) {

                AuthResource.login($.param({username: credentials.username, password: credentials.password}),
                    function (authenticationResult) {
                        AuthService.authenticate(authenticationResult);
                        resetCredentials();
                    },
                    resetPassword()
                );
            };

        }]);

