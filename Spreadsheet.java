import java.util.ArrayList;

public class Spreadsheet
{
    private final ArrayList<ArrayList<Cell>> cells;
    private int column;
    private int row;

    public Spreadsheet()
    {
        row = 0;
        column = 0;
        cells = new ArrayList<>();
    }
    public Spreadsheet(int row, int column)
    {
        if (row < 0 || column < 0)
        {
            throw new InvalidIndexForCreatingSpreadsheetException();
        }

        this.row = row;
        this.column = column;
        cells = new ArrayList<>();

        for (int i = 0; i < row; i++)
        {
            cells.add(new ArrayList<>(column));
        }
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                cells.get(i).add(j, new Cell());
            }
        }
    }

    void addColumn() { addColumn(column); }
    void addColumn(int index)
    {
        try
        {
            for(int i = 0; i < row; i++)
            {
                cells.get(i).add(index, new Cell());
            }
            column++;
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void addRow() { addRow(row); }
    public void addRow (int index)
    {
        try
        {
            cells.add(index, new ArrayList<>());
            row++;

            for (int i = 0; i < column; i++)
            {
                cells.get(index).add(i, new Cell());
            }
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void setValueAt(int rowIndex, int columnIndex, Object value)
    {
        try
        {
            cells.get(rowIndex).get(columnIndex).setValue(value);
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        try
        {
            return cells.get(rowIndex).get(columnIndex).getValue();
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public void setColorAt(int rowIndex, int columnIndex, Color color)
    {
        try
        {
            cells.get(rowIndex).get(columnIndex).setColor(color);
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public Color getColorAt(int rowIndex, int columnIndex)
    {
        try
        {
            return cells.get(rowIndex).get(columnIndex).getColor();
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void reset()
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                cells.get(i).get(j).reset();
            }
        }
    }
    public void resetCellAt(int rowIndex, int columnIndex)
    {
        try
        {
            cells.get(rowIndex).get(columnIndex).reset();
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public double getColumnSum(int column)
    {
        if (column >= this.column)
        {
            System.out.println("Index out of bounds");
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < row; i++)
        {
            if (cells.get(i).get(column).getType() == Type.NUMBER)
            {
                sum += Double.parseDouble(cells.get(i).get(column).getValue().toString());
            }
            else
            {
                System.out.println("Not all values are numbers in " + column + " column");
                return 0;
            }
        }
        return  sum;
    }
    public double getRowSum(int row)
    {
        if (row >= this.row)
        {
            System.out.println("Index out of bounds");
            return  0;
        }

        double sum = 0;
        for (int i = 0; i < column; i++)
        {
            if (cells.get(row).get(i).getType() == Type.NUMBER)
            {
                sum += Double.parseDouble(cells.get(row).get(i).getValue().toString());
            }
            else
            {
                System.out.println("Not all values are numbers in " + row + " row");
                return 0;
            }
        }
        return  sum;
    }
    public double getAreaSum(int rowEnd, int columnEnd)
    {
        return getAreaSum(0,0, rowEnd, columnEnd);
    }
    public double getAreaSum(int rowStart, int columnStart, int rowEnd, int columnEnd)
    {
        if (rowStart >= row || rowEnd >= row || columnStart >= column || columnEnd >= column)
        {
            System.out.println("Index out of bounds");
            return 0;
        }

        double sum = 0;
        for (int i = rowStart; i <= rowEnd; i++)
        {
            for (int j = columnStart; j <= columnEnd; j++)
            {
                if (cells.get(i).get(j).getType() == Type.NUMBER)
                {
                    sum += Double.parseDouble(cells.get(i).get(j).getValue().toString());
                }
                else
                {
                    System.out.println("Not all values are numbers in [" + rowStart + "][" + columnStart + "] - [" + rowEnd + "][" + columnEnd + "] area");
                    return 0;
                }
            }
        }
        return  sum;
    }

    public double getColumnAverage(int column)
    {
        if (column >= this.column)
        {
            System.out.println("Index out of bounds");
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < row; i++)
        {
            if (cells.get(i).get(column).getType() == Type.NUMBER)
            {
                sum += Double.parseDouble(cells.get(i).get(column).getValue().toString());
            }
            else
            {
                System.out.println("Not all values are numbers in " + column + " column");
                return 0;
            }
        }
        return  sum / row;
    }
    public double getRowAverage(int row)
    {
        if (row >= this.row)
        {
            System.out.println("Index out of bounds");
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < column; i++)
        {
            if (cells.get(row).get(i).getType() == Type.NUMBER)
            {
                sum += Double.parseDouble(cells.get(row).get(i).getValue().toString());
            }
            else
            {
                System.out.println("Not all values are numbers in " + row + " row");
                return 0;
            }
        }
        return  sum / column;
    }
    public double getAreaAverage(int rowEnd, int columnEnd)
    {
        return getAreaAverage(0, 0, rowEnd, columnEnd);
    }
    public double getAreaAverage(int rowStart, int columnStart, int rowEnd, int columnEnd)
    {
        if (rowStart >= row || rowEnd >= row || columnStart >= column || columnEnd >= column)
        {
            System.out.println("Index out of bounds");
            return 0;
        }

        double sum = 0;
        for (int i = rowStart; i <= rowEnd; i++)
        {
            for (int j = columnStart; j <= columnEnd; j++)
            {
                if (cells.get(i).get(j).getType() == Type.NUMBER)
                {
                    sum += Double.parseDouble(cells.get(i).get(j).getValue().toString());
                }
                else
                {
                    System.out.println("Not all values are numbers in [" + rowStart + "][" + columnStart + "] - [" + rowEnd + "][" + columnEnd + "] area");
                    return 0;
                }
            }
        }
        return  sum / ((rowEnd - rowStart + 1) + (columnEnd - columnStart + 1));
    }
}