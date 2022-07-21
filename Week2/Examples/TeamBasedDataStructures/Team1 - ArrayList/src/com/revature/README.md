## Group 1 Array List ##

## What is an ArrayList ? ##
- ArrayList is a resizable array implementation in java.
- The backing data structure of ArrayList is an array of Object class.
- When creating an ArrayList you can provide initial capacity then the array is declared with the given capacity.
- The default capacity value is 10. If the initial capacity is not specified by the user then the default capacity is used to create an array of objects.
- When an element is added to an ArrayList it first checks whether the new element has room to fill or it needs to grow the size of the internal array, If capacity has to be increased then the new capacity is calculated which is 50% more than the old capacity and the array is increased by that capacity.
## Are there different ways to implement it? If so, what are they?

- There are multiple ways to implement array lists
- Either through the provided language libraries e.g. Java Collections
  - import java.util.ArrayList;
- You can also implement it yourself or extend the ArrayList class

## What is your data structure useful for? ##
- ArrayList in Java is used to store dynamically sized collection of elements. Contrary to Arrays that are fixed in size, an ArrayList grows its size automatically when new elements are added to it.

### Where would you want to use it, vs when is it not useful? ###

#### Pros: ####
- When you need an array but don't know the size that it needs to be
- Good at sorting the information stored within the array
#### Cons: ####
- If you want to refer to specific values in the array list searching the list is slow
