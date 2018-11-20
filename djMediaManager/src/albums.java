public class albums {
    private album head;


    public albums() {
        head = null;
    }

    public void setHead(album head) {
        this.head = head;
    }

    public album getHead() {
        return head;
    }

    @Override
    public String toString() {
        album current = head;
        String result = "[" + "{" + current.getArtistName() + ", " + current.getAlbumName() + "}, ";

        while (current.getNext() != null) {
            result = result + "{" + current.getNext().getArtistName() + ", " + current.getNext().getAlbumName() + "}, ";
            current = current.getNext();
        }
        return result;
    }
}