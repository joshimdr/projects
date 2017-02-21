define([
  "marionette",
  "hbs!../../../templates/footer"
], function(Marionette, FooterTemplate) {
  "use strict";

  return Marionette.ItemView.extend({
    template: FooterTemplate,
    ui: {
      summary: "#todo-count",
    },
    collectionEvents: {
      all: "render"
    },
    templateHelpers: {
      activeCountLabel: function() {
        return (this.activeCount === 1 ? "item" : "items") + " left";
      }
    },
    serializeData: function() {
      var active = this.collection.getActive().length;
      var total = this.collection.length;

      return {
        activeCount: active,
        totalCount: total,
        completedCount: total - active
      };
    },
    onRender: function() {
      this.$el.parent().toggle(this.collection.length > 0);
    }
  });
});