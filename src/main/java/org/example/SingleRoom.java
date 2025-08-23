package org.example;

    public class SingleRoom extends Room {
        public SingleRoom(int roomNumber) { super(roomNumber); }
        @Override
        public String getRoomType() { return "Single"; }
    }

