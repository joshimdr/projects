define([
  'marionette',
  'hbs!../../../templates/header'
], function(Marionette, HeaderTemplate) {
  'use strict';

  return Marionette.ItemView.extend({
    template: HeaderTemplate,
    ui: {
      input: '#new-todo'
    },
    events: {
      'keypress @ui.input': 'onInputKeypress',
      'keyup @ui.input': 'onInputKeyup'
    },
    onInputKeyup: function(e) {
      var ESC_KEY = 27;

      if (e.which === ESC_KEY) {
        this.render();
      }
    },
    onInputKeypress: function(e) {
      var ENTER_KEY = 13;
      var todoText = this.ui.input.val().trim();

      if (e.which === ENTER_KEY && todoText) {
        this.collection.create({
          description: todoText
        });
        this.ui.input.val('');
      }
    }
  });
});
