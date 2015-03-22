'use strict';

auctionApp
    .service('AuthService', ['$http', '$rootScope', '$cookieStore', 'SECURITY',
        function ($http, $rootScope, $cookieStore, SECURITY) {

            this.authenticate = function (authenticationResult) {
                var token = {
                    userId: authenticationResult.user.userId,
                    username: authenticationResult.user.username,
                    name: authenticationResult.user.name,
                    roles: authenticationResult.user.roles,
                    validDate: authenticationResult.validDate
                }
                $rootScope[SECURITY.AUTH_TOKEN_KEY] = token;
                $cookieStore.put(SECURITY.AUTH_TOKEN_KEY, token);
            };

            this.init = function () {
                var userIsNotInRootScope = $rootScope[SECURITY.AUTH_TOKEN_KEY] === undefined;
                var userInCookies = $cookieStore.get(SECURITY.AUTH_TOKEN_KEY);
                if (userIsNotInRootScope && userInCookies && userInCookies.validDate > new Date().getTime()) {
                    $rootScope[SECURITY.AUTH_TOKEN_KEY] = userInCookies;
                }
                ;
            };

            this.clear = function () {
                $rootScope[SECURITY.AUTH_TOKEN_KEY] = undefined;
                $cookieStore.remove(SECURITY.AUTH_TOKEN_KEY);
            };

            this.isAuthenticated = function () {
                var user = $rootScope[SECURITY.AUTH_TOKEN_KEY];
                if (user !== undefined){
                    return user.roles.indexOf(SECURITY.AUTH_USER_ROLE)!== -1;
                }
                return false;
            };

            return this;
        }]);