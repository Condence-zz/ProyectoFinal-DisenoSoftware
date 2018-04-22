/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital; 
public class Producto {
    
    private int ProductID;
    private String ProductName;
    private int SupplierID;
    private int CategoryID;
    private String QuantityPerUnit;
    private double UnitPrice;
    private int UnitsInStock;
    private int UnitsOnOrder;
    private int RecorderLevel;
    private boolean Discontinued;


    public Producto() {
    }

    
    public Producto(int ProductID) {
        this.ProductID = ProductID;
    }

    public Producto(String ProductName) {
        this.ProductName = ProductName;
    }

    
    
    public Producto(int ProductID, String ProductName, int SupplierID, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int RecorderLevel, boolean Discontinued) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.RecorderLevel = RecorderLevel;
        this.Discontinued = Discontinued;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(int UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }

    public int getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setUnitsOnOrder(int UnitsOnOrder) {
        this.UnitsOnOrder = UnitsOnOrder;
    }

    public int getRecorderLevel() {
        return RecorderLevel;
    }

    public void setRecorderLevel(int RecorderLevel) {
        this.RecorderLevel = RecorderLevel;
    }

    public boolean isDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(boolean Discontinued) {
        this.Discontinued = Discontinued;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.ProductID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.ProductID != other.ProductID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ProductID + ProductName + SupplierID + CategoryID + QuantityPerUnit + UnitPrice + UnitsInStock +
                UnitsOnOrder + RecorderLevel+ Discontinued;
    }
    
    
    
}
