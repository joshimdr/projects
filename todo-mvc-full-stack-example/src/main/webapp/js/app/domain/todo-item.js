define([
  "backbone"
], function(Backbone) {
  "use strict";

  return Backbone.Model.extend({
  	toggle: function () {
  	  return this.set("completed", !this.isCompleted());
  	},
  	isCompleted: function () {
        return this.get("completed");
  	},
  	matchesFilter: function (filter) {
      if (filter === "all") {
        return true;
  	  }

      if (filter === "active") {
        return !this.isCompleted();
      }

      return this.isCompleted();
  	}
  });
});