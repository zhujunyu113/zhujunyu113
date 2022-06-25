package zjy.web.bin;

import java.util.Objects;

public class hotelObj {
    //数据库实体类
    private Integer pk;//数据ID
    private Integer roomno;//房间号
    private String hotel_status;//是否入住
    private String room_type;//房间状态

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

    @Override
    public String toString() {
        return "hotel{" +
                "pk=" + pk +
                ", roomno=" + roomno +
                ", hotel_status='" + hotel_status + '\'' +
                ", room_type='" + room_type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        hotelObj hotelObj = (hotelObj) o;
        return pk.equals(hotelObj.pk) && roomno.equals(hotelObj.roomno) && hotel_status.equals(hotelObj.hotel_status) && room_type.equals(hotelObj.room_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, roomno, hotel_status, room_type);
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Integer getRoomno() {
        return roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public String getHotel_status() {
        return hotel_status;
    }

    public void setHotel_status(String hotel_status) {
        this.hotel_status = hotel_status;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
}
