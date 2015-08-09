define(['jquery', 'underscore', 'backbone', 'moment'],
    function ($, _, Backbone, moment) {

        var commaNumberFormatter = function(value) {
            if (parseFloat(value) < 1000) {
                return value;
            } else {
                return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            }
        };

        var Player = Backbone.Model.extend({
            urlRoot: '/api/players',
            defaults: {
                id: null,
                firstName: null,
                lastName: null,
                positionName: null,
                team: null,
                injuryStatus: null,
                salary: null,
                updated: null
            },

            forTemplate: function() {
                var j = $.extend(true, {}, this.attributes);
                j.lastUpdated = moment(this.get("updated")).format('MM/DD/YY @ HH:MMa');
                j.formattedSalary = "$" + commaNumberFormatter(this.get("salary"));
                return j;
            }
        });

        return Player;

    }
);