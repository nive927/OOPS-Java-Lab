import java.io.*;
import java.util.*;

class Shape
{
	protected String color = "red";

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
	}
}

class Circle extends Shape
{
	protected float radius = 1.0f;

	public Circle()
	{

	}

	public Circle(float radius)
	{
		this.radius = radius;
	}

	public Circle(float radius, String color)
	{
		super(color);
		this.radius = radius;
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

class Rectangle extends Shape
{
	protected float width = 1.0f;
	protected float length = 1.0f;

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
		super(color);
		this.width = width;
		this.length = length;
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

class Square extends Rectangle
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

	public float getSide()
	{
		return width;
	}

	public void setSide(float side)
	{
		width = length = side;
	}
}

public class TestShape
{
	public static void displayCircle(Circle c, int i)
	{
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Circle "+i);
		System.out.println("---------------------------------------");
		System.out.println("Radius: "+c.getRadius());
		System.out.println("Color: "+c.getColor());
		System.out.println("Area: "+c.getArea());
		System.out.println("Perimeter: "+c.getPerimeter());
		System.out.println("---------------------------------------");
	}

	public static void displayRectangle(Rectangle r, int i)
	{
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Rectangle "+i);
		System.out.println("---------------------------------------");
		System.out.println("Width: "+r.getWidth());
		System.out.println("Length: "+r.getLength());
		System.out.println("Color: "+r.getColor());
		System.out.println("Area: "+r.getArea());
		System.out.println("Perimeter: "+r.getPerimeter());
		System.out.println("---------------------------------------");
	}

	public static void displaySquare(Square s, int i)
	{
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Square "+i);
		System.out.println("---------------------------------------");
		System.out.println("Side: "+s.getSide());
		System.out.println("Color: "+s.getColor());
		System.out.println("Area: "+s.getArea());
		System.out.println("Perimeter: "+s.getPerimeter());
		System.out.println("---------------------------------------");

	}

	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		float radius;
		String color;

		float width;
		float length;

		float side;

		Circle c1 = new Circle();

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Circle2 Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Radius: ");
		radius = input.nextFloat();
		System.out.println("---------------------------------------");

		Circle c2 = new Circle(radius);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Circle3 Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Radius: ");
		radius = input.nextFloat();
		System.out.print("Enter Color: ");
		color = reader.readLine();
		System.out.println("---------------------------------------");
				
		Circle c3 = new Circle(radius, color);

		Rectangle r1 = new Rectangle();

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Rectangle2 Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Width: ");
		width = input.nextFloat();
		System.out.print("Enter Length: ");
		length = input.nextFloat();
		System.out.println("---------------------------------------");
		
		Rectangle r2 = new Rectangle(width, length);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Rectangle3 Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Width: ");
		width = input.nextFloat();
		System.out.print("Enter Length: ");
		length = input.nextFloat();
		System.out.print("Enter Color: ");
		color = reader.readLine();
		System.out.println("---------------------------------------");

		Rectangle r3 = new Rectangle(width, length, color);

		Square s1 = new Square();

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Square2 Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Side: ");
		side = input.nextFloat();
		System.out.println("---------------------------------------");

		Square s2 = new Square(side);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Square3 Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Side: ");
		side = input.nextFloat();
		System.out.print("Enter Color: ");
		color = reader.readLine();
		System.out.println("---------------------------------------");

		Square s3 = new Square(side, color);

		displayCircle(c1, 1);
		displayCircle(c2, 2);
		displayCircle(c3, 3);

		displayRectangle(r1, 1);
		displayRectangle(r2, 2);
		displayRectangle(r3, 3);
		
		displaySquare(s1, 1);
		displaySquare(s2, 2);
		displaySquare(s3, 3);

	}
}
