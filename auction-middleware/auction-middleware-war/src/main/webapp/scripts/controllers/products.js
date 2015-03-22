'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:ProductsController
 * @description
 * # ProductsController
 * Controller of the auctionApp
 */
auctionApp
    .controller('ProductsController', ['$scope', '$routeParams', 'ProductResource',
        function ($scope, $routeParams, ProductResource) {

            var product = {
                id: '',
                category: '',
                addedDate: '',
                validDate: '',
                price: '',
                title: '',
                description: '',
                productStatus: ''
            }

            var categoryName = $routeParams.categoryName;
            product.category = categoryName;

            ProductResource.getByTemplate(product, function (response) {
                $scope.products = response;
            });

        }
    ]);