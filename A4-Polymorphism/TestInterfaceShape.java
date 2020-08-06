import java.io.*;
import java.util.*;

interface Shape
{
	/*protected String color = "red";

	public Shape()
	{

	}

	public Shape(String color)
	{
		this.color = color;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}*/

	public String getColor();

	public float getArea();

	public float getPerimeter();

}

class Circle implements Shape
{
	protected float radius = 1.0f;
	protected String color = "red";

	public Circle()
	{

	}

	public Circle(float radius)
	{
		this.radius = radius;
	}

	public Circle(float radius, String color)
	{
		this.color = color;
		this.radius = radius;
	}

	public String getColor()
	{
		return color;
	}

	public float getRadius()
	{
		return radius;
	}

	public void setRadius(float radius)
	{
		this.radius = radius;
	}

	public float getArea()
	{
		return 3.14f * radius * radius;
	}

	public float getPerimeter()
	{
		return 2f * 3.14f * radius;
	}
}

class Rectangle implements Shape
{
	protected float width = 1.0f;
	protected float length = 1.0f;
	protected String color = "red";


	public Rectangle()
	{

	}

	public Rectangle(float width, float length)
	{
		this.width = width;
		this.length = length;
	}

	public Rectangle(float width, float length, String color)
	{
		this.color = color;
		this.width = width;
		this.length = length;
	}

	public String getColor()
	{
		return color;
	}

	public float getWidth()
	{
		return width;
	}

	public void setWidth(float width)
	{
		this.width = width;
	}

	public float getLength()
	{
		return length;
	}

	public void setLength(float length)
	{
		this.length = length;
	}

	public float getArea()
	{
		return width * length;
	}

	public float getPerimeter()
	{
		return 2f * (width + length);
	}
}

class Square extends Rectangle implements Shape
{
	
	public Square()
	{

	}

	public Square(float side)
	{
		super(side, side);
	}

	public Square(float side, String color)
	{
		super(side, side, color);
	}

	public String getColor()
	{
		return color;
	}

	public float getSide()
	{
		return width;
	}

	public void setSide(float side)
	{
		width = length = side;
	}

	public float getArea()
	{
		return width * length;
	}

	public float getPerimeter()
	{
		return 2f * (width + length);
	}	
}

public class TestInterfaceShape
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		int N = 9;

		float radius;
		String color;

		float width;
		float length;

		float side;

		Shape[] s = new Shape[N];

		for(int i=0; i<N ; i++)
		{
			if(i == 0)
				s[i] = new Circle();

			else if(i == 1)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("INPUT Circle 2 Details");
				System.out.println("---------------------------------------");
				System.out.print("Enter Radius: ");
				radius = input.nextFloat();
				System.out.println("---------------------------------------");

				s[i] = new Circle(radius);
			}

			else if(i == 2)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("INPUT Circle 3 Details");
				System.out.println("---------------------------------------");
				System.out.print("Enter Radius: ");
				radius = input.nextFloat();
				System.out.print("Enter Color: ");
				color = reader.readLine();
				System.out.println("---------------------------------------");

				s[i] = new Circle(radius, color);
			}

			else if(i == 3)
				s[i] = new Rectangle();

			else if(i == 4)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("INPUT Rectangle 2 Details");
				System.out.println("---------------------------------------");
				System.out.print("Enter Width: ");
				width = input.nextFloat();
				System.out.print("Enter Length: ");
				length = input.nextFloat();
				System.out.println("---------------------------------------");

				s[i] = new Rectangle(width, length);
			}

			else if( i == 5)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("INPUT Rectangle 3 Details");
				System.out.println("---------------------------------------");
				System.out.print("Enter Width: ");
				width = input.nextFloat();
				System.out.print("Enter Length: ");
				length = input.nextFloat();
				System.out.print("Enter Color: ");
				color = reader.readLine();
				System.out.println("---------------------------------------");

				s[i] = new Rectangle(width, length, color);
			}

			else if(i == 6)
				s[i] = new Square();

			else if(i == 7)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("INPUT Square 2 Details");
				System.out.println("---------------------------------------");
				System.out.print("Enter Side: ");
				side = input.nextFloat();
				System.out.println("---------------------------------------");

				s[i] = new Square(side);
			}

			else if( i == 8)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("INPUT Square 3 Details");
				System.out.println("---------------------------------------");
				System.out.print("Enter Side: ");
				side = input.nextFloat();
				System.out.print("Enter Color: ");
				color = reader.readLine();
				System.out.println("---------------------------------------");

				s[i] = new Square(side, color);
			}
		}

		for(int i=0; i<N; i++)
		{
			if(i >= 0 && i < 3)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("DISPLAY Circle "+(i+1));
				System.out.println("---------------------------------------");
				System.out.println("Radius: "+((Circle) s[i]).getRadius());
				System.out.println("Color: "+s[i].getColor());
				System.out.println("Area: "+s[i].getArea());
				System.out.println("Perimeter: "+s[i].getPerimeter());
				System.out.println("---------------------------------------");
			}

			else if(i >= 3 && i < 6)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("DISPLAY Rectangle "+(i-2));
				System.out.println("---------------------------------------");
				System.out.println("Width: "+((Rectangle) s[i]).getWidth());
				System.out.println("Length: "+((Rectangle) s[i]).getLength());
				System.out.println("Color: "+s[i].getColor());
				System.out.println("Area: "+s[i].getArea());
				System.out.println("Perimeter: "+s[i].getPerimeter());
				System.out.println("---------------------------------------");
			}

			else if(i >= 6 && i < 9)
			{
				System.out.println("");
				System.out.println("---------------------------------------");
				System.out.println("DISPLAY Square "+(i-5));
				System.out.println("---------------------------------------");
				System.out.println("Side: "+((Square) s[i]).getSide());
				System.out.println("Color: "+s[i].getColor());
				System.out.println("Area: "+s[i].getArea());
				System.out.println("Perimeter: "+s[i].getPerimeter());
				System.out.println("---------------------------------------");
			}
		}
	}
}
