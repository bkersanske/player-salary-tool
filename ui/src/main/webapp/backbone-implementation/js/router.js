define(['jquery', 'underscore', 'backbone', 'viewManager'],
    function($, _, Backbone, ViewManager) {

        var AppRouter = Backbone.Router.extend({
            routes: {
                'players/:id'   : 'player',
                '*actions'      : 'defaultAction'
            }
        });

        var initialize = function(options) {
            var appView = options.appView;
            var router = new AppRouter(options);

            router.on('route:defaultAction', function(actions) {
                require(['views/playersTable'], function(PlayersTableView) {
                    ViewManager.create(appView, 'PlayersTableView', PlayersTableView);
                });
            });

            router.on('route:player', function(playerId) {
                require(['views/player'], function(PlayerView) {
                    ViewManager.create(appView, 'PlayerView', PlayerView);
                });
            });

            Backbone.history.start();
        };

        return {
            initialize: initialize
        };
    }
);