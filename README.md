# Advanced Snake and Ladder
[(Full Documentation)](https://docs.google.com/document/d/1l6EzJuKTgMciO-4zhaYDu3L4lGqa5WYQBvoLRvGujYg/edit?usp=sharing)

<ul>

Enter the dimensions of the map and test your luck!


The game consists of various elements that I will mention:
<li>
Player: There is one player in the game who initially has 3 lives and moves around the screen randomly by rolling dice. (The player's movement is not necessarily linear) This player must reach the starting point (0,0) to the ending point (n,n) while still alive, in this case the game is over and the player wins. (If he loses his life, he loses).
</li>

<li>
Normal snake: At the beginning of the game, normal snakes are randomly placed at a specific point on the playing field, and after the start, the location of their heads (source) does not change. When the player comes to the head of these snakes, he is sent to the point that the tail of this snake points to (destination), which are randomly placed on the playing field every time. (That is, every time the player is placed on the head of these snakes, the player is sent to different places on the board).
</li>

<li>
Wild Snake: Wild snakes change their source every time the player rolls dice, and are placed randomly at a specific point on the playing field. When the player comes to the head of these snakes, he is sent to the point that the tail of this snake points to (destination), which are randomly placed on the playing field every time. (That is, every time the player is placed on the head of these snakes, the player is sent to different places on the board). These snakes have a very powerful bite that reduces 1 player's life if bitten.
</li>

<li>
Kind snake (ladder): Kind snakes are like normal snakes. At the beginning of the game, they are randomly placed at a specific point on the playing field, and after the start, the location of their heads (source) does not change. When the player comes to the head of these snakes, he is sent to the point that the tail of this snake points to (destination), which are randomly placed on the playing field every time. (That is, every time the player is placed on the head of these snakes, the player is sent to different places on the board). The only difference is that these snakes are kind enough to lift you up, so the position of the tail of these snakes should definitely be higher than their head on the screen.
</li>

<li>
Dice: The game dice is a 9-sided dice that includes one and two moves in the four directions left, right, up and down (8 sides). Also, one aspect of it includes the case of "extra life", which if the player appears, if he has less than 3 lives, he will get one life.
</li>
</ul>
