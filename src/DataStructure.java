
import java.util.ArrayList;


public class DataStructure implements DT {

	private final Link first;
	private int size;
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;


	//////////////// DON'T DELETE THIS CONSTRUCTOR ////////////////
	public DataStructure(){
	Link firstLink = new Link(new Point(0,0));
	this.first = firstLink;
	this.size = 0;
	}

	@Override
	public void addPoint(Point point) {
		size++;
		// TODO Auto-generated method stub
		Link newlink = new Link(point);
		//set next X
		Link prev = null;
		Link next = first;
		while (next.compare(newlink,true)) {
			prev = next;
			next = next.getNextX();
		}
		newlink.setNextX(next);
		prev.setNextX(newlink);
		next.setPrevX(newlink);
		newlink.setPrevX(prev);
		//set next y
		prev = null;
		next = first;
		while (next.compare(newlink, false)) {
			prev = next;
			next = next.getNextY();
		}
		newlink.setNextY(next);
		prev.setNextY(newlink);
		next.setPrevY(newlink);
		newlink.setPrevY(prev);
	}

	@Override
	public Point[] getPointsInRangeRegAxis(int min, int max, Boolean axis) {
		// TODO Auto-generated method stub

		ArrayList<Point> DynPoints = new ArrayList<>();
		Link linkinRange = first;
		while (axis&linkinRange.getNext(axis)!=null) {
			if (linkinRange.getPoint().getX()>min && linkinRange.getPoint().getX()<max){
				DynPoints.add(linkinRange.getPoint());
			}
			linkinRange = linkinRange.getNextX();
		}
		while (!axis&linkinRange.getNext(axis)!=null) {
			if (linkinRange.getPoint().getY()>min && linkinRange.getPoint().getY()<max){
				DynPoints.add(linkinRange.getPoint());
			}
			linkinRange = linkinRange.getNextY();
		}

		Point[] ans = new Point[DynPoints.size()];
		for (int i=0;i<DynPoints.size();i++) {
			ans[i] = DynPoints.get(i);
		}
		return ans;
	}

	@Override
	public Point[] getPointsInRangeOppAxis(int min, int max, Boolean axis) {
		// TODO Auto-generated method stub
		ArrayList<Point> DynPoints = new ArrayList<>();
		Link linkinRange = first;
		while (axis&linkinRange.getNextY()!=null) {
			if (linkinRange.getPoint().getX()>min && linkinRange.getPoint().getX()<max){
				DynPoints.add(linkinRange.getPoint());
			}
			linkinRange = linkinRange.getNextY();
		}
		while (!axis&linkinRange.getNextX()!=null) {
			if (linkinRange.getPoint().getY()>min && linkinRange.getPoint().getY()<max){
				DynPoints.add(linkinRange.getPoint());
			}
			linkinRange = linkinRange.getNextY();
		}

		Point[] ans = new Point[DynPoints.size()];
		for (int i=0;i<DynPoints.size();i++) {
			ans[i] = DynPoints.get(i);
		}
		return ans;
	}

	@Override
	public double getDensity() {
		// TODO Auto-generated method stub
		return (this.size/((maxX-minX)*(maxY-minY)));
	}

	@Override
	public void narrowRange(int min, int max, Boolean axis) {
		// TODO Auto-generated method stub
		Link prev = null;
		Link delete = first;
		while (axis&delete.getNextX()!=null){

			if (min < delete.getPoint().getX()) {
				//deleting the x
				first.setNextX(delete.getNextX());
				//deleting the y
				delete.getPrevY().setNextY(delete.getNextY());
				delete.getNextY().setPrevY(delete.getPrevY());
			}
		}
		while (!axis&delete.getNextY()!=null){

			if (min < delete.getPoint().getY()) {
				//deleting the x
				first.setNextY(delete.getNextY());
				//deleting the y
				delete.getPrevX().setNextX(delete.getNextX());
				delete.getNextX().setPrevX(delete.getPrevX());
			}
		}
	}

	@Override
	public Boolean getLargestAxis() {
		// TODO Auto-generated method stub
		return (maxX-minX>maxY-minY);
	}

	@Override
	public Container getMedian(Boolean axis) {
		// TODO Auto-generated method stub
		Link median = first;
		int i = size/2;
		while (axis&i>0){
			median = median.getNext(axis);
			i--;
		}
		return (new Container(median.getPoint()));
	}

	@Override
	public Point[] nearestPairInStrip(Container container, double width, Boolean axis) {
		// TODO Auto-generated method stub
		Double minDelta = width;
		Point[] ans = new Point[2];
		if (axis){
			Point[] arrayOfPlanes = getPointsInRangeOppAxis((int)(container.getData().getX() - width/2) , (int)(container.getData().getX() + width/2), axis); // all the planes in the given range by a non-descending order
			int n = arrayOfPlanes.length; // number of planes in the given range.
			for (int i = 0; i < n; i++){
				double currDelta = java.lang.Math.sqrt((Math.pow((double)(arrayOfPlanes[i+1].getX()) , 2) - Math.pow((double)(arrayOfPlanes[i].getX()) , 2)) + (Math.pow((double)(arrayOfPlanes[i+1].getY()) , 2) - Math.pow((double)(arrayOfPlanes[i].getY()) , 2)) );
				if ( currDelta< minDelta){
					minDelta = currDelta;

				}
			}
		}
		return null;
	}

	@Override
	public Point[] nearestPair() {
		// TODO Auto-generated method stub
		return null;
	}


	//TODO: add members, methods, etc.
	public static void main(String[] args) {
		DataStructure DStest = new DataStructure();
		DStest.addPoint(new Point(10,10,"first point"));
	}
}

