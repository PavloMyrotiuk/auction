'use strict';

auctionApp
    .service('AuthService', ['$http', '$rootScope', '$cookieStore', 'SECURITY',
        function ($http, $rootScope, $cookieStore, SECURITY) {

            this.authenticate = function (authenticationResult) {
                var user = {
                    userId: authenticationResult.userId,
                    username: authenticationResult.username,
                    name: authenticationResult.name,
                    roles: authenticationResult.roles,
                    validDate: authenticationResult.validDate
                }
                $rootScope[SECURITY.AUTH_USER_KEY] = user;
                $cookieStore.put(SECURITY.AUTH_USER_KEY, user);
            };

            this.init = function () {
                var userIsNotInRootScope = $rootScope[SECURITY.AUTH_USER_KEY] === undefined;
                var userInCookies = $cookieStore.get(SECURITY.AUTH_USER_KEY);
                if (userIsNotInRootScope && userInCookies && userInCookies.validDate > new Date().getTime()) {
                    $rootScope[SECURITY.AUTH_USER_KEY] = userInCookies;
                }
                ;
            };

            this.clear = function () {
                $rootScope[SECURITY.AUTH_USER_KEY] = undefined;
                $cookieStore.remove(SECURITY.AUTH_USER_KEY);
            };

            this.isAuthenticated = function () {
                var user = $rootScope[SECURITY.AUTH_USER_KEY];
                if (user !== undefined){
                    return user.roles.indexOf(SECURITY.AUTH_USER_ROLE)!== -1;
                }
                return false;
            };

            this.getUserId = function(){
                return $rootScope[SECURITY.AUTH_USER_KEY].userId;
            }

            return this;
        }]);