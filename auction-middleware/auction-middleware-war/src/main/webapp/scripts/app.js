'use strict';

/**
 * @ngdoc overview
 * @name auctionApp
 * @description
 * # auctionApp
 *
 * Main module of the application.
 */
var auctionApp = angular.module('auctionApp', ['ngResource', 'ngRoute', 'ngCookies', 'ui.bootstrap'])
                        .constant('SECURITY', {'AUTH_USER_KEY' : 'user', 'AUTH_USER_ROLE': 'ROLE_USER'})
                        .constant('DATE', {'YEAR' : 365, 'FORMAT': 'dd-MMMM-yyyy'})
                        ;

auctionApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'MainController'
        })
        .when('/signup', {
            templateUrl: 'views/signup.html',
            controller: 'SignUpController'
        })
        .when('/search', {
            templateUrl: 'views/search.html',
            controller: 'SearchProductController'
        })
        .when('/add', {
            templateUrl: 'views/add.html',
            controller: 'AddProductController'
        })
        .when('/products/:categoryName', {
            templateUrl: 'views/products.html',
            controller: 'ProductsController'
        })
        .when('/product/:id', {
            templateUrl: 'views/product.html',
            controller: 'ProductController'
        })
        .otherwise({
            redirectTo: '/'
        });
});
