public abstract class Shape
{
  private int x;
  private int y;
  private Color color;
  
  protected Shape(int x, int y, Color color)
  {
    this.x = x;
    this.y = y;
    this.color = color;
  }
  
  public abstract int getHeight();
  public abstract int getWidth();
  
  public void move(int dx, int dy)
  {
    x += dx;
    y += dy;
  }
  
  public void setColor(Color color)
  {
    this.color = color;
  } 
}

public class Triangle extends Shape, WindowsAdapter
{
  private int size;
  
  public Triangle(int xCorr, int yCorr, Color c, int triSize )
  {
    this.size = triSize;
  }
  
  public int getHeight()
  {
    return (int)(Math.sqrt((3.0*size*size)/4));
  }
  
  public void windowClosing(WindowEvent evt)
  {
    System.exit(0);
  }
}

