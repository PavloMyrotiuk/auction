'use strict';

auctionApp
    .factory('ProductResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/product/", {}, {
            'getByTemplate': {method: 'GET', isArray: true},
            'post': {method: 'POST'}
        });
    }]);