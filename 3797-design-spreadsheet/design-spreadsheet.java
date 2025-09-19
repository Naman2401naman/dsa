class Spreadsheet {
    int[][] sheet;

    public Spreadsheet(int rows) {
        this.sheet = new int[rows][26]; // rows × 26 columns
    }
    
    public void setCell(String cell, int value) {
        char ch = cell.charAt(0);
        int col = ch - 'A';  // column index
        int row = Integer.parseInt(cell.substring(1)) - 1; // row index
        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        char ch = cell.charAt(0);
        int col = ch - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = 0;
    }
    
    private int getCellValue(String token) {
        if (Character.isLetter(token.charAt(0))) {
            char ch = token.charAt(0);
            int col = ch - 'A';
            int row = Integer.parseInt(token.substring(1)) - 1;
            return sheet[row][col];
        } else {
            return Integer.parseInt(token);
        }
    }

    public int getValue(String formula) {
        // formula looks like "=X+Y"
        String exp = formula.substring(1); 
        String[] parts = exp.split("\\+");
        int left = getCellValue(parts[0]);
        int right = getCellValue(parts[1]);
        return left + right;
    }
}
