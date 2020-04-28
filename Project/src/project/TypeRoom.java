/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author faisal7899
 */
public class TypeRoom {
     String RoomNo;
    String RoomType;
    String PricePerDay;
    String NoOfBeds;
    String Availability;

    public TypeRoom(String RoomNo, String RoomType, String PricePerDay, String NoOfBeds, String Availability) {
        this.RoomNo = RoomNo;
        this.RoomType = RoomType;
        this.PricePerDay = PricePerDay;
        this.NoOfBeds = NoOfBeds;
        this.Availability = Availability;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public String getRoomType() {
        return RoomType;
    }

    public String getPricePerDay() {
        return PricePerDay;
    }

    public String getNoOfBeds() {
        return NoOfBeds;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setRoomNo(String RoomNo) {
        this.RoomNo = RoomNo;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public void setPricePerDay(String PricePerDay) {
        this.PricePerDay = PricePerDay;
    }

    public void setNoOfBeds(String NoOfBeds) {
        this.NoOfBeds = NoOfBeds;
    }

    public void setAvailability(String Availability) {
        this.Availability = Availability;
    }

    
    
    
}
