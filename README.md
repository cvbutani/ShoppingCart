# ShoppingCart

Create ShoppingCart program which contains information about current inventory.

It should have stock details and basket to add item in the cart.

Modify program so that adding items to the shopping basket doesn't actually reduce the stock count but, instead, reserves the requested  number of items.

You will need to add a "reserved" field to the StockIist class to store the number of items reserved.

Items can continue to be added to the basket, but it should not be possible to reserve more than the available stock of any item. 

An item's available stock is the stock count less the reserved amount.

The stock count for each item is reduced when a basket is checked out, at which point all reserved items in the basket have their actual stock count reduced.

Once checkout is complete, the contents of the basket are cleared.

It should also be possible to "unreserve" items that were added to the basket by mistake.

Add code to Main that will unreserve items after they have been added to the basket as well as unreserving items that have not been added to make sure that the code can cope with invalid requests like that.

After checking out the baskets, display the full stock list and the contents of each basket that you created.
