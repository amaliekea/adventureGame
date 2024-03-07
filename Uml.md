classDiagram
direction BT
class AdventureGame {
  + AdventureGame() 
  ~ Map maps
  ~ Player player
}
class Main {
  + Main() 
}
class Map {
  + Map() 
  - Room room7
  - Room room8
  - Room room5
  - Room firstRoom
  - Room room1
  - Room room3
  - Room room2
  - Room room6
  - Room room4
  - Room room9
}
class Player {
  + Player(Room) 
  - Room currentRoom
  - String wayBlocked
}
class Room {
  + Room(String, String) 
  - Room connectionEast
  - String description
  - Room connectionNorth
  - Room connectionSouth
  - Room connectionWest
  - String name
}
class UserInterface {
  + UserInterface() 
  - String userInput
  - AdventureGame adventure
  - Scanner input
}

AdventureGame  ..>  Map : «create»
AdventureGame "1" *--> "maps 1" Map 
AdventureGame "1" *--> "player 1" Player 
AdventureGame  ..>  Player : «create»
Main  ..>  UserInterface : «create»
Map  ..>  Room : «create»
Map "1" *--> "room1 1" Room 
Player "1" *--> "currentRoom 1" Room 
UserInterface "1" *--> "adventure 1" AdventureGame 
UserInterface  ..>  AdventureGame : «create»
