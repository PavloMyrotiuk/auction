'use strict';

auctionApp
    .factory('BetResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/bet/", {}, {
            'bet': {
                method: 'POST'
            }
        });
    }]);