'use strict';

auctionApp
    .factory('ProductResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/product/:id", {}, {
            'getByTemplate': {method: 'GET', isArray: true},
            'getById': {method: 'GET'},
            'post': {method: 'POST'}
        });
    }]);