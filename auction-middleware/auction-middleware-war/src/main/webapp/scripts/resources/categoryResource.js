'use strict';

auctionApp
    .factory('CategoryResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/category/");
    }]);