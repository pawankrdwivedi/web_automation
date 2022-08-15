Feature: Test the ToDoMVC user URL for DT Testing

  Background:
    Given Open the given URL in a Browser.

  @Test
  Scenario Outline: Add an item in ToDo list.
    When add the Item: "<item>" in To Do list.
    Examples:
      | item   |
      | Item 1 |

  @Test
  Scenario Outline: Mark an added item in ToDo list as 'Complete'.
    When add the TODO "<item>" to the list.
    Then mark the added "<item>" complete.
    Examples:
      | item   |
      | Item 2 |

  @Test
  Scenario Outline: Mark a completed item in ToDo list as 'Active'.
    When add the TODO "<item>" to the list.
    Then mark the added "<item>" complete.
    Then mark the completed "<item>" as active.
    Examples:
      | item   |
      | Item 3 |

  @Test
  Scenario Outline: Delete an item from ToDo list.
    When add the TODO "<item>" to the list.
    Then Delete "Item 4" from to do list.
    Examples:
      | item   |
      | Item 4 |

  @Test
  Scenario Outline: Add multiple items in ToDo List.
    When add multiple items to the TODO "<item>" to the list.
    Then Count added items in to do list.
    Examples:
      | item                                           |
      | Item 1<>Item 2<>Item 3<>Item 4<>Item 5<>Item 6 |

  @Test
  Scenario Outline: Apply 'Active'/'Completed' filter and verify count in ToDo list.
    When add multiple items to the TODO "<item>" to the list.
    Then Count added items in to do list.
    Then mark the added "Item 3" complete.
    Then Count Completed and Active in to do list.
    Examples:
      | item                                           |
      | Item 1<>Item 2<>Item 3<>Item 4<>Item 5<>Item 6 |