import java.util.Date;

public class Cell
{
    private Object value;
    private Color color;
    private Type type;

    public Cell()
    {
        color = Color.WHITE;
    }
    public Cell(Object value)
    {
        this.value = value;
        color = Color.WHITE;

        setType(value);
    }
    public Cell(Object value, Color color)
    {
        this.value = value;
        this.color = Color.WHITE;

        setType(value);
    }

    public void setValue(Object value)
    {
        this.value = value;
        setType(value);
    }
    public Object getValue() { return value; }

    public void setColor(Color color) { this.color = color; }
    public Color getColor() { return color; }

    private void setType(Object value)
    {
        if (value instanceof Number)
        {
            type = Type.NUMBER;
        }
        else if (value instanceof Date)
        {
            type = Type.DATE;
        }
        else if (value instanceof String)
        {
            type = Type.STRING;
        }
        else
        {
            System.out.println("Invalid type for setting value");
        }
    }
    public Type getType() { return type; }

    public void reset()
    {
        value = null;
        type = null;
        color = Color.WHITE;
    }
}