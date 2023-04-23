
//Don't change the class name
public class Container{
	private Point data;//Don't delete or change this field;
	private Link plane;

	public Container(Point point){
		this.data = point;
	}
	public Container(Point point,Link plane){
		this.data = point;
		this.plane = plane;
	}


	//Don't delete or change this function
	public Point getData()
	{
		return data;
	}

}

