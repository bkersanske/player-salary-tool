define(['jquery', 'underscore', 'backbone', 'collections/playerCollection', 'templates'],
    function($, _, Backbone, PlayerCollection) {

        var PlayersTableView = Backbone.View.extend({

            el: '#main-content',

            initialize: function (options) {
                this.render();
                this.model = new PlayerCollection();
                this.listenTo(this.model, {sync: this.handlePlayersLoaded});
                this.model.fetch();
            },

            render: function() {
                $(this.el).html(Handlebars.templates.players_table);
            },

            handlePlayersLoaded: function() {
                var that = this;
                this.model.each(function(player) {
                    $(that.el).find('#players-table tbody').append(Handlebars.templates.players_table_row(player.forTemplate()));
                });
            }
        });

        return PlayersTableView;
    }
);