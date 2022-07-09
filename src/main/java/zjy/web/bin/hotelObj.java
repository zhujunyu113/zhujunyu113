package zjy.web.bin;

import java.util.Objects;

public class hotelObj {
    private Integer pk;
    private Integer roomno;
    private String hotel_status;
    private String room_type;

    public hotelObj() {
    }

    public hotelObj(Integer roomno, String hotel_status, String room_type) {
        this.roomno = roomno;
        this.hotel_status = hotel_status;
        this.room_type = room_type;
    }

    public hotelObj(Integer pk, Integer roomno, String hotel_status, String room_type) {
        this.pk = pk;
        this.roomno = roomno;
        this.hotel_status = hotel_status;
        this.room_type = room_type;
    }

    public String toString() {
        return "hotel{pk=" + this.pk + ", roomno=" + this.roomno + ", hotel_status='" + this.hotel_status + "', room_type='" + this.room_type + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            hotelObj hotelObj = (hotelObj)o;
            return this.pk.equals(hotelObj.pk) && this.roomno.equals(hotelObj.roomno) && this.hotel_status.equals(hotelObj.hotel_status) && this.room_type.equals(hotelObj.room_type);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pk, this.roomno, this.hotel_status, this.room_type});
    }

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Integer getRoomno() {
        return this.roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public String getHotel_status() {
        return this.hotel_status;
    }

    public void setHotel_status(String hotel_status) {
        this.hotel_status = hotel_status;
    }

    public String getRoom_type() {
        return this.room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
}
