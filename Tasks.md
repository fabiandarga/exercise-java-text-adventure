## Day 2
### Task: How to win and loose
1. Come up with some narrative about the player character
2. Come up with some possible win- and loss-conditions
#### From a story perspective
#### And from a mechanical perspective

### Task: Lose Condition #1
The player has only 10 actions
Remember these actions (or steps) in the game state
Count after every move
Inform the player in the loop about steps left
End the Game with a message when 10 steps are over

### Task: Win Condition
Win condition - collect scales
store the collected amount
When generating random location for left and right, also randomly determine if the reward is 0-3 scales.
Add a new Class "Location" to save Area and Reward(int) in one object  (and danger later)
In the main loop print not only the left/right locations, but also how many scales can be found
When moving increase collected scales

### Task: Dangers
1. Add more Dangers (have it happen more often)
2. Consequences for MoveCommand: have the fish eaten by some chance.
3. CreateRandomDirectionCommand: Refactor, to avoid duplicated code

### Task: Persist the Game State
1. Make the GameState Serializable (Interface Serializable)
2. Create a database and table (id | save_name(unique) | data)
3. Create a separate Class to connect to and use a database
4. After each loop auto-save the game state to the database (for now always use save_name="auto")
5. When the game is quit and restarted: try to load data for save_name="auto" from the database and fill the game state
6. Whenever the game ends (win ore lose) remove the "auto" game state from the database