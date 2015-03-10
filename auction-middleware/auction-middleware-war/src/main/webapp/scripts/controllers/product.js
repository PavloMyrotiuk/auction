'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:ProductController
 * @description
 * # ProductController
 * Controller of the auctionApp
 */
auctionApp
    .controller('ProductController', ['$scope', '$routeParams', 'ProductResource',
        function ($scope, $routeParams, ProductResource) {

            var product = {
                id: '',
                category: '',
                addedDate: '',
                validDate: '',
                price: '',
                title: '',
                description: '',
                productStatus: '',
                userId: '',
                winnerId: '',
                version: ''
            }

            var id = $routeParams.id;

            ProductResource.getById({id: id}, function (response) {
                $scope.product = response;
            });
        }
    ]);