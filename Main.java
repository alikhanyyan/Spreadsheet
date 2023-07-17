public class Main
{
    public static void main(String[] args)
    {
        // Testing Spreadsheet
        var spreadsheet = new Spreadsheet(1, 1);

        spreadsheet.addRow();
        spreadsheet.addColumn();
        spreadsheet.addColumn(0);

        spreadsheet.setValueAt(0, 0, 5);
        spreadsheet.setValueAt(0, 1, 1.1);
        spreadsheet.setValueAt(0, 2, 2);
        spreadsheet.setValueAt(1, 0, 7.4);
        spreadsheet.setValueAt(1, 1, 1);
        spreadsheet.setValueAt(1, 2, 2.8);

        spreadsheet.setColorAt(0, 0, Color.RED);

        System.out.println("0 column sum: " + spreadsheet.getColumnSum(0));
        System.out.println("1 row sum: " + spreadsheet.getRowSum(1));
        System.out.println("[0][0] - [1][1] area sum: " + spreadsheet.getAreaSum(1,1));
        System.out.println();

        System.out.println("0 column average: " + spreadsheet.getColumnAverage(2));
        System.out.println("1 row average: " + spreadsheet.getRowAverage(1));
        System.out.println("[0][1] - [1][2] area average: " + spreadsheet.getAreaAverage(0, 1 , 1,2));
        System.out.println();

        System.out.println("[0][0] color: " + spreadsheet.getColorAt(0, 0));
        System.out.println("[1][1] color: " + spreadsheet.getColorAt(1, 1));
        System.out.println();

        spreadsheet.resetCellAt(0, 1);
        System.out.println("Value at [0][1]: " + spreadsheet.getValueAt(0, 1));
        System.out.println();

        spreadsheet.setValueAt(0,0, false);

    }
}
