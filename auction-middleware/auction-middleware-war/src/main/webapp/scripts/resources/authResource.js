'use strict';

auctionApp
    .factory('AuthResource', ['$resource', function ($resource) {
        return $resource("/auction-middleware/rest/auth/:action", {}, {
            'login': {
                method: 'POST',
                params: {'action': 'authenticate'},
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                interceptor: {responseError: resourceErrorInterceptor}
            },
            'logout':{
                method: 'POST',
                params: {'action': 'logout'},
                interceptor: {responseError: resourceErrorInterceptor}
            }
        });
    }]);