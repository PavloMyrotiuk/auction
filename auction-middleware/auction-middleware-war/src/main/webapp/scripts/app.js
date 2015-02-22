'use strict';

/**
 * @ngdoc overview
 * @name auctionApp
 * @description
 * # auctionApp
 *
 * Main module of the application.
 */
var auctionApp = angular.module('auctionApp', ['ngResource', 'ngRoute', 'ngCookies'])
                        .constant('SECURITY', {'AUTH_USER_KEY' : 'user'});

auctionApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'MainController'
        })
        .when('/about', {
            templateUrl: 'views/about.html',
            controller: 'AboutCtrl'
        })
        .when('/signup', {
            templateUrl: 'views/signup.html',
            controller: 'SignUpController'
        })
        .otherwise({
            redirectTo: '/'
        });
});
