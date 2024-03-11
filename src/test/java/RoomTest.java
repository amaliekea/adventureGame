import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void addItem() {
        //Arrange
        Room room1 =new Room("første", "anden");
        //Act
        room1.addItem(new Item("lamp", "a shiny lamp"));
        ArrayList<Item> items = room1.getItemInRoomArr();
        //Assert
        assertEquals(1, items.size());
        assertEquals("lamp", items.get(0).getLongname());
        assertEquals("a shiny lamp", items.get(0).getShortName());


    }

    @Test
    void removeItem() {
    }

    @Test
    void getItemInRoomArr() {
    }

    @Test
    void setItemInRoom() {
    }
}