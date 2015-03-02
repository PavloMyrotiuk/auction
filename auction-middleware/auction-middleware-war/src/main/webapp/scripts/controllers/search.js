'use strict';

/**
 * @ngdoc function
 * @name auctionApp.controller:SearchProductController
 * @description
 * # SearchProductController
 * Controller of the auctionApp
 */
auctionApp
    .controller('SearchProductController', ['$scope', 'CategoryResource',
        function ($scope, CategoryResource) {
            $scope.oneAtATime = true;

            $scope.categories = CategoryResource.getHierarchy();
        }
    ]);