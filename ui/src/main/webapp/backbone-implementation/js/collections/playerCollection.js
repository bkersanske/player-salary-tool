define(['jquery', 'underscore', 'backbone', 'models/player'],
    function($, _, Backbone, Player) {

        var PlayerCollection = Backbone.Collection.extend({
            model: Player,
            url: '/api/players'
        });

        return PlayerCollection;
    }
);