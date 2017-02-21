define([
  'marionette',
  'app/views/todo-item-view',
  'hbs!../../../templates/todo-item-list'
], function(Marionette, TodoItemView, TodoItemListTemplate) {
  'use strict';

  return Marionette.CompositeView.extend({
    template: TodoItemListTemplate,
    childView: TodoItemView,
    childViewContainer: 'ul#todo-list',
    collectionEvents: {
      'change:completed': 'render'
    },
  });
});
