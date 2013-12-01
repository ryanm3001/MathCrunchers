MathCrunchers 0.1
=============

MathCrunchers is a math game that covers addition, subtraction, multiplication and division. It's intended for
girls and boys of primary school age. As the user progresses to higher levels, the problems get more difficult. Throughout the game, the user is consistently provided with 2 kinds of feedback: 1) Congratulatory statements when she get's a problem right and 2) Encouraging statements when she makes a mistake. To keep the game not-boring, both types of statements are implemented with Java Random api, which provides the user with different statements at random (see methods congratulatePerProblem() and encouragePerProblem() below).

Future plans include using Javascript to implement this as web app. 
Original? No. This has been done a thousand ways, a thousand times. 
An opportunity to change 1 child's life forever? Yes.
 
It will be made available free of charge to all.

=============

Currently, MathCrunchers is only implemented as an Addition game. Subtraction, Multiplication, Division and Mixed versions are in the works.

=============

Version 0.1 is runnable

From the command line:

javac MathCrunchers.java

java MathCrunchers

=============

You can choose how how many problems per level, and how many total levels you want. Simply change these 2 parameters in the main method:

MathCrunchers game1 = new MathCrunchers(3, 10);

This is currently set to 3 problems per level (useful for testing) with 10 levels.


The game will not support more than 10 problems per level, and more than 10 levels total.

