define(['jquery', 'underscore', 'backbone', 'models/player'],
    function($, _, Backbone, Player) {

        var PlayerCollection = Backbone.Collection.extend({
            model: Player,
            url: '/json/playerData.json',

            parse: function(response, options) {
                // ugly workaround due to the fact that the playerData.json contains multiple root properties and we only care about one
                if(response && response.playerList) {
                    return response.playerList;
                }
                return response;
            }
        });

        return PlayerCollection;
    }
);