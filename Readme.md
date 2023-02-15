# Mars Rover Project
## Created in Java using a Test Driven Development (TDD) Approach

This application allows the user to add and move a Rover vehicle around a plateau, of a chosen size, on Mars. This plateau has randomly assigned obstacles. 

## How to use this application
The user can run this project from the "Main" class/method.  This will start command line prompts.

**Step 1** - User enters their name <br/>
<em>Assumptions</em> - names can be any length but not numbers

**Step 2** - User selects planet they want to visit from the list <br/>
<em>Assumptions</em>  - currently only one planet (Mars) and the user must enter 1 to visit Mars

**Step 3** - User types in a plateau size to add to the planet <br/>
<em>Assumptions</em>  - must be of the form XY (where x is the coordinate of the horizontal line (width) and y is the coordinate of the vertical line (height)).
Letters are not accepted and the values must be between 1 and 9

**Step 4** - User enters the coordinates for their vehicle <br/>
<em>Assumptions</em>  - vehicle takes up 1 square.  Coordinates must be of the form XYD where X is the x coordinate, Y is the y coordinate and D is the direction (N, E, S or W).  
This is not case sensitive. Vehicles cannot be placed outwith the plateau and cannot be placed on a square which contains an obstacle.
If a user tries to do either of these, an error message will tell them this is not allowed and they will need to enter a new position.

**Step 5** - The user can now add instructions to move their vehicle around the plateau.  <br/>
<em>Assumptions</em>  - The user must type in a series of instructions on the one line. 
The user is given a choice of "L" for turning left, "R" for turning right and "M" for moving forward one space. 
This is not case sensitive however numbers, special characters and any values outwith "L" "R" or "M" will be ignored.  White space is also ignored. 
If the journey entered tries to move off of the plateau or over an obstacle, the vehicle will be moved UP UNTIL THIS POINT and the user will be told that the full journey was not completed for this reason. 
The user is then informed the original and new position of their vehicle and the application closes. 

Obstacles are added randomly when the plateau is created.  The number is based on the size of the plateau. 
## Future Considerations

This application can be expanded to do the following:
* visit different planets
* have several rovers on the plateau at a time
* have multiple different vehicles on the plateau 
* have different shaped plateaus 
* allow vehicles to collect samples from rocks
* allow vehicles to shoot aliens
* have a more complex User Interface
