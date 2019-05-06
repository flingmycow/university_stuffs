// 11111111111111111111111111111111111111111111111111111 //
// SETUP STAGE OF ULLRICH'S ASSIGNMENT / TREASURE GAME!! //
// 11111111111111111111111111111111111111111111111111111 //

// Variables to be used in the program (these ones are self-explanatory)
var noOfRounds = 0;
var userScore = 0;
var compScore = 0;
var userRobot = 1;
var treasure = 0;
var noOfTreasure = 0;

// variables used to stop/allow certain functions to work depending on what stage the game is in
var play = new Boolean(1); // If these variables are = to 1 then they are TRUE
var end = new Boolean(1);
var movement = new Boolean(1);
movement = 0;

// variables for co-ordinates of the robot
var userRobotX;
var userRobotY;

var compRobotX;
var compRobotY;

// variables used for detecting whether the robot's are stuck or not
var userStuck = new Boolean(1);
userStuck = 0;
var compStuck = new Boolean(1);
compStuck = 0;

var size = prompt("What size grid would you like?",""); 

array = new Array(size);

for (i = 0; i < size; i++) 
{
  array[i] = new Array(size);
  
  for (j = 0; j < size; j++)
  {	
  	array[i][j] = ' ';
  }
}

// Simply shows a 10x10 grid.
function showTable(array) 
{
  document.writeln("<center><table border='1'>\n");
  for (i = 0;i < array.length; i++) 
  {
  	document.writeln("<tr>");
  	for (j = 0;j < array[i].length; j++) 
  	{
  		id = i * array[i].length + j;
  		document.writeln("<td id='"+id+"' width='45' height='45' align='center' onclick='clicked("+i+","+j+");'><font size='+2'>"+array[i][j]+"</font></td>");
  	}
  	
  	document.writeln("</tr>\n");
  }
  
    document.writeln("</table></font>\n");
  
  // These are the buttons that allow the user to end the SETUP and PLAY stage
  // I also added a help button. To hide the div again click the cat gif.
  document.writeln("<button type='button' onclick='endSetup();'>End Setup Stage!</button>");
  document.writeln("<button type='button' onclick='endPlay();'>End Play Stage!</button>");
  document.writeln("<button type='button' onclick='showHelp();'>Help?</button>");
}

window.onload = showTable(array);

// Function to show the div with instructions on how to play (to make my page look nicer)
function showHelp()
{	
	if (end == true)
	{
		help.style.visibility = 'visible';
	}
}

// Function to hide the div with instructions on how to play
function hideHelp()
{
	help.style.visibility = 'hidden';
}

// Changes the number in the box to a random number.
function clicked (i,j) {

// If the play round is not on then when you click on a square it won't do anything.
if (play == true)
{
  // id = position i multiplied by length of array[i] + j determines id name of the cell which will be used to add a value
  id = i * array[i].length + j;
  
  // This simply says if there's nothing in the square, execute the getValue function
  if (array[i][j] == ' ')
  {
  	value = getValue();
 	array[i][j] = value;
  
	// for placing the user robot on the grid
 	if (value == 'u' && userRobot == 1)
 	{
 		document.getElementById(id).innerHTML = "<font size='3' color='#CC66FF'>"+array[i][j]+"</font>";
 		userRobot = 0;
 		userRobotX = i;	// Values are copied to variables userRobotX and userRobotY so it knows where it is
 		userRobotY = j; // when moving the robot around in the game
 	}
 	
	// for placing obstacles
 	else if (value == 'o')
 	{
 		document.getElementById(id).innerHTML = "<font size='3' color='orange'>"+array[i][j]+"</font>";
 	}
 	
	// if the user has already placed the user robot on the grid then don't allow another one to be placed
 	else if (value == 'u' && userRobot == 0)
 	{
 		alert("You already put down your robot!");
 	}
 	
	// for placing numbers in the grid
 	else
 	{
  		document.getElementById(id).innerHTML = "<font size='3'>"+array[i][j]+"</font>";
  	}
  }
  
  // If the square is already occupied, give an alert saying you cannot change it!
  else
  {
  	alert("You cannot change the value in a square!");
  }
  }
}

// Gets a value from the user to put into the grid
function getValue()
{
	var value = prompt("Please enter 1-9, o or u","");
	
	// The value must either be an o, u or a number between 1-9.
	if (value == 'o' || value == 'u' || (value <= 9 && value >= 1))
	{
		return value;
	}
	
	// Execute this code if the user inputs something that is not valid
	else
	{	// Continue to execute the code if the user inputs an incorrect value AGAIN
		while (value != 'o' || value != 'u' || value > 9 || value < 1)
		{
			alert("That is not a valid letter/number in this game!");
			var value = prompt("Please enter 1-9, o or u","");
				
			if (value == 'o' || value == 'u' || (value <= 9 && value >= 1))
			{
					break;
			}
		}		
		return value;
	}
}

// This function is called when the user presses END SETUP button
function endSetup()
{
	// This is here to ensure that it won't do anything while in the END stage IE when the game is over.
	if (end == true)
	{
		var placed = 0; // will only execute next part of code if placed = 1;
	
		// To search through all the squares to make sure there is indeed the user's robot on the board
		for (i = 0; i < size; i++)
		{
			for (j = 0; j < size; j++)
			{
				if (array[i][j] == 'u')	// if the user's robot is found.... then make placed = 1.
				{
					placed = 1;
				}
			}
		}
	
		// If the user did not place their robot
		if (placed == 0)
		{
			alert("You did not place your robot!");
		}
	
		// If the user has placed the robot then execute the next part of game
		else
		{
			alert("You have successfully placed your objects.");
		
			makeVisible();	// makes the DIV with game stats visible
			compRobot();	// places the computer's robot onto the grid
		
			play = 0; // Play round is OVER	
		}
	}
}

// 2222222222222222222222222222222222222222222222222222 //
// PLAY STAGE OF ULLRICH'S ASSIGNMENT / TREASURE GAME!! //
// 2222222222222222222222222222222222222222222222222222 //

// Makes the GAME STATS visible
function makeVisible()
{
	otherdiv.style.visibility = 'visible';
}

// This function is for the computer to place their robot on the grid.
function compRobot()
{
	// To check that the computer's robot hasn't already been placed yet.
	var placed = 0;
	
	for (i = 0; i < size; i++)
	{
		for (j = 0; j < size; j++)
		{
			if (array[i][j] == 'U')
			{
				placed = 1;
			}
		}
	}
	
	// If the computer's robot isn't on the grid yet then...
	if (placed == 0)
	{
		var iPos = Math.floor(Math.random()*size);	// Gets a random number for y co-ordinates from 0-size
		var jPos = Math.floor(Math.random()*size);	// Gets a random number for x co-ordinates from 0-size
		
		if (array[iPos][jPos] == ' ')
		{
			array[iPos][jPos] = "U";
		
			id = iPos * array[iPos].length + jPos;
		
			document.getElementById(id).innerHTML = "<font size='3' color='#33CC33'>"+array[iPos][jPos]+"</font>"
			
			compRobotX = iPos;  // saves the values of the computer's co-ordinates so it knows which cell to remove the value from
			compRobotY = jPos;
			countTreasure();	// Check that there's actually treasure on the board! if there isn't the game will end right away.
		}
		
		else
		{
			compRobot();	// Values generated give a grid that is not empty, re-execute the function.
		}
	}
	
	// Comp robot has already been placed
	else
	{
		alert("Why are you pressing end setup again?");
	}
}

// This function COUNTS all the treasure at the beginning of the game
function countTreasure()
{
	for (i = 0; i < size; i++)
	{
		for (j = 0; j < size; j++)
		{
			if (array[i][j] != ' ')
			{
				var check = array[i][j];
				
				if (check >= 1 && check <= 9) // checks that the value of check is a treasure with value 1-9
				{
					movement = 1;
					noOfTreasure++;	// increases noOfTreasure each time a number is counted
				}
			}
		}
	}
	
	// There is no treasure on the board? Then end the game!
	if (noOfTreasure == 0)
	{
		alert("There's no treasure on the board!!");
		endPlay();
	}
}

// Function for moving the user's robot
function moveUserRobot()
{
	// Will not execute if the game is in END stage
	if (end == true)
	{
		// Will not move unless it's the user robot's turn to go
		if(movement == true)
		{		
			
			var xCord = userRobotX;	// assign old coordinates to xCord and yCord
			var yCord = userRobotY; // xCord and yCord will be the new co-ordinates for the user's robot
	
			id = userRobotX * array[userRobotX].length + userRobotY; // calcuates id of old location
	
			// Gets the value entered in the text field by the user
			var testing = document.getElementById("testing1");
			var value = testing.value;
			document.getElementById('testing1').value = "";	
	
			if (value == 'a')
			{
				yCord = yCord - 1; // Move 1 to the left.
			}	
	
			else if (value == 'd')
			{
				yCord = yCord + 1; // Move 1 to the right.
			}
	
			else if(value == 'w')
			{
				xCord = xCord - 1; // Move up 1 square
			}
		
			else if(value == 'x')
			{
				xCord = xCord + 1; // Move down 1 square
			}
	
			else
			{
				alert("You have put in an invalid move! Please enter a valid letter! (a, d, w, x). Because you entered a invalid move the computer gets to go!");
			}
	
			id1 = xCord * array[xCord].length + yCord; // id of new location for robot to move to

			// Checks that the new coordinates are 'legal' values
			if ( (xCord >= 0 && xCord <= (size - 1)) && (yCord >= 0 && yCord <= (size - 1)) )
			{
				// Checks that the element at the position to move to isn't occupied by an obstacle or robot
				if (array[xCord][yCord] != 'o' && array[xCord][yCord] != 'U')
				{
					// If the value at the array position is empty then place the u there.
					if (array[xCord][yCord] == ' ')
					{	
						array[xCord][yCord] = 'u';
						document.getElementById(id1).innerHTML = "<font size='3' color='#CC66FF'>"+array[xCord][yCord]+"</font>"
						document.getElementById(id).innerHTML = "<font></font>"
					}
			
					// IF there is treasure in the spot the user wants to go to then update the user's score and remove that treasure!
					else
					{
						treasure = array[xCord][yCord];
				
						if (treasure >= 1 && treasure <= 9)
						{
							userScore = parseFloat(userScore) + parseFloat(treasure);	// use parseFloat() so the values are added and not concatenated
				
							array[xCord][yCord] = 'u';
							document.getElementById(id1).innerHTML = "<font size='3' color='#CC66FF'>"+array[xCord][yCord]+"</font>"
							document.getElementById(id).innerHTML = "<font></font>"
							noOfTreasure--; // decrease the treasure count
						}
					}
			
					// So program knows the position of the user's robot again when the function is called again.
					userRobotX = xCord;
					userRobotY = yCord;

					movement == 0;
					moveCompRobot();
				}
				
				else if (array[xCord][yCord] == 'U')
				{
					moveUserRobot();
				}
		
				// When there is an obstacle or computer's robot in the way
				else
				{
					alert("There's something in the way!");
					moveCompRobot();
				}
			}
	
			// When the user tries to go beyond the game dimensions
			else
			{
				alert("Trust me, you do not want to go that way. No one knows what is beyond the wall");
				moveCompRobot();
			}
		}
	}
}

// The function to move the computer's robot accordingly to the games rules.
function moveCompRobot()
{	
	var storeValues = new Array();
	var arrayX = new Array();
	var arrayY = new Array();
	
	var lowX = compRobotX - 1;	// used to go through surrounding cells
	var highX = compRobotX + 1;
	var lowY = compRobotY - 1;
	var highY = compRobotY + 1;
	
	var n = 0;	// n for new; will be used as array position for new array to store treasure values.
	var obstacles = 0;
	
	// Original robot's position
	id = compRobotX * array[compRobotX].length + compRobotY;

	// To check all the surrounding cells for treasure. Should go through 9 squares.
	for (a = (compRobotX - 1); a <= (compRobotX + 1); a++)
	{
		for (b = (compRobotY - 1); b <= (compRobotY + 1); b++)
		{
			if ( (a >= 0 && a <= (size - 1)) && (b >= 0 && b <= (size - 1)) ) // if the values are within the grid co-ordinates
			{	
				if (array[a][b] != ' ' && array[a][b] != 'u') 	// for some reason array[a][b] >= 1 won't work...
				{
					var test = array[a][b];
				
					if (test >= 1)
					{
						storeValues[n] = array[a][b]; 	// store the value at array[a][b] in array storeValues at position n
				
						arrayX[n] = a;	// store the seperate co-ordinate values into two arrays  
						arrayY[n] = b;  // used to determine location of greatest treasure piece
					
						n++; // increase array index
					}
				}
			}
		}
	}
	
	// If the array actually contains a value; IE if there really is treasure in any of the 8 squares around the robot
	if (storeValues.length >= 1)
	{
		// Check through all the elements and pick the highest value
		var largest = Math.max.apply(Math, storeValues);
		
		// This section is to determine the index of the largest value in the storeValues array
		var indexOfLarge = 0;

		var max = Math.max.apply(null, storeValues);
		
		for (var k = 0; k < storeValues.length; k++)
		{
			if (storeValues[k] == max)
			{
				indexOfLarge = k;
			}
		}
		
		var newCompX = arrayX[indexOfLarge];	// assign the value at arrayX index to the new position for the comp's robot
		var newCompY = arrayY[indexOfLarge]; // assign the value at arrayY index to the new position for the comp's robot
		
		id1 = newCompX * array[newCompX].length + newCompY;
	
		array[newCompX][newCompY] = 'U';
		document.getElementById(id1).innerHTML = "<font size='3' color='#33CC33'>"+array[newCompX][newCompY]+"</font>"
		document.getElementById(id).innerHTML = "<font> </font>"
		
		// So it remembers where the last position of the computer's robot is
		compRobotX = newCompX;
		compRobotY = newCompY;
		
		compScore = parseFloat(largest) + parseFloat(compScore); // use parseFloat so values are added and not concatenated

		noOfRounds++;
		noOfTreasure--;
		updateScores();
		checkTreasureCount();
	}

	// No treasure around the robot so must generate grid coordinates for the computer's robot to move to
	else
	{
	
		// To make the computer's robot move to a square and to avoid generating a location to which the comp robot can't actually move to
		if (lowX == -1)
		{
			lowX++;
		}
		
		if (lowY == -1)
		{
			lowY++;
		}
		
		if (highX == size)
		{
			highX--;
		}
		
		if (highY == size)
		{
			highY--;
		}

			do
			{
				// var randomnum = Math.floor(Math.random() * (maximum - minimum + 1)) + minimum;
				var randomX = Math.floor(Math.random() * (highX - lowX + 1)) + lowX;
				var randomY = Math.floor(Math.random() * (highY - lowY + 1)) + lowY;
				
			}while ( (randomX < 0 || randomX > (size - 1)) && (randomY < 0 || randomY > (size - 1)) ); // If the generated values are numbers that are OUTSIDE of the grid, redo 
	
			// The generated numbers should comply with the grid size
			if ( (randomX >= 0 && randomX <= (size - 1)) && (randomY >= 0 && randomY <= (size - 1)) )
			{
				// If the values generated at random don't have an obstacle or the user's robot in them continue...
				if (array[randomX][randomY] != 'o' && array[randomX][randomY] != 'u')
				{
					id2 = randomX * array[randomX].length + randomY;

					array[randomX][randomY] = 'U';
					document.getElementById(id2).innerHTML = "<font size='3' color='#33CC33'>"+array[randomX][randomY]+"</font>"
					document.getElementById(id).innerHTML = "<font> </font>"
		
					// So it remembers where the last position of the computer's robot is
					compRobotX = randomX;
					compRobotY = randomY;
				
					noOfRounds++;
					updateScores();
					checkTreasureCount();
					checkValidMoves();
				}
			
				else
				{
					moveCompRobot(); // restart function if the values generized would point to an illegal move.
				}
			}
		
			else
			{	
				movecompRobot(); // restart function if the values generized would point to an illegal move.
			}
		}
}

function checkTreasureCount()
{	
	// If there is no treasure left, noOfTreasure should = 0 and if so the game is over
	if (noOfTreasure <= 0)
	{
		alert("No treasure left!");
		endPlay();
	}
	
	// There is still treasure left, movement = 1 so that the user can move again.
	else
	{
		movement = 1;
	}
}

function checkValidMoves()
{	

	var userObstacles = 4; // variables used in an IF statement to decide whether the game needs to end or not.
	var compObstacles = 8; //

	// When checking if the user robot is stuck, only need to check 4 squares
	// Checks beside the robot's position in terms of X
	for (var j = (userRobotX - 1); j <= (userRobotX + 1); j++)
	{
		
			if (j < 0 || j > (size - 1))
			{
				continue; // stops the current iteration if the IF statement is true. IF the coordinate goes outside the grid, go to next value	
			}
	
			else
			{
				var checkUser = array[j][userRobotY];
				
				if (checkUser == 'o' || checkUser == 'U') // if the element at array[j][p] IS empty or has a number increment possMoves;
				{
					userObstacles--;
				}
			
				else if (typeof checkUser === 'undefined')
				{
					userObstacles--;
				}
			
				else{}
			}

		}
	
	// Checks above and below the robot's position in terms of Y
		for (var p = (userRobotY - 1); p <= (userRobotY + 1); p++)
		{
	
			if (p < 0 || p > (size - 1))
			{
				continue; // stops the current iteration if the IF statement is true. IF the coordinate goes outside the grid, go to next value	
			}
		
			else
			{
				var checkUser = array[userRobotX][p];
				
				if (checkUser == 'o' || checkUser == 'U') // if the element at array[j][p] IS empty or has a number increment possMoves;
				{
					userObstacles--;
				}
			
				else if (typeof checkUser === 'undefined') // checks if the square is undefined, if it is decrement the obstacle count
				{
					userObstacles--;
				}
			
				else{}
			}
		}
		
		// NEEDS FIXING
		// Checks all surrounding 8 squares around the computer robot
		for (var b = (compRobotX - 1); b <= (compRobotX + 1); b++)
		{
			for (var c = (compRobotY - 1); c <= (compRobotY + 1); c++)
			{	
				var checkComp = array[b][c];
			
				if (checkComp == 'o' || checkComp == 'u') // if the element at array[j][p] IS empty or has a number increment possMoves;
				{
					compObstacles--;
				}
			
				else if (typeof checkComp === 'undefined') // If the square is out of the grid and is undefined, decrement compObstacles
				{
					compObstacles--;
				}
			
				else{}
			}
		}
	
	if (userStuck == true && compStuck == true)
	{
		alert("Both players are stuck!");
		endPlay();
	}
	
	if (userObstacles == 0)
	{
		alert("The user is stuck!");
		userStuck = 1;
	}
	
	if (compObstacles == 0)
	{
		alert("Computer is stuck!");
		compStuck = 1;
	}
	
	if (userStuck == false && compStuck == false)
	{
		userObstacles = 4; // the variables back to their original values
		compObstacles = 8;
	}
}

function updateScores()
{
	document.getElementById("showUserScore").innerHTML = userScore;	// updates the scores after the computer's turn
	document.getElementById("showCompScore").innerHTML = compScore;
	document.getElementById("showRounds").innerHTML = noOfRounds;
}

function endPlay()
{
	if (end == true)
	{
		alert("Game is over! Lets see who won!");
		end = 0; // END MODE ON; all the buttons/textfield should not react to any actions performed by the user
		displayFinal();
	}
}

// 333333333333333333333333333333333333333333333333333 //
// END STAGE OF ULLRICH'S ASSIGNMENT / TREASURE GAME!! //
// 333333333333333333333333333333333333333333333333333 //

// To calculate the total value of all the numbers on the board.
function displayFinal()
{

	alert("Drumroll please.....");	
	if (userScore > compScore)
	{
		alert("Congratulations you have beat the computer!");
	}
	
	else if (compScore > userScore)
	{
		alert("Unfortunately the computer has beaten you this time! Try again?");
	}
	
	else
	{
		alert("No ones a winner this time! Both scores are equal. Try again?");
	}
}

