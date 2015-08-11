define(['jquery', 'underscore', 'backbone', 'collections/playerCollection', 'datatables', 'templates'],
    function($, _, Backbone, PlayerCollection) {

        var PlayersTableView = Backbone.View.extend({

            el: '#main-content',

            events: {
                'click td[data-attr="s"]' : 'handlePlayerSalaryCellClicked',
                'blur input.salary-edit'  : 'handlePlayerSalaryEditingDone',
                'click .undo-button'      : 'handleUndoButtonClicked',
                'click #save-button'      : 'handleSaveButtonClicked'
            },

            initialize: function (options) {
                _.bindAll(this, "handlePlayerSalaryCellClicked");
                _.bindAll(this, "handlePlayerSalaryEditingDone");
                _.bindAll(this, "handleSaveButtonClicked");
                _.bindAll(this, "handleUndoButtonClicked");
                this.render();
                this.model = new PlayerCollection();
                this.listenTo(this.model, {sync: this.handlePlayersLoaded});
                this.model.fetch();
            },

            render: function() {
                $(this.el).html(Handlebars.templates.players_table);
            },

            handlePlayersLoaded: function() {
                this.model.each(function(player) {
                    $('#players-table tbody').append(Handlebars.templates.players_table_row(player.forTemplate()));
                });
                $('#players-table').DataTable( {
                    "order": [[1, "asc"]]
                });
            },

            handlePlayerSalaryCellClicked: function(evt) {
                var $playerRow = $(evt.target).parents('tr');
                var playerId = $playerRow.attr('data-player-id');
                var $playerSalaryCell = $('tr[data-player-id="' + playerId + '"] td[data-attr="s"]');
                if(!$playerSalaryCell.find('input').length) {
                    var player = this.model.get(playerId);
                    if(player.get("tentativeSalary")) {
                        $playerSalaryCell.find('span.val').replaceWith('<input class="salary-edit" type="text" value="' + player.get("tentativeSalary") + '"></input>');
                    } else {
                        $playerSalaryCell.find('span.val').replaceWith('<input class="salary-edit" type="text" value="' + player.get("s") + '"></input>');
                    }
                }
            },

            handlePlayerSalaryEditingDone: function(evt) {
                var playerId = $(evt.target).parents('tr').attr('data-player-id');
                var player = this.model.get(playerId);
                var updatedSalary = $(evt.target).val();
                var $playerSalaryCell = $('tr[data-player-id="' + playerId + '"] td[data-attr="s"]');
                if(player.get("s") !== updatedSalary) {
                    player.set("tentativeSalary", updatedSalary);
                    $playerSalaryCell.addClass('green-background');
                    $('#save-button').removeClass('disabled-button');
                    $playerSalaryCell.find('.undo-button').animate({opacity: 1});
                } else {
                    $playerSalaryCell.removeClass('green-background');
                    $playerSalaryCell.find('.undo-button').animate({opacity: 0});
                }
                $playerSalaryCell.find('input').replaceWith('<span class="val">$' + commaNumberFormatter(updatedSalary) + '</span>');
            },

            handleUndoButtonClicked: function(evt) {
                evt.stopImmediatePropagation();
                var playerId = $(evt.target).parents('tr').attr('data-player-id');
                var player = this.model.get(playerId);
                player.set("tentativeSalary", null);
                var $playerSalaryCell = $('tr[data-player-id="' + playerId + '"] td[data-attr="s"]');
                $playerSalaryCell.find('input').replaceWith('<span class="val">$' + commaNumberFormatter(player.get("s")) + '</span>');
                $playerSalaryCell.removeClass('green-background');
                $playerSalaryCell.find('.undo-button').animate({opacity: 0});
            },

            handleSaveButtonClicked: function(evt) {
                if(!$(evt.target).hasClass('disabled-button')) {
                    var changedPlayers = [];
                    this.model.each(function(player) {
                        if(player.get("tentativeSalary")) {
                            player.set("s", player.get("tentativeSalary"));
                            player.set("tentativeSalary", null);
                            var $playerSalaryCell = $('tr[data-player-id="' + player.get("pid") + '"] td[data-attr="s"]');
                            $playerSalaryCell.removeClass('green-background');
                            $playerSalaryCell.find('.undo-button').animate({opacity: 0});
                            changedPlayers.push({pid: player.get("pid"), s: player.get("s")});
                        }
                    });
                    $(evt.target).addClass('disabled-button');
                }
                console.log(changedPlayers);
            }
        });

        return PlayersTableView;
    }
);