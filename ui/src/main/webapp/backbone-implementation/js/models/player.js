define(['jquery', 'underscore', 'backbone', 'moment'],
    function ($, _, Backbone, moment) {

        var Player = Backbone.Model.extend({
            idAttribute: "pid",
            defaults: {
                tentativeSalary: null,
                ExceptionalMessages: [],
                IsDisabledFromDrafting: null,
                atabbr: null,
                atid: null,
                fn: null,
                fnu: null,
                htabbr: null,
                htid: null,
                i: null,
                ln: null,
                lnu: null,
                news: null,
                opn: null,
                or: null,
                pcode: null,
                pid: null,
                pn: null,
                posid: null,
                pp: null,
                ppg: null,
                s: null,
                slo: null,
                swp: null,
                tid: null,
                tsid: null,
            },

            forTemplate: function() {
                var j = $.extend(true, {}, this.attributes);
                j.isInjured = (this.get("i") !== null && this.get("i").length);
                j.formattedSalary = "$" + commaNumberFormatter(this.get("s"));
                j.upcomingGame = this.get("atabbr") + " @ " + this.get("htabbr");
                return j;
            }
        });

        return Player;

    }
);