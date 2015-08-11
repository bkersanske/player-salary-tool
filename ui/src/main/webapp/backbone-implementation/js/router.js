define(['jquery', 'underscore', 'backbone', 'viewManager'],
    function($, _, Backbone, ViewManager) {

        var AppRouter = Backbone.Router.extend({
            routes: {
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

            Backbone.history.start();
        };

        return {
            initialize: initialize
        };
    }
);