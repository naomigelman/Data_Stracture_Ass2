public class Link {
    private Point point;
    private Link nextX;
    private Link prevX;
    private Link nextY;
    private Link prevY;

    public Link(Point point){
        this.point = point;
    }
    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    public Link getNextX() {
        return nextX;
    }
    public Link getNextY() {
        return nextY;
    }
    public Link getPrevX() {
        return prevX;
    }
    public Link getPrevY() {
        return prevY;
    }
    public void setNextY(Link nextY) {
        this.nextY = nextY;
    }
    public void setNextX(Link nextX) {
        this.nextX = nextX;
    }
    public void setPrevX(Link prevX) {
        this.prevX = prevX;
    }
    public void setPrevY(Link prevY) {
        this.prevY = prevY;
    }
    public boolean compare(Link link, boolean axis) {
        if (axis) {
            return (this.point.getX()<link.point.getX());
        } else {
            return (this.point.getY()<link.point.getY());
        }
    }
    public Link getNext(boolean axis) {
        if (axis) {return nextX;}
        else {return nextY;}
    }
    public Link getPrev(boolean axis) {
        if (axis) {return prevX;}
        else {return prevY;}
    }
    public void setNext(Link Next, boolean axis) {
        if (axis) {
            this.nextX = Next;
        } else {
            this.nextY = Next;
        }
    }
    public void setPrev(Link prev,boolean axis) {
        if (axis) {this.prevX = prev;}
        else {this.prevY = prev;}
    }

}
